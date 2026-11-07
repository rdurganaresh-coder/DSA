package com.durga.leetcode.Arrays.Easy.Remove_Duplicates_From_Sorted_Array;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static int[] removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
        return new int[0]; // Return an empty array if input is null or empty
    }

    int writeIndex = 1;
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] != nums[writeIndex - 1]) {
            nums[writeIndex] = nums[i];
            writeIndex++;
        }
    }
    
    // This crops the array from index 0 up to writeIndex (excluding leftover duplicates)
    return Arrays.copyOf(nums, writeIndex);
}

    public static void main(String[] args) {
        int[] array1 = new int[] {1, 1, 2};
        int[] array2 = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] result1 = removeDuplicates(array1);
        int[] result2 = removeDuplicates(array2);
        System.out.println("Length of array after removing duplicates: " + Arrays.toString(result1));
        System.out.println("Length of array after removing duplicates: " + Arrays.toString(result2));
       
    }
}
        