package D20230706;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import static org.junit.jupiter.api.Assertions.*;

class downloadPictureTest {
    @Test
    void download() throws IOException {
        URL url = new URL("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");
        HttpURLConnection uc = (HttpURLConnection)url.openConnection();
        InputStream in = uc.getInputStream();
        File file = new File("baidu.jpg");
        FileOutputStream fos = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        System.out.println("图片下载完成");
    }
}