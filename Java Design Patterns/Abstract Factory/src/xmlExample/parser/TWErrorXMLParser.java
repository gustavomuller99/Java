package xmlExample.parser;

public class TWErrorXMLParser implements XMLParser {
    public String parse() {
        System.out.println("TW Parsing error XML...");
        return "TW Error XML Message";
    }
}
