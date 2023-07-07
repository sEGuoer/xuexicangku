package D20230707;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class SelectHouseAndThings {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://bbs.xmfish.com/thread-htm-fid-55-page-1.html").get();
        String a = null;
        Elements link = doc.select("tr.tr3 td.subject:has(i[class = windthread_new]) a[class=subject_t f14] ");
        for (Element e : link) {
            /*System.out.println(e.html());*/
            a = e.html();
        }
        //拿到需要过滤掉的内容
//        System.out.println(i);
        Elements links1 = doc.select("tr.tr3 td.subject:has(i) a[class=f14 s4 view],tr.tr3 td.subject:has(i) a[class=subject_t f14] ");
        int i = 0;
//            #threadlist tr[class="tr3"] td[class="subject"] a 另一种方法
        for (Element e : links1) {
            if (!e.html().equals(a)) {
                System.out.println(e.text());
            } else if (e.html().equals(a)) {
                i++;
            }
        }
        //拿到想要的信息
        System.out.println("过滤了" + i + "条");
    }
}
