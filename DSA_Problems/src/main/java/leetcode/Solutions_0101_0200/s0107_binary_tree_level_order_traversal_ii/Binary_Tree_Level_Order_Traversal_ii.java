package leetcode.Solutions_0101_0200.s0107_binary_tree_level_order_traversal_ii;

// #Medium #Breadth_First_Search #Tree #Binary_Tree
// #2022_06_22_Time_1_ms_(97.71%)_Space_43.7_MB_(42.26%)

import leetcode.utils.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
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
public class Binary_Tree_Level_Order_Traversal_ii {
    private List<List<Integer>> order = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        getOrder(root, 0);
        Collections.reverse(order);
        return order;
    }

    public void getOrder(TreeNode root, int level) {
        if (root != null) {
            if (level + 1 > order.size()) {
                order.add(new ArrayList<>());
            }
            order.get(level).add(root.val);
            getOrder(root.left, level + 1);
            getOrder(root.right, level + 1);
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Standard multi-level binary tree configuration
        // Tree structure:     3
        //                   /   \
        //                  9    20
        //                      /  \
        //                     15   7
        // Expected Output: [[15, 7], [9, 20], [3]]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        
        List<List<Integer>> result1 = new Binary_Tree_Level_Order_Traversal_ii().levelOrderBottom(root1);
        System.out.println("Test 1 Result: " + result1);

        // Test Case 2: Single node tree base case
        // Expected Output: [[1]]
        TreeNode root2 = new TreeNode(1);
        List<List<Integer>> result2 = new Binary_Tree_Level_Order_Traversal_ii().levelOrderBottom(root2);
        System.out.println("Test 2 Result: " + result2);

        // Test Case 3: Empty tree edge case (root is null)
        // Expected Output: []
        TreeNode root3 = null;
        List<List<Integer>> result3 = new Binary_Tree_Level_Order_Traversal_ii().levelOrderBottom(root3);
        System.out.println("Test 3 Result (Empty): " + result3);

        // Test Case 4: Asymmetric skewed tree structure
        // Tree structure:     1
        //                      \
        //                       2
        //                      /
        //                     3
        // Expected Output: [[3], [2], [1]]
        TreeNode root4 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<List<Integer>> result4 = new Binary_Tree_Level_Order_Traversal_ii().levelOrderBottom(root4);
        System.out.println("Test 4 Result: " + result4);
    }
}
