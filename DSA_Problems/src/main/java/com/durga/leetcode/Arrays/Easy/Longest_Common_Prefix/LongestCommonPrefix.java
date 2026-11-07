package com.durga.leetcode.Arrays.Easy.Longest_Common_Prefix;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String temp = strs[0];
        int i = 1;
        String cur;
        while (!temp.isEmpty() && i < strs.length) {
            if (temp.length() > strs[i].length()) {
                temp = temp.substring(0, strs[i].length());
            }
            cur = strs[i].substring(0, temp.length());
            if (!cur.equals(temp)) {
                temp = temp.substring(0, temp.length() - 1);
            } else {
                i++;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp1 = new LongestCommonPrefix();
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println(lcp1.longestCommonPrefix(strs1));

        LongestCommonPrefix lcp2 = new LongestCommonPrefix();
        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println(lcp2.longestCommonPrefix(strs2));
    }
}