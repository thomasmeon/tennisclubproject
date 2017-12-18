package com.frenchies.tennisclub.mvc.forms;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.frenchies.tennisclub.dto.CourtCreateDTO;

/**
 * The place for validation checks. Useful for checks involving multiple properties at once.
 * This SpringMVC validation is <b>additional</b> to the JSR-303 validation specified by annotations in CourtCreateDTO.
 *
 * @author Dore Corentin UCO 473308
 */
public class CourtCreateDTOValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CourtCreateDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CourtCreateDTO courtCreateDTO = (CourtCreateDTO) target;
        if (courtCreateDTO.getType() == null) return;
        if (courtCreateDTO.getStatus() == null) return;
    }
}
