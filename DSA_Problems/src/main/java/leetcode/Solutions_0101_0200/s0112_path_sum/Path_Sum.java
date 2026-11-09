package leetcode.Solutions_0101_0200.s0112_path_sum;

// #Easy #Depth_First_Search #Breadth_First_Search #Tree #Binary_Tree #Data_Structure_I_Day_12_Tree
// #Top_Interview_150_Binary_Tree_General #2025_03_06_Time_0_ms_(100.00%)_Space_43.07_MB_(76.46%)

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
public class Path_Sum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (sum == root.val && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        // Test Case 1: Standard multi-level tree with a matching target path sum (Should output true)
        // Tree structure:        5
        //                       / \
        //                      4   8
        //                     /   / \
        //                    11  13  4
        //                   /  \      \
        //                  7    2      1
        // Target Sum: 22 -> Valid root-to-leaf path: 5 -> 4 -> 11 -> 2
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null);
        root1.right = new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)));
        
        boolean result1 = new Path_Sum().hasPathSum(root1, 22);
        System.out.println("Test 1 (Target 22): " + result1);

        // Test Case 2: Sum matches a path that terminates early at a non-leaf node (Should output false)
        // Tree structure:   1
        //                  /
        //                 2
        // Target Sum: 1 -> Even though root value matches 1, it is not a leaf node.
        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);
        boolean result2 = new Path_Sum().hasPathSum(root2, 1);
        System.out.println("Test 2 (Target 1):  " + result2);

        // Test Case 3: Empty tree edge case (Should output false)
        TreeNode root3 = null;
        boolean result3 = new Path_Sum().hasPathSum(root3, 0);
        System.out.println("Test 3 (Empty Tree): " + result3);

        // Test Case 4: Tree containing negative values (Should output true)
        // Tree structure:   -2
        //                     \
        //                     -3
        // Target Sum: -5 -> Valid root-to-leaf path: -2 -> -3
        TreeNode root4 = new TreeNode(-2, null, new TreeNode(-3));
        boolean result4 = new Path_Sum().hasPathSum(root4, -5);
        System.out.println("Test 4 (Target -5): " + result4);
    }
}
