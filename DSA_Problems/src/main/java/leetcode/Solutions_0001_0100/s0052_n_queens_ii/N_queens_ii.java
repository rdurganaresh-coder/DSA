package leetcode.Solutions_0001_0100.s0052_n_queens_ii;

// #Hard #Backtracking #Top_Interview_150_Backtracking
// #2025_03_04_Time_0_ms_(100.00%)_Space_41.18_MB_(24.45%)

public class N_queens_ii {
    public int totalNQueens(int n) {
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[n];
        boolean[] diagonal = new boolean[n + n - 1];
        boolean[] antiDiagonal = new boolean[n + n - 1];
        return totalNQueens(n, 0, row, col, diagonal, antiDiagonal);
    }

    private int totalNQueens(
            int n,
            int r,
            boolean[] row,
            boolean[] col,
            boolean[] diagonal,
            boolean[] antiDiagonal) {
        if (r == n) {
            return 1;
        }
        int count = 0;
        for (int c = 0; c < n; c++) {
            if (!row[r] && !col[c] && !diagonal[r + c] && !antiDiagonal[r - c + n - 1]) {
                row[r] = col[c] = diagonal[r + c] = antiDiagonal[r - c + n - 1] = true;
                count += totalNQueens(n, r + 1, row, col, diagonal, antiDiagonal);
                row[r] = col[c] = diagonal[r + c] = antiDiagonal[r - c + n - 1] = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
    // Test Case 1: N = 1 (Should output 1)
    int result1 = new N_queens_ii().totalNQueens(1);
    System.out.println("N = 1 -> Total Solutions: " + result1);

    // Test Case 2: N = 2 (Should output 0)
    int result2 = new N_queens_ii().totalNQueens(2);
    System.out.println("N = 2 -> Total Solutions: " + result2);

    // Test Case 3: N = 3 (Should output 0)
    int result3 = new N_queens_ii().totalNQueens(3);
    System.out.println("N = 3 -> Total Solutions: " + result3);

    // Test Case 4: N = 4 (Should output 2)
    int result4 = new N_queens_ii().totalNQueens(4);
    System.out.println("N = 4 -> Total Solutions: " + result4);

    // Test Case 5: N = 8 (Should output 92)
    int result5 = new N_queens_ii().totalNQueens(8);
    System.out.println("N = 8 -> Total Solutions: " + result5);
}
}
