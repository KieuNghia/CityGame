package ParseFactory;

import ParseFactory.*;
import ParseFactory.Parsers.*;
import org.json.simple.JSONArray;

import java.util.ArrayList;

public class FactoryBuilder {

        private enum TypeParser {
            DB,EXEL,XML,JSON,FILE
        }

        public static ArrayList createCitiesBuilder(String typeParser) {
            TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
            switch (type) {
                case XML:
                    return new XMLParser().cityParse();
                case EXEL:
                    return new EXELParser().cityParse();
                case DB:
                    return new DBParser().cityParse();
                case JSON:
                    return new JSONParser().cityParse();
                case FILE:
                    return new TXTParser().cityParse();
                default:
                    throw new EnumConstantNotPresentException(type.getDeclaringClass(),
                            type.name());
            }
        }
    }

