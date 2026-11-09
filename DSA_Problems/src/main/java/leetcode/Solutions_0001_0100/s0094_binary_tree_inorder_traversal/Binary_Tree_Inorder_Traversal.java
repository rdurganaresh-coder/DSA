package leetcode.Solutions_0001_0100.s0094_binary_tree_inorder_traversal;

// #Easy #Top_100_Liked_Questions #Top_Interview_Questions #Depth_First_Search #Tree #Binary_Tree
// #Stack #Data_Structure_I_Day_10_Tree #Udemy_Tree_Stack_Queue #Big_O_Time_O(n)_Space_O(n)
// #2024_11_13_Time_0_ms_(100.00%)_Space_41.6_MB_(47.93%)

import leetcode.utils.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
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
public class Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> answer = new ArrayList<>();
        inorderTraversal(root, answer);
        return answer;
    }

    public void inorderTraversal(TreeNode root, List<Integer> answer) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorderTraversal(root.left, answer);
        }
        answer.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right, answer);
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Standard skewed tree configuration
        // Tree structure: 1
        //                  \
        //                   2
        //                  /
        //                 3
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        
        List<Integer> result1 = new Binary_Tree_Inorder_Traversal().inorderTraversal(root1);
        System.out.println("Test 1 Result: " + result1);
        // Expected Output: [1, 3, 2]

        // Test Case 2: Full balanced binary tree
        // Tree structure:     4
        //                   /   \
        //                  2     6
        //                 / \   / \
        //                1   3 5   7
        TreeNode root2 = new TreeNode(4,
            new TreeNode(2, new TreeNode(1), new TreeNode(3)),
            new TreeNode(6, new TreeNode(5), new TreeNode(7))
        );
        
        List<Integer> result2 = new Binary_Tree_Inorder_Traversal().inorderTraversal(root2);
        System.out.println("Test 2 Result: " + result2);
        // Expected Output: [1, 2, 3, 4, 5, 6, 7]

        // Test Case 3: Empty tree edge case (root is null)
        TreeNode root3 = null;
        List<Integer> result3 = new Binary_Tree_Inorder_Traversal().inorderTraversal(root3);
        System.out.println("Test 3 Result (Empty): " + result3);
        // Expected Output: []

        // Test Case 4: Single element base node tree
        TreeNode root4 = new TreeNode(1);
        List<Integer> result4 = new Binary_Tree_Inorder_Traversal().inorderTraversal(root4);
        System.out.println("Test 4 Result (Single Node): " + result4);
        // Expected Output: [1]
    }
}
