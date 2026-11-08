package leetcode.Solutions_0001_0100.s0056_merge_intervals;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Array #Sorting
// #Data_Structure_II_Day_2_Array #Level_2_Day_17_Interval #Udemy_2D_Arrays/Matrix
// #Top_Interview_150_Intervals #Big_O_Time_O(n_log_n)_Space_O(n)
// #2024_11_11_Time_7_ms_(98.37%)_Space_46.8_MB_(11.43%)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        int[] current = intervals[0];
        list.add(current);
        for (int[] next : intervals) {
            if (current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                current = next;
                list.add(current);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
    // Test Case 1: Standard overlapping intervals
    int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    int[][] result1 = new Merge_Intervals().merge(intervals1);
    System.out.println("Test 1 Result: " + Arrays.deepToString(result1));
    // Expected Output: [[1, 6], [8, 10], [15, 18]]

    // Test Case 2: Consecutive touching intervals (end matches next start)
    int[][] intervals2 = {{1, 4}, {4, 5}};
    int[][] result2 = new Merge_Intervals().merge(intervals2);
    System.out.println("Test 2 Result: " + Arrays.deepToString(result2));
    // Expected Output: [[1, 5]]

    // Test Case 3: Completely absorbed/nested intervals
    int[][] intervals3 = {{1, 4}, {2, 3}};
    int[][] result3 = new Merge_Intervals().merge(intervals3);
    System.out.println("Test 3 Result: " + Arrays.deepToString(result3));
    // Expected Output: [[1, 4]]

    // Test Case 4: Unsorted input intervals
    int[][] intervals4 = {{5, 8}, {1, 3}, {2, 4}};
    int[][] result4 = new Merge_Intervals().merge(intervals4);
    System.out.println("Test 4 Result: " + Arrays.deepToString(result4));
    // Expected Output: [[1, 4], [5, 8]]
}
}
