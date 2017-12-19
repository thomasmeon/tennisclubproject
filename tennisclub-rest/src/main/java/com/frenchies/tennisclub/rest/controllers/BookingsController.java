package com.frenchies.tennisclub.rest.controllers;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.frenchies.tennisclub.dto.BookingCreateDTO;
import com.frenchies.tennisclub.dto.BookingDTO;
import com.frenchies.tennisclub.facade.BookingFacade;
import com.frenchies.tennisclub.rest.ApiUris;
import com.frenchies.tennisclub.rest.exceptions.ResourceAlreadyExistingException;
import com.frenchies.tennisclub.rest.exceptions.ResourceNotFoundException;

/**
 * REST Controller for Bookings
 *
 * @author Meon Thomas 473449
 */
@RestController
@RequestMapping(ApiUris.ROOT_URI_BOOKINGS)
public class BookingsController {

    final static Logger logger = LoggerFactory.getLogger(BookingsController.class);

    @Inject
    private BookingFacade bookingFacade;

    /**
     * Get list of Bookings curl -i -X GET
     * http://localhost:8080/pa165/rest/bookings
     *
     * @return BookingDTO
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final List<BookingDTO> getBookings() {
        logger.debug("rest getBookings()");
        return bookingFacade.getAllBookings();
    }

    /**
     *
     * Get Booking by identifier id curl -i -X GET
     * http://localhost:8080/pa165/rest/bookings/1
     *
     * @param id identifier for a booking
     * @return BookingDTO
     * @throws ResourceNotFoundException
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final BookingDTO getBooking(@PathVariable("id") long id) throws Exception {
        logger.debug("rest getBooking({})", id);
        BookingDTO bookingDTO = bookingFacade.getBookingById(id);
        if (bookingDTO != null) {
            return bookingDTO;
        } else {
            throw new ResourceNotFoundException();
        }

    }

    /**
     * Delete one booking by id curl -i -X DELETE
     * http://localhost:8080/pa165/rest/bookings/1
     *
     * @param id identifier for booking
     * @throws ResourceNotFoundException
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final void deleteBooking(@PathVariable("id") long id) throws Exception {
        logger.debug("rest deleteBooking({})", id);
        try {
            bookingFacade.deleteBooking(id);
        } catch (Exception ex) {
            throw new ResourceNotFoundException();
        }
    }

    /**
     * Create a new booking by POST method
    
     * http://localhost:8080/pa165/rest/bookings/create
     * 
     * @param booking BookingCreateDTO with required fields for creation
     * @return the created booking BookingDTO
     * @throws ResourceAlreadyExistingException
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public final BookingDTO createBooking(@RequestBody BookingCreateDTO booking) throws Exception {

        logger.debug("rest createBooking()");

        try {
            Long id = bookingFacade.createBooking(booking);
            return bookingFacade.getBookingById(id);
        } catch (Exception ex) {
            throw new ResourceAlreadyExistingException();
        }
    }

}
