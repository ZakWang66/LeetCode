import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P159_kDistinct {
    public static int lengthOfLongestSubstringTwoDistinct(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        while (right < s.length()) {
            if (map.size() <= k) {
                map.put(s.charAt(right), right++);
            }
            if (map.size() > k){
                left = Collections.min(map.values());
                map.remove(s.charAt(left));
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
    public static void main(String[] args) {
        String s = "eeceeebbbba";
        System.out.print(lengthOfLongestSubstringTwoDistinct(s, 2));
    }
}