package xmlExample.product;

public class ErrorXMLParser implements XMLParser {
    public String parse() {
        System.out.println("Parsing error XML...");
        return "Error XML Message";
    }
}
