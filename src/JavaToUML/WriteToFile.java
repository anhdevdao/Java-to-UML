package JavaToUML;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    private static final String FILENAME = "data.txt";

    public static void writeFile(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
            String content = "Nội dung mình muốn viết vào file\n";
            bw.write(content);
            System.out.println("Xong");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}