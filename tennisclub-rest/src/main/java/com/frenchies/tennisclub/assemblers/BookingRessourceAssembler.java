package com.frenchies.tennisclub.assemblers;

import com.frenchies.tennisclub.dto.BookingDTO;
import com.frenchies.tennisclub.rest.controllers.BookingsControllerHateoas;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * This class shows a resource assembler for a HATEOAS REST Service we are
 * mapping the DTO to a resource 
 * 
 * @author Meon Thomas 473449
 */
@Component
public class BookingResourceAssembler implements ResourceAssembler<BookingDTO, Resource<BookingDTO>> {

    @Override
    public Resource<BookingDTO> toResource(BookingDTO bookingDTO) {
        long id = bookingDTO.getIdBooking();
        Resource<BookingDTO> bookingResource = new Resource<BookingDTO>(bookingDTO);

        try {
        	bookingResource.add(linkTo(BookingsControllerHateoas.class).slash(bookingDTO.getIdBooking()).withSelfRel());
        	bookingResource.add(linkTo(BookingsControllerHateoas.class).slash(bookingDTO.getIdBooking()).withRel("DELETE"));

        } catch (Exception ex) {
            Logger.getLogger(BookingResourceAssembler.class.getName()).log(Level.SEVERE, "could not link resource from BookingsControllerHateoas", ex);
        }

        return bookingResource;
    }
}