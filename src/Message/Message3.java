package Message;

import java.util.Arrays;

public class Message3 {
    public String getIDv(String M){
        char[] Marr=M.toCharArray();
        char[] IDvarr=new char[4];
        System.arraycopy(Marr,0,IDvarr,0,4);
        return Arrays.toString(IDvarr);
    }
    public String getTickettgs(String M){
        char[] Marr=M.toCharArray();
        char[] Ttarr=new char[48];
        System.arraycopy(Marr,4,Ttarr,0,48);
        return Arrays.toString(Ttarr);
    }
    public String getAuthenticator(String M){
        char[] Marr=M.toCharArray();
        char[] ATarr=new char[32];
        System.arraycopy(Marr,52,ATarr,0,32);
        return Arrays.toString(ATarr);
    }
}
