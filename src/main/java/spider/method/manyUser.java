package spider.method;

import D20230711.ConnectSQL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class manyUser {
    public static List<String> xunHuan(String firstTime,int page,int i,String a) throws SQLException, IOException, ParseException {
        ConnectSQL jdbcTest = new ConnectSQL();
        Connection connection = jdbcTest.getConnection();
        Pattern p = Pattern.compile("\\闲\\置\\转\\让");//筛选条件
        List<String> sentEmail = new ArrayList<>(); //发送邮件的信息
        String LastTime = jdbcTest.testPreparedStatement(connection,"http://bbs.xmfish.com/thread-htm-fid-55-page-1.html");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = simpleDateFormat.parse(LastTime);//截至时间
        if (LastTime != null) {
            jdbcTest.update(connection,firstTime,"http://bbs.xmfish.com/thread-htm-fid-55-page-1.html");
            int panduan = 0;
            for (; ; page++) {
                Document doc1 = Jsoup.connect("http://bbs.xmfish.com/thread-htm-fid-55-page-" + page + ".html").get();
                Elements links1 = doc1.select("tr.tr3:has(a[class = f14 s4 view])");
                if (panduan == 0) {
                    for (Element e : links1) {
                        Date date1 = simpleDateFormat.parse((e.select("td[class = author]:has(a[title]) p a").attr("title")+":00"));
                        //数据时间
                        if (date1.before(date)) {
                            panduan = 1;//判断是否为当前时间信息，如果是就终止
                            break;
                        } else {
                           /* System.out.println(e.select("td[class = author]:has(a[title]) p a").attr("title"));
                            System.out.println(s);*/

                            if (!e.html().equals(a)) {
                                String str = e.text();
                                String[] data = str.split(" ");
                                StringBuilder sb = new StringBuilder();
                                sb.append(data[0] + " ");
                                sb.append(data[1]);
                                System.out.println(sb.toString());//得到想要的信息
                                String sbToString = sb.toString();
                                String URL = "http://bbs.xmfish.com/" + e.select("td[class = subject] a[class=\"subject_t f14\"]").attr("href");
                                Matcher m = p.matcher(sb.toString());
                                jdbcTest.add(connection,sbToString,URL);
                                while (m.find()) {
                                    sentEmail.add(sbToString + "<br>" + URL + "<br>");
                                }
                            } else if (e.html().equals(a)) {
                                i++;
                            }
                        }
                    }
                } else if (panduan == 1) {
                    break;
                }
            }
            System.out.println("过滤了" + i + "条");

        } else {
            jdbcTest.add2(connection, firstTime ,"http://bbs.xmfish.com/thread-htm-fid-55-page-1.html");
            for (; page < 4; page++) {
                Document doc1 = Jsoup.connect("http://bbs.xmfish.com/thread-htm-fid-55-page-" + page + ".html").get();
                Elements links1 = doc1.select("tr.tr3:has(a[class = f14 s4 view])");
                for (Element e : links1) {
                    if (!e.html().equals(a)) {
                        String str = e.text();
                        String[] data = str.split(" ");
                        StringBuilder sb = new StringBuilder();
                        sb.append(data[0] + " ");
                        sb.append(data[1]);
                        System.out.println(sb.toString());//得到想要的信息
                        String sbToString = sb.toString();
                        String URL = "http://bbs.xmfish.com/" + e.select("td[class = subject] a[class=\"subject_t f14\"]").attr("href");
                        Matcher m = p.matcher(sb.toString());
                        jdbcTest.add(connection,sbToString,URL);
                        while (m.find()) {
                            sentEmail.add(sbToString + "<br>" + URL + "<br>");
                        }
                    } else if (e.html().equals(a)) {
                        i++;
                    }
                }
                //拿到想要的信息
            }
            System.out.println("过滤了" + i + "条");
        }return sentEmail;
    }
}
