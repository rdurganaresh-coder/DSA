package leetcode.Solutions_0001_0100.s0071_simplify_path;

// #Medium #String #Stack #Top_Interview_150_Stack
// #2025_03_05_Time_2_ms_(99.86%)_Space_43.12_MB_(91.80%)

import java.util.ArrayDeque;
import java.util.Deque;

public class Simplify_Path {
    public String simplifyPath(String path) {
        Deque<String> stk = new ArrayDeque<>();
        int start = 0;
        while (start < path.length()) {
            while (start < path.length() && path.charAt(start) == '/') {
                start++;
            }
            int end = start;
            while (end < path.length() && path.charAt(end) != '/') {
                end++;
            }
            String s = path.substring(start, end);
            if (s.equals("..")) {
                if (!stk.isEmpty()) {
                    stk.pop();
                }
            } else if (!s.equals(".") && !s.equals("")) {
                stk.push(s);
            }
            start = end + 1;
        }
        StringBuilder ans = new StringBuilder();
        while (!stk.isEmpty()) {
            ans.insert(0, stk.pop());
            ans.insert(0, "/");
        }
        return !ans.isEmpty() ? ans.toString() : "/";
    }

    public static void main(String[] args) {
    // Test Case 1: Path with redundant trailing slashes
    String result1 = new Simplify_Path().simplifyPath("/home//foo/");
    System.out.println("Test 1 Result: " + result1);
    // Expected Output: "/home/foo"

    // Test Case 2: Path containing relative up-directory operators ".."
    String result2 = new Simplify_Path().simplifyPath("/home/user/Documents/../Downloads/");
    System.out.println("Test 2 Result: " + result2);
    // Expected Output: "/home/user/Downloads"

    // Test Case 3: Going out-of-bounds above the root directory
    String result3 = new Simplify_Path().simplifyPath("/../");
    System.out.println("Test 3 Result: " + result3);
    // Expected Output: "/"

    // Test Case 4: Path containing current-directory operators "."
    String result4 = new Simplify_Path().simplifyPath("/home/./foo/bar/.");
    System.out.println("Test 4 Result: " + result4);
    // Expected Output: "/home/foo/bar"

    // Test Case 5: Path where periods are part of a valid file name
    String result5 = new Simplify_Path().simplifyPath("/.../a/../b/c/../d/./");
    System.out.println("Test 5 Result: " + result5);
    // Expected Output: "/.../b/d"
}
}
