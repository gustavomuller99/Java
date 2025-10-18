import element.HtmlElement;
import element.HtmlParentElement;
import element.HtmlTag;
import visitor.CssClassVisitor;
import visitor.StyleVisitor;
import visitor.Visitor;

public class DemoVisitor {
    public static void main(String[] args) {

        Visitor css = new CssClassVisitor();
        Visitor style = new StyleVisitor();

        HtmlParentElement parentElement = new HtmlParentElement("<html>");
        parentElement.setStartTag("<html>");
        parentElement.setEndTag("</html>");
        parentElement.accept(css);
        parentElement.accept(style);

        HtmlElement htmlElement = new HtmlElement("<p>");
        htmlElement.setStartTag("<p>");
        htmlElement.setEndTag("</p>");
        htmlElement.setTagBody("Visitor pattern");
        htmlElement.accept(css);
        htmlElement.accept(style);

        parentElement.addChildTag(htmlElement);
        parentElement.generateHtml();
    }
}
