package leetcode.Solutions_0001_0100.s0074_search_a_2d_matrix;

// #Medium #Top_100_Liked_Questions #Array #Binary_Search #Matrix #Data_Structure_I_Day_5_Array
// #Algorithm_II_Day_1_Binary_Search #Binary_Search_I_Day_8 #Level_2_Day_8_Binary_Search
// #Udemy_2D_Arrays/Matrix #Top_Interview_150_Binary_Search #Big_O_Time_O(endRow+endCol)_Space_O(1)
// #2024_11_11_Time_0_ms_(100.00%)_Space_42.2_MB_(40.02%)

public class Search_A_2d_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int endRow = matrix.length;
        int endCol = matrix[0].length;
        int targetRow = 0;
        boolean result = false;
        for (int i = 0; i < endRow; i++) {
            if (matrix[i][endCol - 1] >= target) {
                targetRow = i;
                break;
            }
        }
        for (int i = 0; i < endCol; i++) {
            if (matrix[targetRow][i] == target) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
    // Test Case 1: Target exists in the matrix (Should output true)
    int[][] matrix1 = {
        {1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 60}
    };
    boolean result1 = new Search_A_2d_Matrix().searchMatrix(matrix1, 3);
    System.out.println("Test 1 (Target 3): " + result1);

    // Test Case 2: Target does not exist in the matrix (Should output false)
    int[][] matrix2 = {
        {1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 60}
    };
    boolean result2 = new Search_A_2d_Matrix().searchMatrix(matrix2, 13);
    System.out.println("Test 2 (Target 13): " + result2);

    // Test Case 3: Target is smaller than the first element (Should output false)
    int[][] matrix3 = {
        {5, 8, 12},
        {15, 20, 25}
    };
    boolean result3 = new Search_A_2d_Matrix().searchMatrix(matrix3, 2);
    System.out.println("Test 3 (Target 2): " + result3);

    // Test Case 4: Target is larger than the absolute maximum element
    int[][] matrix4 = {
        {1, 3},
        {5, 7}
    };
    boolean result4 = new Search_A_2d_Matrix().searchMatrix(matrix4, 10);
    System.out.println("Test 4 (Target 10): " + result4);
}
}
