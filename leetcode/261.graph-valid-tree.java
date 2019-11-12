import java.util.*;

/*
 * @lc app=leetcode id=261 lang=java
 *
 * [261] Graph Valid Tree
 */

// @lc code=start
class Solution {
    public boolean validTree(int n, int[][] edges) {

        if (n <= 1) {
            return true;
        }

        if (edges.length < 1) {
            return false;
        }

        Map<Integer,List<Integer>> neighbors = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            Integer a = edges[i][0];
            Integer b = edges[i][1];
                if (!neighbors.containsKey(a)) neighbors.put(a, new LinkedList<>());
                if (!neighbors.containsKey(b)) neighbors.put(b, new LinkedList<>());
                neighbors.get(a).add(b);
                neighbors.get(b).add(a);
        }
        Set<Integer> visited = new HashSet<>();

        if (!dfs(-1, edges[0][0], visited, neighbors)) {
            return false;
        }

        // Queue<Integer> queue = new LinkedList<>();

        // queue.offer(edges[0][0]);
        // while (!queue.isEmpty()) {
        //     Integer currentNode = queue.poll();
        //     if (visited.contains(currentNode)) {
        //         return false;
        //     }
        //     else {
        //         visited.add(currentNode);
        //     }
        //     List<Integer> adjList = neighbors.get(currentNode);
        //     for (int i = 0; i < adjList.size(); i++) {
        //         Integer neighbor = adjList.get(i);
        //         neighbors.get(neighbor).remove(currentNode);
        //         queue.offer(neighbor);
                
        //     }
        // }
        if (visited.size() == n) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean dfs(Integer from, Integer currentNode, Set<Integer> visited, Map<Integer,List<Integer>> neighbors) {
        if (visited.contains(currentNode)) {
            return false;
        }
        else {
            visited.add(currentNode);
        }
        
        List<Integer> adj = neighbors.get(currentNode);
        for (int i: adj) {
            if (i == from) {
                continue;
            }
            if (!dfs(currentNode, i, visited, neighbors)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

