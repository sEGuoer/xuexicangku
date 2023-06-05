package D20230605;

public class StringBasic {
    public static void main(String[] args) {
        /*
        静态初始化
         */
        String[] names;
        names=new String[]{"小早","小中","小晚"};

        /*
        动态初始化
        */
        int [] ages=new int[3];
        ages[0]=20;
        ages[1]=19;
        ages[2]=18;
        /*
        其他写法
        int ages2[]=new int[3]
        String[] names2={"a","b","c"}
         */
        int ages2[]=new int[3];//可以但不推荐

        //int[] numbers={1,2,3,4,5};
        System.out.println(names[1]);




    }
}
