package D20230605;

public class ketangxunlian1 {
    public static void main(String[] args) {
        double[] numbers=new double[]{3.8,8.6,1.9,-3.4};
        double num=0;
        for(double i:numbers){
            System.out.println(i);
            num=num+i;

        //for (int i=0;i<numbers.length;i++){
          //  System.out.println(i);
        }
        System.out.println("和为："+num);
        }
    }
