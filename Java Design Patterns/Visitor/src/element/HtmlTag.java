package element;

import java.util.List;

public abstract class HtmlTag implements Element {

    public abstract String getTagName();

    public abstract void setStartTag(String startTag);
    public abstract String getStartTag();

    public abstract void setEndTag(String endTag);
    public abstract String getEndTag();

    public void setTagBody(String tagBody) {
        throw new UnsupportedOperationException();
    }

    public void addChildTag(HtmlTag child) {
        throw new UnsupportedOperationException();
    }

    public void removeChildTag(HtmlTag child) {
        throw new UnsupportedOperationException();
    }

    public List<HtmlTag> getChildTags() {
        throw new UnsupportedOperationException();
    }

    public abstract void generateHtml();
}
