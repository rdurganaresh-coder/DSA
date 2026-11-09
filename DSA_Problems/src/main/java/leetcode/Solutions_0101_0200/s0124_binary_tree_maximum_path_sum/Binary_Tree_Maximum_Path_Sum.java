package leetcode.Solutions_0101_0200.s0124_binary_tree_maximum_path_sum;

// #Hard #Top_100_Liked_Questions #Top_Interview_Questions #Dynamic_Programming #Depth_First_Search
// #Tree #Binary_Tree #Udemy_Tree_Stack_Queue #Top_Interview_150_Binary_Tree_General
// #Big_O_Time_O(N)_Space_O(N) #2024_11_13_Time_0_ms_(100.00%)_Space_44.4_MB_(29.91%)

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
public class Binary_Tree_Maximum_Path_Sum {
    private int max = Integer.MIN_VALUE;

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // to avoid the -ve values in left side we will compare them with 0
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        int current = root.val + left + right;
        if (current > max) {
            max = current;
        }
        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard tree with a mix of positive and negative values
        // Optimal path: 15 -> 20 -> 7 = 42
        TreeNode root1 = new TreeNode(-10);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        
        int result1 = new Binary_Tree_Maximum_Path_Sum().maxPathSum(root1);
        System.out.println("Test 1 Result: " + result1);
        // Expected Output: 42

        // Test Case 2: Minimal tree configuration
        // Optimal path: 2 -> 1 -> 3 = 6
        TreeNode root2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        int result2 = new Binary_Tree_Maximum_Path_Sum().maxPathSum(root2);
        System.out.println("Test 2 Result: " + result2);
        // Expected Output: 6

        // Test Case 3: Tree comprised completely of negative values
        // Optimal path: -1 (the single largest element)
        TreeNode root3 = new TreeNode(-3, new TreeNode(-1), new TreeNode(-2));
        int result3 = new Binary_Tree_Maximum_Path_Sum().maxPathSum(root3);
        System.out.println("Test 3 Result (All Negative): " + result3);
        // Expected Output: -1

        // Test Case 4: Single element base case tree configuration
        TreeNode root4 = new TreeNode(5);
        int result4 = new Binary_Tree_Maximum_Path_Sum().maxPathSum(root4);
        System.out.println("Test 4 Result (Single Node): " + result4);
        // Expected Output: 5
    }
}
