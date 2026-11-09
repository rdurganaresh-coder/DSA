package leetcode.Solutions_0101_0200.s0118_pascals_triangle;

// #Easy #Top_100_Liked_Questions #Top_Interview_Questions #Array #Dynamic_Programming
// #Data_Structure_I_Day_4_Array #Dynamic_Programming_I_Day_12 #Udemy_Dynamic_Programming
// #2022_06_23_Time_1_ms_(67.08%)_Space_42.4_MB_(5.58%)

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("java:S2589")
public class Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> currRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i || i <= 1) {
                    currRow.add(1);
                } else {
                    int currCell = output.get(i - 1).get(j - 1) + output.get(i - 1).get(j);
                    currRow.add(currCell);
                }
            }
            output.add(currRow);
        }
        return output;
    }

    public static void main(String[] args) {
    // Test Case 1: Standard multi-row execution (numRows = 5)
    List<List<Integer>> result1 = new Pascals_Triangle().generate(5);
    System.out.println("Test 1 (numRows = 5): " + result1);
    // Expected Output: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]

    // Test Case 2: Minimal single-row base case configuration (numRows = 1)
    List<List<Integer>> result2 = new Pascals_Triangle().generate(1);
    System.out.println("Test 2 (numRows = 1): " + result2);
    // Expected Output: [[1]]

    // Test Case 3: Edge case configuration for an empty output requirement (numRows = 0)
    List<List<Integer>> result3 = new Pascals_Triangle().generate(0);
    System.out.println("Test 3 (numRows = 0): " + result3);
    // Expected Output: []
}
}
