/*
 * @lc app=leetcode id=186 lang=java
 *
 * [186] Reverse Words in a String II
 *
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/description/
 *
 * algorithms
 * Medium (40.23%)
 * Likes:    337
 * Dislikes: 87
 * Total Accepted:    75.2K
 * Total Submissions: 186.8K
 * Testcase Example:  '["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]'
 *
 * Given an input string , reverse the string word by word. 
 * 
 * Example:
 * 
 * 
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * 
 * Note: 
 * 
 * 
 * A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces.
 * The words are always separated by a single space.
 * 
 * 
 * Follow up: Could you do it in-place without allocating extra space?
 * 
 */

// @lc code=start
class Solution {
    public void reverseWords(char[] s) {
        reversePartial(0, s.length - 1, s);
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reversePartial(start, i - 1, s);
                start = i + 1;
            }
        }
        reversePartial(start, s.length - 1, s);
    }
    
    private void reversePartial(int start, int end, char[] s) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
// @lc code=end

