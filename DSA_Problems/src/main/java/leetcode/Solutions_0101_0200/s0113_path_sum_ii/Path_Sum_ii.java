package leetcode.Solutions_0101_0200.s0113_path_sum_ii;

// #Medium #Depth_First_Search #Tree #Binary_Tree #Backtracking #Data_Structure_II_Day_16_Tree
// #2022_06_23_Time_1_ms_(100.00%)_Space_44.7_MB_(53.10%)

import leetcode.utils.TreeNode;
import java.util.ArrayList;
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
public class Path_Sum_ii {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        recur(res, new ArrayList<>(), 0, targetSum, root);
        return res;
    }

    private void recur(
            List<List<Integer>> res, ArrayList<Integer> al, int sum, int targetSum, TreeNode root) {
        if (root == null) {
            return;
        }
        al.add(root.val);
        sum += root.val;
        if (sum == targetSum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(al));
        }
        recur(res, al, sum, targetSum, root.left);
        recur(res, al, sum, targetSum, root.right);
        al.remove(al.size() - 1);
    }

    public static void main(String[] args) {
        // Test Case 1: Standard multi-level tree with multiple matching paths
        // Tree structure:        5
        //                       / \
        //                      4   8
        //                     /   / \
        //                    11  13  4
        //                   /  \    / \
        //                  7    2  5   1
        // Target Sum: 22 
        // Expected paths: [5, 4, 11, 2] and [5, 8, 4, 5]
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null);
        root1.right = new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1)));
        
        List<List<Integer>> result1 = new Path_Sum_ii().pathSum(root1, 22);
        System.out.println("Test 1 Result: " + result1);

        // Test Case 2: Sum matches an early path that terminates at a non-leaf node
        // Target Sum: 5 (Root matches, but it has a left child)
        // Expected: [] (Empty, because paths must end at a leaf)
        TreeNode root2 = new TreeNode(5, new TreeNode(3), null);
        List<List<Integer>> result2 = new Path_Sum_ii().pathSum(root2, 5);
        System.out.println("Test 2 Result: " + result2);

        // Test Case 3: Empty tree edge case
        // Expected: []
        TreeNode root3 = null;
        List<List<Integer>> result3 = new Path_Sum_ii().pathSum(root3, 0);
        System.out.println("Test 3 Result: " + result3);

        // Test Case 4: Tree containing negative values
        // Path: 1 -> -2 -> 3 = 2
        // Expected: [[1, -2, 3]]
        TreeNode root4 = new TreeNode(1, new TreeNode(-2, null, new TreeNode(3)), null);
        List<List<Integer>> result4 = new Path_Sum_ii().pathSum(root4, 2);
        System.out.println("Test 4 Result: " + result4);
    }
}
