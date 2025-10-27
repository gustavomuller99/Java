package xmlExample.product;

public class FeedbackXMLParser implements XMLParser {
    public String parse() {
        System.out.println("Parsing feedback XML...");
        return "Feedback XML Message";
    }
}
