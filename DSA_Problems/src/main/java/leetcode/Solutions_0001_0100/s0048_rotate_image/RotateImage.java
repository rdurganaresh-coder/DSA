package leetcode.Solutions_0001_0100.s0048_rotate_image;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Array #Math #Matrix
// #Data_Structure_II_Day_3_Array #Programming_Skills_II_Day_7 #Udemy_2D_Arrays/Matrix
// #Top_Interview_150_Matrix #Big_O_Time_O(n^2)_Space_O(1)
// #2024_11_10_Time_0_ms_(100.00%)_Space_42.2_MB_(43.71%)

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int[][] pos =
                        new int[][] {
                            {i, j}, {j, n - 1 - i}, {n - 1 - i, n - 1 - j}, {n - 1 - j, i}
                        };
                int t = matrix[pos[0][0]][pos[0][1]];
                for (int k = 1; k < pos.length; k++) {
                    int temp = matrix[pos[k][0]][pos[k][1]];
                    matrix[pos[k][0]][pos[k][1]] = t;
                    t = temp;
                }
                matrix[pos[0][0]][pos[0][1]] = t;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RotateImage solver = new RotateImage();

        // Test Case 1: Standard 3x3 Matrix
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("--- Test Case 1: Original 3x3 ---");
        printMatrix(matrix1);
        
        solver.rotate(matrix1);
        
        System.out.println("\n--- Test Case 1: Rotated 90 Degrees ---");
        printMatrix(matrix1);
        System.out.println();

        // Test Case 2: Standard 4x4 Matrix
        int[][] matrix2 = {
            {5, 1, 9, 11},
            {2, 4, 8, 10},
            {13, 3, 6, 7},
            {15, 14, 12, 16}
        };
        System.out.println("--- Test Case 2: Original 4x4 ---");
        printMatrix(matrix2);
        
        solver.rotate(matrix2);
        
        System.out.println("\n--- Test Case 2: Rotated 90 Degrees ---");
        printMatrix(matrix2);
    }
}
