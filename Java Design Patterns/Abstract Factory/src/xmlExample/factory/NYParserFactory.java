package xmlExample.factory;

import xmlExample.parser.*;
import xmlExample.parser.XMLParser;

public class NYParserFactory implements AbstractParserFactory {
    public XMLParser getParserInstance(String parserType) {
        switch (parserType) {
            case "NYERROR":
                return new NYErrorXMLParser();
            case "NYFEEDBACK":
                return new NYFeedbackXMLParser();
            case "NYORDER":
                return new NYOrderXMLParser();
            case "NYRESPONSE":
                return new NYResponseXMLParser();
        }
        return null;
    }
}
