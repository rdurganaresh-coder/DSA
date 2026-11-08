package leetcode.Solutions_0001_0100.s0051_n_queens;

// #Hard #Top_100_Liked_Questions #Array #Backtracking #Big_O_Time_O(N!)_Space_O(N)
// #2024_11_11_Time_1_ms_(99.77%)_Space_44.8_MB_(61.16%)

import java.util.ArrayList;
import java.util.List;

public class N_queens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];
        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        return res;
    }

    void solve(
            int col,
            char[][] board,
            List<List<String>> res,
            int[] leftRow,
            int[] lowerDiagonal,
            int[] upperDiagonal) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0
                    && lowerDiagonal[row + col] == 0
                    && upperDiagonal[board.length - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                solve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }

    List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] chars : board) {
            String s = new String(chars);
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
    // Test Case 1: N = 1 (Should output [[Q]])
    List<List<String>> result1 = new N_queens().solveNQueens(1);
    System.out.println("N = 1 solution count: " + result1.size());
    System.out.println(result1);
    System.out.println();

    // Test Case 2: N = 2 (Should output [] because it's impossible)
    List<List<String>> result2 = new N_queens().solveNQueens(2);
    System.out.println("N = 2 solution count: " + result2.size());
    System.out.println(result2);
    System.out.println();

    // Test Case 3: N = 4 (Should output 2 distinct solution board layouts)
    List<List<String>> result3 = new N_queens().solveNQueens(4);
    System.out.println("N = 4 solution count: " + result3.size());
    System.out.println(result3);
    System.out.println();

    // Test Case 4: N = 8 (Verifying the count for the classic 8-Queens problem)
    List<List<String>> result4 = new N_queens().solveNQueens(8);
    System.out.println("N = 8 solution count: " + result4.size());
}
}
