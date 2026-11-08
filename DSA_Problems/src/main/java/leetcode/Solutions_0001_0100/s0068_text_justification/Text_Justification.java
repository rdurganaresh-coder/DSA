package leetcode.Solutions_0001_0100.s0068_text_justification;

// #Hard #Array #String #Simulation #Top_Interview_150_Array/String
// #2025_03_05_Time_0_ms_(100.00%)_Space_42.06_MB_(29.81%)

import java.util.ArrayList;
import java.util.List;

public class Text_Justification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        // Trying to gauge the number of lines so the ArrayList doesn't need to resize
        List<String> output = new ArrayList<>((words.length + 1) / (1 + maxWidth / 7));
        // Setting StringBuilder capacity also
        StringBuilder sb = new StringBuilder(maxWidth);
        int lineTotal = 0;
        int numWordsOnLine = 0;
        int startWord = 0;
        // looping until the 2nd last word, since we're checking words[i + 1] for
        // overflows
        for (int i = 0; i < words.length - 1; i++) {
            lineTotal += words[i].length();
            // tracking line length + #words
            numWordsOnLine++;
            // checking if the next word causes an overflow
            if (lineTotal + numWordsOnLine + words[i + 1].length() > maxWidth) {
                // if only one word fits on the line...
                if (numWordsOnLine == 1) {
                    // append word
                    sb.append(words[i]);
                    // pad right with spaces
                    while (lineTotal++ < maxWidth) {
                        sb.append(' ');
                    }
                } else {
                    // # of extra spaces
                    int extraSp = (maxWidth - lineTotal) % (numWordsOnLine - 1);

                    // Creating the line
                    for (int j = startWord; j < (startWord + numWordsOnLine - 1); j++) {
                        // appending the word
                        sb.append(words[j]);
                        if (extraSp-- > 0) {
                            // appending an extra space, if required
                            sb.append(' ');
                        }
                        // appending the rest of the required spaces
                        int max = Math.max(0, (maxWidth - lineTotal) / (numWordsOnLine - 1));
                        sb.append(" ".repeat(max));
                    }
                    // appending the last word of the line
                    sb.append(words[startWord + numWordsOnLine - 1]);
                }
                // adding to output list
                output.add(sb.toString());
                // reset everything for next line
                // keeping track of the first word for next line
                startWord = i + 1;
                // resetting these to 0 for processing next line
                numWordsOnLine = lineTotal = 0;
                // need a new StringBuilder for the next line
                sb = new StringBuilder(maxWidth);
            }
        }
        // handling the final line (no justification, right padded with spaces)
        lineTotal = 0;
        for (int i = startWord; i < words.length; i++) {
            lineTotal += words[i].length();
            sb.append(words[i]);
            if (lineTotal++ < maxWidth) {
                sb.append(' ');
            }
        }
        // padding right side with spaces
        while (lineTotal++ < maxWidth) {
            sb.append(' ');
        }
        // add the final line to output list
        output.add(sb.toString());
        return output;
    }

    public static void main(String[] args) {
    // Test Case 1: Standard text justification with mixed word lengths
    String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
    int maxWidth1 = 16;
    List<String> result1 = new Text_Justification().fullJustify(words1, maxWidth1);
    System.out.println("--- Test 1 Result (maxWidth = 16) ---");
    for (String line : result1) {
        System.out.println("\"" + line + "\"");
    }
    System.out.println();

    // Test Case 2: Greedy approach leaving spaces distributed to the left side
    String[] words2 = {"What", "must", "be", "acknowledgment", "shall", "be"};
    int maxWidth2 = 16;
    List<String> result2 = new Text_Justification().fullJustify(words2, maxWidth2);
    System.out.println("--- Test 2 Result (maxWidth = 16) ---");
    for (String line : result2) {
        System.out.println("\"" + line + "\"");
    }
    System.out.println();

    // Test Case 3: Long sentence with varied line packing and left-justified final line
    String[] words3 = {
        "Science", "is", "knowledge", "which", "improves", "the", "reputation", "of", "the", 
        "human", "mind", "in", "the", "literate", "world."
    };
    int maxWidth3 = 20;
    List<String> result3 = new Text_Justification().fullJustify(words3, maxWidth3);
    System.out.println("--- Test 3 Result (maxWidth = 20) ---");
    for (String line : result3) {
        System.out.println("\"" + line + "\"");
    }
}
}
