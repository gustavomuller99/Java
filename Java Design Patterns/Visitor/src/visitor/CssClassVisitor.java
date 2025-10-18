package visitor;

import element.HtmlElement;
import element.HtmlParentElement;

public class CssClassVisitor implements Visitor {

    public void visit(HtmlElement htmlTag) {
        htmlTag.setStartTag(htmlTag.getStartTag().replace(">", " class='visitor'>"));
    }

    public void visit(HtmlParentElement htmlParentElement) {
        htmlParentElement.setStartTag(htmlParentElement.getStartTag().replace(">", " class='visitor'>"));
    }
}
