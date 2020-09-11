package com.moon.spring.aop.advice;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/8/27 10:15 上午
 */
public class AfterReturning {
    public void afterReturning(String returning){
        System.out.println("返回正常结果通知：打印返回结果："+returning);
    }
}
