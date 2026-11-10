package startpatterns;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 📘 THE ULTIMATE JAVA LOOPS MEGA-WORKBOOK (COMPLETE COMPILATION)
 * -----------------------------------------------------------------
 * A comprehensive, zero-dependency educational guide to master control flow.
 * Covers basic counters, data collection streams, advanced coordinate matrices,
 * jump statements, and deep pipeline escape labels.
 * -----------------------------------------------------------------
 */
public class LoopsMegaWorkbook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================================");
        System.out.println("   🚀 WELCOME TO THE CONSOLIDATED JAVA LOOPS MEGA-WORKBOOK 🚀   ");
        System.out.println("==================================================================\n");

        // =====================================================================
        // CHAPTER 1: The 'for' Loop - Counter-Driven Control Flow
        // =====================================================================
        printChapterHeader(1, "The 'for' Loop (Counted Iterations)");
        challengeLog("Challenge 1.1: Print even numbers between 1 and 10.");
        System.out.print("   Result: ");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n");

        challengeLog("Challenge 1.2: Compute the sum of the first N numbers (N = 5).");
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += i;
        }
        System.out.println("   Result: Sum of 1 to 5 is = " + sum + "\n");

        // =====================================================================
        // CHAPTER 2: The 'while' Loop - Condition-Driven Control Flow
        // =====================================================================
        printChapterHeader(2, "The 'while' Loop (Conditional Iterations)");
        challengeLog("Challenge 2.1: Count down from 5 down to 1.");
        System.out.print("   Result: ");
        int countdown = 5;
        while (countdown > 0) {
            System.out.print(countdown + " ");
            countdown--;
        }
        System.out.println("\n");

        challengeLog("Challenge 2.2: Extract digits from an integer variable backwards (Number = 4823).");
        System.out.print("   Result: ");
        int number = 4823;
        while (number > 0) {
            int lastDigit = number % 10;
            System.out.print(lastDigit + " ");
            number = number / 10;
        }
        System.out.println("\n");

        // =====================================================================
        // CHAPTER 3: The 'do-while' Loop - Guaranteed Execution Run
        // =====================================================================
        printChapterHeader(3, "The 'do-while' Loop (Post-Condition Evaluation)");
        challengeLog("Challenge 3.1: Run a simulation snippet that exits immediately.");
        int statusTracker = 100;
        System.out.print("   Result: ");
        do {
            System.out.print("[Executed Once even though condition is false: tracker=" + statusTracker + "] ");
        } while (statusTracker < 10);
        System.out.println("\n");

        // =====================================================================
        // CHAPTER 4: Nested Loops - Multidimensional Grid Operations
        // =====================================================================
        printChapterHeader(4, "Nested Loops & Geometric Star Patterns");

        challengeLog("Challenge 4.1: Right-Angled Triangle Pattern (Scale = 5)");
        int rowsTriangle = 5;
        for (int i = 1; i <= rowsTriangle; i++) {
            System.out.print("   ");
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        challengeLog("Challenge 4.2: Inverted Right-Angled Pyramid (Scale = 5)");
        int rowsInverted = 5;
        for (int i = rowsInverted; i >= 1; i--) {
            System.out.print("   ");
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        challengeLog("Challenge 4.3: Solid Block Square Matrix (Scale = 4x4)");
        int matrixScale = 4;
        for (int i = 0; i < matrixScale; i++) {
            System.out.print("   ");
            for (int j = 0; j < matrixScale; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        challengeLog("Challenge 4.4: Pyramid / Equilateral Triangle (Scale Height = 4)");
        int height = 4;
        for (int i = 1; i <= height; i++) {
            System.out.print("   ");
            for (int space = 1; space <= height - i; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= (2 * i - 1); star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("\n");

        // =====================================================================
        // CHAPTER 5: Interactive Laboratory Exercise - Chapter 1 Baseline
        // =====================================================================
        printChapterHeader(5, "Interactive Laboratory Terminal Exercise");
        System.out.println("👉 Challenge 5.1: Enter a number to generate its Multiplication Table!");
        System.out.print("   Type any integer here and press Enter: ");
        try {
            int inputUser = scanner.nextInt();
            System.out.println("\n   Generated Table Matrix for " + inputUser + ":");
            for (int i = 1; i <= 10; i++) {
                System.out.println("   | " + inputUser + " x " + i + " = " + (inputUser * i));
            }
        } catch (Exception e) {
            System.out.println("   ⚠️ Input parsing aborted. Defaulting execution stack onward.");
            scanner.next(); // Clear scanner buffer
        }
        System.out.println();

        // =====================================================================
        // CHAPTER 6: Loop Interruptions - 'break' vs 'continue'
        // =====================================================================
        printChapterHeader(6, "Jump Statements (break & continue)");

        challengeLog("Challenge 6.1: Use 'continue' to skip multiples of 3 in a range from 1 to 8.");
        System.out.print("   Result: ");
        for (int i = 1; i <= 8; i++) {
            if (i % 3 == 0) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println("\n");

        challengeLog("Challenge 6.2: Use 'break' to stop a loop immediately when target value 7 is reached.");
        System.out.print("   Result: ");
        for (int i = 1; i <= 20; i++) {
            if (i == 7) {
                System.out.print("[Target Hit! Exiting] ");
                break;
            }
            System.out.print(i + " ");
        }
        System.out.println("\n");

        // =====================================================================
        // CHAPTER 7: Processing Array Collections
        // =====================================================================
        printChapterHeader(7, "Array Traversal and Data Manipulation");

        int[] scores = { 45, 82, 91, 38, 73 };
        challengeLog("Challenge 7.1: Find the maximum score in an array. Target Array: " + Arrays.toString(scores));
        int highest = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > highest) {
                highest = scores[i];
            }
        }
        System.out.println("   Result: The maximum element found is = " + highest + "\n");

        challengeLog("Challenge 7.2: Use an Enhanced For-Each loop to calculate the average of values.");
        int totalSum = 0;
        for (int score : scores) {
            totalSum += score;
        }
        double average = (double) totalSum / scores.length;
        System.out.println("   Result: Array Average Calculated = " + average + "\n");

        // =====================================================================
        // CHAPTER 8: Advanced Geometric Architecture
        // =====================================================================
        printChapterHeader(8, "Complex Structural Grid Engineering");

        challengeLog("Challenge 8.1: Complete Diamond Pattern Layout (Scale Size Height = 5)");
        System.out.println("   Result:");
        int n = 5;
        for (int i = 1; i <= n; i++) {
            System.out.print("   ");
            for (int j = 1; j <= n - i; j++)
                System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++)
                System.out.print("*");
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            System.out.print("   ");
            for (int j = 1; j <= n - i; j++)
                System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++)
                System.out.print("*");
            System.out.println();
        }
        System.out.println();

        challengeLog("Challenge 8.2: Hollow Border Box Square Frame (Matrix = 5x5)");
        System.out.println("   Result:");
        int size = 5;
        for (int i = 0; i < size; i++) {
            System.out.print("   ");
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println("\n");
        // =====================================================================
        // CHAPTER 9: Interactive State Machine Sentinel Loop Laboratory
        // =====================================================================
        printChapterHeader(9, "Sentinel Value Control & User Inputs Validation");
        System.out.println("👉 Challenge 9.1: Type values to continually accumulate balances.");
        System.out
                .println("   [RULE]: The system loops indefinitely until you input the secret kill-code (-1) to exit.");
        int runSum = 0;
        while (true) {
            System.out.print("   Enter value to add (or -1 to quit): ");
            try {
                int inputVal = scanner.nextInt();
                if (inputVal == -1) {
                    System.out.println("   🚨 Sentinel kill code intercepted! Breaking out of loop.");
                    break;
                }
                runSum += inputVal;
                System.out.println("     Current Running Total Cumulative Balance: " + runSum);
            } catch (Exception e) {
                System.out.println("   ⚠️ Non-integer value provided. Discarding entry.");
                scanner.next();
            }
        }
        System.out.println();
        scanner.nextLine(); // Consume remainder line clear
        // =====================================================================
        // CHAPTER 10: 2D Arrays & Matrix Processing
        // =====================================================================
        printChapterHeader(10, "2D Arrays & Coordinate Matrix Grids");
        challengeLog("Challenge 10.1: Print a 3x3 Tic-Tac-Toe Game Board layout.");
        char[][] board = {
                { 'X', 'O', 'X' },
                { 'O', 'X', 'O' },
                { 'X', ' ', 'O' }
        };
        System.out.println("   Result:");
        for (int row = 0; row < board.length; row++) {
            System.out.print("   ");
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(" " + board[row][col] + " ");
                if (col < board[row].length - 1)
                    System.out.print("|");
            }
            System.out.println();
            if (row < board.length - 1) {
                System.out.println("   -----------");
            }
        }
        System.out.println();
        challengeLog("Challenge 10.2: Compute the sum of all elements in an integer matrix grid.");
        int[][] numberGrid = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int gridSum = 0;
        for (int[] rowArray : numberGrid) {
            for (int value : rowArray) {
                gridSum += value;
            }
        }
        System.out.println("   Result: Cumulative Grid Sum = " + gridSum + "\n");
        // =====================================================================
        // CHAPTER 11: Labeled Loops for Deep Nested Breaks
        // =====================================================================
        printChapterHeader(11, "Labeled Loops (Deep Control Escapes)");
        challengeLog("Challenge 11.1: Terminate multi-layer coordinates instantly via identifiers.");
        System.out.println("   Searching 2D plane matrix space...");
        matrixScanner: for (int row = 1; row <= 5; row++) {
            for (int col = 1; col <= 5; col++) {
                System.out.println("   Checking Coordinates: [Row: " + row + ", Col: " + col + "]");
                if (row == 2 && col == 3) {
                    System.out.println("   🎯 Target Item found! Escaping entire multi-layer tracking system...");
                    break matrixScanner;
                }
            }
        }
        System.out.println("   Exited out cleanly.\n");
        // =====================================================================
        // CHAPTER 12: Independent Self-Test Laboratory & Homework Blueprint
        // =====================================================================
        printChapterHeader(12, "Independent Homework Challenge Lab");
        System.out.println("👉 Homework Assignments Review Panel:");
        System.out.println("   1. Fibonacci Sequence Generation Model Matrix Loop");
        System.out.println("   2. Prime Number Square Root Boundary Verification Filter");
        System.out.println("\nPress [Enter] to reveal the solution benchmarks matrix execution...");
        scanner.nextLine();
        printSolutionsBlueprint();
        System.out.println("==================================================================");
        System.out.println(" 🎉 GRAND FINALE COMPLETE! YOU ARE A MASTER OF JAVA LOOPS FLOW! 🎉");
        System.out.println("==================================================================");
        scanner.close();
    }

    // --- Decorative Presentation & Utility Methods ---
    private static void printChapterHeader(int chapterNum, String title) {
        System.out.println("------------------------------------------------------------------");
        System.out.println(" 📖 CHAPTER " + chapterNum + ": " + title.toUpperCase());
        System.out.println("------------------------------------------------------------------");
    }

    private static void challengeLog(String text) {
        System.out.println("👉 " + text);
    }

    private static void printSolutionsBlueprint() {
        System.out.println("==================================================================");
        System.out.println(" 🔑 HOMEWORK SOLUTIONS BLUEPRINT REFERENCE ANSWER MATRIX");
        System.out.println("==================================================================");
        System.out.println("\n💡 Solution 1: Fibonacci Generator Logic (N = 6)");
        System.out.print("   Code Output: ");
        int n1 = 0, n2 = 1;
        for (int i = 0; i < 6; i++) {
            System.out.print(n1 + " ");
            int next = n1 + n2;
            n1 = n2;
            n2 = next;
        }
        System.out.println("\n");
        System.out.println("💡 Solution 2: Prime Number Check (Number = 17)");
        int checkNum = 17;
        boolean isPrime = true;
        if (checkNum <= 1)
            isPrime = false;
        else {
            for (int i = 2; i <= Math.sqrt(checkNum); i++) {
                if (checkNum % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        System.out.println("   Code Output: Is " + checkNum + " prime? " + isPrime + "\n");
    }
}
