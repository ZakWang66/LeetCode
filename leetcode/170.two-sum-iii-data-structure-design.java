import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=170 lang=java
 *
 * [170] Two Sum III - Data structure design
 *
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/description/
 *
 * algorithms
 * Easy (32.03%)
 * Likes:    227
 * Dislikes: 188
 * Total Accepted:    69.2K
 * Total Submissions: 215.7K
 * Testcase Example:  '["TwoSum","add","add","add","find","find"]\n[[],[1],[3],[5],[4],[7]]'
 *
 * Design and implement a TwoSum class. It should support the following
 * operations: add and find.
 * 
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the
 * value.
 * 
 * Example 1:
 * 
 * 
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * 
 * 
 * Example 2:
 * 
 * 
 * add(3); add(1); add(2);
 * find(3) -> true
 * find(6) -> false
 * 
 */

// @lc code=start
class TwoSum {
    Set<Integer> set;
    Set<Integer> dup;
    /** Initialize your data structure here. */
    public TwoSum() {
        set = new HashSet<>();
        dup = new HashSet<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (set.contains(number)) {
            dup.add(number);
        }
        else {
            set.add(number);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int num : set) {
            if (value - num == num) {
                if (dup.contains(num)) {
                    return true;
                }
                else {
                    continue;
                }
            }
            if (set.contains(value - num)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
// @lc code=end

