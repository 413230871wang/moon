package com.moon.spring.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/8/26 5:52 下午
 */
public class BeforeAdvice {
    public void methodBefore(){
        System.out.println("我在方法之前执行.....");
    }

    public void methodAfter(){
        System.out.println("我在方法之后执行......");
    }


    public void methodThrowingException(){
        System.out.println("我在报错之后执行.......");
    }

    public void before(JoinPoint point){
        System.out.println(point.getSignature().getName());
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        try {
            System.out.println("环绕通知......");
            Object proceed = proceedingJoinPoint.proceed();
            System.out.println("环绕通知原方法之后....");
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
