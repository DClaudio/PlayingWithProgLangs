package com.bscg.data;

import com.bcsg.card.CreditCard;
import com.bcsg.data.CardPANMasker;
import org.junit.Test;

import java.time.Month;
import java.time.YearMonth;

import static org.junit.Assert.assertEquals;

public class CardPANMaskerTest {

    private CardPANMasker cardPANMasker = new CardPANMasker();

    @Test
    public void shouldMaskMasterCardPAN() {
        String masterCardPAN = "5601-2345-3446-5678";
        String expectedMaskedPAN = "56xx-xxxx-xxxx-xxxx";

        String actualMaskedNumber = cardPANMasker.getMaskedPan(masterCardPAN);
        assertEquals(expectedMaskedPAN, actualMaskedNumber);
    }

    @Test
    public void shouldMaskVisaPAN() {
        String visaPAN = "4519-4532-4524-2456";
        String expectedMaskedPAN = "4519-xxxx-xxxx-xxxx";

        String actualMaskedNumber = cardPANMasker.getMaskedPan(visaPAN);
        assertEquals(expectedMaskedPAN, actualMaskedNumber);
    }

    @Test
    public void shouldMaskAmexPAN() {
        String amexPAN = "3786-7334-8965-345";
        String expectedMaskedPAN = "xxxx-xxxx-xxxx-345";

        String actualMaskedNumber = cardPANMasker.getMaskedPan(amexPAN);
        assertEquals(expectedMaskedPAN, actualMaskedNumber);
    }

    @Test
    public void shouldMaskEntirePanForUnknownPanType() {
        assertEquals("xxxx-xxxx-xxxx-xxx-xxx", cardPANMasker.getMaskedPan("3786-7334-8965-345-123"));
        assertEquals("xxxx-xxxx-xxxx-xxxx", cardPANMasker.getMaskedPan("8888-7334-8965-3452"));
    }

    @Test
    public void shouldComputeMaskedPanCreditCard() {
        CreditCard testCard = new CreditCard("HSBC Canada", "5601-2345-3446-5678", YearMonth.of(2017, Month.NOVEMBER));
        CreditCard expectedCard = new CreditCard("HSBC Canada", "5601-2345-3446-5678", "56xx-xxxx-xxxx-xxxx", YearMonth.of(2017, Month.NOVEMBER));

        assertEquals(expectedCard, cardPANMasker.getMaskedPanCard(testCard));
    }
}
