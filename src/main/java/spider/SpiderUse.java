package spider;

import jakarta.mail.MessagingException;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public interface SpiderUse {
    public void parse() throws SQLException, IOException;
    public void getInformations() throws SQLException, IOException, ParseException;
    public void sentEamil(String string) throws SQLException, IOException, ParseException, MessagingException;
}
