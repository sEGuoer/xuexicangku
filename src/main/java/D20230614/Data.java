package D20230614;

import cn.hutool.core.date.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Data {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);
        Date date1 = new Date(1000);
        System.out.println(date1);
/*        long time = date.getTime();
        date.setTime(time + 2000);
        System.out.println(date);*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
        String s = sdf.format(date);
        System.out.println(s);

        String s1 = "20230614101159";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddhhmmss");
        Date date2 = sdf1.parse(s1);
        System.out.println(date2);


 /*       Scanner scanner1 = new Scanner(System.in);
        System.out.println("输入你要查询的年份");
        System.out.println("示例:2023");
        String str1 = scanner1.next();*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入你要查询的年月日是第几周");
        System.out.println("示例:20230501");
        String str = scanner.next();

//        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMdd");
//        Date parse = sdf3.parse(str);
//        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy");
//        Date parse1 = sdf4.parse(str1);
//        long time = parse.getTime();
//        long time1 = parse1.getTime();
//        long t = time - time1 ;
//        int week = (int) (t/1000/60/60/24/7)+1;
//        System.out.println("是"+str1+"年第"+week+"周");


        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMdd");
        Date parse = sdf3.parse(str);

        SimpleDateFormat sdf4 = new SimpleDateFormat("ww");
        String week = sdf4.format(parse);
        System.out.println("是第"+week+"周");

    }

}
