package leetcode.Solutions_0101_0200.s0116_populating_next_right_pointers_in_each_node;

import java.util.ArrayList;
import java.util.List;

// #Medium #Top_Interview_Questions #Depth_First_Search #Breadth_First_Search #Tree #Binary_Tree
// #Linked_List #Algorithm_I_Day_8_Breadth_First_Search_Depth_First_Search
// #2022_06_23_Time_0_ms_(100.00%)_Space_47.8_MB_(30.30%)

import leetcode.utils.left_right.Node;;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

public class Populating_Next_Right_Pointers_In_Each_Node {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        if (root.next != null && root.right != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    // Helper method to collect level-order entries along next pointers for verification
    private static List<String> serializeWithNext(Node root) {
        List<String> result = new ArrayList<>();
        Node levelStart = root;
        while (levelStart != null) {
            Node current = levelStart;
            while (current != null) {
                result.add(String.valueOf(current.val));
                current = current.next;
            }
            result.add("#"); // Visual indicator for the end of a level row
            levelStart = levelStart.left; // Moves down to the next tier level
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard perfect full binary tree configuration
        // Tree structure:        1
        //                       / \
        //                      2   3
        //                     / \ / \
        //                    4  5 6  7
        // Expected Output linked sequence: [1, #, 2, 3, #, 4, 5, 6, 7, #]
        Node root1 = new Node(1,
            new Node(2, new Node(4), new Node(5), null),
            new Node(3, new Node(6), new Node(7), null),
            null
        );
        new Populating_Next_Right_Pointers_In_Each_Node().connect(root1);
        System.out.println("Test 1 Stitched Results: " + serializeWithNext(root1));

        // Test Case 2: Minimal tree containing only a single root node base case
        // Expected Output: [1, #]
        Node root2 = new Node(1);
        new Populating_Next_Right_Pointers_In_Each_Node().connect(root2);
        System.out.println("Test 2 Stitched Results: " + serializeWithNext(root2));

        // Test Case 3: Empty tree edge case input (root is null)
        // Expected Output: []
        Node root3 = null;
        Node result3 = new Populating_Next_Right_Pointers_In_Each_Node().connect(root3);
        System.out.println("Test 3 Stitched Results: " + serializeWithNext(result3));
    }
}
