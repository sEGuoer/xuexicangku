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
import java.util.Arrays;
import java.util.List;

public class XMfish implements SpiderUse {
    private int surfaceparameters = 0;
    private int page = 1;
    private String uselessURL;
    private String demandWeb;

    public int getSurfaceparameters() {
        return surfaceparameters;
    }

    public void setSurfaceparameters(int surfaceparameters) {
        this.surfaceparameters = surfaceparameters;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getUselessURL() {
        return uselessURL;
    }

    public void setUselessURL(String a) {
        this.uselessURL = a;
    }

    public String getDemandWeb() {
        return demandWeb;
    }

    public void setDemandWeb(String demandWeb) {
        this.demandWeb = demandWeb;
    }

    private Document doc;

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    @Override
    public String parse(int whichWeb) throws SQLException, IOException {
        String demandWeb = WhichWeb.getInstance().getWeb(whichWeb);
        setDemandWeb(demandWeb);//拿到对应的网址
        setDoc(Jsoup.connect(getDemandWeb() + "-page-1.html").get());
        return demandWeb;
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
            setUselessURL(e.html());
        }
        Elements links2 = getDoc().select("tr.tr3:has(a[class = f14 s4 view]) td[class = author]:has(a[title]) p a");
        for (Element e : links2) {
            System.out.println(e.attr("title"));
            setFirstTime(e.attr("title") + ":00");
            break;
        }
        setSentEmail(ManyUser.getInformationsToSent(getFirstTime(), getPage(), getSurfaceparameters(), getUselessURL()));
    }

    @Override
    public void sentEamil(String toWho) throws MessagingException {
        SentEmail sentEmail1 = new SentEmail();
        sentEmail1.sentEmail(getSentEmail(), toWho);
    }

    @Override
    public String loadContentAndResponseToDatabaseByTitle(String title) throws SQLException, IOException {
        WhichWeb whichWeb = WhichWeb.getInstance();
        String URL = whichWeb.getJbdcTest().test(whichWeb.getconnection(), title);
        String[] data = URL.split(".html");
        StringBuilder sb = new StringBuilder();
        sb.append(data[0]);
        String a = sb.toString();
        System.out.println(a);
        int id = whichWeb.getJbdcTest().test(whichWeb.getconnection(), title, 1);
//        System.out.println(id);
        XMfish xMfish = new XMfish();
        xMfish.setDoc(Jsoup.connect(URL).get());
        Element link2 = xMfish.getDoc().selectFirst("div[class = cc mb10]");
        String s = link2.text();
        System.out.println(s);
        String[] strings = s.split("[\\共\\页]");
        Element element = xMfish.getDoc().selectFirst("td.floot_bottom div.tpc_content");
        String content = element.text();
        if (strings.length == 1) {
            Elements link = xMfish.getDoc().select("td.floot_bottom div.tpc_content");
            System.out.println(Arrays.toString(strings));
            for (Element e : link) {
                String str = e.text();
                if (str.equals(content)) {
                } else {
                    whichWeb.getJbdcTest().add(whichWeb.getconnection(), id, content, str);
                    /*System.out.println(str);*/
                }
            }
            List<String> response = whichWeb.getJbdcTest().loadresponse(whichWeb.getconnection(), content);
            if (response.isEmpty()) {
                whichWeb.getJbdcTest().add(whichWeb.getconnection(), id, content, null);
            }
            return content;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(data[1]);
            System.out.println(sb2.toString());
            int page = Integer.parseInt(sb2.toString());
            for (int i1 = 1; i1 <=page ; i1++) {
                xMfish.setDoc(Jsoup.connect(a + "-page-" + i1 + ".html").get());
                Elements link = xMfish.getDoc().select("td.floot_bottom div.tpc_content");
                System.out.println(Arrays.toString(strings));
                for (Element e : link) {
                    String eachResponse = e.text();
                    if (eachResponse.equals(content)) {
                    } else {
                        whichWeb.getJbdcTest().add(whichWeb.getconnection(), id, content, eachResponse);
                        /*System.out.println(str);*/
                    }
                }
                List<String> responses = whichWeb.getJbdcTest().loadresponse(whichWeb.getconnection(), content);
                if (responses.isEmpty()) {
                    whichWeb.getJbdcTest().add(whichWeb.getconnection(), id, content, null);
                }
            }return content;
        }
    }

    @Override
    public void getResponseByContent(String content) throws SQLException {
        WhichWeb whichWeb = WhichWeb.getInstance();
        List<String> response = whichWeb.getJbdcTest().loadresponse(whichWeb.getconnection(), content);
        System.out.println(response.toString());
    }
}


