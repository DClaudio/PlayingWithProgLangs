package com.bcsg.data;

import com.bcsg.card.CreditCard;
import com.bcsg.card.InvalidCardDataException;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CardDataParser {

    private static final String DEFAULT_DATE_FORMAT = "MMM-yyyy";
    private String dateFormat;

    public CardDataParser(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public CardDataParser() {
        this(DEFAULT_DATE_FORMAT);
    }

    private YearMonth parseDate(String date) throws InvalidCardDataException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        try {
            YearMonth ym = YearMonth.parse(date, formatter);
            return ym;
        } catch (DateTimeParseException ex) {
            throw new InvalidCardDataException(ex.getMessage());
        }
    }

    public CreditCard parseLine(String testLine) throws InvalidCardDataException {
        String[] splitLine = testLine.split(",");
        if (splitLine.length < 3) {
            throw new InvalidCardDataException("Card Data incomplete.");
        }
        String bankName = removeExtraWhitespace(splitLine[0]);
        String pan = splitLine[1];
        YearMonth expiryDate = parseDate(splitLine[2]);
        return new CreditCard(bankName, pan, expiryDate);
    }

    private String removeExtraWhitespace(String str) {
        return str.replaceAll("\\s+", " ");
    }
}
