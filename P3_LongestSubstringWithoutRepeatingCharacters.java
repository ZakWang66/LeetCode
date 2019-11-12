import java.util.HashSet;
import java.util.Set;

public class P3_LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        if (s.length() <= 1) return s.length();
        int max = 0;
        Set<Character> distinct = new HashSet<Character>();
        while (right < s.length() && left < s.length()) {
            if (!distinct.contains(s.charAt(right))) {
                distinct.add(s.charAt(right++));
                max = Math.max(max, right - left);
            }
            else {
                distinct.remove(s.charAt(left++));
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}