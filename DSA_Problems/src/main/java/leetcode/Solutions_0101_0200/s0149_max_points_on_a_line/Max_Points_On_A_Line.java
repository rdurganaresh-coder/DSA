package leetcode.Solutions_0101_0200.s0149_max_points_on_a_line;

// #Hard #Top_Interview_Questions #Array #Hash_Table #Math #Geometry #Algorithm_II_Day_21_Others
// #Top_Interview_150_Math #2025_03_06_Time_7_ms_(99.18%)_Space_41.70_MB_(81.57%)

public class Max_Points_On_A_Line {
    public int maxPoints(int[][] points) {
        if (points.length < 2) {
            return points.length;
        }
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                int c = x * points[j][1] - y * points[j][0];
                int count = 2;
                for (int k = j + 1; k < points.length; k++) {
                    if (c == x * points[k][1] - y * points[k][0]) {
                        count++;
                    }
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }

    // --- Main Method Executing Test Cases ---
    public static void main(String[] args) {
        Max_Points_On_A_Line solver = new Max_Points_On_A_Line();

        System.out.println("--- Running Max Points On A Line Tests ---\n");

        // Test Case 1: Empty or Single Point
        System.out.println("Test 1 (Single Point):");
        int[][] points1 = {{1, 1}};
        System.out.println("Expected: 1 -> Actual: " + solver.maxPoints(points1) + "\n");

        // Test Case 2: Three points on a simple diagonal line
        // Points: (1,1), (2,2), (3,3)
        System.out.println("Test 2 (Simple Diagonal Line):");
        int[][] points2 = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println("Expected: 3 -> Actual: " + solver.maxPoints(points2) + "\n");

        // Test Case 3: More complex scatter graph
        // Points: (1,1), (3,2), (5,3), (4,1), (2,3), (1,4)
        // Line through (1,1), (3,2), (5,3) has 3 points.
        System.out.println("Test 3 (Scatter Matrix):");
        int[][] points3 = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        System.out.println("Expected: 4 -> Actual: " + solver.maxPoints(points3) + "\n");

        // Test Case 4: Perfectly Vertical Line (Slope undefined, x-diff is 0)
        // Points: (2,1), (2,5), (2,10), (3,3)
        System.out.println("Test 4 (Vertical Line Check):");
        int[][] points4 = {{2, 1}, {2, 5}, {2, 10}, {3, 3}};
        System.out.println("Expected: 3 -> Actual: " + solver.maxPoints(points4) + "\n");

        // Test Case 5: Perfectly Horizontal Line (Slope is 0)
        // Points: (1,5), (2,5), (9,5), (4,2)
        System.out.println("Test 5 (Horizontal Line Check):");
        int[][] points5 = {{1, 5}, {2, 5}, {9, 5}, {4, 2}};
        System.out.println("Expected: 3 -> Actual: " + solver.maxPoints(points5) + "\n");
    }
}
