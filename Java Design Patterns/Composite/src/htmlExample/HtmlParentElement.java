package htmlExample;

import java.util.ArrayList;
import java.util.List;

public class HtmlParentElement extends HtmlTag {

    private String tagName;
    private String startTag;
    private String endTag;
    private List<HtmlTag> childrenTag;

    public HtmlParentElement(String tagName){
        this.tagName = tagName;
        this.startTag = "";
        this.endTag = "";
        this.childrenTag = new ArrayList<>();
    }

    public String getTagName() {
        return tagName;
    }

    public void setStartTag(String tag) {
        this.startTag = tag;
    }

    public void setEndTag(String tag) {
        this.endTag = tag;
    }

    public void addChildTag(HtmlTag htmlTag){
        childrenTag.add(htmlTag);
    }

    public void removeChildTag(HtmlTag htmlTag){
        childrenTag.remove(htmlTag);
    }

    public List<HtmlTag>getChildren(){
        return childrenTag;
    }

    public void generateHtml(int level) {
        System.out.print("\t".repeat(level));
        System.out.println(startTag);
        for(HtmlTag tag : childrenTag){
            tag.generateHtml(level + 1);
        }
        System.out.print("\t".repeat(level));
        System.out.println(endTag);
    }
}
