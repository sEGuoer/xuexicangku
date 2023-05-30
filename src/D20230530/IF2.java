package D20230530;
import javax.swing.plaf.metal.MetalIconFactory;
import java.util.Scanner;

public class IF2 {
    public static void main(String[] args) {
        /*java.util.Scanner input =new java.util.Scanner(System.in);
         *System.out.println("请输入年龄");
         *int age= input.nextInt();
         * if(age>=0);
         *else if(age<0) {System.out.println("请输入正确的年龄");}
         */
        f1();
    }

    public static void f1() {
        int num1=15;
        while (num1>10){
            System.out.println("123");
            num1--;
        }
        int num2=15;
        do {
            System.out.println("321");
            num2--;
        }while (num2>10);
    }
}

