package leetcode.Solutions_0101_0200.s0146_lru_cache;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Hash_Table #Design #Linked_List
// #Doubly_Linked_List #Udemy_Linked_List #Top_Interview_150_Linked_List
// #Big_O_Time_O(1)_Space_O(capacity) #2024_11_15_Time_40_ms_(98.20%)_Space_111.4_MB_(88.70%)

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static class LruCacheNode {
        int key;
        int value;
        LruCacheNode prev;
        LruCacheNode next;

        public LruCacheNode(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int capacity;
    private Map<Integer, LruCacheNode> cacheMap = new HashMap<>();
    // insert here
    private LruCacheNode head;
    // remove here
    private LruCacheNode tail;

    public LRUCache(int cap) {
        capacity = cap;
    }

    public int get(int key) {
        LruCacheNode val = cacheMap.get(key);
        if (val == null) {
            return -1;
        }
        moveToHead(val);
        return val.value;
    }

    /*
     * Scenarios :
     * 1. Value key is already present.
     *          update
     *          move node to head
     * 2. cache is not full
     *          cache is empty (create node and assign head and tail)
     *          cache is partially empty (add node to head and update head pointer)
     * 3. cache is full
     *          remove node at tail, update head, tail pointers
     *          Recursively call put
     *
     *
     * move node to head Scenarios
     * 1. node is at head
     * 2. node is at tail
     * 3. node is in middle
     *
     */
    public void put(int key, int value) {
        LruCacheNode valNode = cacheMap.get(key);
        if (valNode != null) {
            valNode.value = value;
            moveToHead(valNode);
        } else {
            if (cacheMap.size() < capacity) {
                if (cacheMap.size() == 0) {
                    LruCacheNode node = new LruCacheNode(key, value);
                    cacheMap.put(key, node);
                    head = node;
                    tail = node;
                } else {
                    LruCacheNode node = new LruCacheNode(key, value);
                    cacheMap.put(key, node);
                    node.next = head;
                    head.prev = node;
                    head = node;
                }
            } else {
                // remove from tail
                LruCacheNode last = tail;
                tail = last.prev;
                if (tail != null) {
                    tail.next = null;
                }
                cacheMap.remove(last.key);
                if (cacheMap.size() == 0) {
                    head = null;
                }
                // Call recursively
                put(key, value);
            }
        }
    }

    /*
     * check for 3 conditions
     * 1. node is already at head
     * 2. Node is tail node
     * 3. Node in middle node
     */
    private void moveToHead(LruCacheNode node) {
        if (node == head) {
            return;
        }
        if (node == tail) {
            tail = node.prev;
        }
        // node is not head, it should have some valid prev node
        LruCacheNode prev = node.prev;
        LruCacheNode next = node.next;
        prev.next = next;
        if (next != null) {
            next.prev = prev;
        }
        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
    }

    // --- Helper Method to Verify Internal State Sequence ---
    private String getCacheSequence() {
        StringBuilder sb = new StringBuilder("[");
        LruCacheNode current = head;
        while (current != null) {
            sb.append("(").append(current.key).append(":").append(current.value).append(")");
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // --- Main Method Executing Test Cases ---
    public static void main(String[] args) {
        System.out.println("--- Running LRU Cache Tests ---\n");

        // Test Case 1: Standard Operations & Evictions (Capacity 2)
        System.out.println("Test 1: Standard Operations (Capacity = 2)");
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1); // cache: [(1:1)]
        cache.put(2, 2); // cache: [(2:2) -> (1:1)]
        System.out.println("Get(1): " + cache.get(1) + " (Expected: 1) -> Sequence: " + cache.getCacheSequence());
        
        cache.put(3, 3); // evicts key 2, cache: [(3:3) -> (1:1)]
        System.out.println("Get(2): " + cache.get(2) + " (Expected: -1)");
        
        cache.put(4, 4); // evicts key 1, cache: [(4:4) -> (3:3)]
        System.out.println("Get(1): " + cache.get(1) + " (Expected: -1)");
        System.out.println("Get(3): " + cache.get(3) + " (Expected: 3)");
        System.out.println("Get(4): " + cache.get(4) + " (Expected: 4) -> Final Sequence: " + cache.getCacheSequence() + "\n");

        // Test Case 2: Key Updates & Head Reordering (Capacity 2)
        System.out.println("Test 2: Key Overwrites and Promotion (Capacity = 2)");
        LRUCache cache2 = new LRUCache(2);
        
        cache2.put(1, 10);
        cache2.put(2, 20);
        cache2.put(1, 15); // Update existing key 1, moves to head
        System.out.println("Get(1) after update: " + cache2.get(1) + " (Expected: 15) -> Sequence: " + cache2.getCacheSequence());
        
        cache2.put(3, 30); // Evicts key 2 (since 1 was promoted)
        System.out.println("Get(2): " + cache2.get(2) + " (Expected: -1)");
        System.out.println("Get(1): " + cache2.get(1) + " (Expected: 15)\n");

        // Test Case 3: Capacity of 1 Edge Case
        System.out.println("Test 3: Single Capacity Edge Case (Capacity = 1)");
        LRUCache cache3 = new LRUCache(1);
        
        cache3.put(5, 50);
        System.out.println("Get(5): " + cache3.get(5) + " (Expected: 50)");
        cache3.put(6, 60); // Evicts key 5 immediately
        System.out.println("Get(5): " + cache3.get(5) + " (Expected: -1)");
        System.out.println("Get(6): " + cache3.get(6) + " (Expected: 60)");
    }
}

/*
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
