import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 *
 * https://leetcode.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (38.99%)
 * Likes:    2420
 * Dislikes: 122
 * Total Accepted:    282.1K
 * Total Submissions: 707.4K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * Example 1:
 * 
 * 
 * Input: 2, [[1,0]] 
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 * Example 2:
 * 
 * 
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should
 * also have finished course 1. So it is impossible.
 * 
 * 
 * Note:
 * 
 * 
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input
 * prerequisites.
 * 
 * 
 */

// @lc code=start
class Solution {
    private static final String Queue = null;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Set<Integer> start = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            start.add(i);
        }
        for (int[] edge : prerequisites) {
            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new HashSet<>());
            }
            graph.get(edge[1]).add(edge[0]);
            start.remove(edge[0]);
        }
        Set<Integer> totalVisited = new HashSet<>();
        for (int startingNode : start) {
            if (hasLoop(startingNode, graph, new HashSet<Integer>(), totalVisited)) {
                return false;
            }
        }
        if (totalVisited.size() < numCourses) {
            return false;
        }
        return true;
    }

    private boolean hasLoop(int current, Map<Integer, Set<Integer>> graph, Set<Integer>visited, Set<Integer>totalVisited) {
        if (visited.contains(current)) {
            return true;
        }
        else {
            totalVisited.add(current);
            visited.add(current);
        }
        Set<Integer> neighbors = graph.get(current);
        if (neighbors != null) {
            for (int next : neighbors) {
                if (hasLoop(next, graph, visited, totalVisited)) {
                    visited.remove(current);
                    return true;
                }
            }
        }
        visited.remove(current);
        return false;
    }
}
// @lc code=end

