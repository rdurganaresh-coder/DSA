package leetcode.Solutions_0101_0200.s0125_valid_palindrome;

// #Easy #Top_Interview_Questions #String #Two_Pointers #Udemy_Two_Pointers
// #Top_Interview_150_Two_Pointers #2025_03_06_Time_2_ms_(99.11%)_Space_43.15_MB_(70.82%)

public class Valid_Palindrome {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        boolean res = true;
        while (res) {
            // Iterates through string to find first char which is alphanumeric.
            // Done to ignore non-alphanumeric characters.
            // Starts from 0 to j-1.
            while (i < j && isNotAlphaNumeric(s.charAt(i))) {
                i++;
            }
            // Similarly from j-1 to 0.
            while (i < j && isNotAlphaNumeric(s.charAt(j))) {
                j--;
            }
            // Checks if i is greater than or equal to j.
            // The main loop only needs to loop n / 2 times hence this condition (where n is string
            // length).
            if (i >= j) {
                break;
            }
            // Assigning found indices to variables.
            // The upperToLower function is used to convert characters, if upper case, to lower
            // case.
            // If already lower case, it'll return as it is.
            char left = upperToLower(s.charAt(i));
            char right = upperToLower(s.charAt(j));
            // If both variables are not same, result becomes false, and breaks out of the loop at
            // next iteration.
            if (left != right) {
                res = false;
            }
            i++;
            j--;
        }
        return res;
    }

    private boolean isNotAlphaNumeric(char c) {
        return (c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9');
    }

    private boolean isUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private char upperToLower(char c) {
        if (isUpper(c)) {
            c = (char) (c + 32);
        }
        return c;
    }

    public static void main(String[] args) {
    // Test Case 1: Standard valid phrase with mixed casing, spaces, and punctuation
    // After stripping and lowercasing: "amanaplanacanalpanama" (True)
    String s1 = "A man, a plan, a canal: Panama";
    boolean result1 = new Valid_Palindrome().isPalindrome(s1);
    System.out.println("Test 1 Result: " + result1);
    // Expected Output: true

    // Test Case 2: Standard invalid phrase
    // After stripping and lowercasing: "raceacar" (False)
    String s2 = "race a car";
    boolean result2 = new Valid_Palindrome().isPalindrome(s2);
    System.out.println("Test 2 Result: " + result2);
    // Expected Output: false

    // Test Case 3: Empty string base edge case configuration
    String s3 = " ";
    boolean result3 = new Valid_Palindrome().isPalindrome(s3);
    System.out.println("Test 3 Result (Empty/Spaces): " + result3);
    // Expected Output: true

    // Test Case 4: String containing only non-alphanumeric characters
    String s4 = ".,;!! @#";
    boolean result4 = new Valid_Palindrome().isPalindrome(s4);
    System.out.println("Test 4 Result (Punctuation Only): " + result4);
    // Expected Output: true

    // Test Case 5: Palindrome verifying alpha vs numeric matching restrictions
    String s5 = "0P";
    boolean result5 = new Valid_Palindrome().isPalindrome(s5);
    System.out.println("Test 5 Result (\"0P\"): " + result5);
    // Expected Output: false
}
}
