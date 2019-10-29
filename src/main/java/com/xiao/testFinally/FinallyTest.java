package com.xiao.testFinally;

public class FinallyTest {

    public static void main(String[] args) {
        System.out.println("test1输出： " + new FinallyTest().test1());
        System.out.println("test2输出： " + new FinallyTest().test2());
    }

    public int test1() {
        int i = 0;
        try{
            i = 1;
            return i;
        }finally {
            i = 2;
            //finally中有return时，复制会起作用
            return i;
        }
    }

    public int test2() {
        int i = 0;
        try{
            i = 1;
            return i;
        }finally {
            //finally中没有return时复制不起作用
            i = 2;
        }
    }
}
