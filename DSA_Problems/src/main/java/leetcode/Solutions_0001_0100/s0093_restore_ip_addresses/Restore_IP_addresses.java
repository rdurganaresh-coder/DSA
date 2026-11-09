package leetcode.Solutions_0001_0100.s0093_restore_ip_addresses;

// #Medium #String #Backtracking #2024_05_13_Time_1_ms_(99.27%)_Space_42_MB_(90.75%)

import java.util.ArrayList;
import java.util.List;

public class Restore_IP_addresses {
    private static final int SEG_COUNT = 4;
    private List<String> result = new ArrayList<>();
    private int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0);
        return result;
    }

    public void dfs(String s, int segId, int segStart) {
        // find 4 segments and get to last index
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuilder addr = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; i++) {
                    addr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        addr.append('.');
                    }
                }
                result.add(addr.toString());
            }
            return;
        }
        // last index and no 4 segments
        if (segStart == s.length()) {
            return;
        }
        // start with a zero
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
            return;
        }
        int addr = 0;
        for (int index = segStart; index < s.length(); index++) {
            addr = addr * 10 + s.charAt(index) - '0';
            if (addr >= 0 && addr <= 255) {
                segments[segId] = addr;
                dfs(s, segId + 1, index + 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
    // Test Case 1: Standard string with a few overlapping combination options
    String s1 = "25525511135";
    List<String> result1 = new Restore_IP_addresses().restoreIpAddresses(s1);
    System.out.println("Test 1 Result: " + result1);
    // Expected Output: ["255.255.11.135", "255.255.111.35"]

    // Test Case 2: Minimal string comprised completely of zeroes
    String s2 = "0000";
    List<String> result2 = new Restore_IP_addresses().restoreIpAddresses(s2);
    System.out.println("Test 2 Result: " + result2);
    // Expected Output: ["0.0.0.0"]

    // Test Case 3: Long string containing invalid leading zero groups
    String s3 = "101023";
    List<String> result3 = new Restore_IP_addresses().restoreIpAddresses(s3);
    System.out.println("Test 3 Result: " + result3);
    // Expected Output: ["1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"]

    // Test Case 4: Length edge case that is too short to form 4 segments
    String s4 = "123";
    List<String> result4 = new Restore_IP_addresses().restoreIpAddresses(s4);
    System.out.println("Test 4 Result: " + result4);
    // Expected Output: []
}
}
