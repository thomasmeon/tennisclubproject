package com.frenchies.tennisclub.rest.controllers;

import com.frenchies.tennisclub.rest.ApiUris;
import com.frenchies.tennisclub.rest.exceptions.ResourceNotFoundException;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.frenchies.tennisclub.dto.CourtDTO;
import com.frenchies.tennisclub.facade.CourtFacade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

/**
 * REST Controller for Categories
 * 
 * @author Meon Thomas 473449
 */
@RestController
@RequestMapping(ApiUris.ROOT_URI_COURTS)
public class CourtsController {

    final static Logger logger = LoggerFactory.getLogger(CourtsController.class);

    @Inject
    private CourtFacade courtFacade;

    /**
     * get all the courts
     * @return list of CourtDTOs
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final List<CourtDTO> getCourts() {

        logger.debug("rest getCourts()");
        return courtFacade.getAllCourts();
    }

    /**
     * 
     * Get one court specified by id
     * 
     * @param id identifier for the court
     * @return CourtDTO
     * @throws Exception ResourceNotFoundException
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final CourtDTO getCourt(@PathVariable("id") long id) throws Exception {

        logger.debug("rest getCourt({})", id);

        CourtDTO courtDTO = courtFacade.getCourtById(id);
        if (courtDTO == null) {
            throw new ResourceNotFoundException();
        }

        return courtDTO;
    }
}
