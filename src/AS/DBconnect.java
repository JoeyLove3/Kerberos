package AS;

import java.sql.*;

public class DBconnect {
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
    public static void main(String[] args) {

        //初始化驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 建立与数据库的Connection连接
            // 这里需要提供：
            // 数据库所处于的ip:127.0.0.1 (本机)
            // 数据库的端口号： 3306 （mysql专用端口号）
            // 数据库名称 fzk
            // 编码方式 UTF-8
            // 账号 root
            // 密码 admin

            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/text?serverTimezone=UTC",
                    "root", "123456");
            //得到一个Connection对象的时候很容易报错，要注意格式，不同的机器可以运行的会不一样
            //如果这段报错了可以上网查查，多尝试
            Statement s = c.createStatement(); //创建一个Statement对象
//             准备sql语句
//             注意： 字符串要用单引号'
           // String sql = "INSERT INTO kerberos. t1 (idt1,t1name) VALUES (0001,'C1'),(0010,'C2'),(0011,'C3'),(0100,'C4')," +
             //       "(1000,'AS'),(1001,'TGS'),(1011,'V')";
           // s.execute(sql);
             //String sql = "INSERT INTO kerberos. t2 (idt2,t2name) VALUES (0001,'C1'),(0010,'C2'),(0011,'C3'),(0100,'C4')," +
               //   "(1000,'AS'),(1001,'TGS'),(1011,'V')";
             //s.execute(sql);
            System.out.println("执行插入语句成功");
            ResultSet set = s.executeQuery("select *from kerberos.t2");
            while (set.next()) { //一行一行的返回
                String host1=set.getString(1);
                String hostname=set.getString(2);
                System.out.println("ID="+host1+" NAME="+hostname);
            }


        } catch (ClassNotFoundException| SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
