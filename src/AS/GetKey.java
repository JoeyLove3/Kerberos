package AS;

import java.sql.*;

public class GetKey {
    public static String getEktgs(String MyIDtgs) throws SQLException,ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                "root", "123456");
        Statement s = c.createStatement(); //创建一个Statement对象

        String sql = "select t2PK from t2 where IDtgs=" + MyIDtgs;
        ResultSet set = s.executeQuery(sql);
        set.next();
        return set.getString(1);
    }
    public static String getEkc(String M_IDc) throws SQLException,ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                "root", "Lin0413+*");
        Statement s = c.createStatement(); //创建一个Statement对象

        String sql = "select t2pk from t2 where IDv=" + M_IDc;
        ResultSet set = s.executeQuery(sql);
        if(set.next()){
            return set.getString(1);
        }
        else
            return null;
    }
}

