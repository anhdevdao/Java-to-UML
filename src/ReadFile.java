import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public String readFile() throws IOException {
        String s = "";
        FileReader fr = new FileReader("test.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        while ((line = br.readLine()) != null) {
        //    System.out.println(line);
            s += line;
            s = s.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)","");
            s = s.replaceAll("\\s+", " ");
            s = s.trim();
        }
        //System.out.println(s);
        br.close();
        fr.close();
        return s;
    }
}



