package leetcode.Solutions_0001_0100.s0006_zigzag_conversion;

// #Medium #String #Top_Interview_150_Array/String #Big_O_Time_O(n)_Space_O(n)
// #2024_11_17_Time_2_ms_(99.71%)_Space_44.5_MB_(94.69%)

public class ZigzagConversion {
    public static String convert(String s, int numRows) {
        int sLen = s.length();
        if (numRows == 1) {
            return s;
        }
        int maxDist = numRows * 2 - 2;
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int index = i;
            if (i == 0 || i == numRows - 1) {
                while (index < sLen) {
                    buf.append(s.charAt(index));
                    index += maxDist;
                }
            } else {
                while (index < sLen) {
                    buf.append(s.charAt(index));
                    index += maxDist - i * 2;
                    if (index >= sLen) {
                        break;
                    }
                    buf.append(s.charAt(index));
                    index += i * 2;
                }
            }
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows)); // Output: "PAHNAPLSIIGYIR"
        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        System.out.println(convert(s2, numRows2)); // Output: "PINALSIGYAHRPI"
        String s3 = "A";
        int numRows3 = 1;
        System.out.println(convert(s3, numRows3)); // Output: "A"
    }
}
