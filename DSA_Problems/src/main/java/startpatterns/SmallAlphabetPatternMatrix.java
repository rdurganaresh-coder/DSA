package startpatterns;

public class SmallAlphabetPatternMatrix {

    public static void displayPattern(char letter, int n) {
        int mid = n / 2;
        int end = n / 2; // Right boundary line index

        System.out.println("--- Letter " + letter + " ---");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= end; j++) {
                boolean printStar = false;

                switch (letter) {
                    case 'a':
                        if ((i == mid || i == n - 1) && j > 0 && j < end) printStar = true;
                        else if (j == end && i > 0) printStar = true;
                        else if (j == 0 && i > mid && i < n - 1) printStar = true;
                        break;

                    case 'b':
                        if (j == 0 || ((i == mid || i == n - 1) && j < end) || (j == end && i > mid && i < n - 1)) printStar = true;
                        break;

                    case 'c':
                        if ((j == 0 && i > mid && i < n - 1) || ((i == mid || i == n - 1) && j > 0)) printStar = true;
                        break;

                    case 'd':
                        if (j == end || ((i == mid || i == n - 1) && j > 0 && j < end) || (j == 0 && i > mid && i < n - 1)) printStar = true;
                        break;

                    case 'e':
                        if (i == mid || ((i == mid - 1 || i == n - 1) && j > 0 && j < end) || (j == 0 && i > mid - 1 && i < n - 1) || (j == end && i == mid - 1)) printStar = true;
                        break;

                    case 'f':
                        if (j == mid && i > 0) printStar = true;
                        else if (i == 0 && j > mid) printStar = true;
                        else if (i == mid - 1) printStar = true;
                        break;

                    case 'g':
                        if (j == end || ((i == mid || i == n - 2) && j > 0 && j < end) || (j == 0 && i > mid && i < n - 2) || (i == n - 1 && j < end)) printStar = true;
                        break;

                    case 'h':
                        if (j == 0 || (i == mid && j < end) || (j == end && i > mid)) printStar = true;
                        break;

                    case 'i':
                        if (i == 0 && j == mid) printStar = true;
                        else if (i > 1 && j == mid) printStar = true;
                        break;

                    case 'j':
                        if (i == 0 && j == mid) printStar = true;
                        else if (i > 1 && i < n - 1 && j == mid) printStar = true;
                        else if (i == n - 1 && j < mid) printStar = true;
                        break;

                    case 'k':
                        if (j == 0 || (i >= mid && (j == mid - (i - mid) || j == i - mid))) printStar = true;
                        break;

                    case 'l':
                        if (j == mid && i < n - 1) printStar = true;
                        else if (i == n - 1 && j > mid) printStar = true;
                        break;

                    case 'm':
                        if (j == 0 || (i == mid && j > 0) || (j == mid && i > mid) || (j == end && i > mid)) printStar = true;
                        break;

                    case 'n':
                        if (j == 0 || (i == mid && j < end) || (j == end && i > mid)) printStar = true;
                        break;

                    case 'o':
                        if (((i == mid || i == n - 1) && j > 0 && j < end) || ((j == 0 || j == end) && i > mid && i < n - 1)) printStar = true;
                        break;

                    case 'p':
                        if (j == 0 || ((i == mid || i == n - 2) && j < end) || (j == end && i > mid && i < n - 2)) printStar = true;
                        break;

                    case 'q':
                        if (j == end || ((i == mid || i == n - 2) && j > 0 && j < end) || (j == 0 && i > mid && i < n - 2)) printStar = true;
                        break;

                    case 'r':
                        if (j == 0 || (i == mid && j > 0)) printStar = true;
                        break;

                    case 's':
                        if (i == mid || i == n - 1 || (j == 0 && i == mid + 1) || (j == end && i == n - 2)) printStar = true;
                        break;

                    case 't':
                        if (j == mid - 1 && i < n - 1) printStar = true;
                        else if (i == mid - 1) printStar = true;
                        else if (i == n - 1 && j >= mid - 1) printStar = true;
                        break;

                    case 'u':
                        if (j == end || (i == n - 1 && j < end) || (j == 0 && i >= mid && i < n - 1)) printStar = true;
                        break;

                    case 'v':
                        if (i >= mid && ((j == (i - mid)) || (j == end - (i - mid)))) printStar = true;
                        break;

                    case 'w':
                        if ((j == 0 && i >= mid) || (j == end && i >= mid) || (i == n - 1) || (j == mid && i > mid)) printStar = true;
                        break;

                    case 'x':
                        if (i >= mid && (i - mid == j || i - mid + j == end)) printStar = true;
                        break;

                    case 'y':
                        if (j == end || (i == mid && j < end) || (j == 0 && i >= mid && i < n - 2) || (i == n - 1 && j < end)) printStar = true;
                        break;

                    case 'z':
                        if (i == mid || i == n - 1 || i - mid + j == end) printStar = true;
                        break;
                }

                System.out.print(printStar ? "*" : " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int inputSize = 7; 
        
        for (char ch = 'a'; ch <= 'z'; ch++) {
            displayPattern(ch, inputSize);
        }
    }
}
