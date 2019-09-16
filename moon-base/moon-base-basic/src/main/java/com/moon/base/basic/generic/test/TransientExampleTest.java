package com.moon.base.basic.generic.test;

import java.io.*;

/**
 * @ClassName TransientExampleTest
 * @Description TODO
 * @Author lay
 * @Date 2019-05-13 20:17
 * @Version 1.0
 **/
public class TransientExampleTest {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        RectangleTest rectangle = new RectangleTest(3,4);
        System.out.println("1.原始对象\n"+rectangle);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("rectangle"));
        // 往流写入对象
        o.writeObject(rectangle);
        o.close();

        // 从流读取对象
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("rectangle"));
        RectangleTest rectangle1 = (RectangleTest)in.readObject();
        System.out.println("2.反序列化后的对象\n"+rectangle1);
        rectangle1.setArea();
        System.out.println("3.恢复成原始对象\n"+rectangle1);
        in.close();
    }
}
