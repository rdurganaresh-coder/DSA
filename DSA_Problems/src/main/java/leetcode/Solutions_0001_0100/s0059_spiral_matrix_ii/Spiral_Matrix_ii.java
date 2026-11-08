package leetcode.Solutions_0001_0100.s0059_spiral_matrix_ii;

import java.util.Arrays;

// #Medium #Array #Matrix #Simulation #Data_Structure_II_Day_3_Array
// #2023_08_11_Time_0_ms_(100.00%)_Space_40_MB_(98.82%)

public class Spiral_Matrix_ii {
    public int[][] generateMatrix(int n) {
        int num = 1;
        int rStart = 0;
        int rEnd = n - 1;
        int cStart = 0;
        int cEnd = n - 1;
        int[][] spiral = new int[n][n];
        while (rStart <= rEnd && cStart <= cEnd) {
            for (int k = cStart; k <= cEnd; k++) {
                spiral[rStart][k] = num++;
            }
            rStart++;
            for (int k = rStart; k <= rEnd; k++) {
                spiral[k][cEnd] = num++;
            }
            cEnd--;
            if (rStart <= rEnd) {
                for (int k = cEnd; k >= cStart; k--) {
                    spiral[rEnd][k] = num++;
                }
            }
            rEnd--;
            if (cStart <= cEnd) {
                for (int k = rEnd; k >= rStart; k--) {
                    spiral[k][cStart] = num++;
                }
            }
            cStart++;
        }
        return spiral;
    }

    public static void main(String[] args) {
    // Test Case 1: Minimum standard input (N = 1)
    int[][] result1 = new Spiral_Matrix_ii().generateMatrix(1);
    System.out.println("Test 1 (N = 1): " + Arrays.deepToString(result1));
    // Expected Output: [[1]]

    // Test Case 2: Even dimension matrix (N = 2)
    int[][] result2 = new Spiral_Matrix_ii().generateMatrix(2);
    System.out.println("Test 2 (N = 2): " + Arrays.deepToString(result2));
    // Expected Output: [[1, 2], [4, 3]]

    // Test Case 3: Standard odd dimension matrix (N = 3)
    int[][] result3 = new Spiral_Matrix_ii().generateMatrix(3);
    System.out.println("Test 3 (N = 3): " + Arrays.deepToString(result3));
    // Expected Output: [[1, 2, 3], [8, 9, 4], [7, 6, 5]]
}
}
