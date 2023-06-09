package D20230530;

public class xunhuan {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("哈哈");
        }
        f1();
        f2();
    }

    public static void f1() {

        int num = 1;
        for (System.out.println("a"); num <= 3; System.out.println("c"), num++)
            System.out.println("b");
    }

    public static void f2() {
        int s = 1;
        for (; s <= 150; s++) {
            if ((s % 3 == 0) && (s % 5 > 0) && (s % 7 > 0)) {
                System.out.println(s + " g3");
            } else if ((s % 5 == 0) && (s % 3 > 0) && (s % 7 > 0)) {
                System.out.println(s + " g5");
            } else if ((s % 7 == 0) && (s % 3 > 0) && (s % 5 > 0)) {
                System.out.println(s + " g7");
            } else if ((s % 3 == 0) && (s % 5 == 0) && (s % 7 > 0)) {
                System.out.println(s + " g3" + " g5");
            } else if ((s % 3 == 0) && (s % 7 == 0) && (s % 5 > 0)) {
                System.out.println(s + " g3" + " g7");
            } else if ((s % 5 == 0) && (s % 7 == 0) && (s % 3 > 0)) {
                System.out.println(s + " g5" + " g7");
            } else if ((s % 3 == 0) && (s % 5 == 0) && (s % 7 == 0)) {
                System.out.println(s + " g3" + " g5" + " g7");
            } else {
                System.out.println(s);
            }

        }

    }
}


