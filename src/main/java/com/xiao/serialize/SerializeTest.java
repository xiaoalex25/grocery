package com.xiao.serialize;

import java.io.*;

public class SerializeTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //serializeFlyPig();
        FlyPig flyPig = deserializeFlyPig();
    }

    /**
     * 序列化
     */
    public static void serializeFlyPig() throws IOException {
        FlyPig flyPig = new FlyPig();
        flyPig.setName("naruto");
        flyPig.setCar("0000");
        flyPig.setColor("black");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D:/flyPig.txt")));
        oos.writeObject(flyPig);
        System.out.println("序列化成功");
        oos.close();
    }

    /**
     * 反序列化
     */
    public static FlyPig deserializeFlyPig() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:/flyPig.txt")));
        FlyPig flyPig = (FlyPig) ois.readObject();
        System.out.println("放序列化成功");
        return flyPig;
    }
}
