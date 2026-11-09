package leetcode.Solutions_0101_0200.s0138_copy_list_with_random_pointer;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Hash_Table #Linked_List
// #Programming_Skills_II_Day_14 #Udemy_Linked_List #Top_Interview_150_Linked_List
// #Big_O_Time_O(N)_Space_O(N) #2025_07_04_Time_0_ms_(100.00%)_Space_43.96_MB_(99.29%)

import leetcode.utils.random.Node;
import java.util.HashMap;
import java.util.Map;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
public class Copy_List_With_Random_Pointer {
    public Node copyRandomList(Node head) {
        Map<Node, Node> hashMap = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            hashMap.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node copy = hashMap.get(cur);
            copy.next = hashMap.get(cur.next);
            copy.random = hashMap.get(cur.random);
            cur = cur.next;
        }
        return hashMap.get(head);
    }

    // Helper method to verify the deep copy structural alignment
    private static void verifyDeepCopy(Node original, Node cloned) {
        Node oCurr = original;
        Node cCurr = cloned;
        
        while (oCurr != null) {
            if (cCurr == null) {
                System.out.println("FAIL: Cloned list is shorter than original.");
                return;
            }
            if (oCurr == cCurr) {
                System.out.println("FAIL: Node val " + oCurr.val + " shares the same memory reference!");
                return;
            }
            if (oCurr.val != cCurr.val) {
                System.out.println("FAIL: Value mismatch at node " + oCurr.val);
                return;
            }
            if (oCurr.random != null) {
                if (cCurr.random == null) {
                    System.out.println("FAIL: Random pointer is null in clone at node " + oCurr.val);
                    return;
                }
                if (oCurr.random == cCurr.random) {
                    System.out.println("FAIL: Random pointer points to original list reference at node " + oCurr.val);
                    return;
                }
                if (oCurr.random.val != cCurr.random.val) {
                    System.out.println("FAIL: Random target value mismatch at node " + oCurr.val);
                    return;
                }
            } else if (cCurr.random != null) {
                System.out.println("FAIL: Random pointer should be null in clone at node " + oCurr.val);
                return;
            }
            oCurr = oCurr.next;
            cCurr = cCurr.next;
        }
        if (cCurr != null) {
            System.out.println("FAIL: Cloned list is longer than original.");
        } else {
            System.out.println("SUCCESS. Deep copy structurally verified.");
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Standard list with mixed random pointers and a cycle loop
        // 7 -> 13 -> 11 -> 10 -> 1
        Node n7 = new Node(7);
        Node n13 = new Node(13);
        Node n11 = new Node(11);
        Node n10 = new Node(10);
        Node n1 = new Node(1);

        n7.next = n13;
        n13.next = n11;
        n11.next = n10;
        n10.next = n1;

        n7.random = null;
        n13.random = n7;
        n11.random = n1;
        n10.random = n11;
        n1.random = n7;

        Node cloned1 = new Copy_List_With_Random_Pointer().copyRandomList(n7);
        System.out.print("Test 1 (Standard Random List): ");
        verifyDeepCopy(n7, cloned1);

        // Test Case 2: Minimal single node pointing to itself as random
        Node nSingle = new Node(3);
        nSingle.random = nSingle;

        Node clonedSingle = new Copy_List_With_Random_Pointer().copyRandomList(nSingle);
        System.out.print("Test 2 (Self-pointing Random Node): ");
        verifyDeepCopy(nSingle, clonedSingle);

        // Test Case 3: Empty list boundary case (null input)
        Node clonedNull = new Copy_List_With_Random_Pointer().copyRandomList(null);
        System.out.print("Test 3 (Null Input): ");
        if (clonedNull == null) {
            System.out.println("SUCCESS. Correctly returned null.");
        } else {
            System.out.println("FAIL");
        }
    }
}
