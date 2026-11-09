package leetcode.Solutions_0101_0200.s0151_reverse_words_in_a_string;

// #Medium #String #Two_Pointers #LeetCode_75_Array/String #Udemy_Strings
// #Top_Interview_150_Array/String #2025_03_06_Time_2_ms_(99.69%)_Space_42.48_MB_(97.99%)

public class Reverse_Words_In_A_String {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                i--;
                continue;
            }
            int start = s.lastIndexOf(' ', i);
            sb.append(' ');
            sb.append(s, start + 1, i + 1);
            i = start - 1;
        }
        if (!sb.isEmpty()) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    // --- Main Method Executing Test Cases ---
    public static void main(String[] args) {
        Reverse_Words_In_A_String reverser = new Reverse_Words_In_A_String();

        System.out.println("--- Running Reverse Words In A String Tests ---\n");

        // Test Case 1: Simple sentence
        System.out.println("Test 1 (Standard Input):");
        String input1 = "the sky is blue";
        System.out.println("Expected: \"blue is sky the\"");
        System.out.println("Actual:   \"" + reverser.reverseWords(input1) + "\"\n");

        // Test Case 2: Leading and trailing spaces
        System.out.println("Test 2 (Leading & Trailing Spaces):");
        String input2 = "  hello world  ";
        System.out.println("Expected: \"world hello\"");
        System.out.println("Actual:   \"" + reverser.reverseWords(input2) + "\"\n");

        // Test Case 3: Multiple spaces between words
        System.out.println("Test 3 (Multiple Inner Spaces):");
        String input3 = "a good   example";
        System.out.println("Expected: \"example good a\"");
        System.out.println("Actual:   \"" + reverser.reverseWords(input3) + "\"\n");

        // Test Case 4: Single word string
        System.out.println("Test 4 (Single Word):");
        String input4 = "Java";
        System.out.println("Expected: \"Java\"");
        System.out.println("Actual:   \"" + reverser.reverseWords(input4) + "\"\n");

        // Test Case 5: Spaces only (Edge case)
        System.out.println("Test 5 (Only Spaces):");
        String input5 = "     ";
        System.out.println("Expected: \"\"");
        System.out.println("Actual:   \"" + reverser.reverseWords(input5) + "\"\n");
    }
}
