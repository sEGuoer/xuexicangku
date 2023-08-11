package D20230811;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MyClient {
    public static void main(String[] args) throws IOException {
        fromJsoup();
//        fromURL();
    }

    public static void fromJsoup() throws IOException {
        Document doc = Jsoup.connect("http://localhost:8080/")
                .header("User-Agent","MacOS")
                .header("XXX","aaaa")
                .get();
        System.out.println(doc.title());
    }
    public static void fromURL() throws IOException {
        URL url = new URL("http://localhost:8080/");
        URLConnection uc = url.openConnection();
        uc.setConnectTimeout(1000);
        uc.setReadTimeout(1000);
        BufferedReader io = new BufferedReader(new InputStreamReader(uc.getInputStream(),"gb2312"));
        String inputLine;
        while ((inputLine = io.readLine()) != null) {
            System.out.println(inputLine);
        }
        io.close();
    }
}
