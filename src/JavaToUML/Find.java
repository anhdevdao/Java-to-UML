package JavaToUML;

import java.util.*;

public class Find {
    public void nameClass(String s) {
        int i1 = s.indexOf("class");
        for (int i = i1; i < s.length(); i++) {
            if (i == -1) break;
            int i2 = s.indexOf(" ", i + 6);
            String tmp = s.substring(i + 6, i2).replace("{", "");
            i = s.indexOf("class", i + 1) - 1;
            System.out.println("Class Name: " + tmp);
            System.out.println("Method names: ");
            try {
                int i3 = s.indexOf("(");
                while (i3 != -1 && i3 <= i) {
                    int tmp2 = s.lastIndexOf(" ", i3);
                    int tmp3 = s.lastIndexOf(" ", tmp2 - 1);
                    int tmp4 = s.indexOf("{", i3);
                    System.out.println("+ " + s.substring(tmp3 + 1, tmp4 - 1));
                    i3 = s.indexOf("(", tmp4);
                }
            } catch (StringIndexOutOfBoundsException e) {
                e.getMessage();
            }
        }
    }

    public Vector<String> getNameClass(String s) {
        Vector<String> v = new Vector<String>(10, 2);
        int i1 = s.indexOf("class");
        for (int i = i1; i < s.length(); i++) {
            int j = 0;
            if (i == -1) break;
            int i2 = s.indexOf(" ", i + 6);
            String tmp = s.substring(i + 6, i2).replace("{", "");
            i = s.indexOf("class", i + 1) - 1;
            v.add(j, tmp);
            j++;
        }
        return v;
    }

    public String namePackage(String s) {
        int i3 = s.indexOf("package");
        String s2 = new String();
        if (i3 != -1) {
            int i4 = s.indexOf(";");
            s2 = "Package Name: " + s.substring(i3 + 8, i4);
        }
        return s2;
    }

    public void nameAttribute(String s) {
        String s1 = new String();
        String name;
        s1 = s;
        int i = s.indexOf("import");
        while (i != -1) {
            int j = s.indexOf(";", i);
            s1 = s1.replaceAll(s.substring(i, j + 1), "");
            i = s.indexOf("import", j);
        }

        String s2 = new String();
        s2 = s1;
        int i4 = s.indexOf("package");
        while (i4 != -1) {
            int j2 = s1.indexOf(";", i4);
            s2 = s2.replaceAll(s1.substring(i4, j2 + 1), "").trim();
            i4 = s1.indexOf("package", j2);
        }

        s2 = s2.replaceAll("\\s+", " ");

        System.out.println("Attribute Names: ");
        Find f = new Find();
        int i2 = s2.indexOf(";");
        while (i2 != -1) {
            if (s2.charAt(i2 - 1) == ')') {
                int k = s2.lastIndexOf("=", i2);
                int k2 = s2.lastIndexOf(" ", s2.lastIndexOf(" ", k) - 1);
                name = s2.substring(k2 + 1, k);
            } else {
                int i3 = s2.lastIndexOf(" ", s2.lastIndexOf(" ", i2) - 1);
                name = s2.substring(i3 + 1, i2);
            }

            System.out.println("+ " + name);
            String[] tmp = name.split(" ");
            if (f.getNameClass(s).contains(tmp[0])) {
                int k1 = s2.lastIndexOf("class", s2.lastIndexOf(tmp[0], i2));
                int k2 = s2.indexOf(" ", s2.indexOf(" ", k1 + 6));
                String tmp2 = s2.substring(s2.indexOf(" ", k1) + 1, k2);
                System.out.println(tmp2 + " has a " + tmp[0]);
            }
            i2 = s2.indexOf(";", i2 + 1);
        }
    }


    public void nameMethod(String s) {
        System.out.println("Method names: ");
        try {
            int i = s.indexOf("(");
            while (i != -1) {
                int tmp2 = s.lastIndexOf(" ", i);
                int tmp3 = s.lastIndexOf(" ", tmp2 - 1);
                int tmp4 = s.indexOf("{", i);
                System.out.println("+ " + s.substring(tmp2 + 1, tmp4 - 1));
                i = s.indexOf("(", tmp4);
            }
        } catch (StringIndexOutOfBoundsException e) {
            e.getMessage();
        }
    }


    public String optimizeCodeSuperMini(String s) {
        String s1 = s;
        int i1 = s.indexOf("{");
        int tmp = 0, tmp2 = 0;
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

                    try {
                        tmp2 = i;
                        i = s.indexOf("{", tmp2) - 1;
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

    public String optimizeCodeMini(String s) {
        Find f = new Find();
        String s1 = s;
        int i1 = s.indexOf("{");
        int tmp = 0, tmp2 = 0;
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
                    try {
                        int k = s.indexOf("(", tmp2);
                        tmp = s.lastIndexOf(" ", k-2);
                        tmp2 = i;
                        i = s.indexOf("{", tmp2) - 1;
                        str = s.substring(tmp + 1, tmp2 + 1);
                        s1 = s1.replace(str, f.optimizeCodeSuperMini(str));
                    } catch (StringIndexOutOfBoundsException st) {
                        st.getMessage();
                    }
                }
            }
        }
        return s1;
    }

    public String optimizeCode(String str) {
        Find rf = new Find();
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
}

