package leetcode.Solutions_0001_0100.s0012_integer_to_roman;

// #Medium #String #Hash_Table #Math #Top_Interview_150_Array/String #Big_O_Time_O(1)_Space_O(1)
// #2025_03_04_Time_2_ms_(100.00%)_Space_44.30_MB_(83.82%)

public class IntegerToRoman {
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int m = 1000;
        int c = 100;
        int x = 10;
        int i = 1;
        num = numerals(sb, num, m, ' ', ' ', 'M');
        num = numerals(sb, num, c, 'M', 'D', 'C');
        num = numerals(sb, num, x, 'C', 'L', 'X');
        numerals(sb, num, i, 'X', 'V', 'I');
        return sb.toString();
    }

    private static int numerals(StringBuilder sb, int num, int one, char cTen, char cFive, char cOne) {
        int div = num / one;
        switch (div) {
            case 9:
                sb.append(cOne);
                sb.append(cTen);
                break;
            case 8:
                sb.append(cFive);
                sb.append(cOne);
                sb.append(cOne);
                sb.append(cOne);
                break;
            case 7:
                sb.append(cFive);
                sb.append(cOne);
                sb.append(cOne);
                break;
            case 6:
                sb.append(cFive);
                sb.append(cOne);
                break;
            case 5:
                sb.append(cFive);
                break;
            case 4:
                sb.append(cOne);
                sb.append(cFive);
                break;
            case 3:
                sb.append(cOne);
                sb.append(cOne);
                sb.append(cOne);
                break;
            case 2:
                sb.append(cOne);
                sb.append(cOne);
                break;
            case 1:
                sb.append(cOne);
                break;
            default:
                break;
        }
        return num - (div * one);
    }

    public static void main(String[] args) {
        String result1 = intToRoman(3);
        System.out.println(result1); // Output: "III"
        String result2 = intToRoman(4);
        System.out.println(result2); // Output: "IV"
        String result3 = intToRoman(9);
        System.out.println(result3); // Output: "IX"
        String result4 = intToRoman(58);
        System.out.println(result4); // Output: "LVIII"
        String result5 = intToRoman(1994);
        System.out.println(result5); // Output: "MCMXCIV"

    }
}
