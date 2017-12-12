package com.frenchies.tennisclub.rest.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.frenchies.tennisclub.dto.BookingDTO;
import com.frenchies.tennisclub.facade.BookingFacade;
import com.frenchies.tennisclub.rest.assemblers.BookingRessourceAssembler;
import com.frenchies.tennisclub.rest.exceptions.ResourceNotFoundException;
import com.frenchies.tennisclub.rest.exceptions.ResourceNotModifiedException;

/**
 * REST HATEOAS Controller for Bookings
 * This class shows Spring support for full HATEOAS REST services
 * it uses the {@link com.frenchies.tennisclub.assemblers.bookingRessourceAssembler} to create 
 * resources to be returned as ResponseEntities
 *
 */
@RestController
@RequestMapping("/bookings_hateoas")
public class BookingsControllerHateoas {

    final static Logger logger = LoggerFactory.getLogger(BookingsControllerHateoas.class);

    @Inject
    private BookingFacade bookingFacade;

    @Inject
    private BookingRessourceAssembler bookingRessourceAssembler;

    /**
     *
     * Get list of bookings
     * 
     * @return HttpEntity<Resources<Resource<BookingDTO>>>
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final HttpEntity<Resources<Resource<BookingDTO>>> getBookings() {
        
        logger.debug("rest getBookings({}) hateoas");

        Collection<BookingDTO> bookingsDTO = bookingFacade.getAllBookings();
        Collection<Resource<BookingDTO>> bookingResourceCollection = new ArrayList();

        for (BookingDTO b : bookingsDTO) {
        	bookingResourceCollection.add(bookingRessourceAssembler.toResource(b));
        }

        Resources<Resource<BookingDTO>> bookingsResources = new Resources<Resource<BookingDTO>>(bookingResourceCollection);
        bookingsResources.add(linkTo(BookingsControllerHateoas.class).withSelfRel());

        return new ResponseEntity<Resources<Resource<BookingDTO>>>(bookingsResources, HttpStatus.OK);

    }
    
    /**
     *
     * Get list of bookings - this method also supports HTTP caching
     * See http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-caching
     * 
     * See also http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/context/request/WebRequest.html#checkNotModified-java.lang.String-
     * 
     * The conditional request can be sent with
     * curl -i -X GET http://localhost:8080/tennisclub-rest/bookings_hateoas/cached  --header 'If-None-Match: "077e8fe377ab6dfa8b765b166972ba2d6"'
     * 
     * @return HttpEntity<Resources<Resource<BookingDTO>>>
     */
    @RequestMapping(value = "/cached", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final HttpEntity<Resources<Resource<BookingDTO>>> getBookingsCached(WebRequest webRequest) {
        
        logger.debug("rest getBookings({}) hateoas cached version");
       
        final Collection<BookingDTO> bookingsDTO = bookingFacade.getAllBookings();
        final Collection<Resource<BookingDTO>> bookingResourceCollection = new ArrayList();

        for (BookingDTO b : bookingsDTO) {
        	bookingResourceCollection.add(bookingRessourceAssembler.toResource(b));
        }

        Resources<Resource<BookingDTO>> bookingsResources = new Resources(bookingResourceCollection);
        bookingsResources.add(linkTo(BookingsControllerHateoas.class).withSelfRel());

        final StringBuffer eTag = new StringBuffer("\"");
        eTag.append(Integer.toString(bookingsResources.hashCode()));
        eTag.append('\"');
        
        if (webRequest.checkNotModified(eTag.toString())){
            throw new ResourceNotModifiedException();
        }
                
        return ResponseEntity.ok().eTag(eTag.toString()).body(bookingsResources);
    }

    /**
     *
     * Get one booking according to id
     * 
     * @param id identifier for booking
     * @return HttpEntity<Resource<BookingDTO>>
     * @throws ResourceNotFoundException
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final HttpEntity<Resource<BookingDTO>> getBooking(@PathVariable("id") long id) throws Exception {
        
        logger.debug("rest getBooking({}) hateoas", id);

        try {
        	BookingDTO bookingDTO = bookingFacade.getBookingById(id);
            Resource<BookingDTO> resource = bookingRessourceAssembler.toResource(bookingDTO);
            return new ResponseEntity<Resource<BookingDTO>>(resource, HttpStatus.OK);    
        } catch (Exception ex){
            throw new ResourceNotFoundException();
        }
    }
    
        /**
     * Delete one booking by id curl -i -X DELETE
     * http://localhost:8080/tennisclub-rest/bookings/1
     *
     * @param id identifier for booking
     * @throws ResourceNotFoundException
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final void deleteBooking(@PathVariable("id") long id) throws Exception {
        logger.debug("rest deleteBooking({}) hateoas", id);
        try {
        	bookingFacade.deleteBooking(id);
        } catch (Exception ex) {
            throw new ResourceNotFoundException();
        }
    }

}
