package com.afj.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author afj
 * @Date 2020/11/18 10:19
 * @Version 1.0
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "student")
public class Student implements IStudent {

    private Long id;

    private String name;
}