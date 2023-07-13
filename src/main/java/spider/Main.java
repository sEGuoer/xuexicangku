package spider;

import jakarta.mail.MessagingException;
import spider.everyWeb.XMfish;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws MessagingException, SQLException, IOException, ParseException {
        SpiderUse XMfish = new XMfish();
        /*XMfish.parse();
        XMfish.getInformations();
        XMfish.sentEamil("709074535@qq.com");*/
        /*String content = XMfish.loadContentAndResponseToDatabase("[闲置转让] 出三件闲置宝贝");*/
        XMfish.getResponse("玉坠，LV包，手表，欢迎出价，交易地点大唐世家六期");
    }
}
