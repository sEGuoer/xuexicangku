package D20230605;

import java.util.Random;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        /*java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.println("从键盘输入学生人数");
        int[] renshu = new int[scan.nextInt()];
        int a = 0;
        for(int i=0;i< renshu.length;i++){
            System.out.println("请输入第"+(i+1)+"个学生的成绩");
            renshu[i]=scan.nextInt();
            if (renshu[i]>a){
                a=renshu[i];
                }
        }
        System.out.println("  -最高分数"+a);
        char dengji='d';
        int j=0;
        for (;j< renshu.length;j++){
            if(a-renshu[j]<=10){dengji='a';}
            else if(a-renshu[j]<=20){dengji='b';}
            else if(a-renshu[j]<=30){dengji='c';}
            else {dengji='d';}
            System.out.println("第"+(j+1)+"位学生的成绩为"+dengji);
        }
        */
        int[] asd = {5,4,6,8,9,0,1,2,7,3};
        double scout=0;
        int max=0;
        int min=0;
        for (int i=0;i<asd.length;i++){
            System.out.println("分数为"+asd[i]);
            scout=scout+asd[i];

            if (max<asd[i]){
                max=asd[i];
            }

            if (min>asd[i]){
                min=asd[i];
            }
        }
        System.out.println("平均分为"+((scout-max-min)/((asd.length)-2)));
    }
}
