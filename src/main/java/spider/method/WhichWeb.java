package spider.method;

import D20230711.ConnectSQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class WhichWeb {
    private  static  WhichWeb WITCH_WEB;
    private Connection connection;
    private ConnectSQL jbdcTest;

    private WhichWeb() {
    }

    public static WhichWeb getInstance() throws SQLException {
        if (WITCH_WEB == null){
            synchronized (WhichWeb.class){
                if (WITCH_WEB == null){
                    WITCH_WEB = new WhichWeb();
                    ConnectSQL jdbcTest = new ConnectSQL();
                    Connection connection = jdbcTest.getConnection();
                    WITCH_WEB.setConnection(connection);
                    WITCH_WEB.setJbdcTest(jdbcTest);
                }
            }
        }
        return WITCH_WEB;
    }
    public String getWeb(int i) throws SQLException {
        List<String> strings = WITCH_WEB.getJbdcTest().testStatement(getconnection());
        return strings.get(i);
    }

    public void setConnection(Connection connection) {
        WITCH_WEB.connection = connection;
    }

    public void setJbdcTest(ConnectSQL jbdcTest) {
        WITCH_WEB.jbdcTest = jbdcTest;
    }

    public Connection getconnection(){
        return connection;
    }
    public ConnectSQL getJbdcTest(){
        return jbdcTest;
    }
}
