package leetcode.Solutions_0101_0200.s0150_evaluate_reverse_polish_notation;

// #Medium #Top_Interview_Questions #Array #Math #Stack #Programming_Skills_II_Day_3
// #Top_Interview_150_Stack #2025_03_06_Time_6_ms_(76.50%)_Space_44.94_MB_(31.04%)

import java.util.Stack;

@SuppressWarnings("java:S1149")
public class Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            if (!Character.isDigit(token.charAt(token.length() - 1))) {
                st.push(eval(st.pop(), st.pop(), token));
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }

    private int eval(int second, int first, String operator) {
        switch (operator) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            default:
                return first / second;
        }
    }

    // --- Main Method Executing Test Cases ---
    public static void main(String[] args) {
        Evaluate_Reverse_Polish_Notation evaluator = new Evaluate_Reverse_Polish_Notation();

        System.out.println("--- Running Evaluate RPN Tests ---\n");

        // Test Case 1: Simple Addition
        // Input: ["2", "1", "+"] -> (2 + 1)
        System.out.print("Test 1 (Simple Addition): ");
        String[] tokens1 = {"2", "1", "+"};
        System.out.println("Expected: 3 -> Actual: " + evaluator.evalRPN(tokens1));

        // Test Case 2: Subtraction and Multiplication
        // Input: ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 4 + 2
        System.out.print("Test 2 (Division and Addition): ");
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println("Expected: 6 -> Actual: " + evaluator.evalRPN(tokens2));

        // Test Case 3: Complex Expression with Negative Results
        // Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
        // -> ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
        System.out.print("Test 3 (Complex Matrix with Negatives): ");
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("Expected: 22 -> Actual: " + evaluator.evalRPN(tokens3));

        // Test Case 4: Single Number (Edge case)
        // Input: ["42"]
        System.out.print("Test 4 (Single Element): ");
        String[] tokens4 = {"42"};
        System.out.println("Expected: 42 -> Actual: " + evaluator.evalRPN(tokens4));
    }
}
