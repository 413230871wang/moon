package com.moon.base.basic.generic.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName ForeachTest
 * @Description TODO
 * @Author lay
 * @Date 2019-05-13 19:46
 * @Version 1.0
 **/
public class ForeachTest{
    public static final String aaa = "aaa";
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("aaaa".getClass());
        list.add(new Integer(1111).getClass());
        Iterator iterator = list.iterator();
        int i = 0;
        System.out.println(aaa);
        while(iterator.hasNext()){
            list.get(i);
            System.out.println(list.get(i));
            iterator.next();
            i++;
        }

    }
}
