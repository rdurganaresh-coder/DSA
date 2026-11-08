package leetcode.Solutions_0001_0100.s0038_count_and_say;

// #Medium #Top_Interview_Questions #String #2023_08_09_Time_2_ms_(97.68%)_Space_39.9_MB_(90.19%)

public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder res = new StringBuilder();
        String prev = countAndSay(n - 1);
        int count = 1;
        for (int i = 1; i < prev.length(); i++) {
            if (prev.charAt(i) == prev.charAt(i - 1)) {
                count++;
            } else {
                res.append(count).append(prev.charAt(i - 1));
                count = 1;
            }
        }
        res.append(count).append(prev.charAt(prev.length() - 1));
        return res.toString();
    }

    public static void main(String[] args) {
        CountAndSay solver = new CountAndSay();

        // Test Case 1: Base Case
        int n1 = 1;
        System.out.println("n = " + n1 + " -> Output: \"" + solver.countAndSay(n1) + "\" (Expected: \"1\")");

        // Test Case 2: Iteration 2
        int n2 = 2;
        System.out.println("n = " + n2 + " -> Output: \"" + solver.countAndSay(n2) + "\" (Expected: \"11\")");

        // Test Case 3: Iteration 3
        int n3 = 3;
        System.out.println("n = " + n3 + " -> Output: \"" + solver.countAndSay(n3) + "\" (Expected: \"21\")");

        // Test Case 4: Iteration 4 (Standard LeetCode Example)
        int n4 = 4;
        System.out.println("n = " + n4 + " -> Output: \"" + solver.countAndSay(n4) + "\" (Expected: \"1211\")");

        // Test Case 5: Higher Iteration
        int n5 = 5;
        System.out.println("n = " + n5 + " -> Output: \"" + solver.countAndSay(n5) + "\" (Expected: \"111221\")");
    }
}
