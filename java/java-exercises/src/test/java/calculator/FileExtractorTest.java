package calculator;

import calculator.FileExtractor;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by claudio.david on 03/03/2015.
 */
public class FileExtractorTest {

    @Test
    public void test() throws IOException {
        List<String> expectedContent = new LinkedList<String>();
        expectedContent.add("add 2");
        expectedContent.add("multiply 2");
        expectedContent.add("add 2");
        expectedContent.add("apply 2");
        assertEquals(expectedContent, FileExtractor.extractDataFromFile("src/test/java/calculator/testCommands.txt"));
    }
}
