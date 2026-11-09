package leetcode.Solutions_0101_0200.s0144_binary_tree_preorder_traversal;

// #Easy #Depth_First_Search #Tree #Binary_Tree #Stack #Data_Structure_I_Day_10_Tree
// #Udemy_Tree_Stack_Queue #2022_06_24_Time_1_ms_(48.38%)_Space_42_MB_(68.46%)

import leetcode.utils.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
@SuppressWarnings("java:S1149")
public class Binary_Tree_Preorder_Traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                result.add(current.val);
                stack.push(current.right);
                current = current.left;
            }
            current = stack.pop();
        }
        return result;
    }

    // --- Main Method Executing Test Cases ---
    public static void main(String[] args) {
        Binary_Tree_Preorder_Traversal treeTraversal = new Binary_Tree_Preorder_Traversal();

        System.out.println("--- Running Preorder Traversal Tests ---\n");

        // Test Case 1: Empty Tree
        // Input: null
        System.out.println("Test 1 (Empty Tree):");
        System.out.println("Expected: []");
        System.out.println("Actual:   " + treeTraversal.preorderTraversal(null) + "\n");

        // Test Case 2: Single Node Tree
        // Input: [1]
        System.out.println("Test 2 (Single Node):");
        TreeNode root2 = new TreeNode(1);
        System.out.println("Expected: [1]");
        System.out.println("Actual:   " + treeTraversal.preorderTraversal(root2) + "\n");

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
        System.out.println("Expected: [1, 2, 4, 5, 3]");
        System.out.println("Actual:   " + treeTraversal.preorderTraversal(root3) + "\n");

        // Test Case 4: Left-Skewed Tree
        //      1
        //     /
        //    2
        //   /
        //  3
        System.out.println("Test 4 (Left-Skewed Tree):");
        TreeNode root4 = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        System.out.println("Expected: [1, 2, 3]");
        System.out.println("Actual:   " + treeTraversal.preorderTraversal(root4) + "\n");

        // Test Case 5: Right-Skewed Tree
        //  1
        //   \
        //    2
        //     \
        //      3
        System.out.println("Test 5 (Right-Skewed Tree):");
        TreeNode root5 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        System.out.println("Expected: [1, 2, 3]");
        System.out.println("Actual:   " + treeTraversal.preorderTraversal(root5) + "\n");
    }
}
