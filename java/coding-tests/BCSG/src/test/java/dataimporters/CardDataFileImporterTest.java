package dataimporters;

import com.bcsg.card.CreditCard;
import com.bcsg.data.CardDataParser;
import com.bcsg.dataimporters.CardDataFileImporter;
import com.bcsg.dataimporters.CardDataImporter;
import com.bcsg.dataimporters.DataImportFailedException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CardDataFileImporterTest {

    private CardDataImporter cardDataFileImporter;

    @Before
    public void setUp() {
        String path = "mid-test.csv";
        cardDataFileImporter = new CardDataFileImporter(path, new CardDataParser());
    }

    @After
    public void tearDown() {
        cardDataFileImporter = null;
    }

    @Test
    public void shouldImportCardData() throws DataImportFailedException {
        List<CreditCard> expectedList = new ArrayList<>();
        expectedList.add(new CreditCard("HSBC Canada", "5601-2345-3446-5678", YearMonth.of(2017, Month.NOVEMBER)));
        expectedList.add(new CreditCard("Royal Bank of Canada", "4519-4532-4524-2456", YearMonth.of(2017, Month.OCTOBER)));
        expectedList.add(new CreditCard("American Express", "3786-7334-8965-345", YearMonth.of(2018, Month.DECEMBER)));

        List<CreditCard> actualCardList = cardDataFileImporter.getListOfCreditCards();
        assertEquals(expectedList, actualCardList);
    }

    @Test(expected = DataImportFailedException.class)
    public void shouldThrowExceptionWhenInvalidFile() throws DataImportFailedException {
        CardDataImporter faultyImporter = new CardDataFileImporter("abc.xyz", new CardDataParser());
        faultyImporter.getListOfCreditCards();
    }
}
