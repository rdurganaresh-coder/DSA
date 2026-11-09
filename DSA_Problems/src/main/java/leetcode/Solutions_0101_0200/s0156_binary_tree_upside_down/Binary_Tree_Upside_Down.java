package leetcode.Solutions_0101_0200.s0156_binary_tree_upside_down;

public class Binary_Tree_Upside_Down {

    // Definition for a binary tree node
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Iterative Solution: O(N) Time, O(1) Space
     * Sweeps top-down, flipping links similar to reversing a singly linked list.
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode next = null;
        TreeNode temp = null;
        TreeNode prev = null;
        TreeNode prevRight = null;

        while (curr != null) {
            next = curr.left;

            // Flipping the links
            curr.left = prevRight;
            prevRight = curr.right;
            curr.right = prev;

            // Moving pointers forward
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * Alternative Recursive Solution: O(N) Time, O(N) Space (due to recursion stack)
     */
    public TreeNode upsideDownBinaryTreeRecursive(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        
        TreeNode newRoot = upsideDownBinaryTreeRecursive(root.left);
        
        // Re-assigning links on the way out of recursion
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        
        return newRoot;
    }

    // --- Helper Utilities for Testing ---

    private static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder("[");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append(", ");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("null, ");
            }
        }
        // Trim trailing cleanup strings
        String result = sb.toString().replaceAll("(, null)+ ]$", " ]").replaceAll(", $", "]");
        System.out.println(result);
    }

    // --- Main Method Executing Test Cases ---
    public static void main(String[] args) {
        Binary_Tree_Upside_Down solver = new Binary_Tree_Upside_Down();

        System.out.println("--- Running Binary Tree Upside Down Tests ---\n");

        // Test Case 1: Empty Tree
        System.out.print("Test 1 (Empty Tree): Expected: [] -> Actual: ");
        printLevelOrder(solver.upsideDownBinaryTree(null));

        // Test Case 2: Single Node Tree
        System.out.print("Test 2 (Single Node): Expected: [1] -> Actual: ");
        printLevelOrder(solver.upsideDownBinaryTree(new TreeNode(1)));

        // Test Case 3: Standard Tree
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        // Upside Down transformation should yield:
        //        4
        //       / \
        //      5   2
        //         / \
        //        3   1
        System.out.println("\nTest 3 (Standard Balanced Spine):");
        TreeNode root3 = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3)
        );
        System.out.print("Input Structure:  ");
        printLevelOrder(root3);
        
        TreeNode result3 = solver.upsideDownBinaryTree(root3);
        System.out.print("Flipped Output:   ");
        printLevelOrder(result3);
    }
}
