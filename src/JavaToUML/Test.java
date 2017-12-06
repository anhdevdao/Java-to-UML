package JavaToUML;

import java.io.File;

class Test {
    public static void main(String[] args) {
        String str = "";
        try {
            File folder = new File(str);
            ReadFile rf = new ReadFile();
            ReadFolder rf2 = new ReadFolder();
            //str = rf2.InputFile(folder);
            str = rf.readFile();
            System.out.println(str);
            Find f = new Find();
            f.nameClass(str);
            //f.nameInterface(str);
            f.namePackage(str);
            //f.nameMethod(str);
            f.nameAttribute(str);
        } catch (StringIndexOutOfBoundsException st) {
            st.printStackTrace();
        }
    }
}

