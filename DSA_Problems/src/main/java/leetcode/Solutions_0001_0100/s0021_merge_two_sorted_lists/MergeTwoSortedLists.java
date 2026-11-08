package leetcode.Solutions_0001_0100.s0021_merge_two_sorted_lists;

import java.util.Arrays;
import leetcode.utils.LinkedListUtils;
import leetcode.utils.ListNode;

// #Easy #Top_100_Liked_Questions #Top_Interview_Questions #Linked_List #Recursion
// #Data_Structure_I_Day_7_Linked_List #Algorithm_I_Day_10_Recursion_Backtracking
// #Level_1_Day_3_Linked_List #Udemy_Linked_List #Top_Interview_150_Linked_List
// #Big_O_Time_O(m+n)_Space_O(m+n) #2024_11_09_Time_0_ms_(100.00%)_Space_43_MB_(5.04%)



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
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(-1);
        ListNode head = list;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    list.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    list.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            } else if (l1 != null) {
                list.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                list.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            list = list.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = LinkedListUtils.createSinglyLinkedList(Arrays.asList(1, 2, 4));
        ListNode l2 = LinkedListUtils.createSinglyLinkedList(Arrays.asList(1, 3, 4));
        
        ListNode result = mergeTwoLists(l1, l2);
        
        // Static Console Output: "1, 1, 2, 3, 4, 4"
        System.out.println("Merged List 1: " + (result != null ? result.toString() : "null"));

        // LeetCode represents empty lists as literal null references
        ListNode l3 = null;
        ListNode l4 = null;
        
        ListNode result2 = mergeTwoLists(l3, l4);
        
        // Fixed a small bug here: updated "result" to "result2" so it prints the empty list result correctly
        System.out.println("Merged List 2: " + (result2 != null ? result2.toString() : "null"));

        ListNode l5 = null;
        ListNode l6 = LinkedListUtils.createSinglyLinkedList(Arrays.asList(0));
        ListNode result3 = mergeTwoLists(l5, l6);
        System.out.println("Merged List 3: " + (result3 != null ? result3.toString() : "null"));
    }
    
}


