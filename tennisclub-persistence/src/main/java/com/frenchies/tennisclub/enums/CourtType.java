package com.frenchies.tennisclub.enums;

//@Author Jacquet Valentin 473362

public enum CourtType {
	CLAY, GRASS, HARD, CARPET;
	
	/**
     * Checks the enum for a string contained within
     * 
     * @param valueString
     * @return true if the string is contained in the enum 
     */
    public static boolean contains(final String valueString) {
        for (CourtType os : CourtType.values()) {
            if (os.name().equals(valueString)) {
                return true;
            }
        }
        return false;
    }
}
