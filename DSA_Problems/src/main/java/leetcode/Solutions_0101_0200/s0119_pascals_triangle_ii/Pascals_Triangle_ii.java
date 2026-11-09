package leetcode.Solutions_0101_0200.s0119_pascals_triangle_ii;

// #Easy #Array #Dynamic_Programming #Data_Structure_II_Day_3_Array #Dynamic_Programming_I_Day_12
// #Udemy_Dynamic_Programming #2022_06_23_Time_0_ms_(100.00%)_Space_41.5_MB_(70.65%)

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle_ii {
    public List<Integer> getRow(int rowIndex) {
        int[] buffer = new int[rowIndex + 1];
        buffer[0] = 1;
        computeRow(buffer, 1);
        // Copy buffer to List of Integer.
        List<Integer> ans = new ArrayList<>(buffer.length);
        for (int j : buffer) {
            ans.add(j);
        }
        return ans;
    }

    private void computeRow(int[] buffer, int k) {
        if (k >= buffer.length) {
            return;
        }
        int previous = buffer[0];
        for (int i = 1; i < k; i++) {
            int tmp = previous + buffer[i];
            previous = buffer[i];
            buffer[i] = tmp;
        }
        buffer[k] = 1;
        computeRow(buffer, k + 1);
    }

    public static void main(String[] args) {
    // Test Case 1: Standard row generation (rowIndex = 3)
    // Row elements: 1, 3, 3, 1
    List<Integer> result1 = new Pascals_Triangle_ii().getRow(3);
    System.out.println("Test 1 (rowIndex = 3): " + result1);

    // Test Case 2: Zero index base case configuration (rowIndex = 0)
    // Row elements: 1
    List<Integer> result2 = new Pascals_Triangle_ii().getRow(0);
    System.out.println("Test 2 (rowIndex = 0): " + result2);

    // Test Case 3: Small level index configuration (rowIndex = 1)
    // Row elements: 1, 1
    List<Integer> result3 = new Pascals_Triangle_ii().getRow(1);
    System.out.println("Test 3 (rowIndex = 1): " + result3);

    // Test Case 4: Larger level index configuration to verify scaling (rowIndex = 5)
    // Row elements: 1, 5, 10, 10, 5, 1
    List<Integer> result4 = new Pascals_Triangle_ii().getRow(5);
    System.out.println("Test 4 (rowIndex = 5): " + result4);
}
}
