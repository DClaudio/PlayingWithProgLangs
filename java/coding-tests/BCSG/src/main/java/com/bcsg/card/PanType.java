package com.bcsg.card;

public enum PanType {
    VISA('4', "####-xxxx-xxxx-xxxx"),
    MASTER_CARD('5', "##xx-xxxx-xxxx-xxxx"),
    AMEX('3', "xxxx-xxxx-xxxx-###");

    public final static char DIGIT_CODE = '#';
    private char firstDigit;
    private String mask;


    public char getFirstDigit() {
        return firstDigit;
    }

    public String getMask() {
        return mask;
    }

    PanType(char firstDigit, String mask) {
        this.firstDigit = firstDigit;
        this.mask = mask;
    }
}