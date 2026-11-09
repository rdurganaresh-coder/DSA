package leetcode.Solutions_0101_0200.s0102_binary_tree_level_order_traversal;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Breadth_First_Search #Tree
// #Binary_Tree #Data_Structure_I_Day_11_Tree #Level_1_Day_6_Tree #Udemy_Tree_Stack_Queue
// #Top_Interview_150_Binary_Tree_BFS #Big_O_Time_O(N)_Space_O(N)
// #2024_11_13_Time_1_ms_(91.19%)_Space_45.1_MB_(24.35%)

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
public class Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            root = queue.remove();
            while (!queue.isEmpty() && root != null) {
                level.add(root.val);
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
                root = queue.remove();
            }
            result.add(level);
            level = new ArrayList<>();
            if (!queue.isEmpty()) {
                queue.add(null);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard multi-level balanced binary tree
        // Tree structure:     3
        //                   /   \
        //                  9    20
        //                      /  \
        //                     15   7
        // Expected Output: [[3], [9, 20], [15, 7]]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        
        List<List<Integer>> result1 = new Binary_Tree_Level_Order_Traversal().levelOrder(root1);
        System.out.println("Test 1 Result: " + result1);

        // Test Case 2: Single node tree base case
        // Expected Output: [[1]]
        TreeNode root2 = new TreeNode(1);
        List<List<Integer>> result2 = new Binary_Tree_Level_Order_Traversal().levelOrder(root2);
        System.out.println("Test 2 Result: " + result2);

        // Test Case 3: Empty tree edge case (root is null)
        // Expected Output: []
        TreeNode root3 = null;
        List<List<Integer>> result3 = new Binary_Tree_Level_Order_Traversal().levelOrder(root3);
        System.out.println("Test 3 Result: " + result3);

        // Test Case 4: Skewed linear tree (All left children)
        // Tree structure:   1
        //                  /
        //                 2
        //                /
        //               3
        // Expected Output: [[1], [2], [3]]
        TreeNode root4 = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        List<List<Integer>> result4 = new Binary_Tree_Level_Order_Traversal().levelOrder(root4);
        System.out.println("Test 4 Result: " + result4);
    }
}
