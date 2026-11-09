package leetcode.Solutions_0001_0100.s0083_remove_duplicates_from_sorted_list;

// #Easy #Linked_List #Data_Structure_I_Day_8_Linked_List
// #2022_06_20_Time_0_ms_(100.00%)_Space_44_MB_(64.59%)

import leetcode.utils.ListNode;

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Remove_Duplicates_From_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        ListNode next = current.next;
        while (null != next) {
            if (current.val == next.val) {
                current.next = next.next;
            } else {
                current = next;
            }
            next = current.next;
        }
        return head;
    }

    // Helper method to convert an array into a linked list
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

    // Helper method to print the linked list cleanly
    private static void printList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // Test Case 1: Standard list with duplicate nodes
        ListNode list1 = createList(new int[]{1, 1, 2});
        ListNode result1 = new Remove_Duplicates_From_Sorted_List().deleteDuplicates(list1);
        System.out.print("Test 1 Result: ");
        printList(result1);
        // Expected Output: [1 -> 2]

        // Test Case 2: Multi-duplicate chains across the list
        ListNode list2 = createList(new int[]{1, 1, 2, 3, 3});
        ListNode result2 = new Remove_Duplicates_From_Sorted_List().deleteDuplicates(list2);
        System.out.print("Test 2 Result: ");
        printList(result2);
        // Expected Output: [1 -> 2 -> 3]

        // Test Case 3: Empty list base edge case
        ListNode list3 = createList(new int[]{});
        ListNode result3 = new Remove_Duplicates_From_Sorted_List().deleteDuplicates(list3);
        System.out.print("Test 3 Result (Empty): ");
        printList(result3);
        // Expected Output: []

        // Test Case 4: Long sequence of identical elements (All duplicates)
        ListNode list4 = createList(new int[]{1, 1, 1, 1, 1});
        ListNode result4 = new Remove_Duplicates_From_Sorted_List().deleteDuplicates(list4);
        System.out.print("Test 4 Result (All Same): ");
        printList(result4);
        // Expected Output: [1]
    }
}
