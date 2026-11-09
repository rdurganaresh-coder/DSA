package leetcode.Solutions_0101_0200.s0134_gas_station;

// #Medium #Top_Interview_Questions #Array #Greedy #Top_Interview_150_Array/String
// #2025_03_06_Time_2_ms_(97.52%)_Space_57.00_MB_(5.82%)

public class Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0;
        int total = 0;
        int current = 0;
        for (int i = 0; i < gas.length; i++) {
            int balance = gas[i] - cost[i];
            total += balance;
            current += balance;
            if (current < 0) {
                index = i + 1;
                current = 0;
            }
        }
        return total >= 0 ? index : -1;
    }

    public static void main(String[] args) {
    // Test Case 1: Standard case where a complete circular circuit is possible
    // Starting at index 3 (gas=4) yields a valid circuit.
    int[] gas1 = {1, 2, 3, 4, 5};
    int[] cost1 = {3, 4, 5, 1, 2};
    int result1 = new Gas_Station().canCompleteCircuit(gas1, cost1);
    System.out.println("Test 1 Result: " + result1);
    // Expected Output: 3

    // Test Case 2: Complete loop is structurally impossible (Total cost > Total gas)
    int[] gas2 = {2, 3, 4};
    int[] cost2 = {3, 4, 3};
    int result2 = new Gas_Station().canCompleteCircuit(gas2, cost2);
    System.out.println("Test 2 Result: " + result2);
    // Expected Output: -1

    // Test Case 3: Single gas station base case where travel is possible
    int[] gas3 = {5};
    int[] cost3 = {4};
    int result3 = new Gas_Station().canCompleteCircuit(gas3, cost3);
    System.out.println("Test 3 Result (Single Pass): " + result3);
    // Expected Output: 0

    // Test Case 4: Single gas station base case where travel is impossible
    int[] gas4 = {2};
    int[] cost4 = {3};
    int result4 = new Gas_Station().canCompleteCircuit(gas4, cost4);
    System.out.println("Test 4 Result (Single Fail): " + result4);
    // Expected Output: -1
}
}
