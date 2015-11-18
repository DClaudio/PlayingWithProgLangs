package com.bscg.data;

import com.bcsg.card.CreditCard;
import com.bcsg.data.CardExpiryDateDescComparator;
import org.junit.Test;

import java.time.Month;
import java.time.YearMonth;
import java.util.Comparator;

import static org.junit.Assert.assertTrue;

public class ComparatorsTest {

    @Test
    public void shouldCompareCardsByExpiryDateDesc(){
        Comparator<CreditCard> comparator = new CardExpiryDateDescComparator();
        CreditCard newerCard = new CreditCard("HSBC Canada", "5601-2345-3446-5678", YearMonth.of(2017, Month.NOVEMBER));
        CreditCard olderCard = new CreditCard("Royal Bank of Canada", "4519-4532-4524-2456", YearMonth.of(2017, Month.SEPTEMBER));

        assertTrue(comparator.compare(newerCard, olderCard) < 0);
        assertTrue(comparator.compare(olderCard, newerCard) > 0);
     }
}
