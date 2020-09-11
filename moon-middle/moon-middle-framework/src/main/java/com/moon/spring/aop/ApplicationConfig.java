package com.moon.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/8/27 11:45 上午
 */
@Configuration
@Import({AopConfig.class})
@ComponentScan("com.moon.spring.aop.service")
public class ApplicationConfig {
}
