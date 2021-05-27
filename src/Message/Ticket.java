package Message;

import java.util.Arrays;

public class Ticket {
    public static String getKctgs(String M){
        char[] Marr=M.toCharArray();
        char[] Keyarr=new char[8];
        System.arraycopy(Marr,0,Keyarr,0,8);
        return Arrays.toString(Keyarr);
    }
    public static String getIDc(String M){
        char[] Marr=M.toCharArray();
        char[] IDcarr=new char[4];
        System.arraycopy(Marr,8,IDcarr,0,4);
        return Arrays.toString(IDcarr);
    }
    public static String getADc(String M){
        char[] Marr=M.toCharArray();
        char[] ADcarr=new char[12];
        System.arraycopy(Marr,12,ADcarr,0,12);
        return Arrays.toString(ADcarr);
    }
    public static String getID(String M){
        char[] Marr=M.toCharArray();
        char[] IDarr=new char[4];
        System.arraycopy(Marr,24,IDarr,0,4);
        return Arrays.toString(IDarr);
    }
    public static String getTS(String M){
        char[] Marr=M.toCharArray();
        char[] TSarr=new char[13];
        System.arraycopy(Marr,28,TSarr,0,13);
        return Arrays.toString(TSarr);
    }
    public static String getLifetime(String M){
        char[] Marr=M.toCharArray();
        char[] LT2arr=new char[7];
        System.arraycopy(Marr,41,LT2arr,0,7);
        return Arrays.toString(LT2arr);
    }
}
