package com.moon.base.basic.generic.test;

import com.moon.base.basic.generic.Generic;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName GenericTest
 * @Description TODO
 * @Author lay
 * @Date 2019-05-11 10:29
 * @Version 1.0
 **/
public class GenericTest {
    public static void main(String[] args) {
        //泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
//传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        Generic<Integer> genericInteger = new Generic<Integer>(123456);

        //传入的实参类型需与泛型的类型参数类型相同，即为String.
        Generic<String> genericString = new Generic<String>("key_vlaue");

        System.out.println("泛型测试key is " + genericInteger.getKey());
        System.out.println("泛型测试key is " + genericString.getKey());

        Generic<Integer> gInteger = new Generic<Integer>(123);
        Generic<Number> gNumber = new Generic<Number>(456);

        System.out.println("泛型测试key is " + gInteger.getKey());
        System.out.println("泛型测试key is " + gNumber.getKey());

        showKeyValue1(gNumber);

        List arrayList = new ArrayList();
        arrayList.add("aaaa");
        arrayList.add(100);

    }

    public static void showKeyValue1(Generic<?> obj){
        System.out.println("泛型测试key value is " + obj.getKey());
    }
}
