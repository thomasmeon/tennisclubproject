package com.frenchies.tennisclub.exceptions;

import javax.naming.AuthenticationException;

//@Author Meon Thomas UCO 473449


public class UserAuthentificationException extends AuthenticationException {

/*    public UserAuthentificationException(String msg, Throwable t) {
        super(msg, t);
    }*/

    public UserAuthentificationException(String msg) {
        super(msg);
    }
}