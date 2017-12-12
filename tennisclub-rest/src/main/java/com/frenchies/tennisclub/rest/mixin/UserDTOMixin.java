package com.frenchies.tennisclub.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Meon Thomas 473449
 */
@JsonIgnoreProperties({ "passwordHash"})
public class UserDTOMixin {
    
}
