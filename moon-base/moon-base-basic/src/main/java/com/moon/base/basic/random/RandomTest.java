package com.moon.base.basic.random;

/**
 * @ClassName RandomTest
 * @Description TODO
 * @Author lay
 * @Date 2019-04-25 10:25
 * @Version 1.0
 **/
public class RandomTest {
    public static void main(String[] args) {
        for(int i = 0;i<10;i++){
            System.out.println((int) (Math.random() * 5 + 1));
        }
    }
}
