package ParseFactory.Parsers;

import ParseFactory.AbstractFactory;

import java.io.*;
import java.util.ArrayList;


public class TXTParser extends AbstractFactory {
    @Override
    public ArrayList cityParse() {
        File file = new File("src\\main\\resources\\cities.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                cities.add(line.toUpperCase());

            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cities;
    }


}
