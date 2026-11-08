package leetcode.Solutions_0001_0100.s0058_length_of_last_word;

// #Easy #String #Programming_Skills_II_Day_6 #Udemy_Arrays #Top_Interview_150_Array/String
// #2025_03_04_Time_0_ms_(100.00%)_Space_41.72_MB_(64.92%)

public class Length_Of_Last_Word {
    public int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ' ' && len > 0) {
                break;
            } else if (ch != ' ') {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
    // Test Case 1: Standard sentence with no trailing spaces
    String s1 = "Hello World";
    int result1 = new Length_Of_Last_Word().lengthOfLastWord(s1);
    System.out.println("Test 1 Result: " + result1);
    // Expected Output: 5 ("World")

    // Test Case 2: Sentence with multiple trailing and middle spaces
    String s2 = "   fly me   to   the moon  ";
    int result2 = new Length_Of_Last_Word().lengthOfLastWord(s2);
    System.out.println("Test 2 Result: " + result2);
    // Expected Output: 4 ("moon")

    // Test Case 3: Sentence containing only a single word
    String s3 = "a";
    int result3 = new Length_Of_Last_Word().lengthOfLastWord(s3);
    System.out.println("Test 3 Result: " + result3);
    // Expected Output: 1 ("a")

    // Test Case 4: String consisting entirely of spaces
    String s4 = "        ";
    int result4 = new Length_Of_Last_Word().lengthOfLastWord(s4);
    System.out.println("Test 4 Result: " + result4);
    // Expected Output: 0
}
}
