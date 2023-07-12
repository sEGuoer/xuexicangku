package spider;

import jakarta.mail.MessagingException;
import spider.everyWeb.XMfish;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws MessagingException, SQLException, IOException, ParseException {
        SpiderUse XMfish = new XMfish();
        XMfish.star();
    }
}
