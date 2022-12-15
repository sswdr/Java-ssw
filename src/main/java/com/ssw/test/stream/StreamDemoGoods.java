package com.ssw.test.stream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
/**
 * @author ssw
 * @date 2022/8/8 19:39
 */
public class StreamDemoGoods {

//    public static void main(String[] args) {
//        List<Goods> goods=Arrays.asList(
//                new Goods("Apple", 10),
//                new Goods("Banana", 5),
//                new Goods("Bread", 3),
//                new Goods("Milk", 15),
//                new Goods("Wine", 20));
//        //将Good对象流映射到价格流（整数流） 并求出价格总和
//        int priceSum=goods.stream().mapToInt(g->g.getPrice()).sum();
//        System.out.println(priceSum+"\n");//53
//
//        IntStream intStream = goods.stream().mapToInt(g -> g.getPrice());
//        intStream.forEach(System.out::println);
//    }

//    public static void main(String[] args) {
//        List<Goods> goods=Arrays.asList(
//                new Goods("Apple", 10),
//                new Goods("Banana", 5),
//                new Goods("Bread", 3),
//                new Goods("Milk", 15),
//                new Goods("Wine", 20));
//        IntStream intStream=goods.stream().mapToInt(g->g.getPrice());
//        Stream<Integer> stream=intStream.boxed();
//    }

//    public static void main(String[] args) {
//        //生成[1,50]内的所有偶数
//        IntStream evenNums=IntStream.rangeClosed(1, 50).filter(x->x%2==0);
//        evenNums.forEach(x->{System.out.print(" "+x);});
//    }

    public static void main(String[] args) {
//        Stream<String> lines=null;
//        try {
//            lines= Files.lines(Paths.get("data.txt"), Charset.defaultCharset());
//            lines.forEach(System.out::println);
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }finally {
//            lines.close();
//        }

//        /*
//         * iterate方法接受一个初始值（在这里是0），还有一个依次应用在每个产生的新值上的Lambda（UnaryOperator<t>类型）
//         * 这里，我们使用Lambda n-> n+2，返回的是前一个元素加上2
//         */
//        Stream.iterate(0,n->n+2)
//                .limit(10)
//                .forEach(System.out::println);
//
//        /*
//         * 生成斐波那契数列
//         */
//        Stream.iterate(new int[] {0,1},t->new int[] {t[1],t[0]+t[1]})
//                .limit(10)
//                .forEach(t->{System.out.println(t[0]+" "+t[1]);});



        /*
         * 生成10个随机数
         */
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

    }




}
