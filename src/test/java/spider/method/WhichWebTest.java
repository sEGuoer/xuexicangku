package spider.method;

import D20230711.ConnectSQL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WhichWebTest {
    @Test
    void name() throws SQLException {
        WhichWeb whichWeb1 = WhichWeb.getInstance();
        WhichWeb whichWeb2 = WhichWeb.getInstance();
        Assertions.assertEquals(whichWeb2,whichWeb1);
    }
}