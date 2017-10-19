public class Find {
    public void findClassName(String s) {
        String[] str = s.split("\\s");
        for (int i = 0; i < s.length(); i++) {
            if (str[i].equals("class")) {
                System.out.println(str[i + 1]);
            }

            if (str[i-1].equals("public") && str[i] != "class") {
                System.out.println(str[i + 1]);
            }
        }
    }
}
