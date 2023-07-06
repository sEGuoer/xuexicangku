package D20230706;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;

import static org.junit.jupiter.api.Assertions.*;

class URLConnectionReaderTest {
    @Test
    void testOpenConnection()throws Exception{
        URL url = new URL("https://docs.oracle.com/javase/tutorial/java/concepts/index.html");
        URLConnection uc = url.openConnection();
        uc.setConnectTimeout(2);
        uc.setReadTimeout(1);
        Exception exception = assertThrows(SocketTimeoutException.class,() -> {
            BufferedReader io = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine;
            while ((inputLine = io.readLine()) != null){
                System.out.println(inputLine);
                io.close();
            }
        });
        System.out.println(exception.getMessage());
    }@Test
    void testOpenConnection1()throws Exception{
        URL url = new URL("https://docs.oracle.com/javase/tutorial/java/concepts/index.html");
        URLConnection uc = url.openConnection();
        uc.setConnectTimeout(1);
        uc.setReadTimeout(1);
        Exception exception = assertThrows(SocketTimeoutException.class,() -> {
            BufferedReader io = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine;
            while ((inputLine = io.readLine()) != null){
                System.out.println(inputLine);
                io.close();
                //
            }
        });
        System.out.println(exception.getMessage());
    }

}