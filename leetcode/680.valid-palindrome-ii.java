/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 *
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 *
 * algorithms
 * Easy (34.70%)
 * Likes:    848
 * Dislikes: 59
 * Total Accepted:    87.5K
 * Total Submissions: 251.7K
 * Testcase Example:  '"aba"'
 *
 * 
 * Given a non-empty string s, you may delete at most one character.  Judge
 * whether you can make it a palindrome.
 * 
 * 
 * Example 1:
 * 
 * Input: "aba"
 * Output: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * 
 * 
 * 
 * Note:
 * 
 * The string will only contain lowercase characters a-z.
 * The maximum length of the string is 50000.
 * 
 * 
 */
class Solution {
    public boolean validPalindrome(String s) {
        return helper(s, 0);
    }

    private boolean helper(String s, int depth) {
        if (depth >= 2) return false;
        if (s.length() < 2) return true;
        int lo = 0, hi = s.length() - 1;
        boolean error = false;
        String temp = null;
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                if (error) {
                    if (temp == null) {
                        return false;
                    }
                    else {
                        // recursive solve
                        return helper(temp, depth + 1);
                    }
                }
                else {
                    if (s.charAt(lo + 1) == s.charAt(hi) || s.charAt(lo) == s.charAt(hi - 1)) {
                        if (s.charAt(lo + 1) == s.charAt(hi) && s.charAt(lo) == s.charAt(hi - 1)) {
                            temp = s.substring(lo, hi + 1);
                        }
                        if (depth % 2 ==0) {
                            if (s.charAt(lo + 1) == s.charAt(hi)) {
                                lo += 1;
                            }
                            else if (s.charAt(lo) == s.charAt(hi - 1)) {
                                hi -= 1;
                            }
                        }
                        else {
                            if (s.charAt(lo) == s.charAt(hi - 1)) {
                                hi -= 1;
                            }
                            else if (s.charAt(lo + 1) == s.charAt(hi)) {
                                lo += 1;
                            }
                        }

                        error = true;
                    }
                    else {
                        return false;
                    }
                }
            }
            lo++;
            hi--;
        }
        return true;
    }
}

