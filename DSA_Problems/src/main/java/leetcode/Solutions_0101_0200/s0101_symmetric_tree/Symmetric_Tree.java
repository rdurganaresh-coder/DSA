package leetcode.Solutions_0101_0200.s0101_symmetric_tree;

// #Easy #Top_100_Liked_Questions #Top_Interview_Questions #Depth_First_Search #Breadth_First_Search
// #Tree #Binary_Tree #Data_Structure_I_Day_11_Tree #Level_2_Day_15_Tree
// #Top_Interview_150_Binary_Tree_General #Big_O_Time_O(N)_Space_O(log(N))
// #2024_11_13_Time_0_ms_(100.00%)_Space_41.4_MB_(83.38%)

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
public class Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null || rightNode == null) {
            return leftNode == null && rightNode == null;
        }
        if (leftNode.val != rightNode.val) {
            return false;
        }
        return helper(leftNode.left, rightNode.right) && helper(leftNode.right, rightNode.left);
    }

    public static void main(String[] args) {
        // Test Case 1: Perfectly symmetric tree (Should output true)
        // Tree structure:     1
        //                   /   \
        //                  2     2
        //                 / \   / \
        //                3   4 4   3
        TreeNode root1 = new TreeNode(1,
            new TreeNode(2, new TreeNode(3), new TreeNode(4)),
            new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );
        boolean result1 = new Symmetric_Tree().isSymmetric(root1);
        System.out.println("Test 1 (Symmetric Tree): " + result1);

        // Test Case 2: Asymmetric values with symmetric shape (Should output false)
        // Tree structure:     1
        //                   /   \
        //                  2     2
        //                   \     \
        //                    3     3
        TreeNode root2 = new TreeNode(1,
            new TreeNode(2, null, new TreeNode(3)),
            new TreeNode(2, null, new TreeNode(3))
        );
        boolean result2 = new Symmetric_Tree().isSymmetric(root2);
        System.out.println("Test 2 (Asymmetric Tree): " + result2);

        // Test Case 3: Empty tree base case configuration (Should output true)
        TreeNode root3 = null;
        boolean result3 = new Symmetric_Tree().isSymmetric(root3);
        System.out.println("Test 3 (Empty Tree): " + result3);

        // Test Case 4: Single root node only (Should output true)
        TreeNode root4 = new TreeNode(1);
        boolean result4 = new Symmetric_Tree().isSymmetric(root4);
        System.out.println("Test 4 (Single Node): " + result4);
    }
}
