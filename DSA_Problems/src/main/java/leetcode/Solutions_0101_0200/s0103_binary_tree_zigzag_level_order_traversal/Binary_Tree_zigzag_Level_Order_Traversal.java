package leetcode.Solutions_0101_0200.s0103_binary_tree_zigzag_level_order_traversal;

// #Medium #Top_Interview_Questions #Breadth_First_Search #Tree #Binary_Tree
// #Data_Structure_II_Day_15_Tree #Udemy_Tree_Stack_Queue #Top_Interview_150_Binary_Tree_BFS
// #2025_03_05_Time_0_ms_(100.00%)_Space_42.68_MB_(7.11%)

import leetcode.utils.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
public class Binary_Tree_zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        boolean zig = true;
        LinkedList<Integer> level = new LinkedList<>();
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            while (!q.isEmpty() && node != null) {
                if (zig) {
                    level.add(node.val);
                } else {
                    level.addFirst(node.val);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                node = q.remove();
            }
            result.add(level);
            zig = !zig;
            level = new LinkedList<>();
            if (!q.isEmpty()) {
                q.add(null);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard multi-level binary tree showing clear zigzag behavior
        // Tree structure:     3
        //                   /   \
        //                  9    20
        //                      /  \
        //                     15   7
        // Level 0 (Left -> Right): [3]
        // Level 1 (Right -> Left): [20, 9]
        // Level 2 (Left -> Right): [15, 7]
        // Expected Output: [[3], [20, 9], [15, 7]]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        
        List<List<Integer>> result1 = new Binary_Tree_zigzag_Level_Order_Traversal().zigzagLevelOrder(root1);
        System.out.println("Test 1 Result: " + result1);

        // Test Case 2: Single node tree base case
        // Expected Output: [[1]]
        TreeNode root2 = new TreeNode(1);
        List<List<Integer>> result2 = new Binary_Tree_zigzag_Level_Order_Traversal().zigzagLevelOrder(root2);
        System.out.println("Test 2 Result: " + result2);

        // Test Case 3: Empty tree edge case (root is null)
        // Expected Output: []
        TreeNode root3 = null;
        List<List<Integer>> result3 = new Binary_Tree_zigzag_Level_Order_Traversal().zigzagLevelOrder(root3);
        System.out.println("Test 3 Result (Empty): " + result3);

        // Test Case 4: Full balanced tree to track extensive crossover switching
        // Tree structure:     1
        //                   /   \
        //                  2     3
        //                 / \   / \
        //                4   5 6   7
        // Expected Output: [[1], [3, 2], [4, 5, 6, 7]]
        TreeNode root4 = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), new TreeNode(7))
        );
        List<List<Integer>> result4 = new Binary_Tree_zigzag_Level_Order_Traversal().zigzagLevelOrder(root4);
        System.out.println("Test 4 Result: " + result4);
    }
}
