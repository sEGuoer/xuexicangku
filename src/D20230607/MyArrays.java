package D20230607;

import D20230608.Student;

import java.util.Scanner;

public class MyArrays {

    public static void max(int[] args) {
        int max = 0;
        for (int arg : args) {
            if (arg > max) {
                max = arg;
            }
        }
        System.out.println("最大值为" + max);
    }

    public static void min(int[] args) {
        int min = 0;
        for (int arg : args) {
            if (arg < min) {
                min = arg;
            }
        }
        System.out.println("最小值为" + min);
    }

    public static void sum(int[] args) {
        int sum = 0;
        for (int arg : args) {
            sum = sum + arg;
        }
        System.out.println("和为" + sum);
    }

    public static void avarage(int[] args) {
        int avarage = 0;
        for (int arg : args) {
            avarage = avarage + arg;
        }
        avarage = avarage / args.length;
        System.out.println("平均值为" + avarage);
    }

    public static void bianLiShuZu(int[] args) {
        for (int arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();
    }

    public static void fuZhiShuZu(int[] args1, int[] args2) {
        System.out.print("赋值后的数组为");
        for (int i = 0; i < args1.length; i++) {
            args2[i] = args1[i];
            System.out.print(args2[i] + " ");
        }
        System.out.println();
    }

    public static void shuZuFanZhuan(int[] args) {
        for (int i = 0; i < args.length / 2; i++) {
            int a = args[i];
            args[i] = args[args.length - 1 - i];
            args[args.length - 1 - i] = a;
        }
        for (int arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();
    }


    public static void shuZuPaiXu(int[] shuzu) {
        for (int i = shuzu.length; i > 1; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (shuzu[j] > shuzu[j + 1]) {
                    int a = shuzu[j];
                    shuzu[j] = shuzu[j + 1];
                    shuzu[j + 1] = a;
                }
            }
        }
    }


    public static void shuZuPaiXu(Student[] shuzu) {
        for (int i = shuzu.length; i > 1; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (shuzu[j].score > shuzu[j + 1].score) {
                    Student a = shuzu[j];
                    shuzu[j] = shuzu[j + 1];
                    shuzu[j + 1] = a;
                }
            }
        }
    }

    public static void sort(int[] args) {
        int[] erfen = new int[]{3, 4, 5, 6, 7, 8, 9, 10};
        int i = 0;
        int j = erfen.length - 1;
        System.out.println("请输入你想找的数");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while (i <= j) {
            int mid = (i + j) / 2;
            if (erfen[mid] > input) {
                j = mid - 1;
            } else if (erfen[mid] < input) {
                i = mid + 1;
            } else {
                System.out.println();
                System.out.println("能找到输入的数" + erfen[mid]);
                break;
            }
        }
        while (i > j) {
            System.out.println("找不到" + input);
            break;
        }
    }

    public static String inputLanguage(String... a) {
        if (a == null) {
        } else {
            for (int i = 0; i < a.length; i++) {
                if (i < a.length - 1) {
                    System.out.print(a[i] + "-");
                } else {
                    System.out.print(a[i]);
                }
            }
        }
        return "";
    }
}
