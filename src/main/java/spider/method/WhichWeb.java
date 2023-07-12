package spider.method;

import D20230711.ConnectSQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class WhichWeb {
    private Connection connection;
    private ConnectSQL jbdcTest;
    public String getWeb(int i) throws SQLException {
        ConnectSQL jdbcTest = new ConnectSQL();
        Connection connection = jdbcTest.getConnection();
        setConnection(connection);
        setJbdcTest(jdbcTest);
        List<String> strings = jdbcTest.testStatement(connection);
        return strings.get(i);
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setJbdcTest(ConnectSQL jbdcTest) {
        this.jbdcTest = jbdcTest;
    }

    public Connection getconnection(){
        return connection;
    }
    public ConnectSQL getJbdcTest(){
        return jbdcTest;
    }
}
