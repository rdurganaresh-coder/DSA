package leetcode.Solutions_0101_0200.s0147_insertion_sort_list;

// #Medium #Sorting #Linked_List #2022_06_24_Time_4_ms_(90.34%)_Space_45.1_MB_(20.93%)

import leetcode.utils.ListNode;
import java.util.Arrays;

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
public class Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        ListNode tnode = head;
        ListNode res = null;
        int count = 0;
        while (tnode != null) {
            count++;
            tnode = tnode.next;
        }
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = head.val;
            head = head.next;
        }
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            ListNode temp = new ListNode();
            temp.val = nums[i];
            temp.next = res;
            res = temp;
        }
        return res;
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
        Insertion_Sort_List sorter = new Insertion_Sort_List();

        System.out.println("--- Running Insertion Sort List Tests ---\n");

        // Test Case 1: Empty List
        System.out.print("Test 1 (Empty): Expected: [] -> Actual: ");
        ListNode head1 = createList(new int[]{});
        ListNode res1 = sorter.insertionSortList(head1);
        printList(res1);

        // Test Case 2: Unsorted List
        System.out.print("Test 2 (Unsorted): Input: 4 -> 2 -> 1 -> 3 -> Expected: 1 -> 2 -> 3 -> 4 -> Actual: ");
        ListNode head2 = createList(new int[]{4, 2, 1, 3});
        ListNode res2 = sorter.insertionSortList(head2);
        printList(res2);

        // Test Case 3: Already Sorted List
        System.out.print("Test 3 (Sorted): Input: 1 -> 2 -> 3 -> Expected: 1 -> 2 -> 3 -> Actual: ");
        ListNode head3 = createList(new int[]{1, 2, 3});
        ListNode res3 = sorter.insertionSortList(head3);
        printList(res3);

        // Test Case 4: Reverse Sorted List with Negatives
        System.out.print("Test 4 (Negatives & Reverse): Input: -1 -> 5 -> 3 -> 4 -> 0 -> Expected: -1 -> 0 -> 3 -> 4 -> 5 -> Actual: ");
        ListNode head4 = createList(new int[]{-1, 5, 3, 4, 0});
        ListNode res4 = sorter.insertionSortList(head4);
        printList(res4);

        // Test Case 5: Duplicate Elements
        System.out.print("Test 5 (Duplicates): Input: 2 -> 1 -> 2 -> Expected: 1 -> 2 -> 2 -> Actual: ");
        ListNode head5 = createList(new int[]{2, 1, 2});
        ListNode res5 = sorter.insertionSortList(head5);
        printList(res5);
    }
}
