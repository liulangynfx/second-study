package com.rainea.DynamicProxy;

import java.lang.reflect.Proxy;

public class MainTest {
    public static void main(String[] args) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();

        Person p = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, myInvocationHandler);
        p.eat("香蕉", "苹果");
        p.say("你是好人");
    }
}
