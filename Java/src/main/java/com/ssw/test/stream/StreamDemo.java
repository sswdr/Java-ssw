package com.ssw.test.stream;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author ssw
 * @date 2022/8/8 16:30
 */
public class StreamDemo {
//    public static void main(String[] args) {
//        List<Dish> menu= Arrays.asList(
//                new Dish("pork",800),
//                new Dish("beef",700),
//                new Dish("chicken",400),
//                new Dish("french fries",530),
//                new Dish("rice",350),
//                new Dish("fruit",120),
//                new Dish("pizza",550));
//        List<Dish> lowCaloriesDish=new ArrayList<>();
//        for(Dish d:menu)
//        {
//            if(d.getCalories()<400)
//                lowCaloriesDish.add(d);
//        }
//        Collections.sort(lowCaloriesDish,new Comparator<Dish>() {
//
//            @Override
//            public int compare(Dish o1, Dish o2) {
//                return Integer.compare(o1.getCalories(), o2.getCalories());
//            }
//        });
//        for(Dish d:lowCaloriesDish)
//            System.out.println(d.getName()+"  "+d.getCalories());
//    }


//    public static void main(String[] args) {
//        List<Dish> menu=Arrays.asList(
//                new Dish("pork",800),
//                new Dish("beef",700),
//                new Dish("chicken",400),
//                new Dish("french fries",530),
//                new Dish("rice",350),
//                new Dish("fruit",120),
//                new Dish("pizza",550));
//        List<Integer> lowCaloriesDishName=menu.stream()
//                .filter(d->d.getCalories()<400)
//                .sorted((d1,d2)->d1.getCalories()-d2.getCalories())
//                .map(Dish::getCalories)
//                .collect(toList());
//
//
//
//        for(Integer calories:lowCaloriesDishName)
//            System.out.println(calories);
//    }


//public static void main(String[] args) {
//    List<String> title=Arrays.asList("Java","Python","Go");
//    Stream<String> s=title.stream();
//    s.forEach(System.out::println);
//    s.forEach(System.out::println);
//}

//    public static void main(String[] args) {
//        List<Dish> menu=Arrays.asList(
//                new Dish("pork",800),
//                new Dish("beef",700),
//                new Dish("chicken",400),
//                new Dish("french fries",530),
//                new Dish("rice",350),
//                new Dish("fruit",120),
//                new Dish("pizza",550));
//        /*
//         * ????????????????????????
//         */
//        List<String> names=new ArrayList<>();
//        Iterator<Dish> iterator=menu.iterator();
//        while(iterator.hasNext()) {
//            Dish d=iterator.next();
//            names.add(d.getName());
//        }
//        System.out.println(names);
//
//        /*
//         * ?????????????????????
//         */
//        List<String> names2=menu.stream()
//                .map(Dish::getName)
//                .collect(toList());
//        System.out.println(names2);
//    }

//    public static void main(String[] args) {
//        List<Dish> menu=Arrays.asList(
//                new Dish("pork",800),
//                new Dish("beef",700),
//                new Dish("chicken",400),
//                new Dish("french fries",530),
//                new Dish("rice",350),
//                new Dish("fruit",120),
//                new Dish("pizza",550));
//
//        List<String> names=menu.stream()
//                .filter(d->d.getCalories()>400)
//                .map(d->d.getName())
//                .limit(3)
//                .collect(toList());
//        System.out.println(names);
//    }


//    public static void main(String[] args) {
//        List<Dish> menu=Arrays.asList(
//                new Dish("pork",800,false),
//                new Dish("beef",700,false),
//                new Dish("chicken",400,false),
//                new Dish("french fries",530,false),
//                new Dish("rice",350,false),
//                new Dish("fruit",120,true),
//                new Dish("tomato",200,true));
//
//        List<Dish> vegetableMenu=menu.stream()
//                .filter(d->d.isVegetable)//???????????????
//                .collect(toList());
//        System.out.println(vegetableMenu);
//    }

//    public static void main(String[] args) {
//        List<Integer> numbers01=Arrays.asList(1,2,2,3,4,4,5,7);
//        List<Integer> evenNumbers01=numbers01.stream()
//                .filter(x->x%2==0)//????????????
//                .collect(toList());
//        System.out.println(evenNumbers01);//[2, 2, 4, 4]
//
//        List<Integer> numbers02=Arrays.asList(1,2,2,3,4,4,5,7);
//        List<Integer> evenNumbers02=numbers02.stream()
//                .filter(x->x%2==0)//????????????
//                .distinct()//distinct??????????????????
//                .collect(toList());
//        System.out.println(evenNumbers02);//[2, 4]
//    }

//    public static void main(String[] args) {
//        List<Integer> numbers01=Arrays.asList(1,2,3,4,5,6,7,8,9);
//        List<Integer> evenNumbers01=numbers01.stream()
//                .filter(x->x%2==0)//????????????
//                .collect(toList());
//        System.out.println(evenNumbers01);//[2, 4, 6, 8]
//
//        List<Integer> numbers02=Arrays.asList(1,2,3,4,5,6,7,8,9);
//        List<Integer> evenNumbers02=numbers02.stream()
//                .filter(x->x%2==0)//????????????
//                .limit(2)
//                .collect(toList());
//        System.out.println(evenNumbers02);//[2, 4]
//    }


//    public static void main(String[] args) {
//        List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,7,8,9);
//        List<Integer> evenNumbers=numbers.stream()
//                .filter(x->x%2==0)//????????????
//                .skip(1)//??????????????????n?????????
//                .collect(toList());
//        System.out.println(evenNumbers);//[4, 6, 8]
//    }

//    public static void main(String[] args) {
//        /*
//         * ???????????????????????????  ????????????????????????????????????
//         */
//        List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,7,8,9);
//        List<Integer> evenNumbers=numbers.stream()
//                .filter(x->x%2==0)//????????????
//                .map(x->x*x)
//                .collect(toList());
//        System.out.println(evenNumbers);//[2,4,6,8]->[4, 16, 36, 64]
//    }

//    public static void main(String[] args) {
//        List<String> words=Arrays.asList("Monday","Tuesday");
//        List<String> characters=words.stream()
//                .map(word->word.split(""))//?????????????????????????????????????????????
//                .flatMap(Arrays::stream)//??????????????????????????????
//                .collect(toList());
//        System.out.println(characters);//[M, o, n, d, a, y, T, u, e, s, d, a, y]
//        System.out.println(characters.size());//13
//    }

//    public static void main(String[] args) {
//        /*
//         * reduce?????????????????????????????? ??????????????????????????????
//         * reduce???????????????????????????BinaryOperator<T>????????????????????????????????????????????????
//         */
//        List<Integer> numbers=Arrays.asList(4,3,5,9);
//        int sum=numbers.stream().reduce(0, (a,b)->a+b);
//        System.out.println("sum="+sum);//21
//    }

//    public static void main(String[] args) {
//        /*
//         * reduce???????????????
//         * ?????????????????????????????????????????????Optional??????
//         */
//        List<Integer> numbers=Arrays.asList(4,3,5,9);
//        Optional<Integer> maxNum=numbers.stream().reduce((x,y)->x>y?x:y);
//        Optional<Integer> minNum=numbers.stream().reduce((x,y)->x<y?x:y);
//        System.out.println("maxNum="+maxNum);//maxNum=Optional[9]
//        System.out.println("minNum="+minNum);//minNum=Optional[3]
//    }

//    public static void main(String[] args) {
//        /*
//         * reduce???????????????
//         * ?????????????????????????????????????????????Optional??????
//         */
//        List<Integer> numbers=Arrays.asList(4,3,5,9);
//        Optional<Integer> maxNum=numbers.stream().reduce((x,y)->x>y?x:y);
//        Optional<Integer> minNum=numbers.stream().reduce((x,y)->x<y?x:y);
//        System.out.println("maxNum="+maxNum);//maxNum=Optional[9]
//        System.out.println("minNum="+minNum);//minNum=Optional[3]
//    }


}

