package leetcode.Solutions_0001_0100.s0049_group_anagrams;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Array #String #Hash_Table #Sorting
// #Data_Structure_II_Day_8_String #Programming_Skills_II_Day_11 #Udemy_Strings
// #Top_Interview_150_Hashmap #Big_O_Time_O(n*k_log_k)_Space_O(n)
// #2024_11_11_Time_6_ms_(97.61%)_Space_47.7_MB_(69.56%)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("java:S3824")
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String word : strs) {
            char[] freq = new char[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            String keyString = new String(freq);
            if (!anagrams.containsKey(keyString)) {
                anagrams.put(keyString, new ArrayList<>());
            }
            anagrams.get(keyString).add(word);
        }
        return new ArrayList<>(anagrams.values());
    }

    public static void main(String[] args) {
        GroupAnagrams solver = new GroupAnagrams();

        // Test Case 1: Standard LeetCode Example 1
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = solver.groupAnagrams(strs1);
        System.out.println("Test Case 1 Input: " + Arrays.toString(strs1));
        System.out.println("Grouped Anagrams: ");
        result1.forEach(System.out::println);
        System.out.println("Expected: [[bat], [nat, tan], [ate, eat, tea]] (Order of groups may vary)");
        System.out.println();

        // Test Case 2: Empty String
        String[] strs2 = {""};
        List<List<String>> result2 = solver.groupAnagrams(strs2);
        System.out.println("Test Case 2 Input: " + Arrays.toString(strs2));
        System.out.println("Grouped Anagrams: " + result2);
        System.out.println("Expected: [[]]");
        System.out.println();

        // Test Case 3: Single Character String
        String[] strs3 = {"a"};
        List<List<String>> result3 = solver.groupAnagrams(strs3);
        System.out.println("Test Case 3 Input: " + Arrays.toString(strs3));
        System.out.println("Grouped Anagrams: " + result3);
        System.out.println("Expected: [[a]]");
    }
}
