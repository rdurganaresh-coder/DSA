package leetcode.Solutions_0101_0200.s0108_convert_sorted_array_to_binary_search_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// #Easy #Top_100_Liked_Questions #Top_Interview_Questions #Array #Tree #Binary_Tree
// #Binary_Search_Tree #Divide_and_Conquer #Data_Structure_II_Day_15_Tree
// #Level_2_Day_9_Binary_Search_Tree #Udemy_Tree_Stack_Queue #Top_Interview_150_Divide_and_Conquer
// #2025_03_05_Time_0_ms_(100.00%)_Space_43.75_MB_(11.21%)

import leetcode.utils.TreeNode;

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
public class Convert_Sorted_Array_To_Binary_Search_Tree {
    public TreeNode sortedArrayToBST(int[] num) {
        /*1. Set up recursion*/
        return makeTree(num, 0, num.length - 1);
    }

    private TreeNode makeTree(int[] num, int left, int right) {
        /*2. left as lowest# can't be greater than right*/
        if (left > right) {
            return null;
        }
        /*3. Set median# as node*/
        int mid = (left + right) / 2;
        TreeNode midNode = new TreeNode(num[mid]);
        /*4. Set mid node's kids*/
        midNode.left = makeTree(num, left, mid - 1);
        midNode.right = makeTree(num, mid + 1, right);
        /*5. Sends node back || Goes back to prev node*/
        return midNode;
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
        // Test Case 1: Standard sorted array with an odd number of elements
        // Expected balanced BST structural layout: [0, -3, 9, -10, null, 5]
        int[] nums1 = {-10, -3, 0, 5, 9};
        TreeNode result1 = new Convert_Sorted_Array_To_Binary_Search_Tree().sortedArrayToBST(nums1);
        System.out.println("Test 1 Reconstructed Tree: " + levelOrderList(result1));

        // Test Case 2: Even number of elements array
        // Expected balanced BST structural layout: [1, 3] (or [3, 1] depending on floor/ceil rounding choices)
        int[] nums2 = {1, 3};
        TreeNode result2 = new Convert_Sorted_Array_To_Binary_Search_Tree().sortedArrayToBST(nums2);
        System.out.println("Test 2 Reconstructed Tree: " + levelOrderList(result2));

        // Test Case 3: Empty array edge case inputs
        // Expected tree structure: []
        int[] nums3 = {};
        TreeNode result3 = new Convert_Sorted_Array_To_Binary_Search_Tree().sortedArrayToBST(nums3);
        System.out.println("Test 3 Reconstructed Tree: " + levelOrderList(result3));

        // Test Case 4: Single element base case configuration
        // Expected tree structure:
        int[] nums4 = {7};
        TreeNode result4 = new Convert_Sorted_Array_To_Binary_Search_Tree().sortedArrayToBST(nums4);
        System.out.println("Test 4 Reconstructed Tree: " + levelOrderList(result4));
    }
}
