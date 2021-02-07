package com.ttruong.saveourfaves.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ttruong.saveourfaves.accessor.BusinessAccessor;

@Configuration
public class BusinessBeans {

    @Bean
    public BusinessAccessor businessRepository() {
        return new BusinessAccessor();
    }

}
