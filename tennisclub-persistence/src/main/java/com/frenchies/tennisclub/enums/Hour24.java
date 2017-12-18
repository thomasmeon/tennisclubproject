package com.frenchies.tennisclub.enums;

//@Author Meon Thomas 473449
public enum Hour24 {
	SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, FIFTEEN, SIXTEEN, SEVENTEEN, EIGHTEEN, NINETEEN, TWENTY, TWENTY_ONE, TWENTY_TWO;

	public static boolean contains(final String valueString) {
		for (Hour24 os : Hour24.values()) {
			if (os.name().equals(valueString)) {
				return true;
			}
		}
		return false;
	}
}

// And then you call Hour24.SIX.getValue() to get 6.