package com.frenchies.tennisclub.enums;

//@Author Dore Corentin UCO 473308
public enum Hour24{
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    ELEVEN(11),
    TWELVE(12),
    THIRTEEN(13),
    FOURTEEN(14),
    FIFTEEN(15),
    SIXTEEN(16),
    SEVENTEEN(17),
    EIGHTEEN(18),
    NINETEEN(19),
    TWENTY(20),
    TWENTY_ONE(21),
    TWENTY_TWO(22);
    
    private final int value;

    Hour24(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}

// And then you call Hour24.SIX.getValue() to get 6.