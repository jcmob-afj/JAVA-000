package com.afj.starter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author afj
 * @Date 2020/11/18 10:21
 * @Version 1.0
 * @description:
 */
@Configuration
@AutoConfigureBefore({Student.class,Student2.class})
@ConditionalOnProperty(name = {"student.enable","student2.enable"}, havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties({Student.class,Student2.class})
public class StudentAutoConfiguration {

    @Autowired
    private Student student;
    @Autowired
    private Student2 student2;

    @Bean
    @ConditionalOnMissingBean
    public Klass getKlass() {
        Klass klass = new Klass();
        List<IStudent> students = new ArrayList<>();
        students.add(student);
        students.add(student2);
        klass.setStudents(students);
        return klass;
    }

    @ConditionalOnMissingBean
    public School getSchool() {
        School school = new School();
        List<Klass> klassList = new ArrayList<>();
        Klass klass = getKlass();
        klassList.add(klass);
        school.setKlassList(klassList);
        return school;
    }
}