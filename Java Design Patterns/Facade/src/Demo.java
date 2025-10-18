import facade.VideoConversionFacade;

import java.io.File;

public class Demo {
    public static void main(String[] args) {
        VideoConversionFacade facade = new VideoConversionFacade();
        File mp4Video = facade.convertVideo("someVideo.ogg", "mp4");
    }
}
