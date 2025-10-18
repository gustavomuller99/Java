package visitor;

import element.HtmlElement;
import element.HtmlParentElement;

public class StyleVisitor implements Visitor {

    public void visit(HtmlElement htmlElement) {
        htmlElement.setStartTag(htmlElement.getStartTag().replace(">", " style='width:46px;'>"));
    }

    public void visit(HtmlParentElement htmlParentElement) {
        htmlParentElement.setStartTag(htmlParentElement.getStartTag().replace(">", " style='width:58px;'>"));
    }
}
