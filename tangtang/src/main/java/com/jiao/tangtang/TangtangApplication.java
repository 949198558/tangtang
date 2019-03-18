package com.jiao.tangtang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jiao.tangtang.mapper")
public class TangtangApplication {

    public static void main(String[] args) {
        SpringApplication.run(TangtangApplication.class, args);
    }

}
