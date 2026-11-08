package leetcode.Solutions_0001_0100.s0027_remove_element;

import java.util.Arrays;

// #Easy #Array #Two_Pointers #Top_Interview_150_Array/String
// #2025_03_04_Time_0_ms_(100.00%)_Space_42.15_MB_(29.50%)

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int j = len - 1;
        int occurTimes = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val) {
                occurTimes++;
                if (j == i) {
                    return len - occurTimes;
                }
                while (nums[j] == val) {
                    j--;
                    occurTimes++;
                    if (j == i) {
                        return len - occurTimes;
                    }
                }
                nums[i] = nums[j];
                j--;
            }
            if (i == j) {
                return len - occurTimes;
            }
        }
        return len - occurTimes;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] original1 = {3, 2, 2, 3};
        int end1 = removeElement(original1, 3);
        System.out.println("Length 1: " + end1);
        // Prints only the elements up to the valid length: [2, 2]
        System.out.println("Array 1: " + Arrays.toString(Arrays.copyOf(original1, end1)));

        System.out.println(); // Blank line for spacing

        // Test Case 2
        int[] original2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int end2 = removeElement(original2, 2);
        System.out.println("Length 2: " + end2);
        // Prints only the elements up to the valid length: [0, 1, 4, 0, 3]
        System.out.println("Array 2: " + Arrays.toString(Arrays.copyOf(original2, end2)));
    }
}
