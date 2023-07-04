package D20230529;

public class lianxi {
    public static void main(String[] args) {
        int x = 1;
        x *= 0.1;
        //此处的运算为在和上述相同的情况下进行的，也就是int，故运算结果是int对应结果。
        System.out.println("x = " + x);
        x++;
        System.out.println("x = " + x);

        int n = 1;
        int m = 2;
        m *= n++;
        //运算过程是m*n++=m=1*2
        System.out.println("m = " + m);
        System.out.println("n = " + n);
    }
}
