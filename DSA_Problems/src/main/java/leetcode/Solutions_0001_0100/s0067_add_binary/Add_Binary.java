package leetcode.Solutions_0001_0100.s0067_add_binary;

// #Easy #String #Math #Bit_Manipulation #Simulation #Programming_Skills_II_Day_5
// #Top_Interview_150_Bit_Manipulation #2025_03_05_Time_1_ms_(99.82%)_Space_42.31_MB_(52.66%)

public class Add_Binary {
    public String addBinary(String a, String b) {
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = aArray.length - 1;
        int j = bArray.length - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = (i >= 0 ? aArray[i] - '0' : 0) + (j >= 0 ? bArray[j] - '0' : 0) + carry;
            sb.append(sum % 2);
            carry = sum / 2;
            if (i >= 0) {
                i--;
            }
            if (j >= 0) {
                j--;
            }
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
    // Test Case 1: Standard small binary addition without overall length expansion
    String result1 = new Add_Binary().addBinary("11", "1");
    System.out.println("Test 1 Result: " + result1);
    // Expected Output: "100"

    // Test Case 2: Multi-step carrying with mismatched string lengths
    String result2 = new Add_Binary().addBinary("1010", "1011");
    System.out.println("Test 2 Result: " + result2);
    // Expected Output: "10101"

    // Test Case 3: Single bit base values matching zeroes
    String result3 = new Add_Binary().addBinary("0", "0");
    System.out.println("Test 3 Result: " + result3);
    // Expected Output: "0"

    // Test Case 4: Complete cascade carry stretching the overall string length
    String result4 = new Add_Binary().addBinary("1111", "1111");
    System.out.println("Test 4 Result: " + result4);
    // Expected Output: "11110"
}
}
