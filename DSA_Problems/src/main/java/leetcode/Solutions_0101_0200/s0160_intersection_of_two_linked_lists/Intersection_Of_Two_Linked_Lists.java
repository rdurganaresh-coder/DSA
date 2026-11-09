package leetcode.Solutions_0101_0200.s0160_intersection_of_two_linked_lists;

// #Easy #Top_100_Liked_Questions #Top_Interview_Questions #Hash_Table #Two_Pointers #Linked_List
// #Data_Structure_II_Day_11_Linked_List #Udemy_Linked_List #Big_O_Time_O(M+N)_Space_O(1)
// #2024_11_15_Time_1_ms_(99.92%)_Space_48.4_MB_(68.45%)

import leetcode.utils.ListNode;

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
@SuppressWarnings("java:S2583")
public class Intersection_Of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;
        }
        return node1;
    }
    // --- Helper Utilities for Testing ---
    private static ListNode createChain(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // --- Main Method Executing Test Cases ---
    public static void main(String[] args) {
        Intersection_Of_Two_Linked_Lists solver = new Intersection_Of_Two_Linked_Lists();

        System.out.println("--- Running Intersection of Two Linked Lists Tests ---\n");

        // ==========================================
        // Test Case 1: Intersecting Lists (Different Length Before Intersection)
        // List A: 4 -> 1 -> 8 -> 4 -> 5
        // List B: 5 -> 6 -> 1 -> 8 -> 4 -> 5
        // Intersecting Node Value: 8
        // ==========================================
        ListNode common1 = createChain(new int[]{8, 4, 5}); // Fixed: Added []
        
        ListNode headA1 = createChain(new int[]{4, 1});     // Fixed: Added []
        headA1.next.next = common1;
        
        ListNode headB1 = createChain(new int[]{5, 6, 1});  // Fixed: Added []
        headB1.next.next.next = common1;

        ListNode result1 = solver.getIntersectionNode(headA1, headB1);
        System.out.print("Test 1 (Standard Intersection): ");
        System.out.println("Expected: 8 -> Actual: " + (result1 != null ? result1.val : "null"));


        // ==========================================
        // Test Case 2: No Intersection
        // List A: 2 -> 6 -> 4
        // List B: 1 -> 5
        // Intersecting Node Value: null
        // ==========================================
        ListNode headA2 = createChain(new int[]{2, 6, 4});  // Fixed: Added []
        ListNode headB2 = createChain(new int[]{1, 5});     // Fixed: Added []

        ListNode result2 = solver.getIntersectionNode(headA2, headB2);
        System.out.print("Test 2 (No Intersection):       ");
        System.out.println("Expected: null -> Actual: " + (result2 != null ? result2.val : "null"));


        // ==========================================
        // Test Case 3: Complete Overlap (Same Head Node)
        // List A & B: 1 -> 2 -> 3
        // Intersecting Node Value: 1
        // ==========================================
        ListNode headA3 = createChain(new int[]{1, 2, 3});  // Fixed: Added []
        ListNode headB3 = headA3;

        ListNode result3 = solver.getIntersectionNode(headA3, headB3);
        System.out.print("Test 3 (Complete Overlap):      ");
        System.out.println("Expected: 1 -> Actual: " + (result3 != null ? result3.val : "null"));


        // ==========================================
        // Test Case 4: One List is Empty
        // List A: null
        // List B: 1 -> 2
        // Intersecting Node Value: null
        // ==========================================
        ListNode headA4 = null;
        ListNode headB4 = createChain(new int[]{1, 2});     // Fixed: Added []

        ListNode result4 = solver.getIntersectionNode(headA4, headB4);
        System.out.print("Test 4 (Empty List Edge Case):  ");
        System.out.println("Expected: null -> Actual: " + (result4 != null ? result4.val : "null"));
    }
}
