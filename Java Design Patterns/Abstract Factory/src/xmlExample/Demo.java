package xmlExample;

import xmlExample.factory.AbstractParserFactory;
import xmlExample.factory.ParserFactoryProducer;
import xmlExample.parser.XMLParser;

public class Demo {
    public static void main(String[] args) {

        AbstractParserFactory parserFactory = ParserFactoryProducer.getFactory("NYFactory");
        XMLParser parser = parserFactory.getParserInstance("NYORDER");

        String msg;
        msg = parser.parse();

        System.out.println(msg);
        System.out.println("************************************");

        parserFactory = ParserFactoryProducer.getFactory("TWFactory");
        parser = parserFactory.getParserInstance("TWFEEDBACK");

        msg = parser.parse();
        System.out.println(msg);
    }
}
