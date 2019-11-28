import java.util.LinkedList;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (37.00%)
 * Likes:    3257
 * Dislikes: 213
 * Total Accepted:    493.1K
 * Total Submissions: 1.3M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * 
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
    public ListNode mergeKLists(ListNode[] lists) {
        // Divide and conquer
        // ListNode p = helper(0, lists.length - 1, lists);
        
        Queue<ListNode> heads = new LinkedList<>();
        for (ListNode node : lists) {
            heads.offer(node);
        }
        while (heads.size() > 1) {
            ListNode l1 = heads.poll();
            ListNode l2 = heads.poll();
            heads.offer(mergeTwo(l1, l2));
        }
        return heads.poll();
        // while(p != null) {
        //     System.out.print(p.val + " ");
        //     p = p.next;
        // }
        // return p;
    }

    private ListNode helper(int left, int right, ListNode[] lists) {
        if (right == left) {
            return null;
        }
        if (right - left == 1) {
            return mergeTwo(lists[left], lists[right]);
        }
        else {
            int mid = (left + right) / 2;
            return mergeTwo(helper(left, mid, lists), helper(mid, right, lists));
        }
    }

    private ListNode mergeTwo(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummyHead = new ListNode(0);
        ListNode p_res = dummyHead;
        while (p1 != null && p2 != null) {
            
            if (p1.val <= p2.val) {
                p_res.next = p1;
                p1 = p1.next;
            }
            else {
                p_res.next = p2;
                p2 = p2.next;
            }

            p_res = p_res.next;

        }
        if (p1 != null) {
            p_res.next = p1;
        }
        if (p2 != null) {
            p_res.next = p2;
        }
        return dummyHead.next;
    }
}
// @lc code=end

