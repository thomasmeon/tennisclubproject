package com.frenchies.tennisclub.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class shows an example of Jackson mix-ins in case we do not want to modify one DTO
 * in the API layer
 * @author Meon Thomas 473449
 */
@JsonIgnoreProperties({ "imageMimeType", "image" })
public abstract class BookingDTOMixin {
}