package TGS;

import Message.Authenticator;
import Message.Ticket;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Check {
    public static String stampToDate(String stap){
        String time;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(stap);
        Date date = new Date(lt);
        time = simpleDateFormat.format(date);
        return time;
    }
    private static Boolean checkIDc(String T_IDc, String A_IDc){
        return T_IDc.equals(A_IDc);
    }
    private static Boolean checkIDtgs(String T_IDtgs, String MyIDtgs){
        return T_IDtgs.equals(MyIDtgs);
    }
    private static Boolean checkTime(String T_TS2, String T_Lifetime, String A_TS3)throws ParseException {
        String T2=stampToDate(T_TS2);
        String T3=stampToDate(A_TS3);
        char[] LT=T_Lifetime.toCharArray();
        long day=Integer.parseInt(String.valueOf(LT[0]+LT[1]));
        long hour=Integer.parseInt(String.valueOf(LT[2]+LT[3]));
        long minute=Integer.parseInt(String.valueOf(LT[4]+LT[5]+LT[6]));
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = df.parse(T2);
        Date d2 = df.parse(T3);
        long diff = d1.getTime() - d2.getTime();
        long days = diff / (1000 * 60 * 60 * 24);
        long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
        long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
        if(days<day) return true;
        else if (days==day&&hours<hour) return true;
        else return days == day && hours == hour && minutes <= minute;
    }
    private static Boolean checkADc(String T_ADc, String A_ADc, String G_ADc){
        return T_ADc.equals(A_ADc)&&A_ADc.equals(G_ADc);
    }
    public static boolean checkIDv(String G_IDv) throws SQLException,ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                "root", "Lin0413+*");
        Statement s = c.createStatement(); //创建一个Statement对象

        String sql="select *from tgs where IDc="+G_IDv;
        ResultSet set = s.executeQuery(sql);
        return set.next();
    }
    public static Boolean check(String G_ADc, String MyIDtgs, String G_IDv, String DE_Tickettgs, String DE_Authenticator)throws ParseException,SQLException,ClassNotFoundException {
        String T_IDc= Ticket.getIDc(DE_Tickettgs);
        String T_ADc= Ticket.getADc(DE_Tickettgs);
        String T_IDtgs=Ticket.getID(DE_Tickettgs);
        String T_TS2=Ticket.getTS(DE_Tickettgs);
        String T_Lifetime=Ticket.getLifetime(DE_Tickettgs);
        String A_IDc= Authenticator.getIDc(DE_Authenticator);
        String A_ADc=Authenticator.getADc(DE_Authenticator);
        String A_TS3=Authenticator.getTS(DE_Authenticator);
        return checkIDc(T_IDc,A_IDc)&&
                checkIDtgs(T_IDtgs,MyIDtgs)&&
                checkTime(T_TS2,T_Lifetime,A_TS3)&&
                checkADc(T_ADc,A_ADc,G_ADc)&&
                checkIDv(G_IDv);
    }
}
