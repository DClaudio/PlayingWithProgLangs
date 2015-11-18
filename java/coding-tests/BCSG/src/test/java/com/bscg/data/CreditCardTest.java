package com.bscg.data;

import com.bcsg.card.CreditCard;
import org.junit.Test;

import java.time.Month;
import java.time.YearMonth;

import static org.junit.Assert.assertEquals;

public class CreditCardTest {

    @Test
    public void shouldPrettyPrintCard() {
        CreditCard card = new CreditCard("HSBC Canada", "5601-2345-3446-5678", "56xx-xxxx-xxxx-xxxx", YearMonth.of(2017, Month.NOVEMBER));
        String expectedPrettyString = "HSBC Canada 5601-2345-3446-5678 56xx-xxxx-xxxx-xxxx 2017-11";
        assertEquals(expectedPrettyString, card.prettyPrint());
    }
}
