package spider.everyWeb;

import jakarta.mail.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import spider.SpiderUse;
import spider.method.SentEmail;
import spider.method.WhichWeb;
import spider.method.ManyUser;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class XMfish implements SpiderUse {
    private int i = 0;
    private int page = 1;
    private String a;
    private String b;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    private Document doc;

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    @Override
    public String parse(int i) throws SQLException, IOException {
        String b = WhichWeb.getInstance().getWeb(0);
        setB(b);//拿到对应的网址
        setDoc(Jsoup.connect(getB() + "-page-1.html").get());
        return b;
        //拿到需要过滤掉的内容
    }

    private String firstTime;
    private List<String> sentEmail;

    public List<String> getSentEmail() {
        return sentEmail;
    }

    public void setSentEmail(List<String> sentEmail) {
        this.sentEmail = sentEmail;
    }

    public String getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(String firstTime) {
        this.firstTime = firstTime;
    }

    @Override
    public void getInformations() throws SQLException, IOException, ParseException {
        //        System.out.println(i);
//            #threadlist tr[class="tr3"] td[class="subject"] a 另一种方法
        Elements link = getDoc().select("tr.tr3 td.subject:has(i[class = windthread_new]) ");
        for (Element e : link) {
            /*System.out.println(e.html());*/
            setA(e.html());
        }
        Elements links2 = getDoc().select("tr.tr3:has(a[class = f14 s4 view]) td[class = author]:has(a[title]) p a");
        for (Element e : links2) {
            System.out.println(e.attr("title"));
            setFirstTime(e.attr("title") + ":00");
            break;
        }
        setSentEmail(ManyUser.xunHuan(getFirstTime(), getPage(), getI(), getA()));
    }

    @Override
    public void sentEamil(String string) throws MessagingException {
        SentEmail sentEmail1 = new SentEmail();
        sentEmail1.sentEmail(getSentEmail(), string);
    }

    @Override
    public String loadContentAndResponseToDatabase(String string) throws SQLException, IOException {
        WhichWeb whichWeb = WhichWeb.getInstance();
        String URL = whichWeb.getJbdcTest().test(whichWeb.getconnection(), string);
//        System.out.println(URL);
        int id = whichWeb.getJbdcTest().test(whichWeb.getconnection(), string,1);
//        System.out.println(id);
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
                /*System.out.println(str);*/
            }
        }
        return content;
    }

    @Override
    public void getResponse(String string) throws SQLException {
        WhichWeb whichWeb = WhichWeb.getInstance();
        List<String> response = whichWeb.getJbdcTest().loadresponse(whichWeb.getconnection(), string);
        System.out.println(response.toString());
    }
}


