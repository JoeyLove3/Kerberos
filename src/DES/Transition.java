package DES;

public class Transition {

    //原字符串转二进制字符串
    public static String transition1(String wordin) {
        char[] wordarray = wordin.toCharArray();
        String worout = "";
        for (char c : wordarray) {
            byte word = (byte) c;
            worout += Integer.toBinaryString((word & 0xFF) + 0x100).substring(1);//单字符转8位二进制数
        }
        return worout;
    }

    //二进制字符串转原字符串
    public static String transition2(String wordin) {
        char[] wordarray = wordin.toCharArray();
        char[] wordcut = new char[8];
        int j = wordarray.length / 8;
        String wordout = "";
        for (int i = 0; i < j; i++) {
            System.arraycopy(wordarray, i * 8, wordcut, 0, 8);
            String binaryword = String.copyValueOf(wordcut);
            if(binaryword.equals("10000000")){
            }
            else {
                int asciiword = Integer.parseInt(binaryword, 2);
                char word = (char) asciiword;//ASCII码强制转换原字符
                wordout += word;
            }
        }
        return wordout;
    }
}
