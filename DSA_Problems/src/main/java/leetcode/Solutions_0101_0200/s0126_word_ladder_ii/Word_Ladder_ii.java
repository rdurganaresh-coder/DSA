package leetcode.Solutions_0101_0200.s0126_word_ladder_ii;

// #Hard #String #Hash_Table #Breadth_First_Search #Backtracking
// #2022_07_02_Time_19_ms_(60.53%)_Space_43_MB_(90.12%)

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Word_Ladder_ii {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        // reverse graph start from endWord
        Map<String, Set<String>> reverse = new HashMap<>();
        // remove the duplicate words
        Set<String> wordSet = new HashSet<>(wordList);
        // remove the first word to avoid cycle path
        wordSet.remove(beginWord);
        // store current layer nodes
        Queue<String> queue = new LinkedList<>();
        // first layer has only beginWord
        queue.add(beginWord);
        // store nextLayer nodes
        Set<String> nextLevel = new HashSet<>();
        // find endWord flag
        boolean findEnd = false;
        // traverse current layer nodes
        while (!queue.isEmpty()) {
            String word = queue.remove();
            for (String next : wordSet) {
                // is ladder words
                if (isLadder(word, next)) {
                    // construct the reverse graph from endWord
                    Set<String> reverseLadders =
                            reverse.computeIfAbsent(next, k -> new HashSet<>());
                    reverseLadders.add(word);
                    if (endWord.equals(next)) {
                        findEnd = true;
                    }
                    // store next layer nodes
                    nextLevel.add(next);
                }
            }
            // when current layer is all visited
            if (queue.isEmpty()) {
                // if find the endWord, then break the while loop
                if (findEnd) {
                    break;
                }
                // add next layer nodes to queue
                queue.addAll(nextLevel);
                // remove all next layer nodes in wordSet
                wordSet.removeAll(nextLevel);
                nextLevel.clear();
            }
        }
        // if can't reach endWord from startWord, then return ans.
        if (!findEnd) {
            return ans;
        }
        Set<String> path = new LinkedHashSet<>();
        path.add(endWord);
        // traverse reverse graph from endWord to beginWord
        findPath(endWord, beginWord, reverse, ans, path);
        return ans;
    }

    private void findPath(
            String endWord,
            String beginWord,
            Map<String, Set<String>> graph,
            List<List<String>> ans,
            Set<String> path) {
        Set<String> next = graph.get(endWord);
        if (next == null) {
            return;
        }
        for (String word : next) {
            path.add(word);
            if (beginWord.equals(word)) {
                List<String> shortestPath = new ArrayList<>(path);
                // reverse words in shortest path
                Collections.reverse(shortestPath);
                // add the shortest path to ans.
                ans.add(shortestPath);
            } else {
                findPath(word, beginWord, graph, ans, path);
            }
            path.remove(word);
        }
    }

    private boolean isLadder(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int diffCount = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) {
                return false;
            }
        }
        return diffCount == 1;
    }

    public static void main(String[] args) {
    // Test Case 1: Standard case with multiple shortest paths of identical length
    // Paths: ["hit","hot","dot","dog","cog"] and ["hit","hot","lot","log","cog"]
    String beginWord1 = "hit";
    String endWord1 = "cog";
    List<String> wordList1 = new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log", "cog"));
    List<List<String>> result1 = new Word_Ladder_ii().findLadders(beginWord1, endWord1, wordList1);
    System.out.println("Test 1 Result: " + result1);

    // Test Case 2: No possible structural ladder connection exists to the end word
    // Expected Output: []
    String beginWord2 = "hit";
    String endWord2 = "cog";
    List<String> wordList2 = new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log"));
    List<List<String>> result2 = new Word_Ladder_ii().findLadders(beginWord2, endWord2, wordList2);
    System.out.println("Test 2 Result: " + result2);

    // Test Case 3: Immediate neighbor transformation link
    // Expected Output: [["a", "b"]]
    String beginWord3 = "a";
    String endWord3 = "b";
    List<String> wordList3 = new ArrayList<>(List.of("b", "c"));
    List<List<String>> result3 = new Word_Ladder_ii().findLadders(beginWord3, endWord3, wordList3);
    System.out.println("Test 3 Result: " + result3);
}
}
