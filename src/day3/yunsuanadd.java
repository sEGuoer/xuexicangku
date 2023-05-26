package day3;

public class yunsuanadd {
    public static void main(String[] args) {

    byte byte1=2;
    byte byte2=3;
    short short1=188;
    int int1=1888;
    int int2=1999;
    long lo1=18888L;
    long lo2=19999L;
    float fl1=12;
    float fl2=122;
    double dou1=123;
    char char1='a';
    //以上为给不同的变量赋值
    int byte3=byte1+byte2;
    //此处不行byte byte3=byte1+byte2;，因为16-bit以下的相加都要用32-bit以上的
    float short2=short1+byte1;
    //同理short short2=short1+byte1;
    int int3=int1+int2;
    int int4=int1+short1;
    int int5=int1+char1;
    //具体应用，16-bit以下的＋32-bit以上的，用更高位的
        float float1=fl1+fl2;
        float float2=fl1+int1;
        //int float2=fl1+int1不行，用小数点会失去flaat的精度
        double double1=fl1+dou1;
        //float double1=fl1+dou1;同样是精度问题
        int chart1=char1+byte1;
        long chart2=char1+byte1;
        float chart3=char1+byte1;
        //char chart1=char1+byte1;同理只能用32-bit以上;相比于上面两个float会有小数点
        long long1=lo1+lo2;
        System.out.println(long1);

        double double2=19.9;
        int in1=(int)double2;
        System.out.println(in1);
        //此时会出现精度损失，19.9会变为19,（）代表强制转换
        short sh1=128;
        byte b1=(byte)sh1;
        System.out.println(b1);
        //（应该是会在范围内循环，比如byte范围是-128~127，此处的128就是下个循环的第一位-128）

        int in2=188;
        short s1=(short)in2;
        //一般运用于有把握在对大容量缩小，进而使用使其缩小容量.
        String sb="百搭";
        System.out.println(byte1+char1);
        System.out.println(sb+byte1);
        System.out.println(sb+short1);
        System.out.println(sb+int1);
        System.out.println(sb+long1);
        System.out.println(sb+float1);
        System.out.println(sb+char1);
        System.out.println(sb+dou1);
        System.out.println(sb+sb);
        //String输出字符为字母，所以不进行加减乘除，只是简单的输出对应的文本
        String sd=" ";
        System.out.println(sd+sb);
    }
}
