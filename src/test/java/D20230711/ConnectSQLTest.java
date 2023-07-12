package D20230711;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ConnectSQLTest {
    @Test
    void asas() throws ParseException, SQLException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = simpleDateFormat.parse("2023-07-12 10:48");
        System.out.println(date);
        ConnectSQL jdbcTest = new ConnectSQL();
        Connection connection = jdbcTest.getConnection();
        String date1 = jdbcTest.testPreparedStatement(connection,"http://bbs.xmfish.com/thread-htm-fid-55-page-1.html");
        if (date1 == null){
            jdbcTest.add2(connection, "2023-07-12 10:48:00" ,"http://bbs.xmfish.com/thread-htm-fid-55-page-1.html");
        }else {
            System.out.println(date1);
        }
    }

}