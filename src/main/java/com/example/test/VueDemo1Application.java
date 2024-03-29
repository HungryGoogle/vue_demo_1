package com.example.test;

import com.example.test.util.config.DishConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
@MapperScan("com.example.test.mapper")
@ComponentScan("com.example.test.*")
@EnableConfigurationProperties(DishConfig.class)
public class VueDemo1Application {
    public static void main(String[] args) {
        SpringApplication.run(VueDemo1Application.class, args);
    }
}

