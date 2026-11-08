package leetcode.Solutions_0001_0100.s0054_spiral_matrix;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Array #Matrix #Simulation
// #Programming_Skills_II_Day_8 #Level_2_Day_1_Implementation/Simulation #Udemy_2D_Arrays/Matrix
// #Top_Interview_150_Matrix #2025_03_04_Time_0_ms_(100.00%)_Space_41.08_MB_(99.19%)

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int r = 0;
        int c = 0;
        int bigR = matrix.length - 1;
        int bigC = matrix[0].length - 1;
        while (r <= bigR && c <= bigC) {
            for (int i = c; i <= bigC; i++) {
                list.add(matrix[r][i]);
            }
            r++;
            for (int i = r; i <= bigR; i++) {
                list.add(matrix[i][bigC]);
            }
            bigC--;
            for (int i = bigC; i >= c && r <= bigR; i--) {
                list.add(matrix[bigR][i]);
            }
            bigR--;
            for (int i = bigR; i >= r && c <= bigC; i--) {
                list.add(matrix[i][c]);
            }
            c++;
        }
        return list;
    }

    public static void main(String[] args) {
    // Test Case 1: Standard Square Matrix (3x3)
    int[][] matrix1 = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    List<Integer> result1 = new Spiral_Matrix().spiralOrder(matrix1);
    System.out.println("Test 1 (3x3 Square): " + result1);
    // Expected Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]

    // Test Case 2: Rectangular Matrix (3x4)
    int[][] matrix2 = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12}
    };
    List<Integer> result2 = new Spiral_Matrix().spiralOrder(matrix2);
    System.out.println("Test 2 (3x4 Rectangle): " + result2);
    // Expected Output: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]

    // Test Case 3: Single Row Matrix (1x4)
    int[][] matrix3 = {
        {1, 2, 3, 4}
    };
    List<Integer> result3 = new Spiral_Matrix().spiralOrder(matrix3);
    System.out.println("Test 3 (1x4 Single Row): " + result3);
    // Expected Output: [1, 2, 3, 4]

    // Test Case 4: Single Column Matrix (4x1)
    int[][] matrix4 = {
        {1},
        {2},
        {3},
        {4}
    };
    List<Integer> result4 = new Spiral_Matrix().spiralOrder(matrix4);
    System.out.println("Test 4 (4x1 Single Column): " + result4);
    // Expected Output: [1, 2, 3, 4]
}
}
