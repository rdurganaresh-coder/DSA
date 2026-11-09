package leetcode.Solutions_0001_0100.s0100_same_tree;

// #Easy #Depth_First_Search #Breadth_First_Search #Tree #Binary_Tree #Level_2_Day_15_Tree
// #Udemy_Tree_Stack_Queue #Top_Interview_150_Binary_Tree_General
// #2022_06_21_Time_0_ms_(100.00%)_Space_40.9_MB_(78.42%)

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
public class Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == null && q == null;
        }
        boolean b1 = isSameTree(p.left, q.left);
        boolean b2 = isSameTree(p.right, q.right);
        return p.val == q.val && b1 && b2;
    }

    public static void main(String[] args) {
        // Test Case 1: Identical balanced structures (Should output true)
        TreeNode t1_p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode t1_q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        boolean result1 = new Same_Tree().isSameTree(t1_p, t1_q);
        System.out.println("Test 1 (Identical Trees): " + result1);

        // Test Case 2: Structural asymmetry / Mismatched child placement (Should output false)
        // t2_p: Left child is 2, Right child is null
        // t2_q: Left child is null, Right child is 2
        TreeNode t2_p = new TreeNode(1, new TreeNode(2), null);
        TreeNode t2_q = new TreeNode(1, null, new TreeNode(2));
        boolean result2 = new Same_Tree().isSameTree(t2_p, t2_q);
        System.out.println("Test 2 (Mismatched Structures): " + result2);

        // Test Case 3: Same structure but mismatched values (Should output false)
        TreeNode t3_p = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode t3_q = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        boolean result3 = new Same_Tree().isSameTree(t3_p, t3_q);
        System.out.println("Test 3 (Mismatched Values): " + result3);

        // Test Case 4: Double null base configuration (Should output true)
        boolean result4 = new Same_Tree().isSameTree(null, null);
        System.out.println("Test 4 (Both Null): " + result4);
    }
}
