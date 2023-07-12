package spider.method;

import D20230711.ConnectSQL;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WhichWebTest {
    @Test
    void name() throws SQLException {
        ConnectSQL jdbcTest = new ConnectSQL();
        Connection connection = jdbcTest.getConnection();
        List<String> strings = jdbcTest.testStatement(connection);
        System.out.println(strings.get(0));
    }
}