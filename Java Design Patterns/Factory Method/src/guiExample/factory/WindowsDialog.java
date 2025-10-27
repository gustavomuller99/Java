package guiExample.factory;

import guiExample.buttons.Button;
import guiExample.buttons.WindowsButton;

public class WindowsDialog extends Dialog {

    public Button createButton() {
        return new WindowsButton();
    }
}
