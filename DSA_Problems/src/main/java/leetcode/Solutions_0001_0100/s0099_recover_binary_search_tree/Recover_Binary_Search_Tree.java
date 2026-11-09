package leetcode.Solutions_0001_0100.s0099_recover_binary_search_tree;

import java.util.ArrayList;
import java.util.List;

// #Medium #Depth_First_Search #Tree #Binary_Tree #Binary_Search_Tree
// #2022_06_21_Time_3_ms_(76.33%)_Space_47.3_MB_(52.92%)

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
public class Recover_Binary_Search_Tree {
    private TreeNode prev = null;
    private TreeNode first = null;
    private TreeNode second = null;

    public void recoverTree(TreeNode root) {
        evalSwappedNodes(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void evalSwappedNodes(TreeNode curr) {
        if (curr == null) {
            return;
        }
        evalSwappedNodes(curr.left);
        if (prev != null && prev.val > curr.val) {
            if (first == null) {
                first = prev;
            }
            second = curr;
        }
        prev = curr;
        evalSwappedNodes(curr.right);
    }

    // Helper method to collect the inorder traversal for verification
    private static List<Integer> getInorderList(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderHelper(root, list);
        return list;
    }

    private static void inorderHelper(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorderHelper(node.left, list);
        list.add(node.val);
        inorderHelper(node.right, list);
    }

    public static void main(String[] args) {
        // Test Case 1: Swapped nodes are non-adjacent in inorder view
        // Initial invalid structure:   1
        //                             /
        //                            3
        //                             \
        //                              2
        // Inorder before: [3, 2, 1] -> Inorder after: [1, 2, 3]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.left.right = new TreeNode(2);

        Recover_Binary_Search_Tree recoverer1 = new Recover_Binary_Search_Tree();
        System.out.println("Test 1 Before: " + getInorderList(root1));
        recoverer1.recoverTree(root1);
        System.out.println("Test 1 After:  " + getInorderList(root1));
        System.out.println();

        // Test Case 2: Swapped nodes are adjacent in inorder view
        // Initial invalid structure:   3
        //                             / \
        //                            1   4
        //                               /
        //                              2
        // Inorder before: [1, 3, 2, 4] -> Inorder after: [1, 2, 3, 4]
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(2);

        Recover_Binary_Search_Tree recoverer2 = new Recover_Binary_Search_Tree();
        System.out.println("Test 2 Before: " + getInorderList(root2));
        recoverer2.recoverTree(root2);
        System.out.println("Test 2 After:  " + getInorderList(root2));
    }
}
