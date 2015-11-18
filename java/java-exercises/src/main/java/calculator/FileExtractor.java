package calculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by claudio.david on 03/03/2015.
 */
public class FileExtractor {

    public static LinkedList<String> extractDataFromFile(String filename)throws IOException{
        LinkedList<String> lines = new LinkedList<String>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        try {
            String line = br.readLine();
            while (line != null) {
                lines.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
        return lines;
    }
}
