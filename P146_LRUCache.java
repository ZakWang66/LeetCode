import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class P146_LRUCache {

    private class PriorityKey implements Comparable<PriorityKey>{
        private int val;
        private int priority;
        public PriorityKey(int val) {
            this.val = val;
            this.priority = 0;
        }

        @Override
        public int compareTo(PriorityKey anotherKey){
            return anotherKey.priority - priority;
        }

        public int getVal() {
            priority++;
            return val;
        }
    }

    private int capacity;
    private Map<Integer, Integer> list;
    private ArrayList<Integer> priority;
    public P146_LRUCache(int capacity) {
        this.capacity = capacity;
        list = new HashMap<Integer, Integer>();
        priority = new ArrayList<Integer>();
    }
    
    public int get(int key) {
        if (list.get(key) == null) {
            return -1;
        }
        else {
            for (int i = 0; i < priority.size(); i++) {
                int k = priority.get(i);
                if (k == key) {
                    priority.remove(i);
                    priority.add(key);
                }
            }
            return list.get(key);
        }
    }
    
    public void put(int key, int value) {
        if (list.containsKey(key)) return;
        if (list.size() == capacity) {
            list.remove(priority.get(0));
            priority.remove(0);
        }
        priority.add(key);
        list.put(key, value);
    }
    public static void main(String[] args) {
        P146_LRUCache LRU = new P146_LRUCache(2);
        LRU.put(1,1);
        LRU.put(2,2);
        LRU.get(1);
        LRU.put(3,3);
        LRU.get(2);
        return;
    }
}