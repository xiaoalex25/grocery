package com.xiao.staticInner;

public class StaticTest {
    private static String name = "woobo";
    private String num = "X001";

    static class Person {
        //静态内部类中可以定义静态成员或者非静态成员
        private String address = "China";
        private static String x = "as";
        //内部类共有成员
        public String mail = "kongbowoo@yahoo.com.cn";

        public void display() {
            //System.out.println(num);//不能直接输出外部类的非静态成员
            //静态内部类不能直接访问外部类的非静态成员即方法
            System.out.println(name);//可以访问外部类的静态成员
        }
    }

    public void printInfo() {
        //外部类访问时直接new一个对象
        Person person = new Person();
        person.display();
        //System.out.println(mail);//不可访问
        System.out.println(person.address);//可以访问内部类的私有成员
        System.out.println(Person.x);//可以访问内部类的静态成员
    }
}
