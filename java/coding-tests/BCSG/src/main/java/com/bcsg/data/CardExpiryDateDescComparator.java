package com.bcsg.data;

import com.bcsg.card.CreditCard;

import java.util.Comparator;

public class CardExpiryDateDescComparator implements Comparator<CreditCard> {

    @Override
    public int compare(CreditCard c1, CreditCard c2) {
        return c2.getExpiryDate().compareTo(c1.getExpiryDate());
    }

}
