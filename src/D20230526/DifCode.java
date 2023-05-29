package D20230526;

public class DifCode {
    public static void main(String[] args) {
        float ab=19.9f;
        System.out.println(ab);
        //foalt 单精度 32-bit 4字节

        byte ac=1;
        //byte bc=123213123; 此处赋值远超范围，故不行。byte 8-bit 1字节
        System.out.println(ac);

        short ad=123;
        //同理 short 16-bit 2字节
        System.out.println(ad);

        int ae=12345;
        //同理 int 32-bit 4字节
        System.out.println(ae);

        long af=12345667L;
        // long 64-bit 8字节,此处long后要加L/l，L更好区分,所以多用L
        System.out.println(af);

        double ag='3';
        System.out.println(ag);
        //double 双精度 64-bit 8字节

        char ah='1';
        //char 16-bit 2字节对应单字符，对应的’‘中的只能代表·一个单字符，但是内容可以是多个
        char ai='\t';
        char aj='\n';
        //\n代表换行，\t代表空格
        char k='\u2263';
        //这个代表对应表中的字符
        System.out.println(k);
        System.out.println('*'+'\t'+'*');
        boolean result=false;
        char a='*';
        char b='\t';
        System.out.println(a+b);
        System.out.println(a);
        //对应正确或错误，true


    }
}
