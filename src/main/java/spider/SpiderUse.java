package spider;

import jakarta.mail.MessagingException;

import java.io.IOException;
import java.sql.SQLException;

public interface SpiderUse {
    public void star() throws MessagingException, SQLException, IOException;
}
