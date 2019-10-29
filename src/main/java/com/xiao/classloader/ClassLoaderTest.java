package com.xiao.classloader;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {
    public static void main(String[] args) {

        //测试不同加载器加载同个类
        try {
            ClassLoader classLoader = new ClassLoader() {
                @Override
                public Class<?> loadClass(String name) throws ClassNotFoundException {
                    try {
                        String fileName = name.substring(name.lastIndexOf("." ) + 1) + ".class";
                        InputStream is = getClass().getResourceAsStream(fileName);
                        if (is == null) {
                            return super.loadClass(name);
                        }
                        byte[] bytes = new byte[is.available()];
                        is.read(bytes);
                        return defineClass(name, bytes, 0, bytes.length);
                    } catch (IOException e) {
                        throw new ClassNotFoundException(name);
                    }
                }
            };

            Object obj = classLoader.loadClass("com.xiao.classloader.ClassLoaderTest").newInstance();
            //不同加载器加载的同个类在jvm中当成不同的类处理
            System.out.println(obj instanceof  com.xiao.classloader.ClassLoaderTest);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        //测试Class.forname和loadClass
        try {
            //forname方法加载类的时候执行了静态代码块
            System.out.println("--------");
            Class<?> name = Class.forName("com.xiao.classloader.Test");
            //loadClass方法不执行静态代码块
            System.out.println("--------");
            new ClassLoaderTest().getClass().getClassLoader().loadClass("com.xiao.classloader.Test");
            //调用newInstance的时候也不执行
            System.out.println("--------");
            new ClassLoaderTest().getClass().getClassLoader().loadClass("com.xiao.classloader.Test").newInstance();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
