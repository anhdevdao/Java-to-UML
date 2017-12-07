package JavaToUML;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ReadFile {

    public String readFile() {
        String s = "";
        BufferedReader br = null;
        FileReader fr = null;
        Find f = new Find();
        try {
            fr = new FileReader("test.txt");
            br = new BufferedReader(fr);
//            br = new BufferedReader(new FileReader(FILE));
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                s += line;
                s = s.replace("{", " {");
                s = s.replace("(", " (");
                s = s.replace(" ;", "; ");
                s = s.replace(" )", ") ");

                s = s.replace(") ", ")");
                s = s.replace("\"", " \" ");
                s = s.replace(" = ", "=");
                s = s.replace("}}", "} }");
                s = s.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", "");
                s = s.replaceAll("\\s+", " ");
                s = s.trim();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) fr.close();
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        s = f.optimizeCode(s);
        return s;
    }
}