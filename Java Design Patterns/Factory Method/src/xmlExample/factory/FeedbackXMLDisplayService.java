package xmlExample.factory;

import xmlExample.product.FeedbackXMLParser;
import xmlExample.product.XMLParser;

public class FeedbackXMLDisplayService extends DisplayService {
    public XMLParser getParser() {
        return new FeedbackXMLParser();
    }
}
