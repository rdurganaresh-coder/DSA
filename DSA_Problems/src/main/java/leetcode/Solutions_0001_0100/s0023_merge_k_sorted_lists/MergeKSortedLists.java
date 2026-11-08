package leetcode.Solutions_0001_0100.s0023_merge_k_sorted_lists;

import java.util.Arrays;

import leetcode.utils.LinkedListUtils;

// #Hard #Top_100_Liked_Questions #Top_Interview_Questions #Heap_Priority_Queue #Linked_List
// #Divide_and_Conquer #Merge_Sort #Top_Interview_150_Divide_and_Conquer
// #Big_O_Time_O(k*n*log(k))_Space_O(log(k)) #2024_11_10_Time_1_ms_(99.86%)_Space_44.1_MB_(79.93%)

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
public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length);
    }

    private static ListNode mergeKLists(ListNode[] lists, int leftIndex, int rightIndex) {
        if (rightIndex > leftIndex + 1) {
            int mid = (leftIndex + rightIndex) / 2;
            ListNode left = mergeKLists(lists, leftIndex, mid);
            ListNode right = mergeKLists(lists, mid, rightIndex);
            return mergeTwoLists(left, right);
        } else {
            return lists[leftIndex];
        }
    }

    private static ListNode mergeTwoLists(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        ListNode res;
        if (left.val <= right.val) {
            res = left;
            left = left.next;
        } else {
            res = right;
            right = right.next;
        }
        ListNode node = res;
        while (left != null || right != null) {
            if (left == null) {
                node.next = right;
                right = right.next;
            } else if (right == null) {
                node.next = left;
                left = left.next;
            } else {
                if (left.val <= right.val) {
                    node.next = left;
                    left = left.next;
                } else {
                    node.next = right;
                    right = right.next;
                }
            }
            node = node.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head1 = LinkedListUtils.createSinglyLinkedList(Arrays.asList(1, 4, 5));
        ListNode head2 = LinkedListUtils.createSinglyLinkedList(Arrays.asList(1, 3, 4));
        ListNode head3 = LinkedListUtils.createSinglyLinkedList(Arrays.asList(2, 6));
        String result1 = mergeKLists(new ListNode[] {head1, head2, head3}).toString();
        // Prints: 1, 1, 2, 3, 4, 4, 5, 6
        System.out.println("Merged K-Lists 1: " + (result1 != null ? result1.toString() : "null"));

    
        ListNode head4 = LinkedListUtils.createSinglyLinkedList(Arrays.asList(1, 3, 5, 7, 11));
        ListNode head5 = LinkedListUtils.createSinglyLinkedList(Arrays.asList(2, 8, 12));
        ListNode head6 = LinkedListUtils.createSinglyLinkedList(Arrays.asList(4, 6, 9, 10));
        String result2 =mergeKLists(new ListNode[] {head4, head5, head6}).toString();
        // Prints: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
        System.out.println("Merged K-Lists 2: " + (result2 != null ? result2.toString() : "null"));
    }
}
