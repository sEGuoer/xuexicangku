package D20230706;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import static org.junit.jupiter.api.Assertions.*;

class URLReadingTest {
    @Test
    void readingDirectlyFromAURL() throws IOException {
        URL url = new URL("http://localhost:8080/iae_web2_war/CookieForEach");
      /*  InputStream inputStream = url.openStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader io = new BufferedReader(inputStreamReader);
        实际上下面代码等于上面的
        */
        URLConnection uc = url.openConnection();
        uc.setRequestProperty("Cookie","key5*60=value5*60");
        BufferedReader io = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        String inputLine;
        while ((inputLine = io.readLine()) != null) {
            System.out.println(inputLine);
        }
        io.close();
    }
}