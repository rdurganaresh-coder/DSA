package leetcode.Solutions_0101_0200.s0145_binary_tree_postorder_traversal;

// #Easy #Depth_First_Search #Tree #Binary_Tree #Stack #Data_Structure_I_Day_10_Tree
// #Udemy_Tree_Stack_Queue #2022_06_24_Time_1_ms_(49.11%)_Space_42_MB_(62.15%)

import leetcode.utils.TreeNode;
import java.util.ArrayList;
import java.util.List;

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
public class Binary_Tree_Postorder_Traversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = postorderTraversal(root.left);
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);
        return res;
    }

    // --- Main Method Executing Test Cases ---
    public static void main(String[] args) {
        Binary_Tree_Postorder_Traversal treeTraversal = new Binary_Tree_Postorder_Traversal();

        System.out.println("--- Running Postorder Traversal Tests ---\n");

        // Test Case 1: Empty Tree
        // Input: null
        System.out.println("Test 1 (Empty Tree):");
        System.out.println("Expected: []");
        System.out.println("Actual:   " + treeTraversal.postorderTraversal(null) + "\n");

        // Test Case 2: Single Node Tree
        // Input: 1
        System.out.println("Test 2 (Single Node):");
        TreeNode root2 = new TreeNode(1);
        System.out.println("Expected: [1]");
        System.out.println("Actual:   " + treeTraversal.postorderTraversal(root2) + "\n");

        // Test Case 3: Standard Binary Tree
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        System.out.println("Test 3 (Standard Tree):");
        TreeNode root3 = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3)
        );
        System.out.println("Expected: [4, 5, 2, 3, 1]");
        System.out.println("Actual:   " + treeTraversal.postorderTraversal(root3) + "\n");

        // Test Case 4: Left-Skewed Tree
        //      1
        //     /
        //    2
        //   /
        //  3
        System.out.println("Test 4 (Left-Skewed Tree):");
        TreeNode root4 = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        System.out.println("Expected: [3, 2, 1]");
        System.out.println("Actual:   " + treeTraversal.postorderTraversal(root4) + "\n");

        // Test Case 5: Right-Skewed Tree
        //  1
        //   \
        //    2
        //     \
        //      3
        System.out.println("Test 5 (Right-Skewed Tree):");
        TreeNode root5 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        System.out.println("Expected: [3, 2, 1]");
        System.out.println("Actual:   " + treeTraversal.postorderTraversal(root5) + "\n");
    }
}
