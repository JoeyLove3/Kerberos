package Message;

import java.util.Arrays;

public class Message4 {
    public String getKcv(String M){
        char[] Marr=M.toCharArray();
        char[] Keyarr=new char[8];
        System.arraycopy(Marr,0,Keyarr,0,8);
        return Arrays.toString(Keyarr);
    }
    public String getIDv(String M){
        char[] Marr=M.toCharArray();
        char[] IDvarr=new char[4];
        System.arraycopy(Marr,8,IDvarr,0,4);
        return Arrays.toString(IDvarr);
    }
    public String getTS4(String M){
        char[] Marr=M.toCharArray();
        char[] TSarr=new char[13];
        System.arraycopy(Marr,12,TSarr,0,13);
        return Arrays.toString(TSarr);
    }
    public String getTicketv(String M){
        char[] Marr=M.toCharArray();
        char[] Tvarr=new char[48];
        System.arraycopy(Marr,25,Tvarr,0,48);
        return Arrays.toString(Tvarr);
    }
}
