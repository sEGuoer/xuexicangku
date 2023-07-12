package D20230711;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ConnectSQLTest {
    @Test
    void asas() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = simpleDateFormat.parse("2023-07-12 10:48");
        System.out.println(date);
    }

}