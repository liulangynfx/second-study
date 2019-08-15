package com.rainea.lambda;

public class Student {
    public int age;
    public String name;
    public int point;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return name + ",age:" + age + ",poing:" + point;
    }

    public static void main(String[] args) {
//        Student student = new Student();
//        student.setName("liulnag");
//        Student student11 = new Student();
//        student11.setName("liulnag11");
//        Student student2 = new Student();
//        student2.setName("liulnag2");
//        Student student3 = new Student();
//        student3.setName("liulnag3");
//        System.out.println(student.hashCode());
//        System.out.println(student11.hashCode());
//        System.out.println(student2.hashCode());
//        System.out.println(student3.hashCode());
        String ss = "123";
        String ss2 = new String("123");
        System.out.println(ss.equals(ss2));
    }
}
