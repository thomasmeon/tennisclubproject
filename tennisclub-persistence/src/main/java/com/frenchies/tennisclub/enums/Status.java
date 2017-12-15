package com.frenchies.tennisclub.enums;

//@Author Dore Corentin UCO 473308

public enum Status {
	RESERVED, AVAILABLE;
	
	/**
     * Checks the enum for a string contained within
     * 
     * @param valueString
     * @return true if the string is contained in the enum 
     */
    public static boolean contains(final String valueString) {
        for (Status os : Status.values()) {
            if (os.name().equals(valueString)) {
                return true;
            }
        }
        return false;
    }
}
