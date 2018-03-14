package com.rainea.DynamicProxy;

public class Test {
    public static void main(String[] args) {
        for (int i=0; i<1000000; i++) {
            System.out.println(i + i-1);

        }
    }
}
