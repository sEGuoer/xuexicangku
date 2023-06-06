package D20230606;

import java.util.Scanner;

public class yanghuisanjiao {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入杨辉三角的层数");
        int input = scanner.nextInt();
        int[][] yanghui = new int[input][input];
        for (int i=0;i< yanghui.length;i++){
            for (int j=0;j<=i;j++){
                if (j==0||i==j){
                    yanghui[i][j]=1;
                }
                else{
                    yanghui[i][j]=yanghui[i-1][j]+yanghui[i-1][j-1];
                }
                System.out.print(yanghui[i][j]+" ");
            }
            System.out.println();
        }
    }
}
