package codeExample.platform;

import codeExample.Code;

public class JavaPlatform implements Platform {
    public JavaPlatform() {
        System.out.println("JavaPlatform object created");
    }

    public void execute(Code code) {
        System.out.println("Compiling and executing Java code.");
    }
}
