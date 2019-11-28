import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=1042 lang=java
 *
 * [1042] Flower Planting With No Adjacent
 *
 * https://leetcode.com/problems/flower-planting-with-no-adjacent/description/
 *
 * algorithms
 * Easy (47.74%)
 * Likes:    144
 * Dislikes: 180
 * Total Accepted:    13.1K
 * Total Submissions: 27.5K
 * Testcase Example:  '3\n[[1,2],[2,3],[3,1]]'
 *
 * You have N gardens, labelled 1 to N.  In each garden, you want to plant one
 * of 4 types of flowers.
 * 
 * paths[i] = [x, y] describes the existence of a bidirectional path from
 * garden x to garden y.
 * 
 * Also, there is no garden that has more than 3 paths coming into or leaving
 * it.
 * 
 * Your task is to choose a flower type for each garden such that, for any two
 * gardens connected by a path, they have different types of flowers.
 * 
 * Return any such a choice as an array answer, where answer[i] is the type of
 * flower planted in the (i+1)-th garden.  The flower types are denoted 1, 2,
 * 3, or 4.  It is guaranteed an answer exists.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: N = 3, paths = [[1,2],[2,3],[3,1]]
 * Output: [1,2,3]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: N = 4, paths = [[1,2],[3,4]]
 * Output: [1,2,1,2]
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * Output: [1,2,3,4]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= N <= 10000
 * 0 <= paths.size <= 20000
 * No garden has 4 or more paths coming into or leaving it.
 * It is guaranteed an answer exists.
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : paths) {
            if (!graph.containsKey(edge[0])) graph.put(edge[0], new HashSet<>());
            if (!graph.containsKey(edge[1])) graph.put(edge[1], new HashSet<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            int res[] = new int[N];
            dfs(0, N, res, graph);
            return res; 
        }
    }
    private boolean dfs(int current, int N, int[] res, Map<Integer, Set<Integer>> graph) {
        if (current >= N) {
            return true; 
        }
        for (int i = 1; i < 5; i++) {
            Set<Integer> neighbors = graph.get(current);
            boolean good = true;
            for (int neighbor : neighbors) {
                if (res[neighbor] == res[current]) {
                    good = false;
                    break;
                }
            }
            if (good) {
                res[current] = i;
                if (dfs(current + 1, N, res, graph)) {
                    return true;
                }
                else {
                    res[current] = 0;
                }
            }
        }
        return false;
    }
}
// @lc code=end

