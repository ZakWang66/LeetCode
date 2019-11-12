import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class kDistinct {
    public static int kd(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        while (right < s.length()) {
            if (map.size() <= k) {
                map.put(s.charAt(right), right++);
            }
            if (map.size() > k){
                //left = Collections.min(map.values());
                char temp = s.charAt(left);
                left++;
                if (s.charAt(left) != temp) {
                    map.remove(s.charAt(left));
                }
            }
            if (map.size() == k) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s = args[0];
        System.out.print(kd(s, 2));
    }
}