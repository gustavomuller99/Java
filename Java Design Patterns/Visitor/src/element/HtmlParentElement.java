package element;

import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class HtmlParentElement extends HtmlTag {

    private String tagName;
    private String startTag;
    private String endTag;
    private List<HtmlTag> childrenTag;

    public HtmlParentElement(String tagName) {
        this.tagName = tagName;
        this.startTag = "";
        this.endTag = "";
        this.childrenTag = new ArrayList<HtmlTag>();
    }

    public String getTagName() {
        return tagName;
    }

    public void setStartTag(String startTag) {
        this.startTag = startTag;
    }

    public void setEndTag(String endTag) {
        this.endTag = endTag;
    }

    public String getStartTag() {
        return startTag;
    }

    public String getEndTag() {
        return endTag;
    }

    public void addChildTag(HtmlTag child) {
        childrenTag.add(child);
    }

    public void removeChildTag(HtmlTag child) {
        childrenTag.remove(child);
    }

    public List<HtmlTag> getChildTags() {
        return childrenTag;
    }

    public void generateHtml() {
        System.out.println(startTag);
        for (HtmlTag child : childrenTag) {
            child.generateHtml();
        }
        System.out.println(endTag);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
