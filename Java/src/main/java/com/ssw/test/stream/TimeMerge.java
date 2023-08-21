package com.ssw.test.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author ssw
 * @date 2023/8/21 17:34
 */
public class TimeMerge {
    public static void main(String[] args) throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        @Data
        @AllArgsConstructor
        class TimeRange {
            private Date startTime;
            private Date endTime;

            @Override
            public String toString() {
                return "TimeRange{startTime=" + dateFormat.format(startTime) +
                        ", endTime=" + dateFormat.format(endTime) + '}';
            }
        }

        List<TimeRange> dates = new ArrayList<>();
        dates.add(new TimeRange(dateFormat.parse("2023-08-21 17:38:00"), dateFormat.parse("2023-08-21 17:39:00")));
        dates.add(new TimeRange(dateFormat.parse("2023-08-21 17:39:00"), dateFormat.parse("2023-08-21 17:40:00")));
        dates.add(new TimeRange(dateFormat.parse("2023-08-21 17:40:00"), dateFormat.parse("2023-08-21 17:41:00")));
        dates.add(new TimeRange(dateFormat.parse("2023-08-21 17:38:00"), dateFormat.parse("2023-08-21 17:41:00")));
        dates.add(new TimeRange(dateFormat.parse("2023-08-21 17:42:00"), dateFormat.parse("2023-08-21 17:43:00")));

        List<TimeRange> mergedTimeRanges = new ArrayList<>();
        dates.stream()
                .sorted(Comparator.comparingLong(x -> x.getStartTime().getTime()))
                .reduce((currentRange, nextRange) -> {
                    if (nextRange.getStartTime().getTime() <= currentRange.getEndTime().getTime()) {
                        currentRange.setEndTime(new Date(Math.max(currentRange.getEndTime().getTime()
                                , nextRange.getEndTime().getTime())));
                        return currentRange;
                    } else {
                        mergedTimeRanges.add(currentRange);
                        return nextRange;
                    }
                }).ifPresent(mergedTimeRanges::add);

        System.out.println(mergedTimeRanges);
        // TimeRange{startTime=2023-08-21 17:38:00, endTime=2023-08-21 17:41:00}
        // TimeRange{startTime=2023-08-21 17:42:00, endTime=2023-08-21 17:43:00}
    }

//    public static void main(String[] args) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//        @Data
//        @AllArgsConstructor
//        class TimeRange {
//            private LocalDateTime startTime;
//            private LocalDateTime endTime;
//
//            @Override
//            public String toString() {
//                return "TimeRange{startTime=" + startTime.format(formatter) +
//                        ", endTime=" + endTime.format(formatter) + '}';
//            }
//        }
//
//        List<TimeRange> dates = new ArrayList<>();
//        dates.add(new TimeRange(LocalDateTime.parse("2023-08-21 17:38:00", formatter), LocalDateTime.parse("2023-08-21 17:39:00", formatter)));
//        dates.add(new TimeRange(LocalDateTime.parse("2023-08-21 17:39:00", formatter), LocalDateTime.parse("2023-08-21 17:40:00", formatter)));
//        dates.add(new TimeRange(LocalDateTime.parse("2023-08-21 17:40:00", formatter), LocalDateTime.parse("2023-08-21 17:41:00", formatter)));
//        dates.add(new TimeRange(LocalDateTime.parse("2023-08-21 17:38:00", formatter), LocalDateTime.parse("2023-08-21 17:41:00", formatter)));
//        dates.add(new TimeRange(LocalDateTime.parse("2023-08-21 17:42:00", formatter), LocalDateTime.parse("2023-08-21 17:43:00", formatter)));
//
//        List<TimeRange> mergedTimeRanges = new ArrayList<>();
//        dates.stream()
//                .sorted(Comparator.comparing(TimeRange::getStartTime))
//                .forEach(timeRange -> {
//                    if (mergedTimeRanges.isEmpty() || timeRange.getStartTime().isAfter(mergedTimeRanges.get(mergedTimeRanges.size() - 1).getEndTime())) {
//                        mergedTimeRanges.add(timeRange);
//                    } else {
//                        TimeRange lastMergedRange = mergedTimeRanges.get(mergedTimeRanges.size() - 1);
//                        if (timeRange.getEndTime().isAfter(lastMergedRange.getEndTime())) {
//                            lastMergedRange.setEndTime(timeRange.getEndTime());
//                        }
//                    }
//                });
//
//        mergedTimeRanges.forEach(System.out::println);
//    }
}
