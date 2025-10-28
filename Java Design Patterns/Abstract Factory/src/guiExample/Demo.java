package guiExample;

import guiExample.factory.MacOSFactory;
import guiExample.factory.WindowsFactory;

public class Demo {
    public static void main(String[] args) {
        Application app = new Application(new WindowsFactory());
        app.paint();

        app = new Application(new MacOSFactory());
        app.paint();
    }
}
