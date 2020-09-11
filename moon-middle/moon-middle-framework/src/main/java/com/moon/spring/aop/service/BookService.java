package com.moon.spring.aop.service;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/8/26 5:53 下午
 */
public class BookService {
    public void add() throws Exception {
        System.out.println("我添加了一本书.....");
    }

    public String findById(){
        System.out.println("查找方法...");
        return "无限恐怖";
    }
    public void show(){
        System.out.println("显示所有图书.....");
    }
}
