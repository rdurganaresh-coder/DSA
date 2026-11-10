package startpatterns;

public class CapitalAlphabetPatternMatrix {

    public static void displayPattern(char letter, int n) {
        int mid = n / 2;
        int end = n / 2; // Right boundary line index

        System.out.println("--- Letter " + letter + " ---");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= end; j++) {
                boolean printStar = false;

                switch (letter) {
                    case 'A':
                        if (j == 0 || j == end || i == mid || i == 0) {
                            if (i == 0 && (j == 0 || j == end)) printStar = false;
                            else printStar = true;
                        }
                        break;

                    case 'B':
                        if (j == 0 || i == 0 || i == mid || i == n - 1 || j == end) {
                            if ((i == 0 || i == mid || i == n - 1) && j == end) printStar = false;
                            else printStar = true;
                        }
                        break;

                    case 'C':
                        if (j == 0 || i == 0 || i == n - 1) {
                            if ((i == 0 || i == n - 1) && j == 0) printStar = false;
                            else printStar = true;
                        }
                        break;

                    case 'D':
                        if (j == 0 || i == 0 || i == n - 1 || j == end) {
                            if ((i == 0 || i == n - 1) && j == end) printStar = false;
                            else printStar = true;
                        }
                        break;

                    case 'E':
                        if (j == 0 || i == 0 || i == mid || i == n - 1) {
                            printStar = true;
                        }
                        break;

                    case 'F':
                        if (j == 0 || i == 0 || i == mid) {
                            printStar = true;
                        }
                        break;

                    case 'G':
                        if (j == 0 || i == 0 || i == n - 1 || (j == end && i >= mid) || (i == mid && j >= mid - 1)) {
                            if ((i == 0 || i == n - 1) && j == 0) printStar = false;
                            else printStar = true;
                        }
                        break;

                    case 'H':
                        if (j == 0 || j == end || i == mid) {
                            printStar = true;
                        }
                        break;

                    case 'I':
                        if (i == 0 || i == n - 1 || j == mid) {
                            printStar = true;
                        }
                        break;

                    case 'J':
                        if (i == 0 || j == mid || (i == n - 1 && j <= mid) || (j == 0 && i >= mid + 1)) {
                            if (i == n - 1 && j == 0) printStar = false;
                            else printStar = true;
                        }
                        break;

                    case 'K':
                        // Diagonal mapping logic using math offsets
                        if (j == 0 || j == mid - i + 1 || j == i - mid + 1) {
                            printStar = true;
                        }
                        break;

                    case 'L':
                        if (j == 0 || i == n - 1) {
                            printStar = true;
                        }
                        break;

                    case 'M':
                        if (j == 0 || j == end || (i <= mid && (i == j || i + j == end))) {
                            printStar = true;
                        }
                        break;

                    case 'N':
                        if (j == 0 || j == end || i == j) {
                            printStar = true;
                        }
                        break;

                    case 'O':
                        if (j == 0 || j == end || i == 0 || i == n - 1) {
                            if ((i == 0 || i == n - 1) && (j == 0 || j == end)) printStar = false;
                            else printStar = true;
                        }
                        break;

                    case 'P':
                        if (j == 0 || i == 0 || i == mid || (j == end && i <= mid)) {
                            if ((i == 0 || i == mid) && j == end) printStar = false;
                            else printStar = true;
                        }
                        break;

                    case 'Q':
                        if (((j == 0 || j == end - 1) && i < n - 2 && i > 0) || 
                            ((i == 0 || i == n - 2) && j > 0 && j < end - 1) || 
                            (i == j && i >= mid)) {
                            printStar = true;
                        }
                        break;

                    case 'R':
                        if (j == 0 || i == 0 || i == mid || (j == end && i <= mid) || (i >= mid && j == i - mid + 1)) {
                            if ((i == 0 || i == mid) && j == end) printStar = false;
                            else printStar = true;
                        }
                        break;

                    case 'S':
                        if (i == 0 || i == mid || i == n - 1 || (j == 0 && i < mid) || (j == end && i > mid)) {
                            if (i == 0 && j == 0) printStar = false;
                            else if (i == n - 1 && j == end) printStar = false;
                            else printStar = true;
                        }
                        break;

                    case 'T':
                        if (i == 0 || j == mid) {
                            printStar = true;
                        }
                        break;

                    case 'U':
                        if (j == 0 || j == end || i == n - 1) {
                            if (i == n - 1 && (j == 0 || j == end)) printStar = false;
                            else printStar = true;
                        }
                        break;

                    case 'V':
                        // Inverted point scaling formulas
                        if ((j == i / 2 && i % 2 == 0) || (j == end - (i / 2) && i % 2 == 0)) {
                            printStar = true;
                        }
                        break;

                    case 'W':
                        if (j == 0 || j == end || (i >= mid && (i == j || i + j == end * 2))) {
                            printStar = true;
                        }
                        break;

                    case 'X':
                        if (i == j || i + j == end) {
                            printStar = true;
                        }
                        break;

                    case 'Y':
                        if ((i <= mid && (i == j || i + j == end)) || (i > mid && j == mid)) {
                            printStar = true;
                        }
                        break;

                    case 'Z':
                        if (i == 0 || i == n - 1 || i + j == end) {
                            printStar = true;
                        }
                        break;
                }

                System.out.print(printStar ? "*" : " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int inputSize = 7; // Balanced layout baseline dimension scale
        
        // Loop execution targeting the full A-Z sequence spectrum
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            displayPattern(ch, inputSize);
        }
    }
}
