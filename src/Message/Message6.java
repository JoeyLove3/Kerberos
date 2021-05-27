package Message;

import java.util.Arrays;

public class Message6 {
    public String getTS5(String M){
        char[] Marr=M.toCharArray();
        char[] TSarr=new char[13];
        System.arraycopy(Marr,0,TSarr,0,13);
        return Arrays.toString(TSarr);
    }
}