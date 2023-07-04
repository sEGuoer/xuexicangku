package D20230612;

public class JavaTest {
    public static void main(String[] args) {
        /*        String jdk = "jdk";
         *//*        jdk=jdk.replace('j','J');
        jdk=jdk.replace('d','D');
        jdk=jdk.replace('k','K');*//*
        jdk = jdk.toUpperCase();
        System.out.println(jdk);
        String dk = jdk.substring(1);
        System.out.println(dk);*/

        String howMuch = "298fjdsklzfASDJKLKASDd23";
        char[] chars = howMuch.toCharArray();

        //howMuch.charAt(1);

        int daXie = 0;
        int xiaoXie = 0;
        int shuZi = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                xiaoXie++;
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                daXie++;
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                shuZi++;
            }

        }
        System.out.println("大写字母有" + daXie);
        System.out.println("数字有" + shuZi);
        System.out.println("小写字母有" + xiaoXie);

        for (int i = 97; i < 97 + 26; i++) {
            int num = 0;
            for (int j = 97; j < 97 + chars.length; j++) {
                int charj = (int) chars[j - 97];
                if (charj == i) {
                    num++;
                }
            }
            if (num > 0) {
                System.out.println((char) i + ":" + num);
            }
        }
        for (int i = 65; i < 65 + 26; i++) {
            int num = 0;
            for (int j = 65; j < 65 + chars.length; j++) {
                int charj = (int) chars[j - 65];
                if (charj == i) {
                    num++;
                }
            }
            if (num > 0) {
                System.out.println((char) i + ":" + num);
            }
        }
//        int j = (int)'a';
//        System.out.println(j);

    }


}
