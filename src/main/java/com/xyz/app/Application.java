package com.xyz.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 启动应用程序主类
 * Created by Lenovo on 2018/1/6.
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ServletComponentScan
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
