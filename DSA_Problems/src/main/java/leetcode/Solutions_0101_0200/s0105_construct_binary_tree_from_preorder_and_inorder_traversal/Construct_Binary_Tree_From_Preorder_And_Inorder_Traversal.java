package leetcode.Solutions_0101_0200.s0105_construct_binary_tree_from_preorder_and_inorder_traversal;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Array #Hash_Table #Tree #Binary_Tree
// #Divide_and_Conquer #Data_Structure_II_Day_15_Tree #Top_Interview_150_Binary_Tree_General
// #Big_O_Time_O(N)_Space_O(N) #2024_11_13_Time_1_ms_(96.33%)_Space_44.5_MB_(36.49%)

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
public class Construct_Binary_Tree_From_Preorder_And_Inorder_Traversal {
    private int j;
    private Map<Integer, Integer> map = new HashMap<>();

    public int get(int key) {
        return map.get(key);
    }

    private TreeNode answer(int[] preorder, int[] inorder, int start, int end) {
        if (start > end || j > preorder.length) {
            return null;
        }
        int value = preorder[j++];
        int index = get(value);
        TreeNode node = new TreeNode(value);
        node.left = answer(preorder, inorder, start, index - 1);
        node.right = answer(preorder, inorder, index + 1, end);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        j = 0;
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        return answer(preorder, inorder, 0, preorder.length - 1);
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
        // Clean up trailing nulls for aesthetic output
        while (!result.isEmpty() && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard multi-level binary tree configuration
        // Expected tree structure: [3, 9, 20, null, null, 15, 7]
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode result1 = new Construct_Binary_Tree_From_Preorder_And_Inorder_Traversal().buildTree(preorder1, inorder1);
        System.out.println("Test 1 Reconstructed Tree: " + levelOrderList(result1));

        // Test Case 2: Minimal single node configuration
        // Expected tree structure: [1]
        int[] preorder2 = {1};
        int[] inorder2 = {1};
        TreeNode result2 = new Construct_Binary_Tree_From_Preorder_And_Inorder_Traversal().buildTree(preorder2, inorder2);
        System.out.println("Test 2 Reconstructed Tree: " + levelOrderList(result2));

        // Test Case 3: Empty array edge case inputs
        // Expected tree structure: []
        int[] preorder3 = {};
        int[] inorder3 = {};
        TreeNode result3 = new Construct_Binary_Tree_From_Preorder_And_Inorder_Traversal().buildTree(preorder3, inorder3);
        System.out.println("Test 3 Reconstructed Tree: " + levelOrderList(result3));
        
        // Test Case 4: Strictly left-skewed tree
        // Expected tree structure: [1, 2, null, 3]
        int[] preorder4 = {1, 2, 3};
        int[] inorder4 = {3, 2, 1};
        TreeNode result4 = new Construct_Binary_Tree_From_Preorder_And_Inorder_Traversal().buildTree(preorder4, inorder4);
        System.out.println("Test 4 Reconstructed Tree: " + levelOrderList(result4));
    }
}
