package DES;

import java.util.Arrays;

public class Feistel {
    public static char[] feistel(char[] R0, int[] key) {

        char[] exR0 = R0;
        char[] L1 = new char[32];
        exR0 = Arrays.copyOf(exR0, 48);//数组扩展
        Table table = new Table();
        int[] E = table.E;
        int[] xorR0 = new int[48];
        for (int i = 0; i < 48; i++) {
            exR0[i] = R0[E[i] - 1];
            xorR0[i] = Character.getNumericValue(exR0[i]);
            xorR0[i] = xorR0[i] ^ key[i];
        }

        String SBox;
        StringBuilder binaryR0 = new StringBuilder();
        String b;
        int[] xorR0_cut = new int[6];
        char[] chR0 = new char[32];
        char[] chR0_cut;
        for (int i = 0; i < 8; i++) {
            System.arraycopy(xorR0, i * 6, xorR0_cut, 0, 6);
            SBox = "" + xorR0_cut[0] + xorR0_cut[5];
            int line = Integer.parseInt(SBox, 2);
            SBox = "" + xorR0_cut[1] + xorR0_cut[2] + xorR0_cut[3] + xorR0_cut[4];
            int column = Integer.parseInt(SBox, 2);
            int num = table.S[i][line * 16 + column];
            for (int j = 3; j >= 0; j--) {
                binaryR0.append(num >>> j & 1);
            }
            b = binaryR0.toString();
            chR0_cut = b.toCharArray();
            System.arraycopy(chR0_cut, 0, chR0, i * 4, 4);
        }

        int[] P = table.P;
        for (int i = 0; i < 32; i++) {
            L1[i] = chR0[P[i] - 1];
        }
        return L1;
    }
}
