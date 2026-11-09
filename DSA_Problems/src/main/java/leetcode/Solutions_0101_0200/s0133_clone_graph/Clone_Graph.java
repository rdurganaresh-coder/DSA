package leetcode.Solutions_0101_0200.s0133_clone_graph;

// #Medium #Hash_Table #Depth_First_Search #Breadth_First_Search #Graph #Udemy_Graph
// #Top_Interview_150_Graph_General #2025_05_03_Time_25_ms_(68.87%)_Space_43.26_MB_(7.02%)

import leetcode.utils.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Clone_Graph {
    public Node cloneGraph(Node node) {
        return cloneGraph(node, new HashMap<>());
    }

    private Node cloneGraph(Node node, Map<Node, Node> processedNodes) {
        if (node == null) {
            return null;
        } else if (processedNodes.get(node) != null) {
            return processedNodes.get(node);
        }
        Node newNode = new Node();
        processedNodes.put(node, newNode);
        newNode.val = node.val;
        newNode.neighbors = new ArrayList<>();
        for (Node neighbor : node.neighbors) {
            Node clonedNeighbor = cloneGraph(neighbor, processedNodes);
            if (clonedNeighbor != null) {
                newNode.neighbors.add(clonedNeighbor);
            }
        }
        return newNode;
    }

    // Helper method to verify the structure and reference differences
    private static void verifyClone(Node original, Node cloned, Map<Integer, Boolean> visited) {
        if (original == null || visited.containsKey(original.val)) return;
        visited.put(original.val, true);

        if (original == cloned) {
            System.out.println("FAIL: Node " + original.val + " points to the same object memory reference!");
            return;
        }
        if (original.val != cloned.val) {
            System.out.println("FAIL: Value mismatch. Expected " + original.val + ", got " + cloned.val);
            return;
        }
        if (original.neighbors.size() != cloned.neighbors.size()) {
            System.out.println("FAIL: Neighbors size mismatch at node " + original.val);
            return;
        }

        for (int i = 0; i < original.neighbors.size(); i++) {
            verifyClone(original.neighbors.get(i), cloned.neighbors.get(i), visited);
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Standard 4-node connected cyclic undirected graph
        // 1 -- 2
        // |    |
        // 4 -- 3
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        
        n1.neighbors.add(n2); n1.neighbors.add(n4);
        n2.neighbors.add(n1); n2.neighbors.add(n3);
        n3.neighbors.add(n2); n3.neighbors.add(n4);
        n4.neighbors.add(n1); n4.neighbors.add(n3);

        Node cloned1 = new Clone_Graph().cloneGraph(n1);
        System.out.print("Test 1 (Cyclic Graph Verification): ");
        if (cloned1 != null) {
            verifyClone(n1, cloned1, new HashMap<>());
            System.out.println("SUCCESS. Deep copy verified.");
        } else {
            System.out.println("FAIL: Returned null.");
        }

        // Test Case 2: Graph with a single standalone node (no neighbors)
        Node nSingle = new Node(1);
        Node clonedSingle = new Clone_Graph().cloneGraph(nSingle);
        System.out.print("Test 2 (Single Node Graph): ");
        if (clonedSingle != null && clonedSingle != nSingle && clonedSingle.neighbors.isEmpty()) {
            System.out.println("SUCCESS. Standalone clone verified.");
        } else {
            System.out.println("FAIL");
        }

        // Test Case 3: Empty graph boundary case (null root input)
        Node clonedNull = new Clone_Graph().cloneGraph(null);
        System.out.print("Test 3 (Null Input): ");
        if (clonedNull == null) {
            System.out.println("SUCCESS. Correctly returned null.");
        } else {
            System.out.println("FAIL");
        }
    }
}
