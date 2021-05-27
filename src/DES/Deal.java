package DES;

public class Deal {
    public static char[] keydeal(String  key){
        char[] keyarray = key.toCharArray();
        Table table = new Table();
        int[] PC1 = table.PC1;
        char[] key1array = new char[56];
        for (int i = 0; i < PC1.length; i++) {
            key1array[i] = keyarray[PC1[i] - 1];
        }
        return key1array;
    }
    public static char[] textdeal(String plaintext){
        char[] plainarray = plaintext.toCharArray();
        char[] plainarray1 = new char[plainarray.length];
        Table table = new Table();
        int[] IP1 = table.IP1;
        for (int i = 0; i < plainarray.length; i++) {
            plainarray1[i] = plainarray[IP1[i] - 1];
        }
        return plainarray1;
    }
    public static char[] keychange(char[] C0, char[] D0, int round) {
        Table table = new Table();
        int[] PC2 = table.PC2;
        int[] rounds = table.rotated;
        int rotated = 0;
        for (int i = 0; i < round; i++) {
            rotated += rounds[i];
        }
        C0 = Shift.leftshift(C0, rotated);
        D0 = Shift.leftshift(D0, rotated);
        char[] key2array = new char[56];
        System.arraycopy(C0, 0, key2array, 0, 28);
        System.arraycopy(D0, 0, key2array, 28, 28);
        char[] K0 = new char[48];
        for (int i = 0; i < PC2.length; i++) {
            K0[i] = key2array[PC2[i] - 1];
        }
        return K0;
    }
}
