package AS;

import Message.Authenticator;
import Message.Message1;
import Message.Ticket;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class AS_Check {

    //private Boolean checkIDc(String T_IDc,String DB_IDc){
   //     return T_IDc.equals(DB_IDc);
   // }//对比票据IDc和数据库IDc是否匹配
   // private Boolean checkIDtgs(String T_IDtgs,String DB_IDtgs){
   //     return T_IDtgs.equals(DB_IDtgs);
    //}//对比票据TDtgs和数据库tgs是否匹配
    public static boolean checkIDc(String M1_IDc) throws SQLException,ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                "root", "123456");
        Statement s = c.createStatement(); //创建一个Statement对象

        String sql="select *from kerberos.t1 where idt1="+M1_IDc;
        ResultSet set = s.executeQuery(sql);
        return set.next();
    }
    public static boolean checkIDtgs(String M1_IDtgs) throws SQLException,ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                "root", "123456");
        Statement s = c.createStatement(); //创建一个Statement对象

        String sql="select *from kerberos.t1 where idt1="+M1_IDtgs;
        ResultSet set = s.executeQuery(sql);
        return set.next();
    }
    public static boolean check(String G_IDc,String G_IDtgs)throws ParseException,SQLException,ClassNotFoundException {

        return checkIDc(G_IDc)&&
                checkIDtgs(G_IDtgs);
    }

}
