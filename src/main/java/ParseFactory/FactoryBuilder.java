package ParseFactory;

import ParseFactory.Parsers.*;

import java.util.ArrayList;
import java.util.List;

public class FactoryBuilder {

    public FactoryBuilder() {
        super();
    }

    private enum TypeParser {
            DB,EXEL,XML,JSON,FILE
        }

        public ArrayList createCitiesBuilder(String typeParser) {
            TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
            switch (type) {
                case XML:
                    return new XMLParser().cityParse();
                case EXEL:
                    return new EXELParser().cityParse();
                case DB:
                    return new DBParser().cityParse();
               /* case JSON:
                    return new JSONParsers().cityParse();*/
                case FILE:
                    return new TXTParser().cityParse();
                default:
                    throw new EnumConstantNotPresentException(type.getDeclaringClass(),
                            type.name());
            }
        }
    }

