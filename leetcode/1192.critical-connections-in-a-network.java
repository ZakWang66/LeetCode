import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=1192 lang=java
 *
 * [1192] Critical Connections in a Network
 *
 * https://leetcode.com/problems/critical-connections-in-a-network/description/
 *
 * algorithms
 * Hard (48.53%)
 * Likes:    331
 * Dislikes: 33
 * Total Accepted:    15.1K
 * Total Submissions: 31.1K
 * Testcase Example:  '4\n[[0,1],[1,2],[2,0],[1,3]]'
 *
 * There are n servers numbered from 0 to n-1 connected by undirected
 * server-to-server connections forming a network where connections[i] = [a, b]
 * represents a connection between servers a and b. Any server can reach any
 * other server directly or indirectly through the network.
 * 
 * A critical connection is a connection that, if removed, will make some
 * server unable to reach some other server.
 * 
 * Return all critical connections in the network in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * Output: [[1,3]]
 * Explanation: [[3,1]] is also accepted.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 10^5
 * n-1 <= connections.length <= 10^5
 * connections[i][0] != connections[i][1]
 * There are no repeated connections.
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Set<Integer>[] adj = new HashSet[n];
        for (List<Integer> edge : connections) {
            int v1 = edge.get(0);
            int v2 = edge.get(1);
            if (adj[v1] == null) {
                adj[v1] = new HashSet<>();
            }
            if (adj[v2] == null) {
                adj[v2] = new HashSet<>();
            }
            adj[v1].add(v2);
            adj[v2].add(v1);
        }

        List<List<Integer>> res = new LinkedList<>();
        for (List<Integer> edge : connections) {
            int v1 = edge.get(0);
            int v2 = edge.get(1);
            adj[v1].remove(v2);
            adj[v2].remove(v1);
            boolean[] visited = new boolean[n];
            if (!dfs(v1, v2, -1, adj, visited)) {
                res.add(edge);
            }
            adj[v1].add(v2);
            adj[v2].add(v1);
        }
        return res;
    }
    private boolean dfs(int current, int dest, int prev, Set<Integer>[] adj, boolean[] visited) {
        if (visited[current]) {
            return false;
        }
        else {
            visited[current] = true;
        }
        if (current == dest) {
            return true;
        }
        for (int neighbor : adj[current]) {
            if (neighbor == prev) {
                continue;
            }
            if (dfs(neighbor, dest, current, adj, visited)) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

