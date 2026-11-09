package leetcode.Solutions_0001_0100.s0095_unique_binary_search_trees_ii;

// #Medium #Dynamic_Programming #Tree #Binary_Tree #Backtracking #Binary_Search_Tree
// #2022_06_21_Time_1_ms_(99.82%)_Space_45.7_MB_(66.23%)

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
public class Unique_Binary_Search_Trees_ii {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        result.add(new TreeNode(1));
        for (int i = 2; i <= n; i++) {
            List<TreeNode> nresult = new ArrayList<>();
            for (TreeNode r : result) {
                TreeNode node = new TreeNode(i, r, null);
                nresult.add(node);

                TreeNode previous = r;
                while (previous != null) {
                    node = new TreeNode(i);
                    TreeNode cr = copy(r);
                    insert(cr, node, previous);
                    previous = node.left;
                    nresult.add(cr);
                }
            }
            result = nresult;
        }
        return result;
    }

    private void insert(TreeNode dest, TreeNode n, TreeNode from) {
        if (dest.val == from.val) {
            TreeNode h = dest.right;
            dest.right = n;
            n.left = h;
            return;
        }
        insert(dest.right, n, from);
    }

    private TreeNode copy(TreeNode n) {
        if (n == null) {
            return null;
        }
        return new TreeNode(n.val, copy(n.left), copy(n.right));
    }

    // Helper method to serialize a binary tree structure into a flat list view for output readability
    private static List<Integer> serializeTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        serializeHelper(root, list);
        return list;
    }

    private static void serializeHelper(TreeNode node, List<Integer> list) {
        if (node == null) {
            list.add(null);
            return;
        }
        list.add(node.val);
        serializeHelper(node.left, list);
        serializeHelper(node.right, list);
    }

    public static void main(String[] args) {
        // Test Case 1: Minimum typical configuration (n = 1)
        // Should output 1 unique tree: [1]
        List<TreeNode> result1 = new Unique_Binary_Search_Trees_ii().generateTrees(1);
        System.out.println("Test 1 (n = 1) Total Trees: " + result1.size());
        
        // Test Case 2: Small size configuration (n = 2)
        // Should output 2 unique trees: [1, null, 2] and [2, 1]
        List<TreeNode> result2 = new Unique_Binary_Search_Trees_ii().generateTrees(2);
        System.out.println("Test 2 (n = 2) Total Trees: " + result2.size());

        // Test Case 3: Standard benchmark target (n = 3)
        // Should output 5 unique structurally distinct BST configurations
        List<TreeNode> result3 = new Unique_Binary_Search_Trees_ii().generateTrees(3);
        System.out.println("Test 3 (n = 3) Total Trees: " + result3.size());

        // Test Case 4: Zero boundary edge case (n = 0)
        // Should return an empty list [] safely
        List<TreeNode> result4 = new Unique_Binary_Search_Trees_ii().generateTrees(0);
        System.out.println("Test 4 (n = 0) Total Trees: " + result4.size());
    }
}
