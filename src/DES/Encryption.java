package DES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Encryption {

    public static String encryption(String M,String K) {
        String plaintext=M;
        String key=K;
        if(key.length()!=8)return "0";

        //密钥处理
        key = Transition.transition1(key);
        char[] keyarray =Deal.keydeal(key);
        char[] C0 = new char[28];
        char[] D0 = new char[28];
        System.arraycopy(keyarray, 0, C0, 0, 28);
        System.arraycopy(keyarray, 28, D0, 0, 28);
        //明文处理
        plaintext = Transition.transition1(plaintext);
        plaintext=Supplement.supplement(plaintext);
        String ciphertext ="";
        for(int i=0;i<plaintext.length()/64;i++) {
            String plainarray=plaintext.substring(i*64,(i+1)*64);
            char[] plainarrays=Deal.textdeal(plainarray);
            char[] L0 = new char[32];
            char[] R0 = new char[32];
            System.arraycopy(plainarrays, 0, L0, 0, 32);
            System.arraycopy(plainarrays, 32, R0, 0, 32);
            
            //16轮迭代
            for (int round = 0; round < 16; round++) {
                char[] key0 = Deal.keychange(C0, D0, round);
                int[] Key0 = new int[48];
                for (int j = 0; j < key0.length; j++) {
                    Key0[j] = Character.getNumericValue(key0[j]);
                }
                char[] r0 = Feistel.feistel(R0, Key0);
                char[] R1 = XOR.xor(L0, r0);
                L0 = R0;
                R0 = R1;
            }

            Table table = new Table();
            int[] IP2 = table.IP2;
            char[] cipher = new char[64];
            char[] ciphers = new char[64];
            System.arraycopy(L0, 0, cipher, 32, 32);
            System.arraycopy(R0, 0, cipher, 0, 32);
            for (int j = 0; j < cipher.length; j++) {
                ciphers[j] = cipher[IP2[j] - 1];
            }
            ciphertext += new String(ciphers);
        }
        return ciphertext;
    }
    public static void main(String[] args){
        String plaintext="LDleZcRN0001192168137003100116226867305220200000";
        String key="12345678";
        System.out.println(encryption(plaintext,key));
    }
}
