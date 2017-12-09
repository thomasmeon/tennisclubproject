package com.frenchies.tennisclub.exceptions;


public class TennisClubServiceException extends RuntimeException{

	public TennisClubServiceException() {
		super();
	}

	public TennisClubServiceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TennisClubServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public TennisClubServiceException(String message) {
		super(message);
	}

	public TennisClubServiceException(Throwable cause) {
		super(cause);
	}

}
