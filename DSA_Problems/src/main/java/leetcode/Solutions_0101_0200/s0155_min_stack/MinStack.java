package leetcode.Solutions_0101_0200.s0155_min_stack;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Stack #Design
// #Data_Structure_II_Day_14_Stack_Queue #Programming_Skills_II_Day_18 #Level_2_Day_16_Design
// #Udemy_Design #Top_Interview_150_Stack #Big_O_Time_O(1)_Space_O(N)
// #2024_11_15_Time_4_ms_(96.54%)_Space_44.5_MB_(84.54%)

public class MinStack {
    private static class Node {
        int min;
        int data;
        Node nextNode;
        Node previousNode;

        public Node(int min, int data, Node previousNode, Node nextNode) {
            this.min = min;
            this.data = data;
            this.previousNode = previousNode;
            this.nextNode = nextNode;
        }
    }

    private Node currentNode;

    // initialize your data structure here.
    public MinStack() {
        // no initialization needed.
    }

    public void push(int val) {
        if (currentNode == null) {
            currentNode = new Node(val, val, null, null);
        } else {
            currentNode.nextNode = new Node(Math.min(currentNode.min, val), val, currentNode, null);
            currentNode = currentNode.nextNode;
        }
    }

    public void pop() {
        currentNode = currentNode.previousNode;
    }

    public int top() {
        return currentNode.data;
    }

    public int getMin() {
        return currentNode.min;
    }

    // --- Main Method Executing Test Cases ---
    public static void main(String[] args) {
        System.out.println("--- Running MinStack Tests ---\n");

        MinStack minStack = new MinStack();

        // 1. Push elements onto the stack
        System.out.println("Pushing: -2, 0, -3");
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        // 2. Validate standard operations and tracking
        System.out.println("getMin(): " + minStack.getMin() + " (Expected: -3)");
        
        minStack.pop();
        System.out.println("\n--- After Pop ---");
        System.out.println("top():    " + minStack.top()    + " (Expected: 0)");
        System.out.println("getMin(): " + minStack.getMin() + " (Expected: -2)");

        // 3. Push a larger number to verify minimum stays consistent
        minStack.push(5);
        System.out.println("\n--- After Pushing 5 ---");
        System.out.println("top():    " + minStack.top()    + " (Expected: 5)");
        System.out.println("getMin(): " + minStack.getMin() + " (Expected: -2)");
    }
}

/*
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
