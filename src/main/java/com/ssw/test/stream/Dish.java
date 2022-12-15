package com.ssw.test.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ssw
 * @date 2022/8/8 16:27
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
class Dish{
    String name;
    // int price;
    int calories;
    boolean isVegetable;
}
