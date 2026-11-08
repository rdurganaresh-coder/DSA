package leetcode.Solutions_0001_0100.s0044_wildcard_matching;

// #Hard #Top_Interview_Questions #String #Dynamic_Programming #Greedy #Recursion
// #Udemy_Dynamic_Programming #2023_08_11_Time_2_ms_(99.87%)_Space_43.2_MB_(99.49%)

public class WildcardMatching {
    public boolean isMatch(String inputString, String pattern) {
        int i = 0;
        int j = 0;
        int starIdx = -1;
        int lastMatch = -1;
        while (i < inputString.length()) {
            if (j < pattern.length()
                    && (inputString.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < pattern.length() && pattern.charAt(j) == '*') {
                starIdx = j;
                lastMatch = i;
                j++;
            } else if (starIdx != -1) {
                // there is a no match and there was a previous star, we will reset the j to indx
                // after star_index
                // lastMatch will tell from which index we start comparing the string if we
                // encounter * in pattern
                j = starIdx + 1;
                // we are saying we included more characters in * so we incremented the
                lastMatch++;
                // index
                i = lastMatch;
            } else {
                return false;
            }
        }
        boolean isMatch = true;
        while (j < pattern.length() && pattern.charAt(j) == '*') {
            j++;
        }
        if (i != inputString.length() || j != pattern.length()) {
            isMatch = false;
        }
        return isMatch;
    }

    public static void main(String[] args) {
        WildcardMatching solver = new WildcardMatching();

        // Test Case 1: Simple mismatch
        String s1 = "aa", p1 = "a";
        System.out.println("s = \"" + s1 + "\", p = \"" + p1 + "\" -> Result: " + solver.isMatch(s1, p1) + " (Expected: false)");

        // Test Case 2: Universal match with *
        String s2 = "aa", p2 = "*";
        System.out.println("s = \"" + s2 + "\", p = \"" + p2 + "\" -> Result: " + solver.isMatch(s2, p2) + " (Expected: true)");

        // Test Case 3: Single character match with ?
        String s3 = "cb", p3 = "?a";
        System.out.println("s = \"" + s3 + "\", p = \"" + p3 + "\" -> Result: " + solver.isMatch(s3, p3) + " (Expected: false)");

        // Test Case 4: Multiple wildcards combined
        String s4 = "adceb", p4 = "*a*b";
        System.out.println("s = \"" + s4 + "\", p = \"" + p4 + "\" -> Result: " + solver.isMatch(s4, p4) + " (Expected: true)");

        // Test Case 5: Empty string matching pattern with multiple stars
        String s5 = "", p5 = "***";
        System.out.println("s = \"" + s5 + "\", p = \"" + p5 + "\" -> Result: " + solver.isMatch(s5, p5) + " (Expected: true)");

        // Test Case 6: Empty pattern mismatching non-empty string
        String s6 = "abc", p6 = "";
        System.out.println("s = \"" + s6 + "\", p = \"" + p6 + "\" -> Result: " + solver.isMatch(s6, p6) + " (Expected: false)");
    }
}
