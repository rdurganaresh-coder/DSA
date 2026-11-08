package leetcode.Solutions_0001_0100.s0011_container_with_most_water;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Array #Greedy #Two_Pointers
// #LeetCode_75_Two_Pointers #Algorithm_II_Day_4_Two_Pointers #Top_Interview_150_Two_Pointers
// #Big_O_Time_O(n)_Space_O(1) #2024_11_09_Time_3_ms_(96.01%)_Space_57.8_MB_(52.01%)

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxArea = -1;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                maxArea = Math.max(maxArea, height[left] * (right - left));
                left++;
            } else {
                maxArea = Math.max(maxArea, height[right] * (right - left));
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int result1 = maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(result1);
        int result2 = maxArea(new int[] {1, 1});
        System.out.println(result2);
        int result3 = maxArea(new int[] {4, 3, 2, 1, 4});
        System.out.println(result3);
    }
}
