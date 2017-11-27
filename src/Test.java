import java.io.IOException;
import java.lang.StringIndexOutOfBoundsException;


public class Test {
    public static void main(String[] args) throws IOException {
        String str = "";
        ReadFile rf = new ReadFile();
        str = rf.readFile();
        System.out.println(str);
        Find f = new Find();
        f.nameClass(str);
    }
}
