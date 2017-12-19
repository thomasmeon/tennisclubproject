package com.frenchies.tennisclub.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Corentin DORE 473308
 */
@JsonIgnoreProperties({ "passwordHash"})
public class UserDTOMixin {
    
}
