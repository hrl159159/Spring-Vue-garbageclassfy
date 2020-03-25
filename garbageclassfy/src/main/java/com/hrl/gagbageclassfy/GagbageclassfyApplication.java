package com.hrl.gagbageclassfy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableCaching
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
public class GagbageclassfyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GagbageclassfyApplication.class, args);
    }

}
