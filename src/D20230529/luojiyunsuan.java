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
    }
}
