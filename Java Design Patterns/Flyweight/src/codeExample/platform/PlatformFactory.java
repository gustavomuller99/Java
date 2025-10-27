package codeExample.platform;

import java.util.HashMap;
import java.util.Map;

public class PlatformFactory {
    private static Map<String, Platform> map = new HashMap<>();

    private PlatformFactory() {
        throw new AssertionError("Cannot instantiate the class");
    }

    public static synchronized Platform getPlatformInstance(String platformType) {
        Platform platform = map.get(platformType);
        if (platform == null) {
            switch (platformType) {
                case "C":
                    platform = new CPlatform();
                    break;
                case "JAVA":
                    platform = new JavaPlatform();
                    break;
            }
            map.put(platformType, platform);
        }
        return platform;
    }
}
