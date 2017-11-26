package com.frenchies.tennisclub.service;

import javax.inject.Inject;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.frenchies.tennisclub.mappers.BeanMappingService;
import com.frenchies.tennisclub.service.config.ServiceConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import javax.inject.Inject;

@ContextConfiguration(classes = ServiceConfiguration.class)
public abstract class BaseServiceTest extends AbstractTestNGSpringContextTests {
    @Inject
    protected BeanMappingService beanMappingService;
}