package com.example.sweater.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class MyClass {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
//        PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
//        c.setLocation(new ClassPathResource("application.properties"));
//        return c;
//    }


//    public void setFILE_NAME(String FILE_NAME) {
//        this.FILE_NAME = FILE_NAME;
//    }

    @Value("${my.filename}")
    //@Value("test")
    private String FILE_NAME;


    public void foo(){
        System.out.println(FILE_NAME);
    }
}
