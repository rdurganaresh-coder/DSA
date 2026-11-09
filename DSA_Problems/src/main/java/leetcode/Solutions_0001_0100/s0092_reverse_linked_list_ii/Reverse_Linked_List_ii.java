package leetcode.Solutions_0001_0100.s0092_reverse_linked_list_ii;

// #Medium #Linked_List #Top_Interview_150_Linked_List
// #2025_03_05_Time_0_ms_(100.00%)_Space_41.36_MB_(51.54%)

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
public class Reverse_Linked_List_ii {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode prev = null;
        ListNode temp = head;
        ListNode start;
        int k = left;
        while (temp != null && k > 1) {
            prev = temp;
            temp = temp.next;
            k--;
        }
        if (left > 1 && prev != null) {
            prev.next = null;
        }
        ListNode prev1 = null;
        start = temp;
        while (temp != null && right - left >= 0) {
            prev1 = temp;
            temp = temp.next;
            right--;
        }
        if (prev1 != null) {
            prev1.next = null;
        }
        if (left > 1 && prev != null) {
            prev.next = reverse(start);
        } else {
            head = reverse(start);
            prev = head;
        }
        while (prev.next != null) {
            prev = prev.next;
        }
        prev.next = temp;
        return head;
    }

    public ListNode reverse(ListNode head) {
        ListNode p;
        ListNode q;
        ListNode r = null;
        p = head;
        while (p != null) {
            q = p.next;
            p.next = r;
            r = p;
            p = q;
        }
        return r;
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
        // Test Case 1: Standard middle partial inversion
        ListNode list1 = createList(new int[]{1, 2, 3, 4, 5});
        ListNode result1 = new Reverse_Linked_List_ii().reverseBetween(list1, 2, 4);
        System.out.print("Test 1 (middle inversion 2 to 4): ");
        printList(result1);
        // Expected Output: [1 -> 4 -> 3 -> 2 -> 5]

        // Test Case 2: Inverting from the very beginning (left = 1)
        ListNode list2 = createList(new int[]{1, 2, 3, 4, 5});
        ListNode result2 = new Reverse_Linked_List_ii().reverseBetween(list2, 1, 3);
        System.out.print("Test 2 (inversion from start 1 to 3): ");
        printList(result2);
        // Expected Output: [3 -> 2 -> 1 -> 4 -> 5]

        // Test Case 3: Complete list inversion (left = 1, right = length)
        ListNode list3 = createList(new int[]{1, 2, 3, 4, 5});
        ListNode result3 = new Reverse_Linked_List_ii().reverseBetween(list3, 1, 5);
        System.out.print("Test 3 (full list inversion 1 to 5): ");
        printList(result3);
        // Expected Output: [5 -> 4 -> 3 -> 2 -> 1]

        // Test Case 4: No-op edge case where left == right
        ListNode list4 = createList(new int[]{1, 2, 3});
        ListNode result4 = new Reverse_Linked_List_ii().reverseBetween(list4, 2, 2);
        System.out.print("Test 4 (no-op boundary 2 to 2): ");
        printList(result4);
        // Expected Output: [1 -> 2 -> 3]
    }
}
