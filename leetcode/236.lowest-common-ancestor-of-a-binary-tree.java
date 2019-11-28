import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (40.95%)
 * Likes:    2577
 * Dislikes: 149
 * Total Accepted:    353K
 * Total Submissions: 861.7K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n1'
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given
 * nodes in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant
 * of itself according to the LCA definition.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 * 
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> path_p = new Stack<>();
        Stack<TreeNode> path_q = new Stack<>();
        helper(root, path_p, p.val);
        helper(root, path_q, q.val);
        TreeNode prev = null;
        while (!path_p.isEmpty() && !path_q.isEmpty()) {
            TreeNode a = path_p.pop();
            TreeNode b = path_q.pop();
            // System.out.println(a.val);
            // System.out.println(b.val);
            if (a != b) {
                return prev;
            }
            prev = a;
        }
        return prev;
    }
    private boolean helper(TreeNode root, Stack<TreeNode> path, int target) {
        if (root.val == target) {
            path.push(root);
            return true;
        }

        if (root.left != null) {
            if (helper(root.left, path, target)) {
                path.push(root);
                return true;
            }
        }
        if (root.right != null) {
            if (helper(root.right, path, target)) {
                path.push(root);
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

