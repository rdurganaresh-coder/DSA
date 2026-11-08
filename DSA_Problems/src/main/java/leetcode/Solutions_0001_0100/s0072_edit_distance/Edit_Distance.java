package leetcode.Solutions_0001_0100.s0072_edit_distance;

// #Medium #Top_100_Liked_Questions #String #Dynamic_Programming #LeetCode_75_DP/Multidimensional
// #Algorithm_II_Day_18_Dynamic_Programming #Dynamic_Programming_I_Day_19
// #Udemy_Dynamic_Programming #Top_Interview_150_Multidimensional_DP #Big_O_Time_O(n^2)_Space_O(n2)
// #2024_11_11_Time_3_ms_(97.19%)_Space_43.2_MB_(98.23%)

@SuppressWarnings("java:S2234")
public class Edit_Distance {
    public int minDistance(String w1, String w2) {
        int n1 = w1.length();
        int n2 = w2.length();
        if (n2 > n1) {
            return minDistance(w2, w1);
        }
        int[] dp = new int[n2 + 1];
        for (int j = 0; j <= n2; j++) {
            dp[j] = j;
        }
        for (int i = 1; i <= n1; i++) {
            int pre = dp[0];
            dp[0] = i;
            for (int j = 1; j <= n2; j++) {
                int tmp = dp[j];
                dp[j] =
                        w1.charAt(i - 1) != w2.charAt(j - 1)
                                ? 1 + Math.min(pre, Math.min(dp[j], dp[j - 1]))
                                : pre;
                pre = tmp;
            }
        }
        return dp[n2];
    }

    public static void main(String[] args) {
    // Test Case 1: Standard transformations (insertions, deletions, substitutions)
    // horse -> rorse (replace 'h' with 'r') -> rose (remove 'r') -> ros (remove 'e')
    String w1_1 = "horse";
    String w1_2 = "ros";
    int result1 = new Edit_Distance().minDistance(w1_1, w1_2);
    System.out.println("Test 1 Result: " + result1);
    // Expected Output: 3

    // Test Case 2: Multi-step complex word alignment
    // intention -> inention (remove 't') -> enention (replace 'i' with 'e') 
    // -> exention (replace 'n' with 'x') -> execution (replace 'e' with 'u')
    String w2_1 = "intention";
    String w2_2 = "execution";
    int result2 = new Edit_Distance().minDistance(w2_1, w2_2);
    System.out.println("Test 2 Result: " + result2);
    // Expected Output: 5

    // Test Case 3: Empty string base case (All deletions or insertions)
    String w3_1 = "";
    String w3_2 = "abc";
    int result3 = new Edit_Distance().minDistance(w3_1, w3_2);
    System.out.println("Test 3 Result: " + result3);
    // Expected Output: 3

    // Test Case 4: Identical strings (No operations needed)
    String w4_1 = "hello";
    String w4_2 = "hello";
    int result4 = new Edit_Distance().minDistance(w4_1, w4_2);
    System.out.println("Test 4 Result: " + result4);
    // Expected Output: 0
}
}
