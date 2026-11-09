package leetcode.Solutions_0001_0100.s0091_decode_ways;

// #Medium #Top_Interview_Questions #String #Dynamic_Programming
// #Algorithm_II_Day_15_Dynamic_Programming #Dynamic_Programming_I_Day_10
// #2022_06_21_Time_2_ms_(66.37%)_Space_41.8_MB_(78.45%)

public class Decode_Ways {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int[] f = new int[n + 1];
        // Auxiliary
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            // Calculate the independent number
            if (s.charAt(i - 1) != '0') {
                // As long as the current character is not 0, it means that the previous decoding
                // number can be inherited
                f[i] = f[i - 1];
            }
            // Calculate the number of combinations
            int twodigits = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (twodigits >= 10 && twodigits <= 26) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
    // Test Case 1: Standard string with multiple separate decoding options
    // "12" can be decoded as "AB" (1 2) or "L" (12)
    String s1 = "12";
    int result1 = new Decode_Ways().numDecodings(s1);
    System.out.println("Test 1 Result (\"12\"): " + result1);
    // Expected Output: 2

    // Test Case 2: Longer string with multi-digit overlapping combinations
    // "226" can be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6)
    String s2 = "226";
    int result2 = new Decode_Ways().numDecodings(s2);
    System.out.println("Test 2 Result (\"226\"): " + result2);
    // Expected Output: 3

    // Test Case 3: Leading zero invalid configuration edge case
    String s3 = "06";
    int result3 = new Decode_Ways().numDecodings(s3);
    System.out.println("Test 3 Result (\"06\"): " + result3);
    // Expected Output: 0

    // Test Case 4: String containing internal valid zero groups (e.g., '10')
    // "10" can only be decoded as "J" (10). '0' cannot stand alone.
    String s4 = "10";
    int result4 = new Decode_Ways().numDecodings(s4);
    System.out.println("Test 4 Result (\"10\"): " + result4);
    // Expected Output: 1
}
}
