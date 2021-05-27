package Message;

import java.util.Arrays;

public class Authenticator {
    public static String getIDc(String M){
        char[] Marr=M.toCharArray();
        char[] IDcarr=new char[4];
        System.arraycopy(Marr,0,IDcarr,0,4);
        return Arrays.toString(IDcarr);
    }
    public static String getADc(String M){
        char[] Marr=M.toCharArray();
        char[] ADcarr=new char[12];
        System.arraycopy(Marr,4,ADcarr,0,12);
        return Arrays.toString(ADcarr);
    }
    public static String getTS(String M){
        char[] Marr=M.toCharArray();
        char[] TSarr=new char[13];
        System.arraycopy(Marr,16,TSarr,0,13);
        return Arrays.toString(TSarr);
    }
}
