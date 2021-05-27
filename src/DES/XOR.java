package DES;

public class XOR {
    public static char[] xor(char[] a,char[] b){
        int[] a0=new int[a.length];
        int[] b0=new int[b.length];
        int[] c0=new int[a.length];
        String s="";
        for(int i=0;i<a.length;i++){
            a0[i]=Character.getNumericValue(a[i]);
            b0[i]=Character.getNumericValue(b[i]);
            c0[i]=a0[i]^b0[i];
            s+=c0[i];
        }
        return s.toCharArray();
    }
}
