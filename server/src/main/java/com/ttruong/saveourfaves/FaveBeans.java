package com.ttruong.saveourfaves;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FaveBeans {

    @Bean
    public BusinessRepository businessRepository() {
        return new BusinessRepository();
    }

}
