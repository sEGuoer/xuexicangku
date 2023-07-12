package spider;

import jakarta.mail.MessagingException;
import spider.everyWeb.XMfish;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws MessagingException, SQLException, IOException {
        SpiderUse XMfish = new XMfish();
        XMfish.star();
    }
}
