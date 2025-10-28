package xmlExample.factory;

import xmlExample.parser.*;
import xmlExample.parser.XMLParser;

public class TWParserFactory implements AbstractParserFactory {
    public XMLParser getParserInstance(String parserType) {
        switch (parserType) {
            case "TWERROR":
                return new TWErrorXMLParser();
            case "TWFEEDBACK":
                return new TWFeedbackXMLParser();
            case "TWORDER":
                return new TWOrderXMLParser();
            case "TWRESPONSE":
                return new TWResponseXMLParser();
        }
        return null;
    }
}
