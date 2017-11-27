import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;

public class ReadFile {

    public void optimizeCode(String str) {
        int i1 = str.indexOf("{");
        int tmp = i1;
        int count = 0;
        for (int i = i1; i < str.length(); i++) {
            if ((str.charAt(i)) == '{') {
                count++;
                if (count == 1) {
                    tmp = i;
                }
            }
            if ((str.charAt(i)) == '}') {
                count--;
                if (count == 0) {
                    str.replace(str.substring(tmp + 1, i - 1), "hello");
                }
            }
        }
    }

    public String readFile() throws IOException {
        String s = "";
        FileReader fr = new FileReader("test.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        while ((line = br.readLine()) != null) {
            s += line;
            s = s.replace("{", " {");
            s = s.replace("(", " (");
            s = s.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", "");
            s = s.replaceAll("\\s+", " ");
            s = s.trim();
        }

        optimizeCode(s);
        br.close();
        fr.close();
        return s;
    }
}