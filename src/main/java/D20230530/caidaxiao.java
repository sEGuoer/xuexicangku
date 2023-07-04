package D20230530;

import java.util.Random;

public class caidaxiao {
    /*
    1.运行文件
    2.系统会给出一个100以内的随机数
    3.输入一个你自己猜的100以内的正整数
    4.每个人有9次猜密码机会,猜错中止，想继续重新开始，成功会发出祝贺
    5.每次猜都会有相应提示
     */
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        Random random = new Random();
        int a = random.nextInt(100);
        System.out.println("~请输入你猜的一个100以内的正整数");
        int s = 0;
        for (; s < 8; s++) {
            int math = input.nextInt();
            if (a == math) {
                System.out.println("congratulations猜对了");
                break;
            } else if (a < math) {
                System.out.println("~你猜的数有点大哦~");
                System.out.println("还有" + (7 - s) + "次机会");
            } else if (a > math) {
                System.out.println("~你猜的数小了~");
                System.out.println("还有" + (7 - s) + "次机会");
            }
        }
        while (s == 8) {
            System.out.println("游戏失败,本次所猜的数为" + a);
            s++;
        }
    }
}
