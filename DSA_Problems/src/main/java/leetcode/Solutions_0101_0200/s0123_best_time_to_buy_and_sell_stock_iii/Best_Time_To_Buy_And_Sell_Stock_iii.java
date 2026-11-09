package leetcode.Solutions_0101_0200.s0123_best_time_to_buy_and_sell_stock_iii;

// #Hard #Array #Dynamic_Programming #Top_Interview_150_Multidimensional_DP
// #2025_03_06_Time_4_ms_(74.67%)_Space_61.08_MB_(72.04%)

public class Best_Time_To_Buy_And_Sell_Stock_iii {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int fb = Integer.MIN_VALUE;
        int sb = Integer.MIN_VALUE;
        int fs = 0;
        int ss = 0;
        for (int price : prices) {
            fb = Math.max(fb, -price);
            fs = Math.max(fs, fb + price);
            sb = Math.max(sb, fs - price);
            ss = Math.max(ss, sb + price);
        }
        return ss;
    }

    public static void main(String[] args) {
    // Test Case 1: Standard case with multiple profit peaks (Allowed up to 2 transactions)
    // Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3.
    // Buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 3. Total = 6.
    int[] prices1 = {3, 3, 5, 0, 0, 3, 1, 4};
    int result1 = new Best_Time_To_Buy_And_Sell_Stock_iii().maxProfit(prices1);
    System.out.println("Test 1 Result: " + result1);
    // Expected Output: 6

    // Test Case 2: Monotonically increasing continuous trend array
    // Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 4 (Done in 1 transaction).
    int[] prices2 = {1, 2, 3, 4, 5};
    int result2 = new Best_Time_To_Buy_And_Sell_Stock_iii().maxProfit(prices2);
    System.out.println("Test 2 Result: " + result2);
    // Expected Output: 4

    // Test Case 3: Monotonically decreasing prices (No profit possible)
    int[] prices3 = {7, 6, 4, 3, 1};
    int result3 = new Best_Time_To_Buy_And_Sell_Stock_iii().maxProfit(prices3);
    System.out.println("Test 3 Result: " + result3);
    // Expected Output: 0

    // Test Case 4: Single element array base case
    int[] prices4 = {5};
    int result4 = new Best_Time_To_Buy_And_Sell_Stock_iii().maxProfit(prices4);
    System.out.println("Test 4 Result (Single Element): " + result4);
    // Expected Output: 0

    // Test Case 5: Empty input array edge case boundary
    int[] prices5 = {};
    int result5 = new Best_Time_To_Buy_And_Sell_Stock_iii().maxProfit(prices5);
    System.out.println("Test 5 Result (Empty): " + result5);
    // Expected Output: 0
}
}
