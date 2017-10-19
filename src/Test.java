import java.io.IOException;


public class Test {
    public static void main(String[] args) throws IOException {
        String str = "";
        ReadFile rf = new ReadFile();
        Find f = new Find();
        str = rf.readFile();
        System.out.println(str);
        f.findClassName(str);
    }
}
