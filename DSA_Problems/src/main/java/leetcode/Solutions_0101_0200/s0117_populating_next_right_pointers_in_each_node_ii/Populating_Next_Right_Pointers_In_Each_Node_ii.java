package leetcode.Solutions_0101_0200.s0117_populating_next_right_pointers_in_each_node_ii;

// #Medium #Depth_First_Search #Breadth_First_Search #Tree #Binary_Tree #Linked_List
// #Algorithm_II_Day_7_Breadth_First_Search_Depth_First_Search
// #Top_Interview_150_Binary_Tree_General #2025_03_06_Time_0_ms_(100.00%)_Space_44.12_MB_(80.39%)

import leetcode.utils.left_right.Node;
import java.util.ArrayList;
import java.util.List;

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

public class Populating_Next_Right_Pointers_In_Each_Node_ii {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else if (root.next != null) {
                root.left.next = adjacentRightNode(root.next);
            }
        }
        if (root.right != null) {
            root.right.next = adjacentRightNode(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node adjacentRightNode(Node root) {
        Node temp = root;
        while (temp != null) {
            if (temp.left == null && temp.right == null) {
                temp = temp.next;
            } else {
                if (temp.left != null) {
                    return temp.left;
                }
                if (temp.right != null) {
                    return temp.right;
                }
            }
        }
        return null;
    }

    // Helper method to collect level-order entries along next pointers for verification
    private static List<String> serializeWithNext(Node root) {
        List<String> result = new ArrayList<>();
        Node levelStart = root;
        while (levelStart != null) {
            Node current = levelStart;
            Node nextLevelStart = null;
            
            // Traverses horizontally along the next pointers for the current level
            while (current != null) {
                result.add(String.valueOf(current.val));
                
                // Dynamically find the start node for the next level down
                if (nextLevelStart == null) {
                    if (current.left != null) nextLevelStart = current.left;
                    else if (current.right != null) nextLevelStart = current.right;
                }
                current = current.next;
            }
            result.add("#"); // Visual separator indicating end of level
            levelStart = nextLevelStart;
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case 1: An incomplete/imperfect binary tree with missing nodes
        // Tree structure:        1
        //                       / \
        //                      2   3
        //                     /     \
        //                    4       5
        // Expected Output: [1, #, 2, 3, #, 4, 5, #]
        Node root1 = new Node(1,
            new Node(2, new Node(4), null, null),
            new Node(3, null, new Node(5), null),
            null
        );
        new Populating_Next_Right_Pointers_In_Each_Node_ii().connect(root1);
        System.out.println("Test 1 (Imperfect Tree): " + serializeWithNext(root1));

        // Test Case 2: Tree with an empty level gap on one side
        // Tree structure:        1
        //                       / \
        //                      2   3
        //                     / 
        //                    4   
        //                   /
        //                  7
        // Expected Output: [1, #, 2, 3, #, 4, #, 7, #]
        Node root2 = new Node(1,
            new Node(2, new Node(4, new Node(7), null, null), null, null),
            new Node(3),
            null
        );
        new Populating_Next_Right_Pointers_In_Each_Node_ii().connect(root2);
        System.out.println("Test 2 (Deep Skewed Gap): " + serializeWithNext(root2));

        // Test Case 3: Empty tree edge case input
        Node root3 = null;
        new Populating_Next_Right_Pointers_In_Each_Node_ii().connect(root3);
        System.out.println("Test 3 (Null Root):       " + serializeWithNext(root3));
    }
}
