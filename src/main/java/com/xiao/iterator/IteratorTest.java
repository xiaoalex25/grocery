package com.xiao.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            //String next = iterator.next();
            //if (next.equals("a")) {
                list.remove(0);
            //}
        }
    }
}
