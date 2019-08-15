package com.rainea.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author liulang
 * @date 2019-07-31
 */
public class ConsumerTest {

    public static void main(String[] args) {
        Consumer<Integer> consumer = (x) -> {
            int num = x * 2;
            System.out.println(num);
        };
        Consumer<Integer> consumer1 = (x) -> {
            int num = x * 3;
            System.out.println(num);
        };
        consumer.andThen(consumer1);

        //
        List<String> list = Arrays.asList("qq");
        list.forEach((x) -> {
            System.out.println(x);
        });
    }




}
