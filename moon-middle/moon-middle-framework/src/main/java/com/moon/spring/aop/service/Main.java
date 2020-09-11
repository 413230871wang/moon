package com.moon.spring.aop.service;

import com.moon.spring.aop.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/8/27 9:49 上午
 */
public class Main {
    public static void main(String[] args) throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/springConfig.xml");
        BookService bookService = applicationContext.getBean("bookService",BookService.class);
        bookService.add();
        bookService.findById();
        bookService.show();
    }
}
