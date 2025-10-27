package xmlExample.factory;

import xmlExample.product.ErrorXMLParser;
import xmlExample.product.XMLParser;

public class ErrorXMLDisplayService extends DisplayService {
    public XMLParser getParser() {
        return new ErrorXMLParser();
    }
}
