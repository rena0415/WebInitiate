package com.rena.wi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * description 程序入口
 *
 * @author rena
 * @date 2018/11/9 11:10
 **/
@SpringBootApplication
@MapperScan("com.rena.wi.dao")
public class WIApplication  extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WIApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(WIApplication.class, args);
    }
}
