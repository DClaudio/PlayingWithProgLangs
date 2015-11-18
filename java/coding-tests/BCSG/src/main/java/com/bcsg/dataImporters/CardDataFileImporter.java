package com.bcsg.dataimporters;

import com.bcsg.card.CreditCard;
import com.bcsg.card.InvalidCardDataException;
import com.bcsg.data.CardDataParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CardDataFileImporter implements CardDataImporter {

    private String filePath;
    private CardDataParser cardDataParser;

    public CardDataFileImporter(String filePath, CardDataParser cardDataParser) {
        this.filePath = filePath;
        this.cardDataParser = cardDataParser;
    }

    public List<CreditCard> getListOfCreditCards() throws DataImportFailedException {
        File file = new File(filePath);
        List<CreditCard> credCardList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    CreditCard card = cardDataParser.parseLine(line);
                    credCardList.add(card);
                } catch (InvalidCardDataException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException notFoundEx) {
            throw new DataImportFailedException(notFoundEx.getMessage());
        } catch (IOException ioEx) {
            new DataImportFailedException(ioEx.getMessage());
        }
        return credCardList;
    }

}
