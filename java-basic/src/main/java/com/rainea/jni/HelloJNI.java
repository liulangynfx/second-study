package com.rainea.jni;

/**
 * @author brandon
 * @date 2019-07-16
 */
public class HelloJNI {

    public static native void sayHelloWorld();

    public static void main(String[] args) {
        //String property = System.getProperty("java.library.path");
        //System.out.println(property);
        System.load("/Users/liulang/myCode/second-study/java-basic/src/main/java/com/rainea/jni/libhello.jnilib");
        HelloJNI.sayHelloWorld();
    }
}
