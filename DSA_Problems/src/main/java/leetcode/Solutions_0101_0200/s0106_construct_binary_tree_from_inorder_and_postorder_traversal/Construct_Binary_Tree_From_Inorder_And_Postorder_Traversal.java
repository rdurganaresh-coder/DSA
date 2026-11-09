package leetcode.Solutions_0101_0200.s0106_construct_binary_tree_from_inorder_and_postorder_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// #Medium #Array #Hash_Table #Tree #Binary_Tree #Divide_and_Conquer
// #Top_Interview_150_Binary_Tree_General #2025_03_05_Time_0_ms_(100.00%)_Space_45.01_MB_(8.73%)

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
public class Construct_Binary_Tree_From_Inorder_And_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] inIndex = new int[] {inorder.length - 1};
        int[] postIndex = new int[] {postorder.length - 1};
        return helper(inorder, postorder, inIndex, postIndex, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] in, int[] post, int[] index, int[] pIndex, int target) {
        if (index[0] < 0 || in[index[0]] == target) {
            return null;
        }
        TreeNode root = new TreeNode(post[pIndex[0]--]);
        root.right = helper(in, post, index, pIndex, root.val);
        index[0]--;
        root.left = helper(in, post, index, pIndex, target);
        return root;
    }

    // Helper method to convert tree to a list structure for verification
    private static List<Integer> levelOrderList(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                result.add(current.val);
                queue.add(current.left);
                queue.add(current.right);
            } else {
                result.add(null);
            }
        }
        // Clean up trailing nulls for readable output
        while (!result.isEmpty() && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard multi-level binary tree configuration
        // Expected tree structure: [3, 9, 20, null, null, 15, 7]
        int[] inorder1 = {9, 3, 15, 20, 7};
        int[] postorder1 = {9, 15, 7, 20, 3};
        TreeNode result1 = new Construct_Binary_Tree_From_Inorder_And_Postorder_Traversal().buildTree(inorder1, postorder1);
        System.out.println("Test 1 Reconstructed Tree: " + levelOrderList(result1));

        // Test Case 2: Minimal single node configuration
        // Expected tree structure:
        int[] inorder2 = {1};
        int[] postorder2 = {1};
        TreeNode result2 = new Construct_Binary_Tree_From_Inorder_And_Postorder_Traversal().buildTree(inorder2, postorder2);
        System.out.println("Test 2 Reconstructed Tree: " + levelOrderList(result2));

        // Test Case 3: Empty array edge case inputs
        // Expected tree structure: []
        int[] inorder3 = {};
        int[] postorder3 = {};
        TreeNode result3 = new Construct_Binary_Tree_From_Inorder_And_Postorder_Traversal().buildTree(inorder3, postorder3);
        System.out.println("Test 3 Reconstructed Tree: " + levelOrderList(result3));

        // Test Case 4: Strictly right-skewed tree
        // Expected tree structure: [1, null, 2, null, 3]
        int[] inorder4 = {1, 2, 3};
        int[] postorder4 = {3, 2, 1};
        TreeNode result4 = new Construct_Binary_Tree_From_Inorder_And_Postorder_Traversal().buildTree(inorder4, postorder4);
        System.out.println("Test 4 Reconstructed Tree: " + levelOrderList(result4));
    }
}
