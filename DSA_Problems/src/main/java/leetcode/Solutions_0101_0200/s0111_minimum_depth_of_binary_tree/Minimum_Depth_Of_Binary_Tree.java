package leetcode.Solutions_0101_0200.s0111_minimum_depth_of_binary_tree;

// #Easy #Depth_First_Search #Breadth_First_Search #Tree #Binary_Tree #Udemy_Tree_Stack_Queue
// #2022_06_23_Time_1_ms_(97.49%)_Space_97_MB_(5.22%)

import leetcode.utils.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

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
public class Minimum_Depth_Of_Binary_Tree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int d = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left == null && current.right == null && d > 0) {
                    return d + 1;
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
            }
            d++;
        }
        return d;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard multi-level tree with mixed child nodes
        // Tree structure:     3
        //                   /   \
        //                  9    20
        //                      /  \
        //                     15   7
        // Leaf '9' is at depth 2 (Shallowest leaf node)
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        int result1 = new Minimum_Depth_Of_Binary_Tree().minDepth(root1);
        System.out.println("Test 1 Result: " + result1);
        // Expected Output: 2

        // Test Case 2: Highly skewed single-branch tree (Unbalanced)
        // Tree structure:   2
        //                    \
        //                     3
        //                      \
        //                       4
        //                        \
        //                         5
        // Root '2' is NOT a leaf node because it has a right child.
        TreeNode root2 = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5))));
        int result2 = new Minimum_Depth_Of_Binary_Tree().minDepth(root2);
        System.out.println("Test 2 Result: " + result2);
        // Expected Output: 4

        // Test Case 3: Empty tree edge case (root is null)
        TreeNode root3 = null;
        int result3 = new Minimum_Depth_Of_Binary_Tree().minDepth(root3);
        System.out.println("Test 3 Result (Empty): " + result3);
        // Expected Output: 0

        // Test Case 4: Single root node configuration base case
        TreeNode root4 = new TreeNode(1);
        int result4 = new Minimum_Depth_Of_Binary_Tree().minDepth(root4);
        System.out.println("Test 4 Result (Single Node): " + result4);
        // Expected Output: 1
    }
}
