package leetcode.Solutions_0001_0100.s0084_largest_rectangle_in_histogram;

// #Hard #Top_100_Liked_Questions #Top_Interview_Questions #Array #Stack #Monotonic_Stack
// #Big_O_Time_O(n_log_n)_Space_O(log_n) #2024_11_13_Time_9_ms_(93.28%)_Space_54.6_MB_(99.95%)

public class Largest_Rectangle_In_Histogram {
    public int largestRectangleArea(int[] heights) {
        return largestArea(heights, 0, heights.length);
    }

    private int largestArea(int[] a, int start, int limit) {
        if (a == null || a.length == 0) {
            return 0;
        }
        if (start == limit) {
            return 0;
        }
        if (limit - start == 1) {
            return a[start];
        }
        if (limit - start == 2) {
            int maxOfTwoBars = Math.max(a[start], a[start + 1]);
            int areaFromTwo = Math.min(a[start], a[start + 1]) * 2;
            return Math.max(maxOfTwoBars, areaFromTwo);
        }
        if (checkIfSorted(a, start, limit)) {
            int maxWhenSorted = 0;
            for (int i = start; i < limit; i++) {
                if (a[i] * (limit - i) > maxWhenSorted) {
                    maxWhenSorted = a[i] * (limit - i);
                }
            }
            return maxWhenSorted;
        } else {
            int minInd = findMinInArray(a, start, limit);
            return maxOfThreeNums(
                    largestArea(a, start, minInd),
                    a[minInd] * (limit - start),
                    largestArea(a, minInd + 1, limit));
        }
    }

    private int findMinInArray(int[] a, int start, int limit) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int index = start; index < limit; index++) {
            if (a[index] < min) {
                min = a[index];
                minIndex = index;
            }
        }
        return minIndex;
    }

    private boolean checkIfSorted(int[] a, int start, int limit) {
        for (int i = start + 1; i < limit; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private int maxOfThreeNums(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public static void main(String[] args) {
    // Test Case 1: Standard mixed histogram layout
    // Expected max area: 10 (bars 5 and 6 combine: min(5,6) * 2 = 10)
    int[] heights1 = {2, 1, 5, 6, 2, 3};
    int result1 = new Largest_Rectangle_In_Histogram().largestRectangleArea(heights1);
    System.out.println("Test 1 Result: " + result1);

    // Test Case 2: Standard two-bar configuration
    // Expected max area: 4 (bar 4 alone is greater than min(2,4)*2)
    int[] heights2 = {2, 4};
    int result2 = new Largest_Rectangle_In_Histogram().largestRectangleArea(heights2);
    System.out.println("Test 2 Result: " + result2);

    // Test Case 3: Empty array edge case
    int[] heights3 = {};
    int result3 = new Largest_Rectangle_In_Histogram().largestRectangleArea(heights3);
    System.out.println("Test 3 Result (Empty): " + result3);

    // Test Case 4: Continuously increasing bars (Triggers your sorted optimization loop)
    // Expected max area: 9 (bar 3 onwards: 3 * 3 = 9)
    int[] heights4 = {1, 2, 3, 4, 5};
    int result4 = new Largest_Rectangle_In_Histogram().largestRectangleArea(heights4);
    System.out.println("Test 4 Result (Sorted): " + result4);
}
}
