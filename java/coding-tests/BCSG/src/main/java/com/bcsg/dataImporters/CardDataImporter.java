package com.bcsg.dataimporters;

import com.bcsg.card.CreditCard;

import java.util.List;

public interface CardDataImporter {

    List<CreditCard> getListOfCreditCards() throws DataImportFailedException;

}
