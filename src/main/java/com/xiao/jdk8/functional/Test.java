package com.xiao.jdk8.functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 函数式接口指只有一个方法的接口如何Consumer，其中apply方法为lambda表示默认实现的接口
 * 此外可以添加一些default的实现方法来支持其内部的一些操作如addThen方法
 */
public class Test {
    public static void main(String[] args) {
        //Test.testConsumer();
        //Test.testFunction();
        Test.testPredicate();
    }


    /**
     *  Consumer接口测试
     *  Consumer执行一个方法，没有返回值
     */
    public static void testConsumer() {
        Consumer f = System.out::println;
        Consumer f2 = n -> System.out.println(n + "-F2");
        //f2.accept("test");//accept用于接收函数式接口的参数
        //andThen表示调用完成当前方法之后还要调用的方法
        f.andThen(f2).accept("test");
    }


    /**
     * Function接口测试
     * Function执行一个即有输入又有输出的方法
     */
    public static void testFunction() {
        Function<Integer, Integer> f = s -> ++s;
        Function<Integer, Integer> g = s -> s * 2;
        //apply执行函数体
        //System.out.println(f.apply(1));
        //先执行g中的方法，在将g的结构作为f的输入
        System.out.println(f.compose(g).apply(3));
    }

    /**
     * Predicate接口测试
     * Predicate用于判断对错，返回boolean
     */
    public static void testPredicate() {
        Predicate<String> p = (o) -> o.equals("test");
        Predicate<String> g = (o) -> o.startsWith("t");

        System.out.println(p.test("test"));
        //negate方法表示取反
        System.out.println(p.negate().test("test"));
    }
}
