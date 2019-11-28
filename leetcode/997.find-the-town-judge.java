import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

/*
 * @lc app=leetcode id=997 lang=java
 *
 * [997] Find the Town Judge
 *
 * https://leetcode.com/problems/find-the-town-judge/description/
 *
 * algorithms
 * Easy (49.41%)
 * Likes:    273
 * Dislikes: 41
 * Total Accepted:    34.1K
 * Total Submissions: 69.1K
 * Testcase Example:  '2\n[[1,2]]'
 *
 * In a town, there are N people labelled from 1 to N.  There is a rumor that
 * one of these people is secretly the town judge.
 * 
 * If the town judge exists, then:
 * 
 * 
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * 
 * 
 * You are given trust, an array of pairs trust[i] = [a, b] representing that
 * the person labelled a trusts the person labelled b.
 * 
 * If the town judge exists and can be identified, return the label of the town
 * judge.  Otherwise, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 * 
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= N <= 1000
 * trust.length <= 10000
 * trust[i] are all different
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findJudge(int N, int[][] trust) {

        if (trust.length == 0 && N == 1) {
            return 1;
        }

        int largestIndegree = 0;
        int judge = -1;
        int[] inDegrees = new int[N + 1];
        boolean[] trustingOthers = new boolean[N + 1];
        for (int[] edge : trust) {
            int start = edge[0];
            int end = edge[1];
            trustingOthers[start] = true;
            inDegrees[end] = inDegrees[end] + 1;
            if (inDegrees[end] > largestIndegree) {
                judge = end;
                largestIndegree = inDegrees[end];
            }
        }
        
        if (largestIndegree == N - 1 && !trustingOthers[judge]) {
            return judge;
        }
        else {
            return -1;
        }
    }
}
// @lc code=end

