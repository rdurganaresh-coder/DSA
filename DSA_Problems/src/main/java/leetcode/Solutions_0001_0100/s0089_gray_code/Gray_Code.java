package leetcode.Solutions_0001_0100.s0089_gray_code;

// #Medium #Math #Bit_Manipulation #Backtracking
// #2022_06_20_Time_3_ms_(98.59%)_Space_47.3_MB_(99.65%)

import java.util.Arrays;
import java.util.List;

public class Gray_Code {
    public List<Integer> grayCode(int n) {
        Integer[] n1 = {0};
        int shift = 1;
        while (n > 0) {
            Integer[] temp = new Integer[n1.length * 2];
            int pos = 0;
            for (Integer integer : n1) {
                temp[pos++] = integer;
            }
            for (int i = n1.length - 1; i >= 0; i--) {
                temp[pos++] = n1[i] | shift;
            }
            n1 = temp;
            shift <<= 1;
            n--;
        }
        return Arrays.asList(n1);
    }

    public static void main(String[] args) {
    // Test Case 1: Minimum typical configuration (n = 2)
    // Binary sequence values: 00 (0), 01 (1), 11 (3), 10 (2)
    List<Integer> result1 = new Gray_Code().grayCode(2);
    System.out.println("Test 1 (n = 2): " + result1);
    // Expected Output: [0, 1, 3, 2]

    // Test Case 2: Minimal bit scale base case (n = 1)
    // Binary sequence values: 0, 1
    List<Integer> result2 = new Gray_Code().grayCode(1);
    System.out.println("Test 2 (n = 1): " + result2);
    // Expected Output: [0, 1]

    // Test Case 3: Zero bit edge configuration input (n = 0)
    // Binary sequence values: 0
    List<Integer> result3 = new Gray_Code().grayCode(0);
    System.out.println("Test 3 (n = 0): " + result3);
    // Expected Output: [0]

    // Test Case 4: Larger bit scale context verifying progression (n = 3)
    List<Integer> result4 = new Gray_Code().grayCode(3);
    System.out.println("Test 4 (n = 3): " + result4);
    // Expected Output: [0, 1, 3, 2, 6, 7, 5, 4]
}
}
