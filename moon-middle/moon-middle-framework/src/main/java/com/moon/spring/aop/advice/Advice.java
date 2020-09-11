package com.moon.spring.aop.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/8/27 11:54 上午
 */
@Aspect
@Component
public class Advice {
    @Pointcut("execution(public * com.moon.spring.aop.service.StudentService.*(..))")
    public void pointcut(){

    }

    @After("com.moon.spring.aop.advice.Advice.pointcut()")
    public void after(){
        System.out.println("后置通知....");
    }
}
