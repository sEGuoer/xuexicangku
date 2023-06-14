package D20230614;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SuanAge {
    public static void main(String[] args) throws ParseException {
        //小明出生于2012年，他爷爷比他大61岁，他爸爸比他爷爷小23岁，他爸爸的出生日期为11月6号，求小明爸爸的出生日期
       /* String yyyy = "2012";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdf3 = new SimpleDateFormat("MM");
        SimpleDateFormat sdf4 = new SimpleDateFormat("dd");7
        Date parse = sdf.parse(yyyy);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy");
        int year = Integer.parseInt(sdf1.format(parse));
        year = year - 61 + 23 ;
        String year1 = String.valueOf(year);
        String born = year1 + "1106";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
        Date dad = sdf2.parse(born);
        String years = sdf.format(dad);
        String months = sdf3.format(dad);
        String days = sdf4.format(dad);
        System.out.println("出生日期为："+years+"年"+months+"月"+days+"日");*/
        Calendar instance = Calendar.getInstance();  //日历
        int a = 61 ;
        int b = 23 ;
        instance.set(2012 - a + b,Calendar.NOVEMBER,6);
        Date birthday = instance.getTime();
        System.out.println(birthday);


    }
}
