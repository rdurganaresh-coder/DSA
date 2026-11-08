package leetcode.Solutions_0001_0100.s0004_median_of_two_sorted_arrays;

// #Hard #Top_100_Liked_Questions #Top_Interview_Questions #Array #Binary_Search #Divide_and_Conquer
// #Top_Interview_150_Binary_Search #Big_O_Time_O(log(min(N,M)))_Space_O(1)
// #AI_can_be_used_to_solve_the_task #2024_11_09_Time_1_ms_(100.00%)_Space_46.1_MB_(40.80%)

@SuppressWarnings("java:S2234")
public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int cut1;
        int cut2;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0;
        int high = n1;
        while (low <= high) {
            cut1 = (low + high) / 2;
            cut2 = ((n1 + n2 + 1) / 2) - cut1;
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];
            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0.0f;
    }

    public static void main(String[] args) {
        double result1 = findMedianSortedArrays(new int[] {1, 3}, new int[] {2});
        System.out.println("Median of the two sorted arrays: " + result1);
        double result2 = findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4});
        System.out.println("Median of the two sorted arrays: " + result2);
        double result3 = findMedianSortedArrays(new int[] {0, 0}, new int[] {0, 0});
        System.out.println("Median of the two sorted arrays: " + result3);
        
    }
}
