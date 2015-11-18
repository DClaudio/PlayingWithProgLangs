import com.bcsg.card.CreditCard;
import com.bcsg.data.CardDataParser;
import com.bcsg.data.CardExpiryDateDescComparator;
import com.bcsg.data.CardPANMasker;
import com.bcsg.dataimporters.CardDataFileImporter;
import com.bcsg.dataimporters.CardDataImporter;
import com.bcsg.dataimporters.DataImportFailedException;

import java.util.Comparator;
import java.util.List;

public class ChallengeSolutionMain {

    public static final String DEFAULT_PATH = "mid-test.csv";

    public static void main(String[] args) {
        String path;
        if(args.length >= 1){
            path = args[0];
        }else{
            path = DEFAULT_PATH;
        }
        CardDataImporter fileImporter = new CardDataFileImporter(path, new CardDataParser());
        try {
            List<CreditCard> cardList = fileImporter.getListOfCreditCards();

            Comparator<CreditCard> descDateComparator = new CardExpiryDateDescComparator();
            CardPANMasker cpanMasker = new CardPANMasker();

            System.out.println("Bank \t\t Card Number \t Masked Card Number \t Expiry Date");
            cardList.stream()
                    .sorted(descDateComparator)
                    .map(cpanMasker::getMaskedPanCard)
                    .forEach(card -> System.out.println(card.prettyPrint()));

        } catch (DataImportFailedException e) {
            System.err.println(e.getMessage());
        }
    }
}