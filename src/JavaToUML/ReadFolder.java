package JavaToUML;

import java.io.File;

public class ReadFolder {
    public String InputFile(final File f) {
        String s = "";
        ReadFile rf = new ReadFile();
        try {
            for (final File input : f.listFiles()) {
                if (input.isDirectory()) {
                    InputFile(input);
                } else {
                    //s += rf.readFile("D:\\OOP\\W5\\Bai 2\\src" + input.getName() + " ");
                }
            }
        } catch (NullPointerException e) {
            e.getMessage();
        }
        return s;
    }
}
