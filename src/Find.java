import com.sun.xml.internal.ws.encoding.SwACodec;
import java.util.*;

public class Find {

//    public void findClassName(String s) {
//        String[] str;
//        // Tim ten class
//        int i1 = s.indexOf("class");
//        for (int i=i1; i < s.length(); i++) {
//            if (i == -1) break;
//            int i2 = s.indexOf(" ", i+6);
//            String tmp = s.substring(i+6,  i2);
//            i = s.indexOf("class", i+1) -1;
//            tmp = tmp.replace("{", "");
//            System.out.println(tmp);
//
//        }
//    }
//
//    public void findAbilitiesName(String s) {
//        int il = s.indexOf(";");
//    }
        public void nameClass (String s) {
            System.out.println("Classes: ");
            int i1 = s.indexOf("class");
            for (int i=i1; i< s.length(); i++) {
                if (i ==-1) break;
                int i2 = s.indexOf(" ", i+6);
                String tmp = s.substring(i +6,  i2).replace("{", "");
                i = s.indexOf("class", i+1) -1;
                System.out.println(tmp);
            }
        }


        public String namePackage(String s) {
            int i3= s.indexOf("package");
            String s2 = new String();
            if(i3 != -1) {
                int i4= s.indexOf(";");
                s2 = "Packages: "+s.substring(i3+8, i4);
            }
            return s2;
        }


//        public void nameAttribute(String s) {
//            String s1 = new String();
//            String name;
//            s1=s;
//            int i = s.indexOf("import");
//            while(i!=-1) {
//                int j = s.indexOf(";", i);
//                s1 = s1.replaceAll(s.substring(i, j+1), "");
//                i = s.indexOf("import", j);
//            }
//
//            String s2 = new String();
//            s2=s1;
//            int i4 = s.indexOf("package");
//            while(i4!=-1) {
//                int j2 = s1.indexOf(";", i4);
//                s2 = s2.replaceAll(s1.substring(i4, j2+1), "").trim();
//                i4 = s1.indexOf("package", j2);
//            }
//
//            s2= s2.replaceAll("\\s+", " ");
//            //System.out.println(s2);
//
//            Find f= new Find();
//            int i2 = s2.indexOf(";");
//            while (i2!=-1) {
//                if(s2.charAt(i2-1) == ')') {
//                    int k = s2.lastIndexOf("=", i2);
//                    int k2 = s2.lastIndexOf(" ", s2.lastIndexOf(" ", k)-1);
//                    name = s2.substring(k2+1, k);
//                }
//                else {
//                    int i3 = s2.lastIndexOf(" " , s2.lastIndexOf(" ", i2)-1);
//                    name = s2.substring(i3+1, i2);
//                }
//
//                System.out.println("Attributes: " + name);
//                String[] tmp = name.split(" ");
//                if(f.getNameClass(s).contains(tmp[0])) {
//                    int k1 = s2.lastIndexOf("class", s2.lastIndexOf(tmp[0], i2));
//                    int k2 = s2.indexOf(" " , s2.indexOf(" " ,k1+6));
//                    String tmp2 = s2.substring(s2.indexOf(" ", k1) +1, k2);
//                    System.out.println(tmp2 + " has a " + tmp[0]);
//                }
//                i2 = s2.indexOf(";", i2+1);
//            }
//        }


        public void nameMethod(String s) {
            int i = s.indexOf("(");
            while (i!=-1) {
                int tmp2 = s.lastIndexOf(" ", i);
                int tmp3 = s.lastIndexOf(" ", tmp2-1);
                int tmp4 = s.indexOf("{", i);
                System.out.println("Methods: " + s.substring(tmp3+1, tmp4-1));
                i = s.indexOf("(", tmp4);
            }
        }
}
