package Message;

import java.util.Arrays;

public class Message5 {
    public static String getTicketv(String M){
        char[] Marr=M.toCharArray();
        char[] Tvarr=new char[48];
        System.arraycopy(Marr,0,Tvarr,0,48);//srcPos:源数组复制开始起始位置；destPos：目的起始
        return Arrays.toString(Tvarr);
    }
    public static String getAuthenticatorc(String M){
        char[] Marr=M.toCharArray();
        char[] ATarr=new char[32];
        System.arraycopy(Marr,48,ATarr,0,32);
        return Arrays.toString(ATarr);
    }

}
