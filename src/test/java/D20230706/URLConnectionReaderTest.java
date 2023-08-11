package D20230706;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;

import static org.junit.jupiter.api.Assertions.assertThrows;

class URLConnectionReaderTest {
    @Test
    void testOpenConnection() throws Exception {
        URL url = new URL("https://docs.oracle.com/javase/tutorial/java/concepts/index.html");
        URLConnection uc = url.openConnection();
        uc.setConnectTimeout(2);
        uc.setReadTimeout(1);
        Exception exception = assertThrows(SocketTimeoutException.class, () -> {
            BufferedReader io = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine;
            while ((inputLine = io.readLine()) != null) {
                System.out.println(inputLine);
            }
            io.close();
        });
        System.out.println(exception.getMessage());
    }

    @Test
    void testOpenConnection1() throws Exception {
        URL url = new URL("https://docs.oracle.com/javase/tutorial/java/concepts/index.html");
        URLConnection uc = url.openConnection();
        uc.setConnectTimeout(1);
        uc.setReadTimeout(1);
        Exception exception = assertThrows(SocketTimeoutException.class, () -> {
            BufferedReader io = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine;
            while ((inputLine = io.readLine()) != null) {
                System.out.println(inputLine);
            }
            io.close();
        });
        System.out.println(exception.getMessage());
    }

    @Test
    void newMethod() throws IOException {
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
    @Test
    void newMethod1() throws IOException {
        URL url = new URL("https://www.douban.com");
        URLConnection uc = url.openConnection();
        uc.setConnectTimeout(1000);
        uc.setReadTimeout(1000);
        uc.addRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36");
        BufferedReader io = new BufferedReader(new InputStreamReader(uc.getInputStream(),"gb2312"));
        String inputLine;
        while ((inputLine = io.readLine()) != null) {
            System.out.println(inputLine);
        }
        io.close();
    }

}