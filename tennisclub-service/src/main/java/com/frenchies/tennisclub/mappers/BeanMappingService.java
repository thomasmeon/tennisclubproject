package com.frenchies.tennisclub.mappers;

import java.util.Collection;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;

/**
 * Bean mapping service.
 *
 */

//@Author Dore Corentin UCO 473308

@Service
public interface BeanMappingService {

    public  <T> List<T> mapTo(Collection<?> objects, Class<T> mapToClass);

    public  <T> T mapTo(Object u, Class<T> mapToClass);

    public Mapper getMapper();
    
}
