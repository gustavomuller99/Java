package fileExample;

import fileExample.handlers.*;

public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        File file = null;

        Handler textHandler = new TextFileHandler("Text fileExample.handlers.Handler");
        Handler docHandler = new DocFileHandler("Doc fileExample.handlers.Handler");
        Handler audioHandler = new AudioFileHandler("Audio fileExample.handlers.Handler");
        Handler imageHandler = new ImageFileHandler("Image fileExample.handlers.Handler");

        textHandler.setHandler(docHandler);
        docHandler.setHandler(audioHandler);
        audioHandler.setHandler(imageHandler);

        file = new File("Abc.mp3", "audio", "C:");
        textHandler.process(file);

        System.out.println();

        file = new File("Abc.jpg", "video", "C:");
        textHandler.process(file);

        System.out.println();

        file = new File("Abc.doc", "doc", "C:");
        textHandler.process(file);

        System.out.println();

        file = new File("Abc.bat", "bat", "C:");
        textHandler.process(file);
    }
}
