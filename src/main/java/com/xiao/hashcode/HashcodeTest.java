package com.xiao.hashcode;

import java.util.HashMap;
import java.util.Map;

public class HashcodeTest {
    public static void main(String[] args) {
        Map<User, String> map = new HashMap<>();
        User user1 = new User(1, "xiao");
        map.put(user1, "test");
        User user2 = new User(1, "xiao");
        String result = map.get(user2);
        //默认的hashcode方法是根据地址生成hash，user1和user2地址不同，所以hash不同，无法正确获取到值。应当重写hashcode和equals方法
        System.out.println("是否能够获取到： "  + (result != null));
    }
}
