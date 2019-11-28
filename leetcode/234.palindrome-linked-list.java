/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 *
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (37.38%)
 * Likes:    2106
 * Dislikes: 299
 * Total Accepted:    320.3K
 * Total Submissions: 856.9K
 * Testcase Example:  '[1,2]'
 *
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2
 * Output: false
 * 
 * Example 2:
 * 
 * 
 * Input: 1->2->2->1
 * Output: true
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int size = 0;
        ListNode p = head;
        while (p != null) {
            size += 1;
            p = p.next;
        }

        p = head;
        int count = 0;
        ListNode prev = null;
        while (count < size / 2) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
            count += 1;
        }

        ListNode half = p;
        if (size % 2 == 1) {
            half = half.next;
        }
        p = prev;
        while (half != null) {
            if (p.val != half.val) return false;
            half = half.next;
            p = p.next;
        }

        return true;
    }
}
// @lc code=end

