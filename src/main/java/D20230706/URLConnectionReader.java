package D20230706;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class URLConnectionReader {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect( "https://so.gushiwen.cn/gushi/shijing.aspx").get();

        Elements links = doc.select("div.main3 div.left div.sons a");
        int i = 0;
        for (Element e : links){
            i++;
            System.out.println(e.html());
        }
        System.out.println(i);
       /* Elements link = doc.select("span > a");
        int u = 0;
        for (Element e : link){
            u++;
            System.out.println(e.html());
        }
        System.out.println(u);*/
    }
}
