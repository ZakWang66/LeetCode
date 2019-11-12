import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=269 lang=java
 *
 * [269] Alien Dictionary
 *
 * https://leetcode.com/problems/alien-dictionary/description/
 *
 * algorithms
 * Hard (31.93%)
 * Likes:    1168
 * Dislikes: 224
 * Total Accepted:    101.5K
 * Total Submissions: 306.9K
 * Testcase Example:  '["wrt","wrf","er","ett","rftt"]'
 *
 * There is a new alien language which uses the latin alphabet. However, the
 * order among letters are unknown to you. You receive a list of non-empty
 * words from the dictionary, where words are sorted lexicographically by the
 * rules of this new language. Derive the order of letters in this language.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠ "wrt",
 * ⁠ "wrf",
 * ⁠ "er",
 * ⁠ "ett",
 * ⁠ "rftt"
 * ]
 * 
 * Output: "wertf"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * [
 * ⁠ "z",
 * ⁠ "x"
 * ]
 * 
 * Output: "zx"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * [
 * ⁠ "z",
 * ⁠ "x",
 * ⁠ "z"
 * ] 
 * 
 * Output: "" 
 * 
 * Explanation: The order is invalid, so return "".
 * 
 * 
 * Note:
 * 
 * 
 * You may assume all letters are in lowercase.
 * You may assume that if a is a prefix of b, then a must appear before b in
 * the given dictionary.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is
 * fine.
 * 
 * 
 */

// @lc code=start
class Solution {
    public String alienOrder(String[] words) {

        /**
         * Base cases
         */
        if (words == null || words.length < 1) {
            return "";
        }
        
        /**
         * Build the graph and calculate in-degree of each node
         */
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegrees = new HashMap<>();

        /**
         * Initialize the in-degrees to be 0
         */
        for (String s : words) {
            for (Character c : s.toCharArray()) {
                inDegrees.put(c, 0);
            }
        }

        /**
         * If a character is 'followed' by another one, 
         * it's in-degree increase by one and an edge is built 
         * (the "follower" adds a neighbor).
         * 
         * Since the relationship between two nodes is unique, 
         * this logic only execute for the first time when the neighbor 
         * is being adding.
         * 
         * The basic logic of comparing two Strings can refer to 
         * String.class :: this.compareTo(String anotherString) method
         */
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int minLength = s1.length() < s2.length() ? s1.length() : s2.length();
            for (int j = 0; j < minLength; j++) {
                Character smaller = s1.charAt(j);
                Character larger = s2.charAt(j);
                if (smaller != larger) {
                    if (!graph.containsKey(smaller)) graph.put(smaller, new HashSet<>());
                    Set<Character> neighbors = graph.get(smaller);
                    if (!neighbors.contains(larger)) {    
                        neighbors.add(larger);
                        inDegrees.put(larger, inDegrees.get(larger) + 1);
                    }
                    break;
                }
            }
        }

        /**
         * Do BFS (Topological sort) on the map. 
         * 
         * The basic idea is that for every node (character), 
         * every in-degree of itself on the graph represents another 
         * character which is smaller in the new lexicographical order.
         * 
         * Let's define : a character is 'unlocked' means it has 0 in-degree, otherwise 
         * it has a positive in-degree and is 'locked'.
         * 
         * Only unlocked characters can be put into the result 
         * 
         * Whenever we see an unlocked character, we put it into the result and 
         * do BFS to reach all of its neighboring nodes. Then we let all of those 
         * neighboring nodes' in-degree decrease by one, as the unlocked character 
         * has been added to the result and 'removed' from the graph (since the 
         * unlocked character has 0 in-degree, we will never see it again in the 
         * future when doing this BFS).
         * 
         * By decreasing the in-degree of these neighbors, new 0 in-degree nodes 
         * might appear among them. We can then put these newly unlocked nodes into 
         * the queue and wait for them to be fetched out in the following cycle of 
         * the BFS.
         * 
         */

        StringBuffer res = new StringBuffer();
        Queue<Character> queue = new LinkedList<>();

        for (Character c : inDegrees.keySet()) {
            if (inDegrees.get(c) == 0) {
                queue.offer(c);
            }    
        }
        
        while (!queue.isEmpty()) {
            Character current = queue.poll();
            res.append(current);
            Set<Character> neighbors = graph.get(current);
            if (neighbors == null) continue;
            for (Character neighbor : neighbors) {
                int newDegree = inDegrees.get(neighbor) - 1;
                inDegrees.put(neighbor, newDegree);
                if (newDegree == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        /**
         * When the queue is empty, there are 2 cases:
         * 
         * 1. All character nodes are unlocked and put into the result
         * 
         * 2. There still remains some nodes locked and cannot be reached, since 
         *    current unlocked nodes have no edge to reach them.
         * 
         * For the first situation, we get a valid answer. For the second one, 
         * we can know that the order is invalid. Because these remaining nodes 
         * appeared in the input String[], but now they cannot be placed at a 
         * proper place under the rule that the BFS can only expand on unlocked 
         * nodes. This is a conflict so the result without them is invalid.
         * 
         */
        
        String result = res.toString();   
        System.out.println(result);  
        if (result.length() == inDegrees.size()) {
            return result;
        }
        return "";
    }
}
// @lc code=end

