/*
 * @lc app=leetcode id=896 lang=java
 *
 * [896] Monotonic Array
 *
 * https://leetcode.com/problems/monotonic-array/description/
 *
 * algorithms
 * Easy (55.60%)
 * Likes:    329
 * Dislikes: 26
 * Total Accepted:    54.6K
 * Total Submissions: 98.1K
 * Testcase Example:  '[1,2,2,3]'
 *
 * An array is monotonic if it is either monotone increasing or monotone
 * decreasing.
 * 
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array
 * A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * 
 * Return true if and only if the given array A is monotonic.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,2,3]
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [6,5,4,4]
 * Output: true
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [1,3,2]
 * Output: false
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: [1,2,4,5]
 * Output: true
 * 
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: [1,1,1]
 * Output: true
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean isMonotonic(int[] A) {
        if (A.length < 2) return true;
        int first = A[0];
        for (int i = 0; i < A.length; i++) {
            if (A[i] > first) {
                return trueMonotone(A, i, true);
            }
            else if (A[i] < first) {
                return trueMonotone(A, i, false);
            }
        }
        return true;
    }

    private boolean trueMonotone(int[] A, int start, boolean incr) {
        for (int i = start; i < A.length - 1; i++) {
            if (incr && A[i] > A[i + 1]) return false;
            if (!incr && A[i] < A[i + 1]) return false;
        }
        return true;
    }
}

