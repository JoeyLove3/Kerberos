package AS;

import DES.Encryption;

public class CreateM2 {
    public static String createM2(String Ekc,String Kctgs,String Ektgs,String IDtgs,String IDc,String ADc,String Lifetime2){
        long TS2 = System.currentTimeMillis();
        String DE_Tickettgs= Kctgs+IDc+ADc+IDtgs+TS2+Lifetime2;
        String EN_Tickettgs= Encryption.encryption(DE_Tickettgs,Ektgs);
        String DE_M2=Kctgs+IDtgs+TS2+EN_Tickettgs;
        return Encryption.encryption(DE_M2,Ekc);
    }
}
