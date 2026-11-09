package leetcode.Solutions_0001_0100.s0086_partition_list;

// #Medium #Two_Pointers #Linked_List #Top_Interview_150_Linked_List
// #2025_03_05_Time_0_ms_(100.00%)_Space_41.88_MB_(91.77%)

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
public class Partition_List {
    public ListNode partition(ListNode head, int x) {
        ListNode nHead = new ListNode(0);
        ListNode nTail = new ListNode(0);
        ListNode ptr = nTail;
        ListNode temp = nHead;
        while (head != null) {
            ListNode nNext = head.next;
            if (head.val < x) {
                nHead.next = head;
                nHead = nHead.next;
            } else {
                nTail.next = head;
                nTail = nTail.next;
            }
            head = nNext;
        }
        nTail.next = null;
        nHead.next = ptr.next;
        return temp.next;
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
        // Test Case 1: Standard mixed list layout
        ListNode list1 = createList(new int[]{1, 4, 3, 2, 5, 2});
        ListNode result1 = new Partition_List().partition(list1, 3);
        System.out.print("Test 1 Result (x = 3): ");
        printList(result1);
        // Expected Output: [1 -> 2 -> 2 -> 4 -> 3 -> 5]

        // Test Case 2: List elements are already partitioned or sorted
        ListNode list2 = createList(new int[]{1, 2, 3});
        ListNode result2 = new Partition_List().partition(list2, 4);
        System.out.print("Test 2 Result (x = 4): ");
        printList(result2);
        // Expected Output: [1 -> 2 -> 3]

        // Test Case 3: Empty list edge case
        ListNode list3 = createList(new int[]{});
        ListNode result3 = new Partition_List().partition(list3, 0);
        System.out.print("Test 3 Result (Empty): ");
        printList(result3);
        // Expected Output: []

        // Test Case 4: No elements are strictly less than x
        ListNode list4 = createList(new int[]{5, 6, 4});
        ListNode result4 = new Partition_List().partition(list4, 2);
        System.out.print("Test 4 Result (x = 2): ");
        printList(result4);
        // Expected Output: [5 -> 6 -> 4]
    }
}
