package fileExample.handlers;

public class DocFileHandler implements Handler {
    private Handler handler;
    private String handlerName;

    public DocFileHandler(String handlerName) {
        this.handlerName = handlerName;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void process(File file) {
        if (file.getFileType().equals("doc")) {
            System.out.println("Process and saving doc file by " + handlerName);
        } else if (handler != null) {
            System.out.println(handlerName + " forwards request to " + handler.getHandlerName());
            handler.process(file);
        } else {
            System.out.println("fileExample.handlers.File not supported");
        }
    }

    public String getHandlerName() {
        return handlerName;
    }
}