package com.rainea.DynamicProxy;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("传入的对象是:" + proxy);
        System.out.println("调用的方法是：" + method);
        System.out.println("传入的参数是：" + JSON.toJSONString(args));
        return null;
    }
}
