/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
 *
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 *
 * algorithms
 * Easy (42.92%)
 * Likes:    1577
 * Dislikes: 70
 * Total Accepted:    146K
 * Total Submissions: 339.6K
 * Testcase Example:  '[3,4,5,1,2]\n[4,1,2]'
 *
 * 
 * Given two non-empty binary trees s and t, check whether tree t has exactly
 * the same structure and node values with a subtree of s. A subtree of s is a
 * tree consists of a node in s and all of this node's descendants. The tree s
 * could also be considered as a subtree of itself.
 * 
 * 
 * Example 1:
 * 
 * Given tree s:
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * 
 * Given tree t:
 * 
 * ⁠  4 
 * ⁠ / \
 * ⁠1   2
 * 
 * Return true, because t has the same structure and node values with a subtree
 * of s.
 * 
 * 
 * Example 2:
 * 
 * Given tree s:
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * ⁠   /
 * ⁠  0
 * 
 * Given tree t:
 * 
 * ⁠  4
 * ⁠ / \
 * ⁠1   2
 * 
 * Return false.
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return preorderTraversal(s, t);
    }

    private boolean preorderTraversal(TreeNode current, TreeNode t) {
        if (current == null) {
            return false;
        }
        if (preorderValidate(current, t)) {
            return true;
        }
        return preorderTraversal(current.left, t) || preorderTraversal(current.right, t);
    }

    private boolean preorderValidate(TreeNode current, TreeNode t) {
        if (current == null && t == null) {
            return true;
        }
        else if (current == null || t == null) {
            return false;
        }
        else {
            if (current.val != t.val) {
                return false;
            }
            else {
                return preorderValidate(current.left, t.left) && preorderValidate(current.right, t.right);
            }
        }
    }
}
// @lc code=end

