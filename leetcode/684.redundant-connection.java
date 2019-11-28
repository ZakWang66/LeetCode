import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 *
 * https://leetcode.com/problems/redundant-connection/description/
 *
 * algorithms
 * Medium (54.36%)
 * Likes:    877
 * Dislikes: 208
 * Total Accepted:    67.9K
 * Total Submissions: 124.9K
 * Testcase Example:  '[[1,2],[1,3],[2,3]]'
 *
 * 
 * In this problem, a tree is an undirected graph that is connected and has no
 * cycles.
 * 
 * The given input is a graph that started as a tree with N nodes (with
 * distinct values 1, 2, ..., N), with one additional edge added.  The added
 * edge has two different vertices chosen from 1 to N, and was not an edge that
 * already existed.
 * 
 * The resulting graph is given as a 2D-array of edges.  Each element of edges
 * is a pair [u, v] with u < v, that represents an undirected edge connecting
 * nodes u and v.
 * 
 * Return an edge that can be removed so that the resulting graph is a tree of
 * N nodes.  If there are multiple answers, return the answer that occurs last
 * in the given 2D-array.  The answer edge [u, v] should be in the same format,
 * with u < v.
 * Example 1:
 * 
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given undirected graph will be like this:
 * ⁠ 1
 * ⁠/ \
 * 2 - 3
 * 
 * 
 * Example 2:
 * 
 * Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * Output: [1,4]
 * Explanation: The given undirected graph will be like this:
 * 5 - 1 - 2
 * ⁠   |   |
 * ⁠   4 - 3
 * 
 * 
 * Note:
 * The size of the input 2D-array will be between 3 and 1000.
 * Every integer represented in the 2D-array will be between 1 and N, where N
 * is the size of the input array.
 * 
 * 
 * 
 * 
 * 
 * Update (2017-09-26):
 * We have overhauled the problem description + test cases and specified
 * clearly the graph is an undirected graph. For the directed graph follow up
 * please see Redundant Connection II). We apologize for any inconvenience
 * caused.
 * 
 */

// @lc code=start
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<String> loopEdges = new HashSet<>();
        for (int[] edge : edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new HashSet<>());
            }
            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new HashSet<>());
            }

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);

        }
        
        dfs(edges[0][0], -1, visited, graph, loopEdges);
        int[] res = null;
        for (int[] edge : edges) {
            if (loopEdges.contains(new String(edge[0] + "," + edge[1])) ||
                loopEdges.contains(new String(edge[1] + "," + edge[0])) ) {
                res = edge;
            }
        }
        return res;
    }
    private Integer dfs(int current, int parent, Set<Integer> visited, Map<Integer, Set<Integer>> graph, Set<String> loopEdges) {
        if (visited.contains(current)) {
            loopEdges.add(current + "," + parent);
            return new Integer(current);
        }
        else {
            visited.add(current);
        }
        Set<Integer> neighbors = graph.get(current);
        for (Integer neighbor : neighbors) {
            if (neighbor == parent) {
                continue;
            }
            Integer loopPoint = dfs(neighbor, current, visited, graph, loopEdges);
            if (loopPoint != null) {
                if (loopPoint != -1) {
                    loopEdges.add(current + "," + parent);
                    if (parent == loopPoint) {
                        return -1;
                    }
                    else {
                        return loopPoint;
                    }
                }
                else {
                    return -1;
                }
            }
        }
        return null;
    }
}
// @lc code=end

