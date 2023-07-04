package D20230609;

public class DiGui {

    public static void main(String[] args) {
        DiGui misTake = new DiGui();
        System.out.println(misTake.sum(100));
        System.out.println(misTake.JieCheng(10));
        System.out.println(misTake.f(5));
        /*        misTake.mm();*/
    }

    /*    public void mm(){
            System.out.println("搞死你");
            mm();
        }*/
    public int sum(int i) {
        if (i == 1) {
            return 1;
        } else {
            return sum(i - 1) + i;
        }
    }

    public int JieCheng(int i) {
        if (i == 1){
            return 1;
        }
        else {
            return JieCheng(i - 1) * i;
        }
    }

    //求斐波那契数列f（n）=？
    public int f(int i){
        if (i == 1 || i == 2){
            return 1;
        }
        else {
            return f(i - 2) + f(i - 1);
        }
    }
}
