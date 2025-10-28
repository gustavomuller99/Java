package xmlExample.factory;

import xmlExample.parser.XMLParser;

public interface AbstractParserFactory {
    public XMLParser getParserInstance(String parserType);
}
