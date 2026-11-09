package leetcode.Solutions_0001_0100.s0082_remove_duplicates_from_sorted_list_ii;


// #Medium #Two_Pointers #Linked_List #Data_Structure_II_Day_11_Linked_List
// #Algorithm_II_Day_3_Two_Pointers #Top_Interview_150_Linked_List
// #2025_03_05_Time_0_ms_(100.00%)_Space_43.31_MB_(44.18%)

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
public class Remove_Duplicates_From_Sorted_List_ii {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        prev.next = head;
        ListNode curr = head.next;
        while (curr != null) {
            boolean flagFoundDuplicate = false;
            while (curr != null && prev.next.val == curr.val) {
                flagFoundDuplicate = true;
                curr = curr.next;
            }
            if (flagFoundDuplicate) {
                prev.next = curr;
                if (curr != null) {
                    curr = curr.next;
                }
            } else {
                prev = prev.next;
                prev.next = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
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
        // Test Case 1: Standard case with duplicates (Should completely remove 3 and 4)
        ListNode list1 = createList(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNode result1 = new Remove_Duplicates_From_Sorted_List_ii().deleteDuplicates(list1);
        System.out.print("Test 1 Result: ");
        printList(result1);
        // Expected Output: [1 -> 2 -> 5]

        // Test Case 2: Multi-duplicate sequence at the very beginning (Should completely remove 1)
        ListNode list2 = createList(new int[]{1, 1, 1, 2, 3});
        ListNode result2 = new Remove_Duplicates_From_Sorted_List_ii().deleteDuplicates(list2);
        System.out.print("Test 2 Result: ");
        printList(result2);
        // Expected Output: [2 -> 3]

        // Test Case 3: Empty list edge case
        ListNode list3 = createList(new int[]{});
        ListNode result3 = new Remove_Duplicates_From_Sorted_List_ii().deleteDuplicates(list3);
        System.out.print("Test 3 Result (Empty): ");
        printList(result3);
        // Expected Output: []

        // Test Case 4: List consisting entirely of duplicate numbers (Should output an empty list [])
        ListNode list4 = createList(new int[]{1, 1, 2, 2});
        ListNode result4 = new Remove_Duplicates_From_Sorted_List_ii().deleteDuplicates(list4);
        System.out.print("Test 4 Result (All Duplicates): ");
        printList(result4);
        // Expected Output: []
    }
}
