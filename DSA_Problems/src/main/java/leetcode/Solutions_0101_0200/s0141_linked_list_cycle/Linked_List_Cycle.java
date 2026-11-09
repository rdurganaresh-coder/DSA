package leetcode.Solutions_0101_0200.s0141_linked_list_cycle;

// #Easy #Top_100_Liked_Questions #Top_Interview_Questions #Hash_Table #Two_Pointers #Linked_List
// #Data_Structure_I_Day_7_Linked_List #Udemy_Linked_List #Top_Interview_150_Linked_List
// #Big_O_Time_O(N)_Space_O(1) #2024_11_15_Time_0_ms_(100.00%)_Space_44.3_MB_(52.46%)

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
public class Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard linked list with a loop cycle (Should output true)
        // 3 -> 2 -> 0 -> -4 -> (loops back to 2)
        ListNode head1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creating the cycle loop back to index 1

        boolean result1 = new Linked_List_Cycle().hasCycle(head1);
        System.out.println("Test 1 (Cyclic List):   " + result1);

        // Test Case 2: Linear list without any cycles (Should output false)
        // 1 -> 2
        ListNode head2 = new ListNode(1, new ListNode(2));
        boolean result2 = new Linked_List_Cycle().hasCycle(head2);
        System.out.println("Test 2 (Linear List):   " + result2);

        // Test Case 3: Empty list boundary configuration (Should output false)
        ListNode head3 = null;
        boolean result3 = new Linked_List_Cycle().hasCycle(head3);
        System.out.println("Test 3 (Null Head):     " + result3);

        // Test Case 4: Single standalone node without a cycle (Should output false)
        ListNode head4 = new ListNode(1);
        boolean result4 = new Linked_List_Cycle().hasCycle(head4);
        System.out.println("Test 4 (Single Node):   " + result4);
    }
}
