package spider.method;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManyUser {
    private ManyUser() {
    }
    private static volatile ManyUser manyUser;


    public static ManyUser getManyUser() {
        if (manyUser == null){
            synchronized (ManyUser.class){
                if (manyUser == null){
                    manyUser = new ManyUser();
                }
            }
        }
        return manyUser;
    }

    private String demandWeb;
    List<String> sentEmail;

    public String getDemandWeb() {
        return demandWeb;
    }

    public void setDemandWeb(String demandWeb) {
        this.demandWeb = demandWeb;
    }

    public List<String> getSentEmail() {
        return sentEmail;
    }

    public void setSentEmail(List<String> sentEmail) {
        this.sentEmail = sentEmail;
    }

    public static List<String> getInformationsToSent(String firstTime, int page, int i, String uselessURL) throws SQLException, IOException, ParseException {
        Pattern p = Pattern.compile("\\闲\\置\\转\\让");//筛选条件
        WhichWeb whichWeb =WhichWeb.getInstance();
        ManyUser manyUser =getManyUser();
        manyUser.setDemandWeb(whichWeb.getWeb(0));
        System.out.println(manyUser);
        System.out.println(manyUser.getDemandWeb());
        List<String> medium = new ArrayList<>();
        System.out.println(firstTime);
        String LastTime = whichWeb.getJbdcTest().testPreparedStatement(whichWeb.getconnection(), manyUser.getDemandWeb());
        System.out.println(LastTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = simpleDateFormat.parse(LastTime);//截至时间
        if (LastTime != null) {
            whichWeb.getJbdcTest().update(whichWeb.getconnection(),firstTime,manyUser.getDemandWeb());
            int panduan = 0;
            for (; ; page++) {
                Document doc1 = Jsoup.connect(manyUser.getDemandWeb()+"-page-" + page + ".html").get();
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

                            if (!e.html().equals(uselessURL)) {
                                String str = e.text();
                                System.out.println(str);
                                String[] data = str.split(" ");
                                StringBuilder sb = new StringBuilder();
                                sb.append(data[0]);
                                sb.append(data[1]);
                                System.out.println(sb.toString());//得到想要的信息
                                String sbToString = sb.toString();
                                String URL = "http://bbs.xmfish.com/" + e.select("td[class = subject] a[class=\"subject_t f14\"]").attr("href");
                                Matcher m = p.matcher(sb.toString());
                                whichWeb.getJbdcTest().add(whichWeb.getconnection(),sbToString,URL);
                                while (m.find()) {
                                    medium.add(sbToString + "<br>" + URL + "<br>");
                                }
                            } else if (e.html().equals(uselessURL)) {
                                i++;
                            }
                        }
                    }
                } else  {
                    break;
                }
            }
            System.out.println("过滤了" + i + "条");

        } else {
            whichWeb.getJbdcTest().add2(whichWeb.getconnection(), firstTime ,manyUser.getDemandWeb());
            for (; page < 4; page++) {
                Document doc1 = Jsoup.connect(manyUser.getDemandWeb()+"-page-" + page + ".html").get();
                Elements links1 = doc1.select("tr.tr3:has(a[class = f14 s4 view])");
                for (Element e : links1) {
                    if (!e.html().equals(uselessURL)) {
                        String str = e.text();
                        String[] data = str.split(" ");
                        StringBuilder sb = new StringBuilder();
                        sb.append(data[0] + " ");
                        sb.append(data[1]);
                        System.out.println(sb.toString());//得到想要的信息
                        String sbToString = sb.toString();
                        String URL = "http://bbs.xmfish.com/" + e.select("td[class = subject] a[class=\"subject_t f14\"]").attr("href");
                        Matcher m = p.matcher(sb.toString());
                        whichWeb.getJbdcTest().add(whichWeb.getconnection(),sbToString,URL);
                        while (m.find()) {
                            medium.add(sbToString + "<br>" + URL + "<br>");
                        }
                    } else if (e.html().equals(uselessURL)) {
                        i++;
                    }
                }
                //拿到想要的信息
            }
            System.out.println("过滤了" + i + "条");
        }
        manyUser.setSentEmail(medium);
        return manyUser.getSentEmail();
    }
}
