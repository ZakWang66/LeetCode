import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (50.77%)
 * Likes:    2218
 * Dislikes: 137
 * Total Accepted:    436.3K
 * Total Submissions: 859.2K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * Note:
 * 
 * 
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            Integer[] id = new Integer[26];
            for (int i = 0; i < 26; i ++) {
                id[i] = 0;
            }
            for (int i = 0; i < s.length(); i++) {
                id[s.charAt(i) - 'a'] += 1;
            }
            String idString = Arrays.toString(id);
            if (!map.containsKey(idString)) {
                map.put(idString, new LinkedList<String>());
            }
            map.get(idString).add(s);
        }

        List<List<String>> res = new LinkedList<>();
        for (List<String> sList : map.values()) {
            res.add(sList);
        }
        System.out.println(map.toString());
        return res;
    }
}
// @lc code=end

