package JavaToUML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class WriteToFile {

    public static void writeFile(String path) throws FileNotFoundException {
        Test t = new Test();
        File f = new File(".\\diagram.txt");
        FileOutputStream fos = new FileOutputStream(f);
        PrintStream ps = new PrintStream(fos);
        System.setOut(ps);
        //t.main(path);
    }
}