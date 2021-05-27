package AS;

import Message.Authenticator;
import Message.Ticket;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class AS_Check {

    private Boolean checkIDc(String T_IDc,String DB_IDc){
        return T_IDc.equals(DB_IDc);
    }//对比票据IDc和数据库IDc是否匹配
    private Boolean checkIDtgs(String T_IDtgs,String DB_IDtgs){
        return T_IDtgs.equals(DB_IDtgs);
    }//对比票据TDtgs和数据库tgs是否匹配



}
