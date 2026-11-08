package leetcode.Solutions_0001_0100.s0060_permutation_sequence;

// #Hard #Math #Recursion #2023_08_11_Time_0_ms_(100.00%)_Space_40.2_MB_(52.90%)

public class Permutation_Sequence {
    public String getPermutation(int n, int k) {
        char[] res = new char[n];
        // We want the permutation sequence to be zero-indexed
        k = k - 1;
        // The set bits indicate the available digits
        int a = (1 << n) - 1;
        int m = 1;
        for (int i = 2; i < n; i++) {
            // m = (n - 1)!
            m *= i;
        }
        for (int i = 0; i < n; i++) {
            int b = a;
            for (int j = 0; j < k / m; j++) {
                b &= b - 1;
            }
            // b is the bit corresponding to the digit we want
            b &= ~b + 1;
            res[i] = (char) ('1' + Integer.bitCount(b - 1));
            // Remove b from the set of available digits
            a &= ~b;
            k %= m;
            m /= Math.max(1, n - i - 1);
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
    // Test Case 1: Standard small input (n = 3, k = 3)
    // Permutations: "123", "132", "213", "231", "312", "321"
    String result1 = new Permutation_Sequence().getPermutation(3, 3);
    System.out.println("Test 1 Result: " + result1);
    // Expected Output: "213"

    // Test Case 2: Another standard input (n = 4, k = 9)
    String result2 = new Permutation_Sequence().getPermutation(4, 9);
    System.out.println("Test 2 Result: " + result2);
    // Expected Output: "2314"

    // Test Case 3: Minimum base case (n = 1, k = 1)
    String result3 = new Permutation_Sequence().getPermutation(1, 1);
    System.out.println("Test 3 Result: " + result3);
    // Expected Output: "1"

    // Test Case 4: The very last permutation sequence (n = 3, k = 6)
    String result4 = new Permutation_Sequence().getPermutation(3, 6);
    System.out.println("Test 4 Result: " + result4);
    // Expected Output: "321"
}
}
