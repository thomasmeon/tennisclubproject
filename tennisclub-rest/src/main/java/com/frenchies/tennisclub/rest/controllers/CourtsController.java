package com.frenchies.tennisclub.rest.controllers;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.frenchies.tennisclub.dto.CourtDTO;
import com.frenchies.tennisclub.facade.CourtFacade;
import com.frenchies.tennisclub.rest.ApiUris;
import com.frenchies.tennisclub.rest.exceptions.ResourceNotFoundException;


/**
 * REST Controller for Courts
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
        if (courtDTO != null) {
        	return courtDTO;
        } else {
            throw new ResourceNotFoundException();
        }
    }
    

    /**
     * Delete one court by id curl -i -X DELETE
     * http://localhost:8080/pa165/rest/courts/1
     *
     * @param id identifier for court
     * @throws ResourceNotFoundException
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final void deleteCourt(@PathVariable("id") long id) throws Exception {
        logger.debug("rest deleteCourt({})", id);
        try {
            courtFacade.deleteCourt(id);
        } catch (Exception ex) {
            throw new ResourceNotFoundException();
        }
    }
}
