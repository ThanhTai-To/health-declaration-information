package com.thanhtai.healthdeclarationinformation;

import com.thanhtai.healthdeclarationinformation.aop.ActionAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class HealthDeclarationInformationApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthDeclarationInformationApplication.class, args);
    }

    @Bean
    public ActionAspect actionAspect() {
        return new ActionAspect();
    }

}
