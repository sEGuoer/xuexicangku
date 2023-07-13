package D20230711;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
    CREATE TABLE `user` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `name` varchar(255) DEFAULT NULL,
      `balance` int(11) DEFAULT NULL,
      PRIMARY KEY (`id`)
    );
 */
public class ConnectSQL {
    public static void main(String[] args) throws SQLException {
        ConnectSQL jdbcTest = new ConnectSQL();
        Connection connection = jdbcTest.getConnection();
        jdbcTest.testStatement(connection);
//        jdbcTest.testPreparedStatement(connection);
//        jdbcTest.testTransactions(connection);
//        jdbcTest.add(connection);
//        jdbcTest.batchAdd(connection);
//        jdbcTest.update(connection);
//        jdbcTest.delete(connection);
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false", "root", null);
        System.out.println("Connected to database");
        return conn;
    }

    public List<String> testStatement(Connection connection) {
        Statement stmt = null;
        String query = "select id, LastTime , URL from tb_whichweb";
        List<String> url = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String LastTime = rs.getString("LastTime");
                String URL = rs.getString("URL");
                url.add(URL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return url;
    }

    public String testPreparedStatement(Connection connection, String url) {
        PreparedStatement ppstmt = null;
        String query = "select id, LastTime , URL from tb_whichweb where url = ?";
        try {
            ppstmt = connection.prepareStatement(query);
            ppstmt.setString(1, url);
            ResultSet rs = ppstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String url1 = rs.getString("URL");
                String dates = rs.getString("LastTime");
                System.out.println(id + "\t" + url1 + dates);
                return dates;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ppstmt != null) {
                try {
                    ppstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<String> loadresponse(Connection connection, String title) {
        PreparedStatement ppstmt = null;
        String query = "select response from tb_contentandresponse where content = ?";
        List<String> responses = new ArrayList<>();
        int i = 1;
        try {
            ppstmt = connection.prepareStatement(query);
            ppstmt.setString(1, title);
            ResultSet rs = ppstmt.executeQuery();
            while (rs.next()) {
                String response = "<br>" + i + "."+rs.getString("response");
                responses.add(response);
                i++;
            }
            return responses;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ppstmt != null) {
                try {
                    ppstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String test(Connection connection, String title) {
        PreparedStatement ppstmt = null;
        String query = "select id, title , content from tb_wujinqiyong where title = ?";
        try {
            ppstmt = connection.prepareStatement(query);
            ppstmt.setString(1, title);
            ResultSet rs = ppstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title1 = rs.getString("title");
                String url = rs.getString("content");
                System.out.println(id + "\t" + title1 + url);
                return url;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (ppstmt != null) {
                try {
                    ppstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int test(Connection connection, String title, int i) {
        PreparedStatement ppstmt = null;
        String query = "select id, title , content from tb_wujinqiyong where title = ?";
        try {
            ppstmt = connection.prepareStatement(query);
            ppstmt.setString(1, title);
            ResultSet rs = ppstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title1 = rs.getString("title");
                String url = rs.getString("content");
                System.out.println(id + "\t" + title1 + url);
                return id;
            }
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            return i;
        } finally {
            if (ppstmt != null) {
                try {
                    ppstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void add(Connection connection, String titile, String content) {
        PreparedStatement ppstmt = null;
        String insertSql = "insert into tb_wujinqiyong(title, content) values(?, ?);";
        try {
            ppstmt = connection.prepareStatement(insertSql);
            ppstmt.setString(1, titile);
            ppstmt.setString(2, content);
            ppstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ppstmt != null) {
                try {
                    ppstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void add(Connection connection, int wujinqiyong_id, String content, String response) {
        PreparedStatement ppstmt = null;
        String insertSql = "insert into tb_contentandresponse(wujinqiyong_id,content,response) values(?, ?, ?);";
        try {
            ppstmt = connection.prepareStatement(insertSql);
            ppstmt.setInt(1, wujinqiyong_id);
            ppstmt.setString(2, content);
            ppstmt.setString(3, response);
            ppstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ppstmt != null) {
                try {
                    ppstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void add2(Connection connection, String date, String url) {
        PreparedStatement ppstmt = null;
        String insertSql = "insert into tb_whichweb(LastTime, URL) values(?, ?);";
        try {
            ppstmt = connection.prepareStatement(insertSql);
            ppstmt.setString(1, date);
            ppstmt.setString(2, url);
            ppstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ppstmt != null) {
                try {
                    ppstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void batchAdd(Connection connection) {
        PreparedStatement ppstmt = null;
        String insertSql = "insert into user(name, balance) values(?, ?);";
        try {
            ppstmt = connection.prepareStatement(insertSql);
            ppstmt.setString(1, "alex");
            ppstmt.setInt(2, 50);
            ppstmt.addBatch();
            ppstmt.setString(1, "bob");
            ppstmt.setInt(2, 30);
            ppstmt.addBatch();
            ppstmt.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ppstmt != null) {
                try {
                    ppstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void update(Connection connection, String date, String url) {
        PreparedStatement ppstmt = null;
        String updateSql = "update tb_whichweb set LastTime = ? where URL = ?";
        try {
            ppstmt = connection.prepareStatement(updateSql);
            ppstmt.setString(1, date);
            ppstmt.setString(2, url);
            ppstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ppstmt != null) {
                try {
                    ppstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void delete(Connection connection) {
        PreparedStatement ppstmt = null;
        String updateSql = "delete from user where name = ?";
        try {
            ppstmt = connection.prepareStatement(updateSql);
            ppstmt.setString(1, "alex");
            ppstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ppstmt != null) {
                try {
                    ppstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void testTransactions(Connection connection) {
        PreparedStatement ppstmt1 = null;
        PreparedStatement ppstmt2 = null;
        String update1 = "update user set balance = balance - 10 where id = ?";
        String update2 = "update user set balance = balance + 10 where id = ?";
        try {
            connection.setAutoCommit(false);
            ppstmt1 = connection.prepareStatement(update1);
            ppstmt1.setInt(1, 1);
            ppstmt1.executeUpdate();
            int i = 2 / 0;
            ppstmt2 = connection.prepareStatement(update2);
            ppstmt2.setInt(1, 2);
            ppstmt2.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ppstmt1 != null) {
                    ppstmt1.close();
                }
                if (ppstmt2 != null) {
                    ppstmt2.close();
                }
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}