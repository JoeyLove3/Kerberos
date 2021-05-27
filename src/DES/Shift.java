package DES;

public class Shift {
    //左移操作，输入明文，变换的步数，
    public static char[] leftshift(char[] wordin, int step) {
        int i = wordin.length;
        char[] first = new char[step];
        if (step >= 0) System.arraycopy(wordin, 0, first, 0, step);
        char[] wordout = new char[i];
        System.arraycopy(wordin, step, wordout, 0, wordin.length - step);
        System.arraycopy(first, 0, wordout, i - step , step);
        return wordout;
    }
}
