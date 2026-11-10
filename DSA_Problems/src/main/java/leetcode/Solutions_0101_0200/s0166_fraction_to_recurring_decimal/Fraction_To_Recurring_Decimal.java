package leetcode.Solutions_0101_0200.s0166_fraction_to_recurring_decimal;

// #Medium #Top_Interview_Questions #String #Hash_Table #Math
// #2022_06_25_Time_3_ms_(55.19%)_Space_41.8_MB_(35.85%)

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("java:S2153")
public class Fraction_To_Recurring_Decimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        // negative case
        if (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0) {
            sb.append("-");
        }
        long x = Math.abs(Long.valueOf(numerator));
        long y = Math.abs(Long.valueOf(denominator));
        sb.append(x / y);
        long remainder = x % y;
        if (remainder == 0) {
            return sb.toString();
        }
        // decimal case
        sb.append(".");
        // store the remainder in a Hashmap because in the case of recurring decimal, the remainder
        // repeats as dividend.
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            // store the remainder and the index of it's occurence in the String
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / y);
            remainder %= y;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Fraction_To_Recurring_Decimal solver = new Fraction_To_Recurring_Decimal();
        int passed = 0;
        int failed = 0;

        // 1. Numerator is Zero
        if (assertTest("Numerator is zero", solver.fractionToDecimal(0, 3).equals("0"))) passed++; else failed++;

        // 2. Exact Integer Division (No fractional part)
        if (assertTest("Exact integer division", solver.fractionToDecimal(4, 2).equals("2"))) passed++; else failed++;

        // 3. Terminating Decimal Block
        if (assertTest("Terminating decimal", solver.fractionToDecimal(1, 2).equals("0.5"))) passed++; else failed++;
        if (assertTest("Terminating multi-digit decimal", solver.fractionToDecimal(3, 8).equals("0.375"))) passed++; else failed++;

        // 4. Simple Recurring Decimal Block
        if (assertTest("Single digit repeating", solver.fractionToDecimal(1, 3).equals("0.(3)"))) passed++; else failed++;
        if (assertTest("Multi-digit repeating sequence", solver.fractionToDecimal(4, 333).equals("0.(012)"))) passed++; else failed++;

        // 5. Mixed Terminating and Recurring Parts
        if (assertTest("Terminating then repeating", solver.fractionToDecimal(1, 6).equals("0.1(6)"))) passed++; else failed++;

        // 6. Sign Variations (Negative Fractions)
        if (assertTest("Negative numerator", solver.fractionToDecimal(-1, 2).equals("-0.5"))) passed++; else failed++;
        if (assertTest("Negative denominator", solver.fractionToDecimal(1, -2).equals("-0.5"))) passed++; else failed++;
        if (assertTest("Double negative signs cancel out", solver.fractionToDecimal(-1, -2).equals("0.5"))) passed++; else failed++;

        // 7. Extreme Overflows (Verifies Math.abs(Long.valueOf(numerator)) works properly)
        if (assertTest("Integer MIN value boundary overflow", 
                solver.fractionToDecimal(-2147483648, -1).equals("2147483648"))) passed++; else failed++;

        // Summary
        System.out.println("\n-----------------------------------");
        System.out.println("Test Results: " + passed + " Passed, " + failed + " Failed.");
        System.out.println("-----------------------------------");
    }

    private static boolean assertTest(String testName, boolean condition) {
        if (condition) {
            System.out.println("[PASS] " + testName);
            return true;
        } else {
            System.err.println("[FAIL] " + testName);
            return false;
        }
    }
}
