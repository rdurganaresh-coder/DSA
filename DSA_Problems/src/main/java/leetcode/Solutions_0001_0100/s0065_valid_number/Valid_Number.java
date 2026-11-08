package leetcode.Solutions_0001_0100.s0065_valid_number;

// #Hard #String #2023_08_11_Time_1_ms_(100.00%)_Space_41.3_MB_(91.10%)

public class Valid_Number {
    public boolean isNumber(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean decimalSeen = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 48 && c <= 57) {
                numberSeen = true;
            } else if (c == '+' || c == '-') {
                if (i == s.length() - 1
                        || (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')) {
                    return false;
                }
            } else if (c == '.') {
                if (eSeen || decimalSeen) {
                    return false;
                }
                decimalSeen = true;
            } else if (c == 'e' || c == 'E') {
                if (i == s.length() - 1 || eSeen || !numberSeen) {
                    return false;
                }
                eSeen = true;
            } else {
                return false;
            }
        }
        return numberSeen;
    }

    public static void main(String[] args) {
    // Test Case 1: Valid integers and decimals (Should all output true)
    System.out.println("Test 1a (2): " + new Valid_Number().isNumber("2"));
    System.out.println("Test 1b (0.1): " + new Valid_Number().isNumber("0.1"));
    System.out.println("Test 1c (-90E3): " + new Valid_Number().isNumber("-90E3"));
    System.out.println("Test 1d (+6e-1): " + new Valid_Number().isNumber("+6e-1"));
    System.out.println("Test 1e (53.5e93): " + new Valid_Number().isNumber("53.5e93"));
    System.out.println("Test 1f (-.3): " + new Valid_Number().isNumber("-.3"));
    System.out.println();

    // Test Case 2: Invalid patterns (Should all output false)
    System.out.println("Test 2a (abc): " + new Valid_Number().isNumber("abc"));
    System.out.println("Test 2b (1a): " + new Valid_Number().isNumber("1a"));
    System.out.println("Test 2c (1e): " + new Valid_Number().isNumber("1e"));
    System.out.println("Test 2d (e3): " + new Valid_Number().isNumber("e3"));
    System.out.println("Test 2e (99e2.5): " + new Valid_Number().isNumber("99e2.5"));
    System.out.println("Test 2f (--6): " + new Valid_Number().isNumber("--6"));
    System.out.println("Test 2g (-+3): " + new Valid_Number().isNumber("-+3"));
    System.out.println("Test 2h (95a54e53): " + new Valid_Number().isNumber("95a54e53"));
    System.out.println();

    // Test Case 3: Tricky valid cases ending with a decimal point (e.g., "3.")
    System.out.println("Test 3 (3.): " + new Valid_Number().isNumber("3."));
}
}
