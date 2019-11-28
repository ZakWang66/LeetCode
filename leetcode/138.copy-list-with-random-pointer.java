import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 *
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 *
 * algorithms
 * Medium (30.46%)
 * Likes:    2162
 * Dislikes: 530
 * Total Accepted:    311K
 * Total Submissions: 1M
 * Testcase Example:  '{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}'
 *
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input:
 * 
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * 
 * Explanation:
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer
 * points to itself.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * You must return the copy of the given head as a reference to the cloned
 * list.
 * 
 * 
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Integer, Node> newRandoms = new HashMap<>();
        Node current = head;
        Node dummyHead = new Node(0);
        dummyHead.next = new Node(0);
        Node currentCopy = dummyHead.next;
        if (current != null) {
            newRandoms.put(current.val, currentCopy);
        }
        while (current != null) {
            currentCopy.val = current.val;
            if (current.random != null) {
                int randomVal = current.random.val;
                Node copyRandom = null;
                if (!newRandoms.containsKey(randomVal)) {
                    copyRandom = new Node(randomVal);
                    newRandoms.put(randomVal, copyRandom);
                }
                else {
                    copyRandom = newRandoms.get(randomVal);
                }
                currentCopy.random = copyRandom;
            }

            
            if (current.next != null) {
                int nextVal = current.next.val;
                Node copyNext = null;
                if (!newRandoms.containsKey(nextVal)) {
                    copyNext = new Node(nextVal);
                    newRandoms.put(nextVal, copyNext);
                }
                else {
                    copyNext = newRandoms.get(nextVal);
                }
                currentCopy.next = copyNext;
            }
            currentCopy =  currentCopy.next;
            current = current.next;
        }
        return dummyHead.next;
    }
}
// @lc code=end

