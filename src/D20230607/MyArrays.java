package D20230607;

import java.util.Scanner;

public class MyArrays {
    public static void max(int[] args) {
        int max=0;
        for (int i=0;i<args.length;i++){
            if (args[i]>max){
                max=args[i];
            }
        }
        System.out.println("最大值为"+max);
    }

    public static void min(int[] args) {
        int min=0;
        for (int i=0;i<args.length;i++){
            if (args[i]<min){
                min=args[i];
            }
        }
        System.out.println("最小值为"+min);
    }

    public static void sum(int[] args) {
        int sum=0;
        for (int i=0;i<args.length;i++){
            sum=sum+args[i];
            }
        System.out.println("和为"+sum);
    }

    public static void avarage(int[] args) {
        int avarage=0;
        for (int i=0;i<args.length;i++){
            avarage=avarage+args[i];
        }
        avarage=avarage/ args.length;
        System.out.println("平均值为"+avarage);
    }

    public static void bianlishuzu(int[] args) {
        for (int i=0;i<args.length;i++){
            System.out.print(args[i]+" ");
        }
        System.out.println();
    }

    public static void fuzhishuzu(int[] args1,int[] args2) {
        System.out.print("赋值后的数组为");
        for (int i=0;i<args1.length;i++){
            args2[i]=args1[i];
            System.out.print(args2[i]+" ");
        }
        System.out.println();
    }

    public static void shuzufanzhuan(int[] args) {
        for (int i=0;i<args.length/2;i++){
            int a=args[i];
            args[i]=args [args.length-1-i];
            args [args.length-1-i]=a;
        }
        for (int i=0;i<args.length;i++){
            System.out.print(args[i]+" ");
        }
        System.out.println();
    }


    public static void shuzupaixu(int[] shuzu) {
        for (int i= shuzu.length;i>1;i--){
            for (int j=0;j<i-1;j++){
                if (shuzu[j]>shuzu[j+1]){
                    int a =shuzu[j];
                    shuzu[j]=shuzu[j+1];
                    shuzu[j+1]=a;
                }
            }
        }
        for (int i1=0;i1< shuzu.length;i1++){
            System.out.print(shuzu[i1]+" ");
        }
        System.out.println();
    }

    public static void chazhao(int[] args) {
        int[] erfen=new int[]{3,4,5,6,7,8,9,10};
        int i= 0;
        int j= erfen.length-1;
        System.out.println("请输入你想找的数");
        Scanner scanner=new Scanner(System.in);
        int input=scanner.nextInt();
        while (i<=j){
            int mid=(i+j)/2;
            if(erfen[mid]>input){
                j=mid-1;
            } else if (erfen[mid]<input) {
                i=mid+1;
            }
            else{
                System.out.println();
                System.out.println("能找到输入的数"+erfen[mid]);
                break;
            }
        }
        while (i>j){
            System.out.println("找不到"+input);
            break;
        }
    }
}
