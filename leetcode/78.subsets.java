import java.awt.List;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (56.31%)
 * Likes:    2555
 * Dislikes: 62
 * Total Accepted:    444.7K
 * Total Submissions: 789.7K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<Integer>());
        dfs(0, nums, new LinkedList<>(), res);
        return res;
    }
    
    private void dfs(int current, int[] nums, List<Integer> temp, List<List<Integer>> res) {
        if (current == nums.length) {
            return;
        }
        for (int i = current; i < nums.length; i++) {
            temp.add(nums[i]);
            res.add(new LinkedList<Integer>(temp));
            dfs(i + 1, nums, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
// @lc code=end

