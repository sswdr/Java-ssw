package com.ssw.test.time;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;

/**
 * @author ssw
 * @date 2022/8/2 14:23
 */
public class GetMaxTime {

    public static LocalDateTime getMaxTime(List<Object> listTime){
        ArrayList<Long> resultList = new ArrayList<>();
        LocalDateTime result = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ZoneId zoneId = ZoneId.systemDefault();
        ZoneOffset offset = OffsetDateTime.now(zoneId).getOffset();
        for (Object time : listTime) {
            try {
                if(time instanceof LocalDateTime)
                    resultList.add(((LocalDateTime) time).toInstant(offset).toEpochMilli());
                if(time instanceof Long)
                    resultList.add((Long)time);
                if(time instanceof String)
                    resultList.add(simpleDateFormat.parse((String)time).getTime());
                // ......
            }catch (Exception e){
                System.out.println("处理"+time+"出错,原因: "+e.getMessage());
            }
        }
        System.out.println(resultList);
        if(!resultList.isEmpty()){
            Long max = Collections.max(resultList);
            result = LocalDateTime.ofInstant(Instant.ofEpochMilli(max), zoneId);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Object> times = new ArrayList<>();
        times.add(LocalDateTime.now());
        Long time001= 1659605429227L;
        times.add(time001);
        times.add("2022-08-04 17:42:15");

        System.out.println(getMaxTime(times));
    }

}
