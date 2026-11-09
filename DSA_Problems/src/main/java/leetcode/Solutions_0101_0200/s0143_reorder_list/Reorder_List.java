package leetcode.Solutions_0101_0200.s0143_reorder_list;

// #Medium #Two_Pointers #Stack #Linked_List #Recursion #Data_Structure_II_Day_13_Linked_List
// #Programming_Skills_II_Day_14 #2022_06_24_Time_2_ms_(72.59%)_Space_55.1_MB_(5.83%)

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
public class Reorder_List {
    private ListNode forward;

    public void reorderList(ListNode head) {
        forward = head;
        dfs(head);
    }

    private void dfs(ListNode node) {
        if (node != null) {
            dfs(node.next);
            if (forward != null) {
                ListNode next = forward.next;
                // even case: forward.next coincide with node
                if (next == node) {
                    node.next = null;
                } else {
                    node.next = next;
                }
                forward.next = node;
                forward = node.next;
            }
            // odd case: forward coincide with node
            if (forward == node) {
                forward.next = null;
                forward = forward.next;
            }
        }
    }

    // --- Helper Utilities for Testing ---

    private static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    private static void printList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        ListNode current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        System.out.println(sb.toString());
    }

    // --- Main Method Executing Test Cases ---
    public static void main(String[] args) {
        Reorder_List solution = new Reorder_List();

        System.out.println("--- Running Reorder List Tests ---\n");

        // Test Case 1: Empty List
        System.out.print("Test 1 (Empty): ");
        ListNode head1 = createList(new int[]{});
        solution.reorderList(head1);
        printList(head1);

        // Test Case 2: Single Element
        System.out.print("Test 2 (Single): Input: [1] -> Expected: 1 -> Result: ");
        ListNode head2 = createList(new int[]{1});
        solution.reorderList(head2);
        printList(head2);

        // Test Case 3: Two Elements
        System.out.print("Test 3 (Two): Input: [1, 2] -> Expected: 1 -> 2 -> Result: ");
        ListNode head3 = createList(new int[]{1, 2});
        solution.reorderList(head3);
        printList(head3);

        // Test Case 4: Even Number of Elements
        System.out.print("Test 4 (Even): Input: [1, 2, 3, 4] -> Expected: 1 -> 4 -> 2 -> 3 -> Result: ");
        ListNode head4 = createList(new int[]{1, 2, 3, 4});
        solution.reorderList(head4);
        printList(head4);

        // Test Case 5: Odd Number of Elements
        System.out.print("Test 5 (Odd): Input: [1, 2, 3, 4, 5] -> Expected: 1 -> 5 -> 2 -> 4 -> 3 -> Result: ");
        ListNode head5 = createList(new int[]{1, 2, 3, 4, 5});
        solution.reorderList(head5);
        printList(head5);
    }
}
