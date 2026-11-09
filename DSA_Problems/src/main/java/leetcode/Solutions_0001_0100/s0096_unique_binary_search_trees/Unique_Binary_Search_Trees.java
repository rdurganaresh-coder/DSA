package leetcode.Solutions_0001_0100.s0096_unique_binary_search_trees;

// #Medium #Dynamic_Programming #Math #Tree #Binary_Tree #Binary_Search_Tree
// #Dynamic_Programming_I_Day_11 #Big_O_Time_O(n)_Space_O(1)
// #2024_11_13_Time_0_ms_(100.00%)_Space_40.7_MB_(6.57%)

public class Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        long result = 1;
        for (int i = 0; i < n; i++) {
            result *= 2L * n - i;
            result /= i + 1;
        }
        result /= n + 1;
        return (int) result;
    }

    public static void main(String[] args) {
    // Test Case 1: Standard benchmark value (n = 3)
    int result1 = new Unique_Binary_Search_Trees().numTrees(3);
    System.out.println("Test 1 (n = 3) -> Count: " + result1);
    // Expected Output: 5

    // Test Case 2: Minimal single element node configuration (n = 1)
    int result2 = new Unique_Binary_Search_Trees().numTrees(1);
    System.out.println("Test 2 (n = 1) -> Count: " + result2);
    // Expected Output: 1

    // Test Case 3: Small node collection (n = 4)
    int result3 = new Unique_Binary_Search_Trees().numTrees(4);
    System.out.println("Test 3 (n = 4) -> Count: " + result3);
    // Expected Output: 14

    // Test Case 4: Scale evaluation to confirm long truncation safety (n = 19)
    int result4 = new Unique_Binary_Search_Trees().numTrees(19);
    System.out.println("Test 4 (n = 19) -> Count: " + result4);
    // Expected Output: 1767263190
}
}
