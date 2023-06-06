package D20230606;

import java.util.Scanner;

public class erfenfa {
    public static void main(String[] args) {
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
