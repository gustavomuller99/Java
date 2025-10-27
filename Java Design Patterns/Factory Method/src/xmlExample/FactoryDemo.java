package xmlExample;

import xmlExample.factory.DisplayService;
import xmlExample.factory.ErrorXMLDisplayService;
import xmlExample.factory.FeedbackXMLDisplayService;

public class FactoryDemo {
    public static void main(String[] args) {
        DisplayService service = new FeedbackXMLDisplayService();
        service.display();

        service = new ErrorXMLDisplayService();
        service.display();
    }
}
