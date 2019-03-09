import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class P146_LRUCache {
    class DList {
        Node head;
        Node tail;
        public DList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }
        public void addNode(Node n) {
            tail.prev.next = n;
            n.prev = tail.prev;
            tail.prev = n;
            n.next = tail;
        }
        public void removeNode(Node n) {
            Node prev = n.prev;
            Node next = n.next;
            prev.next = n.next;
            next.prev = n.prev;
        }
        public Node newNode(int key, int val) {
            return new Node(key, val);
        }
        class Node {
            Node next, prev;
            int key, val;
            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
            public Node(){}
        }
    }

    Map<Integer, DList.Node> m;
    DList l;
    int capacity;
 
    public P146_LRUCache(int capacity) {
        l = new DList();
        m = new HashMap<Integer, DList.Node>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!m.containsKey(key)) return -1;
        DList.Node n = m.get(key);
        l.removeNode(n);
        l.addNode(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        if (!m.containsKey(key)) {
            DList.Node n = l.newNode(key, value);
            l.addNode(n);
            m.put(key, n);
        }
        else {
            DList.Node n = m.get(key);
            l.removeNode(n);
            m.remove(key);
            put(key, value);
        }
        if (m.size() > capacity) {
            DList.Node n = l.head.next;
            if (n != l.tail) {
                l.removeNode(n);
                m.remove(n.key);
            }
        }
    }

    public static void main(String[] args) {
        P146_LRUCache LRUC = new P146_LRUCache(2);
        LRUC.put(1,1);
        LRUC.put(2,2);
        LRUC.get(1);
        LRUC.put(3,3);
        System.out.println(LRUC.get(1));
    }
}