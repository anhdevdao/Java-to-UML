package JavaToUML;

import JavaToUML.Find;
import JavaToUML.ReadFile;

import java.io.IOException;



public class Test {
    public static void main(String[] args) {
        String str = "";
        try {
            ReadFile rf = new ReadFile();
            str = rf.readFile();
            System.out.println(str);
            Find f = new Find();
            f.nameClass(str);
            f.namePackage(str);
            f.nameMethod(str);
            f.nameAttribute(str);
        } catch (StringIndexOutOfBoundsException st) {
            st.printStackTrace();
        }
    }
}
