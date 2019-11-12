import java.util.Arrays;

/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (45.76%)
 * Likes:    1297
 * Dislikes: 92
 * Total Accepted:    376.7K
 * Total Submissions: 823.1K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */
class Solution {

    private class Pair {
        int sum;
        int absDiff;
        int first, second;
        public Pair(int first, int second, int third, int target) {
            this.first = first;
            this.second = second;
            this.sum = first + second + third;
            this.absDiff = Math.abs(target - sum);
        }
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return -1;
        }
        Pair best = new Pair(nums[0], nums[1], nums[2], target);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                Pair newPair = new Pair(nums[i], nums[lo], nums[hi], target);
                if (newPair.absDiff == 0) {
                    return target;
                }
                else {
                    if (newPair.absDiff < best.absDiff) {
                        best = newPair;
                    }
                    if (nums[lo] + nums[hi] < target - nums[i]) lo++;
                    else hi--;
                }
            }
        }
        return best.sum;
    }
}

