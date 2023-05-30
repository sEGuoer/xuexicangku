package D20230530;

public class chengfabiao {
    public static void main(String[] args) {
        f1();
    }

    public static void f1() {
        int i=1;
        int n=1;
        while (i<10){while (i>=n){
            System.out.println(n+"*"+i+"="+(i*n));
            n++;}
            n=1;
            i++;
            System.out.println();
        }
    }
}

