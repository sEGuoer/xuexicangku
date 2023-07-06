package D20230706;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class URLConnectionReader {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect( "http://www.baidu.com/").get();

        Element links = doc.selectFirst("a#s-top-loginbtn");
        System.out.println(links.html());
    }
}
