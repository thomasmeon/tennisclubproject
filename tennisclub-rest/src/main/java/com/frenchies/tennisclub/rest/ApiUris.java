package com.frenchies.tennisclub.rest;

/**
 * Represents the entry points for the API
 * this list can be increased so that it contains all the 
 * other URIs also for the sub-resources so that it can 
 * reused globally from all the controllers
 * 
 * @author Meon Thomas 473449
 */
public abstract class ApiUris {
    public static final String ROOT_URI_BOOKINGS   = "/bookings"; 
    public static final String ROOT_URI_USERS      = "/users";
    public static final String ROOT_URI_COURTS     = "/courts";  
}
