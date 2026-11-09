package leetcode.Solutions_0001_0100.s0098_validate_binary_search_tree;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Depth_First_Search #Tree #Binary_Tree
// #Binary_Search_Tree #Data_Structure_I_Day_14_Tree #Level_1_Day_8_Binary_Search_Tree
// #Udemy_Tree_Stack_Queue #Top_Interview_150_Binary_Search_Tree #Big_O_Time_O(N)_Space_O(log(N))
// #2024_11_13_Time_0_ms_(100.00%)_Space_42.9_MB_(95.84%)

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
public class Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // we will send a valid range and check whether the root lies in the range
    // and update the range for the subtrees
    private boolean solve(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }
        if (root.val <= left || root.val >= right) {
            return false;
        }
        return solve(root.left, left, root.val) && solve(root.right, root.val, right);
    }

    public static void main(String[] args) {
        // Test Case 1: Standard valid Binary Search Tree (Should output true)
        // Tree structure:   2
        //                  / \
        //                 1   3
        TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        boolean result1 = new Validate_Binary_Search_Tree().isValidBST(root1);
        System.out.println("Test 1 (Valid BST): " + result1);

        // Test Case 2: Invalid BST due to a out-of-position grandchild node (Should output false)
        // Tree structure:   5
        //                  / \
        //                 1   4
        //                    / \
        //                   3   6
        // Note: 3 is in the right subtree of 5, which violates the BST rule (3 < 5).
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4, new TreeNode(3), new TreeNode(6));
        boolean result2 = new Validate_Binary_Search_Tree().isValidBST(root2);
        System.out.println("Test 2 (Invalid BST): " + result2);

        // Test Case 3: Empty tree base configuration (Should output true)
        TreeNode root3 = null;
        boolean result3 = new Validate_Binary_Search_Tree().isValidBST(root3);
        System.out.println("Test 3 (Empty Tree): " + result3);

        // Test Case 4: Tricky extreme integer boundary values (Should output true)
        // Tree structure: Integer.MAX_VALUE
        //                 /
        //          Integer.MIN_VALUE
        TreeNode root4 = new TreeNode(Integer.MAX_VALUE);
        root4.left = new TreeNode(Integer.MIN_VALUE);
        boolean result4 = new Validate_Binary_Search_Tree().isValidBST(root4);
        System.out.println("Test 4 (Boundary Values): " + result4);
    }
}
