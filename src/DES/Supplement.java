package DES;

public class Supplement {
    //不足64位补全1
    public static String supplement(String wordin){
        int wordlength=wordin.length();
        int wordbyte=(wordlength/8)%8;
        if(wordbyte==0){
            return wordin;
        }
        String wordout=wordin;
        String supple="10000000";
        for(int i=0;i<8-wordbyte;i++){
            wordout+=supple;
        }
        return wordout;
    }
}
