package com.afj.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author afj
 * @Date 2020/11/18 10:22
 * @Version 1.0
 * @description:
 */
@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        StudentAutoConfiguration school = applicationContext.getBean(StudentAutoConfiguration.class);
        System.out.println(school.getSchool().toString());
    }



}
