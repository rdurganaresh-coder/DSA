package leetcode.Solutions_0101_0200.s0104_maximum_depth_of_binary_tree;

// #Easy #Top_100_Liked_Questions #Top_Interview_Questions #Depth_First_Search #Breadth_First_Search
// #Tree #Binary_Tree #LeetCode_75_Binary_Tree/DFS #Data_Structure_I_Day_11_Tree
// #Programming_Skills_I_Day_10_Linked_List_and_Tree #Udemy_Tree_Stack_Queue
// #Top_Interview_150_Binary_Tree_General #Big_O_Time_O(N)_Space_O(H)
// #2024_11_13_Time_0_ms_(100.00%)_Space_42.2_MB_(88.11%)

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
public class Maximum_Depth_Of_Binary_Tree {
    public int maxDepth(TreeNode root) {
        return findDepth(root, 0);
    }

    private int findDepth(TreeNode node, int currentDepth) {
        if (node == null) {
            return 0;
        }
        currentDepth++;
        return 1
                + Math.max(findDepth(node.left, currentDepth), findDepth(node.right, currentDepth));
    }

    public static void main(String[] args) {
        // Test Case 1: Standard multi-level tree configuration
        // Tree structure:     3
        //                   /   \
        //                  9    20
        //                      /  \
        //                     15   7
        // Expected Output: 3
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        int result1 = new Maximum_Depth_Of_Binary_Tree().maxDepth(root1);
        System.out.println("Test 1 Result: " + result1);

        // Test Case 2: Skewed single-branch linear tree structure
        // Tree structure:   1
        //                    \
        //                     2
        //                      \
        //                       3
        // Expected Output: 3
        TreeNode root2 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        int result2 = new Maximum_Depth_Of_Binary_Tree().maxDepth(root2);
        System.out.println("Test 2 Result: " + result2);

        // Test Case 3: Empty tree edge case (root is null)
        // Expected Output: 0
        TreeNode root3 = null;
        int result3 = new Maximum_Depth_Of_Binary_Tree().maxDepth(root3);
        System.out.println("Test 3 Result (Empty): " + result3);

        // Test Case 4: Single root node only
        // Expected Output: 1
        TreeNode root4 = new TreeNode(10);
        int result4 = new Maximum_Depth_Of_Binary_Tree().maxDepth(root4);
        System.out.println("Test 4 Result (Single Node): " + result4);
    }
}
