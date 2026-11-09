package leetcode.Solutions_0101_0200.s0157_read_n_characters_given_read4;

import java.util.Arrays;

/**
 * Mocking the parent class Reader4 provided by LeetCode for compilation context.
 */
class Reader4 {
    private String fileContent = ""; 
    private int filePointer = 0;

    int read4(char[] buf4) {
        int readCount = 0;
        while (readCount < 4 && filePointer < fileContent.length()) {
            buf4[readCount] = fileContent.charAt(filePointer);
            filePointer++;
            readCount++;
        }
        return readCount;
    }
    
    void resetFile(String content) {
        this.fileContent = content;
        this.filePointer = 0;
    }
}

/**
 * LeetCode 157 Test Target Class.
 * File Name must be: ReadNCharactersGivenReader4.java
 */
public class ReadNCharactersGivenReader4 extends Reader4 {
    
    public int read(char[] buf, int n) {
        char[] tempBuffer = new char[4]; // Fixed structural syntax initialization typo
        int totalCharsCopied = 0;
        
        while (totalCharsCopied < n) {
            int charsReadFrom4 = read4(tempBuffer);
            if (charsReadFrom4 == 0) {
                break;
            }
            int charsToCopy = Math.min(charsReadFrom4, n - totalCharsCopied);
            for (int i = 0; i < charsToCopy; i++) {
                buf[totalCharsCopied] = tempBuffer[i];
                totalCharsCopied++;
            }
        }
        return totalCharsCopied;
    }

    // --- Main Method Executing Comprehensive Test Scenes ---
    public static void main(String[] args) {
        ReadNCharactersGivenReader4 program = new ReadNCharactersGivenReader4();

        System.out.println("======================================================");
        System.out.println("  RUNNING SCENARIO LABS FOR READ N CHARACTERS GIVEN READ4 ");
        System.out.println("======================================================\n");

        // Test Case 1: File size is smaller than requested 'n'
        runScene(program, "abc", 4, "Test 1: File smaller than n");

        // Test Case 2: File size perfectly matches requested 'n' 
        runScene(program, "abcdefgh", 8, "Test 2: File size matches n exactly");

        // Test Case 3: File is significantly larger than requested 'n'
        runScene(program, "leetcode_solution", 5, "Test 3: File larger than n");

        // Test Case 4: Stream contains no elements (Empty File Edge Case)
        runScene(program, "", 10, "Test 4: Completely empty file stream");

        // Test Case 5: Exact single pass block size match
        runScene(program, "abcd", 4, "Test 5: Single Read4 Full Block Cycle Evaluation");
    }

    /**
     * Reusable Test Matrix Scenario Executer
     */
    private static void runScene(ReadNCharactersGivenReader4 program, String initialFileContent, int requestSize, String sceneHeader) {
        System.out.println("👉 " + sceneHeader);
        System.out.println("   File Contents        : \"" + initialFileContent + "\" (Length: " + initialFileContent.length() + ")");
        System.out.println("   Requested Size (n)   : " + requestSize);
        
        program.resetFile(initialFileContent);
        char[] destinationBuffer = new char[requestSize + 5]; // Padding to avoid array overflow checks
        Arrays.fill(destinationBuffer, '\u0000'); 
        
        int resultBytes = program.read(destinationBuffer, requestSize);
        int expectedBytes = Math.min(initialFileContent.length(), requestSize);
        String parsedString = new String(destinationBuffer, 0, resultBytes);
        
        System.out.println("   Bytes Extracted      : " + resultBytes + " (Expected: " + expectedBytes + ")");
        System.out.println("   Buffer Output String : \"" + parsedString + "\"");
        System.out.println(resultBytes == expectedBytes ? "   STATUS               : ✅ PASSED" : "   STATUS               : ❌ FAILED");
        System.out.println("------------------------------------------------------\n");
    }
}
