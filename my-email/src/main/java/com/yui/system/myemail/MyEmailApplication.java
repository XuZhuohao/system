package com.yui.system.myemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableEurekaClient
@SpringBootApplication
@EnableJpaAuditing
public class MyEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyEmailApplication.class, args);
    }
}
