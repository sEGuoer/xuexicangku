package D20230526;

public class jinzhi {
    public static void main(String[] args) {
        int binaryNum = 0b110;
        //2进制
        System.out.println("binaryNum=" + binaryNum);
        int decimaNum = 110;
        System.out.println("decimaNum=" + decimaNum);
        int actalNum = 0127;
        //不能是128，因为128是8的倍数，会进一位
        //8进制
        System.out.println("actalNum=" + actalNum);
        int hexNum = 0x110A;
        //16进制
        System.out.println("hexNum=" + hexNum);
    }
}
