package JavaToUML;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.PatternSyntaxException;

public class ReadFile {
    public String optimizeCodeMini(String s) {
        String s1 = s;
        int i1 = s.indexOf("{");
        int tmp = 0, tmp2;
        int count = 0;
        String str;
        for (int i = i1; i < s.length(); i++) {
            if (i == -1) break;
            if (count == 0) {
                tmp = i;
            }
            if (s.charAt(i) == '{') {
                count++;
            }
            if (s.charAt(i) == '}') {
                count--;
                if (count == 0) {
                    tmp2 = i;
                    try {
                        i = s.indexOf("{", tmp2)-1;
                        str = s.substring(tmp + 1, tmp2 - 1);
                        s1 = s1.replace(str, "");
                    } catch (StringIndexOutOfBoundsException st) {
                        st.getMessage();
                    }
                }
            }
        }
        return s1;
    }

    public String optimizeCode(String str) {
        ReadFile rf = new ReadFile();
        String s1 = str;
        int i1 = str.indexOf("{");
        int tmp = 0, tmp2;
        int count = 0;
        String s;
        for (int i = i1; i < str.length(); i++) {
            if (i == -1) break;
            if (count == 0) {
                tmp = i;
            }
            if (str.charAt(i) == '{') {
                count++;
            }
            if (str.charAt(i) == '}') {
                count--;
                if (count == 0) {
                    tmp2 = i;
                    try {
                        i = str.indexOf("{", tmp2) - 1;
                        s = str.substring(tmp + 1, tmp2 - 1);
                        s1 = s1.replace(s, rf.optimizeCodeMini(s));
                    } catch (StringIndexOutOfBoundsException st) {
                        st.getMessage();
                    }
                }
            }
        }
        return s1;
    }

    public String readFile() {
        String s = "";
        BufferedReader br = null;
        FileReader fr = null;
        ReadFile r = new ReadFile();
        try {
            fr = new FileReader("test.txt");
            br = new BufferedReader(fr);
            String line = "";
            int count = 0;
            while ((line = br.readLine()) != null) {
                s += line;
                s = s.replace("{", " {");
                s = s.replace("(", " (");
                s = s.replace(";", "; ");
                s = s.replace(" )", ") ");
                s = s.replace(" }", "} ");
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

        s = r.optimizeCode(s);
        return s;
    }
}