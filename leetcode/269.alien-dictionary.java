package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=269 lang=java
 *
 * [269] Alien Dictionary
 *
 * https://leetcode.com/problems/alien-dictionary/description/
 *
 * algorithms
 * Hard (31.93%)
 * Likes:    1168
 * Dislikes: 224
 * Total Accepted:    101.5K
 * Total Submissions: 306.9K
 * Testcase Example:  '["wrt","wrf","er","ett","rftt"]'
 *
 * There is a new alien language which uses the latin alphabet. However, the
 * order among letters are unknown to you. You receive a list of non-empty
 * words from the dictionary, where words are sorted lexicographically by the
 * rules of this new language. Derive the order of letters in this language.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠ "wrt",
 * ⁠ "wrf",
 * ⁠ "er",
 * ⁠ "ett",
 * ⁠ "rftt"
 * ]
 * 
 * Output: "wertf"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * [
 * ⁠ "z",
 * ⁠ "x"
 * ]
 * 
 * Output: "zx"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * [
 * ⁠ "z",
 * ⁠ "x",
 * ⁠ "z"
 * ] 
 * 
 * Output: "" 
 * 
 * Explanation: The order is invalid, so return "".
 * 
 * 
 * Note:
 * 
 * 
 * You may assume all letters are in lowercase.
 * You may assume that if a is a prefix of b, then a must appear before b in
 * the given dictionary.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is
 * fine.
 * 
 * 
 */

// @lc code=start
class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length < 1) {
            return "";
        }

        if (words.length == 1) {
            if (words[0].length() == 1) {
                return words[0];
            }
            else {
                return "";
            }
        }
        
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();



        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int minLength = s1.length() < s2.length() ? s1.length() : s2.length();
            for (int j = 0; j < minLength; j++) {
                Character smaller = s1.charAt(j);
                Character larger = s2.charAt(j);
                if (smaller != larger) {
                    if (!degree.containsKey(smaller)) degree.put(smaller, 0);
                    if (!degree.containsKey(larger)) degree.put(larger, 0);

                    if (!graph.containsKey(smaller)) graph.put(smaller, new HashSet<>());
                    graph.get(smaller).add(larger);
                    degree.put(larger, degree.get(smaller) + 1);
                }
            }
        }

        System.out.println(degree.toString());
        System.out.println(graph.toString());        
        
        return "";
    }
}
// @lc code=end

