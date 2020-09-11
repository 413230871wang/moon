package com.moon.extension.poi;

import com.cfc.common.utils.LogUtil;
import com.cfc.common.utils.SpringContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

/**
 * @desc:TODO
 * @author:lay
 * @date:2020/7/24 11:17 上午
 */
@SpringBootApplication
@PropertySource(ignoreResourceNotFound=true,value= "classpath:properties/application.properties")
@RestController
@MapperScan("com.moon.extension.poi.mapper")
public class Application {
    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(Application.class, args);
        SpringContextUtil.setApplicationContextStaticlly((WebApplicationContext) app);
        LogUtil.info("信息注册服务启动成功！");
    }
}
