package spider;

import jakarta.mail.MessagingException;
import spider.everyWeb.XMfish;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws MessagingException, SQLException, IOException, ParseException {
        SpiderUse XMfish = new XMfish();
//        XMfish.parse(0);
//        XMfish.getInformations();//拿到的标题名为用户信息第一个空格之前的内容（没空格时输出全部   ）
//        XMfish.sentEamil("709074535@qq.com");
        String content = XMfish.loadContentAndResponseToDatabase("[闲置转让] 全新焖茶杯保温壶，冰山玻璃杯");
//        XMfish.getResponse(content);
    }
}
