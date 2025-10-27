package guiExample.factory;

import guiExample.buttons.Button;
import guiExample.buttons.HtmlButton;

public class HtmlDialog extends Dialog {
    public Button createButton() {
        return new HtmlButton();
    }
}
