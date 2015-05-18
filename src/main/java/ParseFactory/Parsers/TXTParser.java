package ParseFactory.Parsers;

import ParseFactory.AbstractFactory;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Kuanh_Nhkhiia_Kiieu on 5/18/2015.
 */
public class TXTParser  extends AbstractFactory{
    @Override
    public ArrayList cityParse() {
        File file = new File("src\\main\\resources\\cities.txt");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file)));
            String line = null;

            while ((line = br.readLine()) != null) {
                cities.add(line.toLowerCase());

            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cities;
    }


}
