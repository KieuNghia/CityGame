package ParseFactory.Parsers;

import java.util.ArrayList;

import ParseFactory.AbstractFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XMLParser extends AbstractFactory {
    @Override
    public ArrayList cityParse() {

        try {

            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            DefaultHandler defaultHandler = new DefaultHandler() {
                boolean bName = false;

                public void startElement(String uri, String localName,
                                         String qName, Attributes attributes)
                        throws SAXException {
                    if (qName.equalsIgnoreCase("region")) {
                        bName = true;
                    }

                }

                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {

                }

                public void characters(char ch[], int start, int length)
                        throws SAXException {

                    if (bName) {
                        cities.add(new String(ch, start, length).toUpperCase());
                        bName = false;
                    }

                }

            };

            saxParser.parse("src/main/resources/cities.xml", defaultHandler);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            ex.printStackTrace();
        }
        return cities;
    }
}

