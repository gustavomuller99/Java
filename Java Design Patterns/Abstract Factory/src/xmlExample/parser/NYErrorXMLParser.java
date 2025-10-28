package xmlExample.parser;

public class NYErrorXMLParser implements XMLParser {
    public String parse() {
        System.out.println("NY Parsing error XML...");
        return "NY Error XML Message";
    }
}
