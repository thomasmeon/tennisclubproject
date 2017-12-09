package com.frenchies.tennisclub.mvc.forms;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.frenchies.tennisclub.dto.BookingCreateDTO;

/**
 * The place for validation checks. Useful for checks involving multiple properties at once.
 * This SpringMVC validation is <b>additional</b> to the JSR-303 validation specified by annotations in CourtCreateDTO.
 *
 * @author Dore Corentin UCO 473308
 */
public class BookingCreateDTOValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return BookingCreateDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    	BookingCreateDTO bookingCreateDTO = (BookingCreateDTO) target;
        if (bookingCreateDTO.getIdCourt() == null) return;
        if (bookingCreateDTO.getUser1() == null) return;
        if (bookingCreateDTO.getDateOfBooking() == null) return;
        if (bookingCreateDTO.getHourOfBooking() == null) return;
    }
}
