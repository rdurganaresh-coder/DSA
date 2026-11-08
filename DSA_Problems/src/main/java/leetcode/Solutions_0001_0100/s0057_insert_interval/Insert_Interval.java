package leetcode.Solutions_0001_0100.s0057_insert_interval;

// #Medium #Array #Level_2_Day_17_Interval #Top_Interview_150_Intervals
// #2025_03_04_Time_0_ms_(100.00%)_Space_44.76_MB_(89.09%)

import java.util.Arrays;

public class Insert_Interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int l = 0;
        int r = n - 1;
        while (l < n && newInterval[0] > intervals[l][1]) {
            l++;
        }
        while (r >= 0 && newInterval[1] < intervals[r][0]) {
            r--;
        }
        int[][] res = new int[l + n - r][2];
        for (int i = 0; i < l; i++) {
            res[i] = Arrays.copyOf(intervals[i], intervals[i].length);
        }
        res[l][0] = Math.min(newInterval[0], l == n ? newInterval[0] : intervals[l][0]);
        res[l][1] = Math.max(newInterval[1], r == -1 ? newInterval[1] : intervals[r][1]);
        for (int i = l + 1, j = r + 1; j < n; i++, j++) {
            res[i] = intervals[j];
        }
        return res;
    }

    public static void main(String[] args) {
    // Test Case 1: Standard middle insertion with overlapping merges
    int[][] intervals1 = {{1, 3}, {6, 9}};
    int[] newInterval1 = {2, 5};
    int[][] result1 = new Insert_Interval().insert(intervals1, newInterval1);
    System.out.println("Test 1 Result: " + Arrays.deepToString(result1));
    // Expected: [[1, 5], [6, 9]]

    // Test Case 2: Multi-interval overlapping merge
    int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
    int[] newInterval2 = {4, 8};
    int[][] result2 = new Insert_Interval().insert(intervals2, newInterval2);
    System.out.println("Test 2 Result: " + Arrays.deepToString(result2));
    // Expected: [[1, 2], [3, 10], [12, 16]]

    // Test Case 3: Insertion into an empty list
    int[][] intervals3 = {};
    int[] newInterval3 = {5, 7};
    int[][] result3 = new Insert_Interval().insert(intervals3, newInterval3);
    System.out.println("Test 3 Result: " + Arrays.deepToString(result3));
    // Expected: [[5, 7]]

    // Test Case 4: Non-overlapping insertion at the very beginning
    int[][] intervals4 = {{3, 5}, {6, 9}};
    int[] newInterval4 = {1, 2};
    int[][] result4 = new Insert_Interval().insert(intervals4, newInterval4);
    System.out.println("Test 4 Result: " + Arrays.deepToString(result4));
    // Expected: [[1, 2], [3, 5], [6, 9]]

    // Test Case 5: Non-overlapping insertion at the very end
    int[][] intervals5 = {{1, 2}, {3, 5}};
    int[] newInterval5 = {6, 8};
    int[][] result5 = new Insert_Interval().insert(intervals5, newInterval5);
    System.out.println("Test 5 Result: " + Arrays.deepToString(result5));
    // Expected: [[1, 2], [3, 5], [6, 8]]
}
}
