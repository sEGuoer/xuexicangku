package spider.everyWeb;

import D20230711.ConnectSQL;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import spider.SpiderUse;
import spider.method.SentEmail;
import spider.method.manyUser;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMfish implements SpiderUse {
    @Override
    public void star() throws MessagingException, SQLException, IOException {
        int page = 1;
        int i = 0;
        String a = null;

        Document doc = Jsoup.connect("http://bbs.xmfish.com/thread-htm-fid-55-page-1.html").get();

        //拿到需要过滤掉的内容
//        System.out.println(i);
//            #threadlist tr[class="tr3"] td[class="subject"] a 另一种方法
        Elements link = doc.select("tr.tr3 td.subject:has(i[class = windthread_new]) ");
        for (Element e : link) {
            /*System.out.println(e.html());*/
            a = e.html();
        }

        String firstTime = "";
        Elements links2 = doc.select("tr.tr3:has(a[class = f14 s4 view]) td[class = author]:has(a[title]) p a");
        for (Element e : links2) {
            System.out.println(e.attr("title"));
            firstTime = e.attr("title")+":00";
            break;
        }
        List<String> sentEmail = manyUser.xunHuan(firstTime,page,i,a);
        SentEmail sentEmail1 = new SentEmail();
        sentEmail1.sentEmail(sentEmail);
    }
}
