package com.yui.system.myemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MyEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyEmailApplication.class, args);
    }
}
