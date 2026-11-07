package com.durga.leetcode.Arrays.Two_sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            Integer requiredNum = target - numbers[i];
            if (indexMap.containsKey(requiredNum)) {
                return new int[] {indexMap.get(requiredNum), i};
            }
            indexMap.put(numbers[i], i);
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int result1[] = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("Indices: " + result1[0] + ", " + result1[1]);
        int result2[] = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println("Indices: " + result2[0] + ", " + result2[1]);
        int result3[] = twoSum(new int[]{3, 3}, 6);
        System.out.println("Indices: " + result3[0] + ", " + result3[1]);
        int result4[] = twoSum(new int[]{3, 3}, 7);
        System.out.println("Indices: " + result4[0] + ", " + result4[1]);

    }
}