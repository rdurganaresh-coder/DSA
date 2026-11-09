package leetcode.Solutions_0001_0100.s0079_word_search;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Array #Matrix #Backtracking
// #Algorithm_II_Day_11_Recursion_Backtracking #Top_Interview_150_Backtracking
// #Big_O_Time_O(4^(m*n))_Space_O(m*n) #2024_11_11_Time_64_ms_(98.51%)_Space_41.6_MB_(51.63%)

public class Word_Search {
    private boolean exists = false;

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    dfs(board, word, 1, i, j);
                }
            }
        }
        return exists;
    }

    private void dfs(char[][] board, String word, int wordIndex, int i, int j) {
        if (wordIndex == word.length()) {
            exists = true;
            return;
        }
        char currentChar = board[i][j];
        char nextChar = word.charAt(wordIndex);
        if (i > 0 && board[i - 1][j] == nextChar) {
            // go up
            board[i][j] = '-';
            dfs(board, word, wordIndex + 1, i - 1, j);
            board[i][j] = currentChar;
        }
        if (j > 0 && board[i][j - 1] == nextChar) {
            // go left
            board[i][j] = '-';
            dfs(board, word, wordIndex + 1, i, j - 1);
            board[i][j] = currentChar;
        }
        if (i < board.length - 1 && board[i + 1][j] == nextChar) {
            // go down
            board[i][j] = '-';
            dfs(board, word, wordIndex + 1, i + 1, j);
            board[i][j] = currentChar;
        }
        if (j < board[0].length - 1 && board[i][j + 1] == nextChar) {
            // go right
            board[i][j] = '-';
            dfs(board, word, wordIndex + 1, i, j + 1);
            board[i][j] = currentChar;
        }
    }

    public static void main(String[] args) {
    // Test Case 1: Word exists via a winding path (Should output true)
    char[][] board1 = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    };
    boolean result1 = new Word_Search().exist(board1, "ABCCED");
    System.out.println("Test 1 (ABCCED): " + result1);

    // Test Case 2: Word exists as a single character matching the board (Should output true)
    char[][] board2 = {
        {'a'}
    };
    boolean result2 = new Word_Search().exist(board2, "a");
    System.out.println("Test 2 (a): " + result2);

    // Test Case 3: Word path attempts to revisit the same cell twice (Should output false)
    char[][] board3 = {
        {'A', 'B'},
        {'C', 'D'}
    };
    boolean result3 = new Word_Search().exist(board3, "ABA");
    System.out.println("Test 3 (ABA): " + result3);

    // Test Case 4: The word cannot be formed from the board grid elements (Should output false)
    char[][] board4 = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    };
    boolean result4 = new Word_Search().exist(board4, "ABCD");
    System.out.println("Test 4 (ABCD): " + result4);
}
}
