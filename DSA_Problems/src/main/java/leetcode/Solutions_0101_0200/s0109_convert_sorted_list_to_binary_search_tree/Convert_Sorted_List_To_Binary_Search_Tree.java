package leetcode.Solutions_0101_0200.s0109_convert_sorted_list_to_binary_search_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// #Medium #Tree #Binary_Tree #Linked_List #Binary_Search_Tree #Divide_and_Conquer
// #2022_06_22_Time_1_ms_(87.04%)_Space_47.1_MB_(55.77%)

import leetcode.utils.ListNode;
import leetcode.utils.TreeNode;

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
/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Convert_Sorted_List_To_Binary_Search_Tree {
    public TreeNode sortedListToBST(ListNode head) {
        // Empty list -> empty tree / sub-tree
        if (head == null) {
            return null;
        }
        // No next node -> this node will become leaf
        if (head.next == null) {
            TreeNode leaf = new TreeNode(head.val);
            leaf.left = null;
            leaf.right = null;
            return leaf;
        }
        ListNode slow = head;
        // Head-Start fast by 1 to get slow = mid -1
        ListNode fast = head.next.next;
        // Find the mid of list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow.next ->  mid = our "root"
        TreeNode root = new TreeNode(slow.next.val);
        // Right sub tree from mid - end
        root.right = sortedListToBST(slow.next.next);
        // Left sub tree from head - mid (chop slow.next)
        slow.next = null;
        root.left = sortedListToBST(head);
        return root;
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

    // Helper method to convert tree to a list structure for verification
    private static List<Integer> levelOrderList(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                result.add(current.val);
                queue.add(current.left);
                queue.add(current.right);
            } else {
                result.add(null);
            }
        }
        // Clean up trailing nulls for aesthetic output
        while (!result.isEmpty() && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard sorted list with an odd number of elements
        ListNode list1 = createList(new int[]{-10, -3, 0, 5, 9});
        TreeNode result1 = new Convert_Sorted_List_To_Binary_Search_Tree().sortedListToBST(list1);
        System.out.println("Test 1 Reconstructed Tree: " + levelOrderList(result1));
        // Expected balanced BST layout: [0, -3, 9, -10, null, 5]

        // Test Case 2: Even number of elements list
        ListNode list2 = createList(new int[]{1, 3});
        TreeNode result2 = new Convert_Sorted_List_To_Binary_Search_Tree().sortedListToBST(list2);
        System.out.println("Test 2 Reconstructed Tree: " + levelOrderList(result2));
        // Expected balanced BST layout: [3, 1]

        // Test Case 3: Empty list edge case input
        ListNode list3 = createList(new int[]{});
        TreeNode result3 = new Convert_Sorted_List_To_Binary_Search_Tree().sortedListToBST(list3);
        System.out.println("Test 3 Reconstructed Tree: " + levelOrderList(result3));
        // Expected: []

        // Test Case 4: Single element base case configuration
        ListNode list4 = createList(new int[]{7});
        TreeNode result4 = new Convert_Sorted_List_To_Binary_Search_Tree().sortedListToBST(list4);
        System.out.println("Test 4 Reconstructed Tree: " + levelOrderList(result4));
        // Expected: [7]
    }
}
