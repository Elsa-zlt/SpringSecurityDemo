package com.elsa.securityjwt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.elsa.securityjwt.mapper")
public class SecurityJwtDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityJwtDemoApplication.class, args);
    }

}
