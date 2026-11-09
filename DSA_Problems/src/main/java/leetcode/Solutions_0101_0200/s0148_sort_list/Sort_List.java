package leetcode.Solutions_0101_0200.s0148_sort_list;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Sorting #Two_Pointers #Linked_List
// #Divide_and_Conquer #Merge_Sort #Level_2_Day_4_Linked_List #Top_Interview_150_Divide_and_Conquer
// #Big_O_Time_O(log(N))_Space_O(log(N)) #2024_11_15_Time_9_ms_(93.90%)_Space_56.9_MB_(37.47%)

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
@SuppressWarnings("java:S135")
public class Sort_List {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = slow;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode first = sortList(head);
        ListNode second = sortList(slow);
        ListNode res = new ListNode(1);
        ListNode cur = res;
        while (first != null || second != null) {
            if (first == null) {
                cur.next = second;
                break;
            } else if (second == null) {
                cur.next = first;
                break;
            } else if (first.val <= second.val) {
                cur.next = first;
                first = first.next;
                cur = cur.next;
            } else {
                cur.next = second;
                second = second.next;
                cur = cur.next;
            }
        }
        return res.next;
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
        Sort_List sorter = new Sort_List();

        System.out.println("--- Running Merge Sort List Tests ---\n");

        // Test Case 1: Empty List
        System.out.print("Test 1 (Empty): Expected: [] -> Actual: ");
        ListNode head1 = createList(new int[]{});
        ListNode res1 = sorter.sortList(head1);
        printList(res1);

        // Test Case 2: Single Element List
        System.out.print("Test 2 (Single): Input: 5 -> Expected: 5 -> Actual: ");
        ListNode head2 = createList(new int[]{5});
        ListNode res2 = sorter.sortList(head2);
        printList(res2);

        // Test Case 3: Standard Unsorted List
        System.out.print("Test 3 (Unsorted): Input: 4 -> 2 -> 1 -> 3 -> Expected: 1 -> 2 -> 3 -> 4 -> Actual: ");
        ListNode head3 = createList(new int[]{4, 2, 1, 3});
        ListNode res3 = sorter.sortList(head3);
        printList(res3);

        // Test Case 4: List with Negatives & Mixed Order
        System.out.print("Test 4 (Negatives): Input: -1 -> 5 -> 3 -> 4 -> 0 -> Expected: -1 -> 0 -> 3 -> 4 -> 5 -> Actual: ");
        ListNode head4 = createList(new int[]{-1, 5, 3, 4, 0});
        ListNode res4 = sorter.sortList(head4);
        printList(res4);

        // Test Case 5: Duplicate Values
        System.out.print("Test 5 (Duplicates): Input: 2 -> 1 -> 3 -> 2 -> Expected: 1 -> 2 -> 2 -> 3 -> Actual: ");
        ListNode head5 = createList(new int[]{2, 1, 3, 2});
        ListNode res5 = sorter.sortList(head5);
        printList(res5);
    }
}
