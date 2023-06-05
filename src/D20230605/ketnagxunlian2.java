package D20230605;

public class ketnagxunlian2 {
    public static void main(String[] args) {
        int[] array1=new int[]{8,2,1,0,3};
        int[] array2=new int[]{2,0,3,2,4,0,1,3,2,3,3};
        System.out.println(array1);
        System.out.println(array2);
        for (int i : array2){
            int phoneNum=array1[i];
            System.out.print(phoneNum);
        }
        System.out.println();
        int[][] ij=new int[][]{{3,5,8},{12,9},{7,0,6,4}};
        for (int i=0;i<ij[i].length;i++){
            for (int j=0;j<ij[i].length;j++){
                System.out.print(" "+ij[i][j]);
            }
            System.out.println();
        }
        //System.out.println(ij[0][0]+" "+ij[0][1]+" "+ij[0][2]+" ");
        //System.out.println(ij[1][0]+" "+ij[1][1]+" ");
        //System.out.println(ij[2][0]+" "+ij[2][1]+" "+ij[2][2]+" "+ij[2][3]+" ");

    }
}
