package D20230529;

public class luojiyunsuan {
    public static void main(String[] args) {
        boolean a=true;
        boolean b=false;
        System.out.println("   a   "+"   b   "+"  a&b  "+"  a&&b "+"  a|b  "+"  a||b "+"   !a  "+"  a^b  ");
        System.out.println(" true  "+"  true  "+" "+(a&a)+"   "+(a&&a)+"   "+(a|a)+"   "+(a||a)+"   "+(!a)+" "+(a^a));
        System.out.println(" true  "+" false "+" "+(a&b)+"   "+(a&&b)+"  "+(a|b)+"   "+(a||b)+"   "+(!a)+"  "+(a^b));
        System.out.println(" false "+"  true  "+(b&a)+"   "+(b&&a)+"  "+(b|a)+"   "+(b||a)+"   "+(!b)+"   "+(b^a));
        System.out.println(" false "+" false  "+(b&b)+"   "+(b&&b)+" "+(b|b)+"  "+(b||b)+"   "+(!b)+"  "+(b^b));

        byte c=5;
        c <<=2;
        System.out.println("c = " + c);
        c >>=2;
        System.out.println(c);
        c >>=3;
        System.out.println("c = " + c);
        byte d=127;
        d >>=3;
        System.out.println("d = " + d);
        d <<=3;
        d >>>=3;
        System.out.println(d);
        int f=12;
        int t=5;
        System.out.println(f|t);
        int a1=10;
        int a2=20;
        System.out.println("a2="+((a1|a2)+(a1&a2)-a1));
        System.out.println("a1="+((a1|a2)+(a1&a2)-a2));
        System.out.println("a1="+((a2^a1)^a2));
        /*
        三种方法用a1,a2得到对方

        第一：设置一个新变量，使a1+a2=a，从而得到a1,a2的值

        第二：a1=a1+a2
        a2=a1-a2
        原来的a1=a2,原来的a2=a1-a2

        第三就是用异反
        先求两个数的异反，求出来的异反和其中一个数的异反就是另一个数.
         */
    }
}
