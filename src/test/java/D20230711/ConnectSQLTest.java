package D20230711;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import spider.SpiderUse;
import spider.everyWeb.XMfish;
import spider.method.WhichWeb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;

class ConnectSQLTest {
    @Test
    void asas() throws ParseException, SQLException, IOException {
       /* SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = simpleDateFormat.parse("2023-07-12 10:48");
        System.out.println(date);
        ConnectSQL jdbcTest = new ConnectSQL();
        Connection connection = jdbcTest.getConnection();
        String date1 = jdbcTest.testPreparedStatement(connection,"http://bbs.xmfish.com/thread-htm-fid-55-page-1.html");
        if (date1 == null){
            jdbcTest.add2(connection, "2023-07-12 10:48:00" ,"http://bbs.xmfish.com/thread-htm-fid-55-page-1.html");
        }else {
            System.out.println(date1);
        }*/
        WhichWeb whichWeb = WhichWeb.getInstance();
        String URL = whichWeb.getJbdcTest().test(whichWeb.getconnection(), "[闲置转让] 出三件闲置宝贝");
        System.out.println(URL);
        int id = whichWeb.getJbdcTest().test(whichWeb.getconnection(), "[闲置转让] 出三件闲置宝贝",1);
        System.out.println(id);
        XMfish xMfish = new XMfish();
        xMfish.setDoc(Jsoup.connect(URL).get());
        Elements link = xMfish.getDoc().select("td.floot_bottom div.tpc_content");
        Element element = xMfish.getDoc().selectFirst("td.floot_bottom div.tpc_content");
        String content = element.text();
        for (Element e : link) {
            String str = e.text();
            if (str.equals(content)) {
            }else {
                whichWeb.getJbdcTest().add(whichWeb.getconnection(),id,content,str);
                System.out.println(str);
            }
        }
    }
}