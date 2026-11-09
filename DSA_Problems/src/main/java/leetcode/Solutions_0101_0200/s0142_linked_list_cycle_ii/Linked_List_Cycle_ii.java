package leetcode.Solutions_0101_0200.s0142_linked_list_cycle_ii;

// #Medium #Top_100_Liked_Questions #Hash_Table #Two_Pointers #Linked_List
// #Data_Structure_II_Day_10_Linked_List #Level_1_Day_4_Linked_List #Udemy_Linked_List
// #Big_O_Time_O(N)_Space_O(1) #2024_11_15_Time_0_ms_(100.00%)_Space_44.7_MB_(20.31%)

import leetcode.utils.ListNode;

/*
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Linked_List_Cycle_ii {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // intersected inside the loop.
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard linked list with a loop cycle (Should return node with value 2)
        // 3 -> 2 -> 0 -> -4 -> (loops back to 2)
        ListNode head1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creating the cycle loop back to index 1

        ListNode result1 = new Linked_List_Cycle_ii().detectCycle(head1);
        System.out.println("Test 1 (Cycle starts at node val): " + (result1 != null ? result1.val : "null"));

        // Test Case 2: Linear list without any cycles (Should return null)
        // 1 -> 2
        ListNode head2 = new ListNode(1, new ListNode(2));
        ListNode result2 = new Linked_List_Cycle_ii().detectCycle(head2);
        System.out.println("Test 2 (No cycle):                   " + (result2 != null ? result2.val : "null"));

        // Test Case 3: Empty list boundary configuration (Should return null)
        ListNode head3 = null;
        ListNode result3 = new Linked_List_Cycle_ii().detectCycle(head3);
        System.out.println("Test 3 (Null Head):                 " + (result3 != null ? result3.val : "null"));

        // Test Case 4: Single standalone node without a cycle (Should return null)
        ListNode head4 = new ListNode(1);
        ListNode result4 = new Linked_List_Cycle_ii().detectCycle(head4);
        System.out.println("Test 4 (Single Node):               " + (result4 != null ? result4.val : "null"));
    }
}
