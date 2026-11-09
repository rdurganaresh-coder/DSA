package leetcode.Solutions_0001_0100.s0076_minimum_window_substring;

// #Hard #Top_100_Liked_Questions #Top_Interview_Questions #String #Hash_Table #Sliding_Window
// #Level_2_Day_14_Sliding_Window/Two_Pointer #Top_Interview_150_Sliding_Window
// #Big_O_Time_O(s.length())_Space_O(1) #2024_11_11_Time_2_ms_(99.83%)_Space_44.5_MB_(89.46%)

public class Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i) - 'A']++;
        }
        int count = t.length();
        int begin = 0;
        int end = 0;
        int d = Integer.MAX_VALUE;
        int head = 0;
        while (end < s.length()) {
            if (map[s.charAt(end++) - 'A']-- > 0) {
                count--;
            }
            while (count == 0) {
                if (end - begin < d) {
                    d = end - begin;
                    head = begin;
                }
                if (map[s.charAt(begin++) - 'A']++ == 0) {
                    count++;
                }
            }
        }
        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }

    public static void main(String[] args) {
    // Test Case 1: Standard case with a clear minimum window (Should output "BANC")
    String s1 = "ADOBECODEBANC";
    String t1 = "ABC";
    String result1 = new Minimum_Window_Substring().minWindow(s1, t1);
    System.out.println("Test 1 Result: \"" + result1 + "\"");

    // Test Case 2: Target is the exact entire string (Should output "a")
    String s2 = "a";
    String t2 = "a";
    String result2 = new Minimum_Window_Substring().minWindow(s2, t2);
    System.out.println("Test 2 Result: \"" + result2 + "\"");

    // Test Case 3: Target cannot be formed from string (Should output "")
    String s3 = "a";
    String t3 = "aa";
    String result3 = new Minimum_Window_Substring().minWindow(s3, t3);
    System.out.println("Test 3 Result: \"" + result3 + "\"");

    // Test Case 4: Target contains mixed case characters (Should output "aB")
    String s4 = "aBcDeFg";
    String t4 = "Ba";
    String result4 = new Minimum_Window_Substring().minWindow(s4, t4);
    System.out.println("Test 4 Result: \"" + result4 + "\"");
}
}
