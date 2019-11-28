import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=89 lang=java
 *
 * [89] Gray Code
 *
 * https://leetcode.com/problems/gray-code/description/
 *
 * algorithms
 * Medium (47.22%)
 * Likes:    481
 * Dislikes: 1354
 * Total Accepted:    147.2K
 * Total Submissions: 311.8K
 * Testcase Example:  '2'
 *
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * Example 1:
 * 
 * 
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 * 
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 0
 * Output: [0]
 * Explanation: We define the gray code sequence to begin with 0.
 * A gray code sequence of n has size = 2^n, which for n = 0 the size is 2^0 =
 * 1.
 * Therefore, for n = 0 the gray code sequence is [0].
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> grayCode(int n) {
        Set<Integer> res = new LinkedHashSet<>();
        
        //System.out.println(convertBinary(new int[] {0,1,1,0}));

        if (n == 0) {
            res.add(0);
            return new LinkedList<Integer>(res);
        }
        dfs(new int[n], res, (int)Math.pow(2, n));
        return new LinkedList<Integer>(res);
    }
    private boolean dfs(int[] temp, Set<Integer> res, int maxSize) {
        int num = convertBinary(temp);
        if (!res.contains(num)) {
            res.add(num);
        }
        else {
            return false;
        }
        
        if (res.size() >= maxSize) return true;

        for (int i = 0; i < temp.length; i++) {
            temp[i] = 1 - temp[i];
            if (dfs(temp, res, maxSize)) {
                return true;
            }
            temp[i] = 1 - temp[i];
        }
        return false;
    }

    private int convertBinary(int[] binary) {
        int res = 0;
        int power = 1;
        for (int i = 0; i < binary.length; i++) {
            res += binary[i] * power;
            power *= 2;
        }
        return res;
    }
}
// @lc code=end

 