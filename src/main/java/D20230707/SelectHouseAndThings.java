package D20230707;

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

import java.io.*;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SelectHouseAndThings {
    public static void main(String[] args) throws IOException, MessagingException, SQLException {
        int page = 1;
        int i = 0;
        String a = null;

        ConnectSQL jdbcTest = new ConnectSQL();
        Connection connection = jdbcTest.getConnection();
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
            firstTime = e.attr("title");
            break;
        }
        //拿到第一个时间
        File file = new File(".\\src\\main\\java\\D20230707\\time.txt");
        file.createNewFile();
        Pattern p = Pattern.compile("\\闲\\置\\转\\让");
        List<String> sentEmail = new ArrayList<>();
        if (file.length() != 0) {
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[16];
            inputStream.read(bytes);
            inputStream.close();
            String s = new String(bytes);//读取文件的字符串

            try (FileWriter writer = new FileWriter(file)) {
                writer.write("");//清空原文件内容
                writer.write(firstTime);
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int panduan = 0;
            for (; ; page++) {
                Document doc1 = Jsoup.connect("http://bbs.xmfish.com/thread-htm-fid-55-page-" + page + ".html").get();
                Elements links1 = doc1.select("tr.tr3:has(a[class = f14 s4 view])");
                if (panduan == 0) {
                    for (Element e : links1) {
                        if (e.select("td[class = author]:has(a[title]) p a").attr("title").equals(s)) {
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
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("");//清空原文件内容
                writer.write(firstTime);
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
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
        }
        String emailMessage = sentEmail.toString();
        if (sentEmail.isEmpty()) {
        } else {
            Properties prop = new Properties();
            prop.put("mail.smtp.auth", true);
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", "smtp.qq.com");
            prop.put("mail.smtp.port", "587");

            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(System.getenv("qqmail"), System.getenv("password"));
                }
            });

            Message message = new MimeMessage(session);
            // who you are
            message.setFrom(new InternetAddress(System.getenv("qqmail")));
            // send to ...
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("709074535@qq.com"));

            message.setSubject("Mail Subject");

            String msg = emailMessage;

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Sent message successfully....");
        }
    }
}
