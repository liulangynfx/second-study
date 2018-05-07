package com.rainea.lambda;

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
//        new LambdaUsages().foreachTest();
        List<String> languages = Arrays.asList("java", "C", "C++", "Python", "jRuby", "Go");
        List<String> list = new ArrayList<>();
//        Optional<String> optional = languages.stream().filter(x -> x.equals("gg")).findFirst();
//        if (optional.isPresent()) {
//            System.out.println(optional.get());
//        } else {
//            System.out.println("dsfdsfsdf");
//        }

         List<String> list1 = languages.stream()
                .filter(name -> name.startsWith("java2"))
                .collect(Collectors.toList());

//         list1.stream().forEach(x -> System.out.println(x));

//        JSONObject.parseObject();
//        System.out.println(languages.subList(0,2));
        AtomicInteger idx = new AtomicInteger(0);

        List<String> collect = languages.stream().map((str) -> {
            if (str.contains("j")) {
                return str;
            } else {
                return "j" + str;
            }
        }).filter(x -> x.equals("jC")).collect(Collectors.toList());

//        System.out.println(collect);

        System.out.println("ss".equals(null));

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
