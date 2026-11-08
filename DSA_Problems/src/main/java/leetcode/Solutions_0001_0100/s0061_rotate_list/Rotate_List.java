package leetcode.Solutions_0001_0100.s0061_rotate_list;

// #Medium #Two_Pointers #Linked_List #Programming_Skills_II_Day_16 #Udemy_Linked_List
// #Top_Interview_150_Linked_List #2025_03_04_Time_0_ms_(100.00%)_Space_42.42_MB_(78.37%)

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
public class Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode tail = head;
        // find the count and let tail points to last node
        int count = 1;
        while (tail != null && tail.next != null) {
            count++;
            tail = tail.next;
        }
        // calculate number of times to rotate by count modulas
        int times = k % count;
        if (times == 0) {
            return head;
        }
        ListNode temp = head;
        // iterate and go to the K+1 th node from the end or count - K - 1 node from
        // start
        for (int i = 1; i <= count - times - 1 && temp != null; i++) {
            temp = temp.next;
        }
        ListNode newHead = null;
        if (temp != null && tail != null) {
            newHead = temp.next;
            temp.next = null;
            tail.next = head;
        }
        return newHead;
    }

    private static ListNode createList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // Test Case 1: Standard list with k smaller than count
        ListNode list1 = createList(new int[]{1, 2, 3, 4, 5});
        ListNode result1 = new Rotate_List().rotateRight(list1, 2);
        System.out.print("Test 1 Result (k = 2): ");
        printList(result1);
        // Expected Output: [4 -> 5 -> 1 -> 2 -> 3]

        // Test Case 2: List with k larger than list size (k % count handles this)
        ListNode list2 = createList(new int[]{0, 1, 2});
        ListNode result2 = new Rotate_List().rotateRight(list2, 4);
        System.out.print("Test 2 Result (k = 4): ");
        printList(result2);
        // Expected Output: [2 -> 0 -> 1]

        // Test Case 3: Empty list edge case
        ListNode list3 = createList(new int[]{});
        ListNode result3 = new Rotate_List().rotateRight(list3, 5);
        System.out.print("Test 3 Result (Empty): ");
        printList(result3);
        // Expected Output: []

        // Test Case 4: k is an exact multiple of the list length (Should return original list)
        ListNode list4 = createList(new int[]{1, 2});
        ListNode result4 = new Rotate_List().rotateRight(list4, 2);
        System.out.print("Test 4 Result (k = length): ");
        printList(result4);
        // Expected Output: [1 -> 2]
    }
}
