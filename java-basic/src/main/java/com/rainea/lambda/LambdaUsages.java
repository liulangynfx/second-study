package com.rainea.lambda;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.omg.CORBA.StringHolder;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * lambda表达式用法
 */
public class LambdaUsages {

    /**
     * 集合遍历
     */
    private void foreachTest() {
        List<String> languages = Arrays.asList("java", "C", "C++");
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("t", 1));
        personList.add(new Person("y", 1));


//        for (String language : languages) {
//            System.out.println(language);
//        }

        System.out.println("--------");
        //lambda
        personList.forEach((x) -> x.name = "bbbbb");
        personList.forEach((x) -> System.out.println(x));
    }

    private void mapTest() {
        List<Double> cost = Arrays.asList(0.0, 2.0, 30.0);
        cost.stream().map(x -> 2*x).forEach(x -> System.out.println(x));
    }

    public static void filterTest(List<String> languages, Predicate<String> condition) {
        languages.stream().filter(x -> condition.test(x)).forEach(x -> System.out.println(x + " "));
    }

    public static void main(String[] args) {


    }

    class Person {
        public String name;
        public int age = 0;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return this.name + ":" + this.age;
        }
    }
}
