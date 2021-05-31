package TGS;

import java.sql.*;

public class GetKey {
    public static String getEktgs(String MyIDtgs) throws SQLException,ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                "root", "Lin0413+*");
        Statement s = c.createStatement(); //创建一个Statement对象

        String sql = "select Ektgs from keytgs where IDtgs=" + MyIDtgs;
        ResultSet set = s.executeQuery(sql);
        set.next();
        return set.getString(1);
    }
    public static String getEkv(String G_IDv) throws SQLException,ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                "root", "Lin0413+*");
        Statement s = c.createStatement(); //创建一个Statement对象

        String sql = "select Ekv from keyv where IDv=" + G_IDv;
        ResultSet set = s.executeQuery(sql);
        if(set.next()){
            return set.getString(1);
        }
        else
            return null;
    }
}
