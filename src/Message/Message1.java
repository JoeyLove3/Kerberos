package Message;

import java.util.Arrays;

public class Message1 {
     public String getIDc(String M){
         char[] Marr=M.toCharArray();
         char[] IDcarr=new char[4];
         System.arraycopy(Marr,0,IDcarr,0,4);
         return Arrays.toString(IDcarr);
    }
    public String getIDtgs(String M){
        char[] Marr=M.toCharArray();
        char[] IDtgsarr=new char[4];
        System.arraycopy(Marr,4,IDtgsarr,0,4);
        return Arrays.toString(IDtgsarr);
    }
    public String getTS1(String M){
        char[] Marr=M.toCharArray();
        char[] TSarr=new char[13];
        System.arraycopy(Marr,8,TSarr,0,13);
        return Arrays.toString(TSarr);
    }
}
