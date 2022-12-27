package com.ssw.test.compara;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Arrays;

/**
 * @author ssw
 * @date 2022/10/25 16:48
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Goods implements Comparable {
    private String name;
    private double price;

    //指明商品比较大小的方式:按照价格从低到高排序,再按照产品名称从高到低排序
    @Override
    public int compareTo(Object o) {
        //System.out.println("**************");
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            //方式一：比较两个double数
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            } else {
                //return 0;
                return -this.name.compareTo(goods.name);
            }
            //方式二：比较两个double数
            //return Double.compare(this.price,goods.price);
        }
        //return 0;
        throw new RuntimeException("传入的数据类型不一致！");
    }
}
