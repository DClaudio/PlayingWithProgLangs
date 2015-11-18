package com.bscg.data;

import com.bcsg.card.CreditCard;
import com.bcsg.card.InvalidCardDataException;
import com.bcsg.data.CardDataParser;
import org.junit.Test;

import java.time.Month;
import java.time.YearMonth;

import static org.junit.Assert.assertEquals;

public class CardDataParserTest {

    private CardDataParser cardDataParser = new CardDataParser();

    @Test
    public void shouldParseOneLine() throws InvalidCardDataException {
        String testLine = "HSBC Canada,5601-2345-3446-5678,Nov-2017";
        CreditCard expectedCard = new CreditCard("HSBC Canada", "5601-2345-3446-5678", YearMonth.of(2017, Month.NOVEMBER));

        CreditCard actualCard = cardDataParser.parseLine(testLine);
        assertEquals(expectedCard, actualCard);
    }

    @Test
    public void shouldRemoveExtraWhitespaceFromBankName() throws InvalidCardDataException {
        String testLine = "Royal Bank of  Canada,4519-4532-4524-2456,Oct-2017";
        String expectedBankName = "Royal Bank of Canada";

        CreditCard actualCard = cardDataParser.parseLine(testLine);
        assertEquals(expectedBankName, actualCard.getBankName());
    }

    @Test(expected = InvalidCardDataException.class)
    public void shouldThrowExceptionForInvalidDate() throws InvalidCardDataException {
        String testLine = "HSBC Canada,5601-2345-3446-5678,xyz-2017";
        cardDataParser.parseLine(testLine);
    }

    @Test(expected = InvalidCardDataException.class)
    public void shouldThrowExceptionForIncompleteData() throws InvalidCardDataException {
        String testLine = "HSBC Canada,5601-2345-3446-5678";
        cardDataParser.parseLine(testLine);
    }


}
