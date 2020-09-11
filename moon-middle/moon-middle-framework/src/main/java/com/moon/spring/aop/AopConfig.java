package com.moon.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/8/27 11:08 上午
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.moon.spring.aop.advice")
public class AopConfig {
}
