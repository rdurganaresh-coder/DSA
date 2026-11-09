package leetcode.Solutions_0101_0200.s0114_flatten_binary_tree_to_linked_list;

import java.util.ArrayList;
import java.util.List;

// #Medium #Top_100_Liked_Questions #Depth_First_Search #Tree #Binary_Tree #Stack #Linked_List
// #Udemy_Linked_List #Top_Interview_150_Binary_Tree_General #Big_O_Time_O(N)_Space_O(N)
// #2024_11_13_Time_0_ms_(100.00%)_Space_42.5_MB_(6.71%)

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
public class Flatten_Bbinary_Tree_To_Linked_List {
    public void flatten(TreeNode root) {
        if (root != null) {
            findTail(root);
        }
    }

    private TreeNode findTail(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode tail;
        // find the tail of left subtree, tail means the most left leaf
        if (left != null) {
            tail = findTail(left);
            // stitch the right subtree below the tail
            root.left = null;
            root.right = left;
            tail.right = right;
        } else {
            tail = root;
        }
        // find tail of the right subtree
        if (tail.right == null) {
            return tail;
        } else {
            return findTail(tail.right);
        }
    }

    // Helper method to print the flattened list layout for verification
private static List<Integer> printFlattenedTree(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    TreeNode current = root;
    while (current != null) {
        list.add(current.val);
        if (current.left != null) {
            System.out.println("Error: Left child found at node " + current.val);
        }
        // Fix: Always follow the right pointer since the list is right-skewed
        current = current.right; 
    }
    return list;
}

    public static void main(String[] args) {
        // Test Case 1: Standard multi-level binary tree configuration
        // Expected flattened layout: [1, 2, 3, 4, 5, 6]
        TreeNode root1 = new TreeNode(1,
            new TreeNode(2, new TreeNode(3), new TreeNode(4)),
            new TreeNode(5, null, new TreeNode(6))
        );
        new Flatten_Bbinary_Tree_To_Linked_List().flatten(root1);
        System.out.println("Test 1 Result: " + printFlattenedTree(root1));

        // Test Case 2: Minimal tree containing only a single root node
        // Expected: [1]
        TreeNode root2 = new TreeNode(1);
        new Flatten_Bbinary_Tree_To_Linked_List().flatten(root2);
        System.out.println("Test 2 Result: " + printFlattenedTree(root2));

        // Test Case 3: Empty tree edge case input (root is null)
        // Expected: []
        TreeNode root3 = null;
        new Flatten_Bbinary_Tree_To_Linked_List().flatten(root3);
        System.out.println("Test 3 Result: " + printFlattenedTree(root3));

        // Test Case 4: Tree with only right children (Already flattened profile)
        // Expected: [1, 2, 3]
        TreeNode root4 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        new Flatten_Bbinary_Tree_To_Linked_List().flatten(root4);
        System.out.println("Test 4 Result: " + printFlattenedTree(root4));
    }
}
