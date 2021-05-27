package Message;

import java.util.Arrays;

public class Message2 {
    public String getKctgs(String M){
        char[] Marr=M.toCharArray();
        char[] Keyarr=new char[8];
        System.arraycopy(Marr,0,Keyarr,0,8);
        return Arrays.toString(Keyarr);
    }
    public String getIDtgs(String M){
        char[] Marr=M.toCharArray();
        char[] IDtgsarr=new char[4];
        System.arraycopy(Marr,8,IDtgsarr,0,4);
        return Arrays.toString(IDtgsarr);
    }
    public String getTS2(String M){
        char[] Marr=M.toCharArray();
        char[] TSarr=new char[13];
        System.arraycopy(Marr,12,TSarr,0,13);
        return Arrays.toString(TSarr);
    }
    public String getLifetime2(String M){
        char[] Marr=M.toCharArray();
        char[] LT2arr=new char[7];
        System.arraycopy(Marr,25,LT2arr,0,7);
        return Arrays.toString(LT2arr);
    }
    public String getTickettgs(String M){
        char[] Marr=M.toCharArray();
        char[] Ttarr=new char[48];
        System.arraycopy(Marr,32,Ttarr,0,48);
        return Arrays.toString(Ttarr);
    }
}
