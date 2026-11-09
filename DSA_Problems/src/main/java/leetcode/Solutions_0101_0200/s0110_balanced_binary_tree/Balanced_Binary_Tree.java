package leetcode.Solutions_0101_0200.s0110_balanced_binary_tree;

// #Easy #Depth_First_Search #Tree #Binary_Tree #Programming_Skills_II_Day_2 #Level_2_Day_6_Tree
// #Udemy_Tree_Stack_Queue #2022_06_22_Time_1_ms_(98.82%)_Space_44.8_MB_(19.20%)

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
public class Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        // Empty Tree is balanced
        if (root == null) {
            return true;
        }
        // Get max height of subtree child
        // Get max height of subtree child
        // compare height difference (cannot be more than 1)
        int leftHeight = 0;
        int rightHeight = 0;
        if (root.left != null) {
            leftHeight = getMaxHeight(root.left);
        }
        if (root.right != null) {
            rightHeight = getMaxHeight(root.right);
        }
        int heightDiff = Math.abs(leftHeight - rightHeight);
        // if passes height check
        //  - Check if left subtree is balanced and if the right subtree is balanced
        //  - If one of both are imbalanced, then the tree is imbalanced
        return heightDiff <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getMaxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = 0;
        int rightHeight = 0;
        // Left
        if (root.left != null) {
            leftHeight = getMaxHeight(root.left);
        }
        // Right
        if (root.right != null) {
            rightHeight = getMaxHeight(root.right);
        }
        if (leftHeight > rightHeight) {
            return 1 + leftHeight;
        } else {
            return 1 + rightHeight;
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Perfectly balanced binary tree (Should output true)
        // Tree structure:     3
        //                   /   \
        //                  9    20
        //                      /  \
        //                     15   7
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        boolean result1 = new Balanced_Binary_Tree().isBalanced(root1);
        System.out.println("Test 1 (Balanced Tree): " + result1);

        // Test Case 2: Highly imbalanced tree structure (Should output false)
        // Tree structure:       1
        //                      / \
        //                     2   2
        //                    / \
        //                   3   3
        //                  / \
        //                 4   4
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3));
        root2.right = new TreeNode(2);
        boolean result2 = new Balanced_Binary_Tree().isBalanced(root2);
        System.out.println("Test 2 (Imbalanced Tree): " + result2);

        // Test Case 3: Empty tree boundary case configuration (Should output true)
        TreeNode root3 = null;
        boolean result3 = new Balanced_Binary_Tree().isBalanced(root3);
        System.out.println("Test 3 (Empty Tree): " + result3);

        // Test Case 4: Single root node base case (Should output true)
        TreeNode root4 = new TreeNode(1);
        boolean result4 = new Balanced_Binary_Tree().isBalanced(root4);
        System.out.println("Test 4 (Single Node): " + result4);
    }
}
