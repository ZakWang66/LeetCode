import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class P133 {

    public static void main(String[] args) {
        P133 problem = new P133();
        Node node = new Node(1, new LinkedList());
        Node node2 = new Node(2, new LinkedList());
        Node node3 = new Node(3, new LinkedList());
        Node node4 = new Node(4, new LinkedList());

        node.neighbors.add(node2);
        node.neighbors.add(node4);

        node2.neighbors.add(node);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node);
        node4.neighbors.add(node3);

        Node res = problem.cloneGraph(node);
        return;
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node newHead = new Node();
        Node p = newHead;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        q.offer(node);
        visited.add(node);
        while (!q.isEmpty()) {
            Node current = q.poll();
            p.val = current.val;
            p.neighbors = new LinkedList<>();
            map.put(current, p);
            for (Node neighbor : current.neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    q.offer(neighbor);
                }
            }
            p = new Node();
        }
        
        visited = new HashSet<>();
        q.offer(node);
        visited.add(node);
        while (!q.isEmpty()) {
            Node current = q.poll();
            Node copy = map.get(current);
            for (Node neighbor : current.neighbors) {
                copy.neighbors.add(map.get(neighbor));
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    q.offer(neighbor);
                }
            }
        }
        StringBuffer s = new StringBuffer();
        return newHead;
    }
}