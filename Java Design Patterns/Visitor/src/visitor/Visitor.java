package visitor;

import element.HtmlElement;
import element.HtmlParentElement;

public interface Visitor {
    public void visit(HtmlElement element);
    public void visit(HtmlParentElement element);
}
