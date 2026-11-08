package leetcode.Solutions_0001_0100.s0037_sudoku_solver;

// #Hard #Array #Matrix #Backtracking #2023_08_09_Time_2_ms_(99.55%)_Space_40.4_MB_(20.80%)

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {
    private List<int[]> emptyCells = new ArrayList<>();
    private int[] rows = new int[9];
    private int[] cols = new int[9];
    private int[] boxes = new int[9];

    public void solveSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    emptyCells.add(new int[] {r, c});
                } else {
                    int val = board[r][c] - '0';
                    int boxPos = r / 3 * 3 + c / 3;
                    rows[r] |= 1 << val;
                    cols[c] |= 1 << val;
                    boxes[boxPos] |= 1 << val;
                }
            }
        }
        backtracking(board, 0);
    }

    private boolean backtracking(char[][] board, int i) {
        // Check if we filled all empty cells?
        if (i == emptyCells.size()) {
            return true;
        }

        int r = emptyCells.get(i)[0];
        int c = emptyCells.get(i)[1];
        int boxPos = (r / 3) * 3 + c / 3;
        for (int val = 1; val <= 9; ++val) {
            // skip if that value is existed!
            if (hasBit(rows[r], val) || hasBit(cols[c], val) || hasBit(boxes[boxPos], val)) {
                continue;
            }
            board[r][c] = (char) ('0' + val);
            // backup old values
            int oldRow = rows[r];
            int oldCol = cols[c];
            int oldBox = boxes[boxPos];
            rows[r] |= 1 << val;
            cols[c] |= 1 << val;
            boxes[boxPos] |= 1 << val;
            if (backtracking(board, i + 1)) {
                return true;
            }
            rows[r] = oldRow;
            cols[c] = oldCol;
            boxes[boxPos] = oldBox;
        }
        return false;
    }

    private boolean hasBit(int x, int k) {
        return (x >> k & 1) == 1;
    }

    private static void printBoard(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                System.out.print(board[r][c] + " ");
                if ((c + 1) % 3 == 0 && c < 8) System.out.print("| ");
            }
            System.out.println();
            if ((r + 1) % 3 == 0 && r < 8) {
                System.out.println("---------------------");
            }
        }
    }
    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println("--- Original Sudoku Puzzle ---");
        printBoard(board);
        System.out.println();

        SudokuSolver solver = new SudokuSolver();
        solver.solveSudoku(board);

        System.out.println("--- Solved Sudoku Grid ---");
        printBoard(board);
    }
}
