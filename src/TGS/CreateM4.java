package TGS;

import DES.Encryption;

public class CreateM4 {
    public static String createM4(String Kctgs,String Ekv,String Kcv,String IDv,String IDc,String ADc,String Lifetime4){
        long TS4 = System.currentTimeMillis();
        String DE_Ticketv= Kcv+IDc+ADc+IDv+TS4+Lifetime4;
        String EN_Ticketv= Encryption.encryption(DE_Ticketv,Ekv);
        String DE_M4=Kcv+IDv+TS4+EN_Ticketv;
        return Encryption.encryption(DE_M4,Kctgs);
    }
}
