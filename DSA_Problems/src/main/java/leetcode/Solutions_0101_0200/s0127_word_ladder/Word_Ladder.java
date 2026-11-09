package leetcode.Solutions_0101_0200.s0127_word_ladder;

import java.util.ArrayList;

// #Hard #Top_Interview_Questions #String #Hash_Table #Breadth_First_Search
// #Graph_Theory_I_Day_12_Breadth_First_Search #Top_Interview_150_Graph_BFS
// #2025_03_06_Time_22_ms_(96.00%)_Space_45.97_MB_(83.68%)

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Word_Ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordDict) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordDict);
        Set<String> visited = new HashSet<>();
        if (!wordDict.contains(endWord)) {
            return 0;
        }
        int len = 1;
        int strLen = beginWord.length();
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> tempSet = new HashSet<>();
            for (String s : beginSet) {
                char[] chars = s.toCharArray();
                for (int i = 0; i < strLen; i++) {
                    char old = chars[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        chars[i] = j;
                        String temp = new String(chars);
                        if (endSet.contains(temp)) {
                            return len + 1;
                        }
                        if (!visited.contains(temp) && wordSet.contains(temp)) {
                            tempSet.add(temp);
                            visited.add(temp);
                        }
                    }
                    chars[i] = old;
                }
            }
            beginSet = tempSet;
            len++;
        }
        return 0;
    }

    public static void main(String[] args) {
    // Test Case 1: Standard reachable path configuration
    // Shortest path: "hit" -> "hot" -> "dot" -> "dog" -> "cog" (Length: 5)
    String beginWord1 = "hit";
    String endWord1 = "cog";
    List<String> wordDict1 = new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log", "cog"));
    int result1 = new Word_Ladder().ladderLength(beginWord1, endWord1, wordDict1);
    System.out.println("Test 1 Result: " + result1);
    // Expected Output: 5

    // Test Case 2: Target endWord is missing from the dictionary list completely
    // Shortest path cannot exist, should return 0 safely.
    String beginWord2 = "hit";
    String endWord2 = "cog";
    List<String> wordDict2 = new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log"));
    int result2 = new Word_Ladder().ladderLength(beginWord2, endWord2, wordDict2);
    System.out.println("Test 2 Result: " + result2);
    // Expected Output: 0

    // Test Case 3: Target word exists in dictionary but there is no bridging step
    String beginWord3 = "a";
    String endWord3 = "c";
    List<String> wordDict3 = new ArrayList<>(List.of("a", "c"));
    int result3 = new Word_Ladder().ladderLength(beginWord3, endWord3, wordDict3);
    System.out.println("Test 3 Result: " + result3);
    // Expected Output: 0
}
}
