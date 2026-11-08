package leetcode.Solutions_0001_0100.s0073_set_matrix_zeroes;

import java.util.Arrays;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Array #Hash_Table #Matrix
// #Udemy_2D_Arrays/Matrix #Top_Interview_150_Matrix #Big_O_Time_O(m*n)_Space_O(1)
// #2024_11_11_Time_0_ms_(100.00%)_Space_45.6_MB_(50.86%)

public class Set_Matrix_Zeroes {
    // Approach: Use first row and first column for storing whether in future
    //           the entire row or column needs to be marked 0
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row0 = false;
        boolean col0 = false;
        // Check if 0th col needs to be market all 0s in future
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                col0 = true;
                break;
            }
        }
        // Check if 0th row needs to be market all 0s in future
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                row0 = true;
                break;
            }
        }
        // Store the signals in 0th row and column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // Mark 0 for all cells based on signal from 0th row and 0th column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // Set 0th column
        for (int i = 0; i < m; i++) {
            if (col0) {
                matrix[i][0] = 0;
            }
        }
        // Set 0th row
        for (int i = 0; i < n; i++) {
            if (row0) {
                matrix[0][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
    // Test Case 1: Standard matrix with an internal zero element
    int[][] matrix1 = {
        {1, 1, 1},
        {1, 0, 1},
        {1, 1, 1}
    };
    new Set_Matrix_Zeroes().setZeroes(matrix1);
    System.out.println("Test 1 Result: " + Arrays.deepToString(matrix1));
    // Expected Output: [[1, 0, 1], [0, 0, 0], [1, 0, 1]]

    // Test Case 2: Zeroes located explicitly along the first row and column borders
    int[][] matrix2 = {
        {0, 1, 2, 0},
        {3, 4, 5, 2},
        {1, 3, 1, 5}
    };
    new Set_Matrix_Zeroes().setZeroes(matrix2);
    System.out.println("Test 2 Result: " + Arrays.deepToString(matrix2));
    // Expected Output: [[0, 0, 0, 0], [0, 4, 5, 0], [0, 3, 1, 0]]

    // Test Case 3: Small 1x1 matrix without any zeroes
    int[][] matrix3 = {
        {5}
    };
    new Set_Matrix_Zeroes().setZeroes(matrix3);
    System.out.println("Test 3 Result: " + Arrays.deepToString(matrix3));
    // Expected Output: [[5]]

    // Test Case 4: Small 1x1 matrix containing a zero
    int[][] matrix4 = {
        {0}
    };
    new Set_Matrix_Zeroes().setZeroes(matrix4);
    System.out.println("Test 4 Result: " + Arrays.deepToString(matrix4));
    // Expected Output: [[0]]
}
}
