package test;
import java.sql.*;

public class Test {
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
            String sql = "INSERT INTO `text`.`mima` (`idmima`) VALUES ('1')";
            s.execute(sql);
            System.out.println("执行插入语句成功");
            ResultSet set = s.executeQuery("select *from mima");
            while (set.next()) { //一行一行的返回
                String studentName=set.getString(1);

                System.out.println("name="+studentName+" ID=");
            }


        } catch (ClassNotFoundException| SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}