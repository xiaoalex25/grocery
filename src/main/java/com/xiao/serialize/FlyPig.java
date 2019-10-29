package com.xiao.serialize;

import java.io.Serializable;

public class FlyPig implements Serializable {
    //值在类被加载时自动分配，序列化对象中会保存一个UID。反序列化之后对比序列化对象中的UID
    //和class中的UID来判断是否是同个类
    //private static final long serialVersionUID

    private String name;
    private String color;
    transient private String car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "FlyPig{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", car='" + car + '\'' +
                //", addTip='" + addTip + '\'' +
                '}';
    }
}
