package leetcode.Solutions_0101_0200.s158_read_n_characters_given_read4_II_call_multiple_times;



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
 * LeetCode 158 Solution - Call Multiple Times.
 * File Name must be: ReadNCharactersGivenReader4II.java
 */
public class ReadNCharactersGivenReader4II extends Reader4 {
    
    // Internal persistent buffers to retain state across repeated calls
    private char[] tempBuffer = new char[4];
    private int buffPtr = 0;
    private int buffCount = 0;

    /**
     * @param buf Destination buffer to copy characters into
     * @param n   Number of characters to read
     * @return    The actual number of characters successfully read into buf
     */
    public int read(char[] buf, int n) {
        int totalCharsCopied = 0;
        
        while (totalCharsCopied < n) {
            // If internal buffer is completely dry, pull fresh characters using read4
            if (buffPtr == buffCount) {
                buffCount = read4(tempBuffer);
                buffPtr = 0; // Reset index back to front of array
                
                // If EOF hit, exit processing loop
                if (buffCount == 0) {
                    break;
                }
            }
            
            // Consume characters one-by-one from the cached storage
            while (totalCharsCopied < n && buffPtr < buffCount) {
                buf[totalCharsCopied] = tempBuffer[buffPtr];
                totalCharsCopied++;
                buffPtr++;
            }
        }
        return totalCharsCopied;
    }

    // --- Main Method Executing Comprehensive State Multi-Call Tests ---
    public static void main(String[] args) {
        ReadNCharactersGivenReader4II program = new ReadNCharactersGivenReader4II();

        System.out.println("======================================================");
        System.out.println("  RUNNING SCENARIO LABS FOR READ N CHARACTERS GIVEN READ4 II ");
        System.out.println("======================================================\n");

        // Scenario 1: Multi-Call Buffer Extraction Sequence
        System.out.println("👉 Scenario 1: Intermittent Sequential Extraction Streams");
        String streamContent1 = "abcde";
        program.resetFile(streamContent1);
        System.out.println("   File Contents : \"" + streamContent1 + "\"\n");

        // Call 1: Request 1 character (Should cache 'b', 'c', 'd' internally)
        char[] bufA = new char[5];
        int readA = program.read(bufA, 1);
        System.out.println("   [Call 1] Requested: 1 -> Extracted: " + readA + " -> String: \"" + new String(bufA, 0, readA) + "\"");

        // Call 2: Request 3 characters (Should drain 'b', 'c', 'd' without fetching new read4 blocks)
        char[] bufB = new char[5];
        int readB = program.read(bufB, 3);
        System.out.println("   [Call 2] Requested: 3 -> Extracted: " + readB + " -> String: \"" + new String(bufB, 0, readB) + "\"");

        // Call 3: Request 1 character (Should hit read4 again to pull remaining 'e')
        char[] bufC = new char[5];
        int readC = program.read(bufC, 1);
        System.out.println("   [Call 3] Requested: 1 -> Extracted: " + readC + " -> String: \"" + new String(bufC, 0, readC) + "\"\n");
        
        //-----------------------------------------------------

        // Scenario 2: Requesting zero boundaries on exhausted pipelines
        System.out.println("👉 Scenario 2: Overshoot Extraction past EOF Point");
        program.resetFile("xyz");
        
        char[] bufX = new char[10];
        int readX = program.read(bufX, 4);
        System.out.println("   [Call 1] Requested: 4 -> Extracted: " + readX + " -> String: \"" + new String(bufX, 0, readX) + "\"");
        
        char[] bufY = new char[10];
        int readY = program.read(bufY, 2);
        System.out.println("   [Call 2] Requested: 2 -> Extracted: " + readY + " -> String: \"" + new String(bufY, 0, readY) + "\"");
    }
}

