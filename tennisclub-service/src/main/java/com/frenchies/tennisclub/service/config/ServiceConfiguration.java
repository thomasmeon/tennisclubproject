package com.frenchies.tennisclub.service.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.frenchies.tennisclub.PersistenceSampleApplicationContext;

@Configuration
@Import(PersistenceSampleApplicationContext.class)
@ComponentScan(basePackages = "com.frenchies.tennisclub.service")
public class ServiceConfiguration {
    @Bean
    public Mapper dozer() {
        return new DozerBeanMapper();
    }
}


