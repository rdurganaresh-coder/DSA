package leetcode.Solutions_0101_0200.s0129_sum_root_to_leaf_numbers;

// #Medium #Depth_First_Search #Tree #Binary_Tree #Top_Interview_150_Binary_Tree_General
// #2025_03_06_Time_0_ms_(100.00%)_Space_41.47_MB_(30.87%)

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
public class Sum_Root_To_Leaf_Numbers {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        recurseSum(root, 0);
        return sum;
    }

    private void recurseSum(TreeNode node, int curNum) {
        if (node.left == null && node.right == null) {
            sum += 10 * curNum + node.val;
        } else {
            if (node.left != null) {
                recurseSum(node.left, 10 * curNum + node.val);
            }
            if (node.right != null) {
                recurseSum(node.right, 10 * curNum + node.val);
            }
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Standard small tree layout
        // Paths: 1 -> 2 (12) and 1 -> 3 (13). Sum = 12 + 13 = 25
        TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        int result1 = new Sum_Root_To_Leaf_Numbers().sumNumbers(root1);
        System.out.println("Test 1 Result: " + result1);
        // Expected Output: 25

        // Test Case 2: Multi-level complete tree layout
        // Paths: 4->9->5 (495) and 4->9->1 (491) and 4->0 (40). Sum = 495 + 491 + 40 = 1026
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(9, new TreeNode(5), new TreeNode(1));
        root2.right = new TreeNode(0);
        int result2 = new Sum_Root_To_Leaf_Numbers().sumNumbers(root2);
        System.out.println("Test 2 Result: " + result2);
        // Expected Output: 1026

        // Test Case 3: Empty tree edge case (root is null)
        TreeNode root3 = null;
        int result3 = new Sum_Root_To_Leaf_Numbers().sumNumbers(root3);
        System.out.println("Test 3 Result (Empty): " + result3);
        // Expected Output: 0

        // Test Case 4: Single root node configuration base case
        TreeNode root4 = new TreeNode(7);
        int result4 = new Sum_Root_To_Leaf_Numbers().sumNumbers(root4);
        System.out.println("Test 4 Result (Single): " + result4);
        // Expected Output: 7
    }
}
