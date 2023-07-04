package D20230608;

public class Method {
    int i;
    int j;

    public static void huitu() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void huitumianji() {
        int f1 = 0;
        int f2 = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("*");
                f1 = j;
            }
            f2 = i;
            System.out.println();
        }
        System.out.println((f1 + 1) * (f2 + 1));

    }

    public static int HuiTuBingJiSuan(int i, int j) {
        for (int i1 = 0; i1 < i; i1++) {
            for (int j1 = 0; j1 < j; j1++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println((i) * (j));
        return (i + 1) * (j + 1);
    }
}
