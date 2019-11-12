import java.util.Map;
import java.util.Collections;
import java.util.HashMap;

public class P13_RomanToInteger {

    public static int romanToInt(String s) {
        final Map<Character, Integer> rToNum;
        {
            Map<Character, Integer> temp = new HashMap<Character, Integer>();
            temp.put('I', 1);
            temp.put('V', 5);
            temp.put('X', 10);
            temp.put('L', 50);
            temp.put('C', 100);
            temp.put('D', 500);
            temp.put('M', 1000);
            rToNum = Collections.unmodifiableMap(temp);
        }
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) {
            return rToNum.get(s.charAt(0));
        }
        int res = 0;
        for (int i = s.length() - 1; i >= 1; i--) {
            int thisNum = rToNum.get(s.charAt(i));
            int nextNum = rToNum.get(s.charAt(i - 1));
            if (thisNum - nextNum) {

            }
        }
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("s"));
    }
}