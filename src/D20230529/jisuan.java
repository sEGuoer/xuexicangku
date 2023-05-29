package D20230529;

public class jisuan {
    public static void main(String[] args) {
        int a=12;
        int b=5;
        int x=a/b;
        System.out.println(x);
        double y=a/b;
        System.out.println(y);
        double y1=(double)a/b;
        System.out.println(y1);
        double x1=a/b+0.5;
        System.out.println(x1);

        double asd = a / b + 0.5;
        System.out.println(asd);
        System.out.println(asd);
        System.out.println(asd);
        System.out.println(asd);
        //选中后右键refactor，rename可以将所有的同名变量替换掉
        int v1=12;
        int m1=5;
        int s1=v1%m1;
        System.out.println("v1 % m1 = " + v1 % m1);

        int v2=-12;
        int m2=5;
        System.out.println("v2 % m2 = " + v2 % m2);


        int v3=12;
        int m3=-5;
        System.out.println("v3 % m3 = " + v3 % m3);

        int v4=-12;
        int m4=-5;
        System.out.println("v4 % m4 = " + v4 % m4);
        //对比发现结果之与被除数有关（a%b中的a的正负有关）

        int i1=10;
        int i2=20;
        int i=i1++;
        //System.out.println("i = " + i);  i=10;
        //System.out.println("i1 = " + i1);  i=11;
        //i=++i1;
        //System.out.println("i = " + i);   i=12;
        //System.out.println("i1 = " + i1);  i=12;
        //int i=i2--;
        //System.out.println("i = " + i); i=20;
        //System.out.println("i2 = " + i2); i=19;
        //i=--i2;
        //  System.out.println("i = " + i);  i=18;
        // System.out.println("i2 = " + i2);  i=18;



    }
}
