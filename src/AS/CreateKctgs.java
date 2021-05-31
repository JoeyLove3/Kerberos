package AS;

import java.util.Random;

public class CreateKctgs {
    public static String createKctgs() {
        int maxNum = 62;
        int i;
        int count = 0;
        char[] str = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
                'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                '0','1','2','3','4','5','6','7','8','9'};
        StringBuilder pwd = new StringBuilder();
        Random r = new Random();
        while (count < 8) {
            i = Math.abs(r.nextInt(maxNum));
            pwd.append(str[i]);
            count++;
        }
        return pwd.toString();
    }
}
