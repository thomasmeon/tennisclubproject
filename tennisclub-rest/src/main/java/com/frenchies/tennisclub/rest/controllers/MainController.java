package com.frenchies.tennisclub.rest.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.frenchies.tennisclub.rest.ApiUris;
/**
 * 
 * @author Corentin DORE 473308
 *
 */
@RestController
public class MainController {
    
    final static Logger logger = LoggerFactory.getLogger(MainController.class);
    
    /**
     * The main entry point of the REST API
     * Provides access to all the resources with links to resource URIs
     * Can be even extended further so that all the actions on all the resources are available
     * and can be reused in all the controllers (possibly in full HATEOAS style)
     * 
     * @return resources uris
     */
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Map<String, String> getResources() {

        Map<String,String> resourcesMap = new HashMap<>();
        
        resourcesMap.put("bookings_uri", ApiUris.ROOT_URI_BOOKINGS);
        resourcesMap.put("courts_uri", ApiUris.ROOT_URI_COURTS);
        resourcesMap.put("users_uri", ApiUris.ROOT_URI_USERS);
        
        return Collections.unmodifiableMap(resourcesMap);
        
    }
}