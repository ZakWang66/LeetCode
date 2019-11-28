/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 *
 * https://leetcode.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (30.15%)
 * Likes:    1383
 * Dislikes: 466
 * Total Accepted:    284.8K
 * Total Submissions: 944.1K
 * Testcase Example:  '10'
 *
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * Example:
 * 
 * 
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        int res = 0;
        boolean[] visited = new boolean[n];
        for (int i = 2; i < visited.length; i++) {
            if (!visited[i]) {
                res += 1;
            }
            for (int j = 1; j <= i; j++) {
                if (i * j < n) {
                    visited[i * j] = true;
                }
                else {
                    break;
                }
            }
        }
        return res;


        // int res = 0;
        // for (int i = 2; i < n; i++) {
        //     if (isPrime(i)) {
        //         res += 1;
        //     }
        // }
        // return res;
    }
    private boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

