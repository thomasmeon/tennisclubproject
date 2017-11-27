package com.frenchies.tennisclub.service.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.frenchies.tennisclub.PersistenceSampleApplicationContext;

/*
 * @Author Meon Thomas 473449
 */

@Configuration
@Import(PersistenceSampleApplicationContext.class)
@ComponentScan(basePackages = "cz.fi.muni.pa165.teamred.service")
public class ServiceConfiguration {
    @Bean
    public Mapper dozer() {
        return new DozerBeanMapper();
    }
}


