import java.util.HashMap;
import java.util.Map;

/**
 * Provides utility methods to convert ASCII characters to Braille encoding, and vice versa.
 * Also includes a method to convert Braille bit patterns to Unicode Braille characters.
 * Author: @Rommin Adl
 */
public class BrailleASCIITables {

    private static BitTree brailleToAscii = new BitTree(6);
    private static BitTree asciiToBraille = new BitTree(8); 
    private static Map<String, String> brailleToUnicodeMap = new HashMap<>();

    static {
        initializeMappings();
    }
    /**
     * Loads the mappings between ASCII, Braille, and Unicode Braille.
     */
    private static void initializeMappings() {
        asciiToBraille.set("01000001", "100000"); // A
        asciiToBraille.set("01000010", "110000"); // B
        asciiToBraille.set("01000011", "100100"); // C
        asciiToBraille.set("01000100", "100110"); // D
        asciiToBraille.set("01000101", "100010"); // E
        asciiToBraille.set("01000110", "110100"); // F
        asciiToBraille.set("01000111", "110110"); // G
        asciiToBraille.set("01001000", "110010"); // H
        asciiToBraille.set("01001001", "010100"); // I
        asciiToBraille.set("01001010", "010110"); // J
        asciiToBraille.set("01001011", "101000"); // K
        asciiToBraille.set("01001100", "111000"); // L
        asciiToBraille.set("01001101", "101100"); // M
        asciiToBraille.set("01001110", "101110"); // N
        asciiToBraille.set("01001111", "101010"); // O
        asciiToBraille.set("01010000", "111100"); // P
        asciiToBraille.set("01010001", "111110"); // Q
        asciiToBraille.set("01010010", "111010"); // R
        asciiToBraille.set("01010011", "011100"); // S
        asciiToBraille.set("01010100", "011110"); // T
        asciiToBraille.set("01010101", "101001"); // U
        asciiToBraille.set("01010110", "111001"); // V
        asciiToBraille.set("01010111", "010111"); // W
        asciiToBraille.set("01011000", "101101"); // X
        asciiToBraille.set("01011001", "101111"); // Y
        asciiToBraille.set("01011010", "101011"); // Z

        brailleToAscii.set("100000", "A");
        brailleToAscii.set("110000", "B");
        brailleToAscii.set("100100", "C");
        brailleToAscii.set("100110", "D");
        brailleToAscii.set("100010", "E");
        brailleToAscii.set("110100", "F");
        brailleToAscii.set("110110", "G");
        brailleToAscii.set("110010", "H");
        brailleToAscii.set("010100", "I");
        brailleToAscii.set("010110", "J");
        brailleToAscii.set("101000", "K");
        brailleToAscii.set("111000", "L");
        brailleToAscii.set("101100", "M");
        brailleToAscii.set("101110", "N");
        brailleToAscii.set("101010", "O");
        brailleToAscii.set("111100", "P");
        brailleToAscii.set("111110", "Q");
        brailleToAscii.set("111010", "R");
        brailleToAscii.set("011100", "S");
        brailleToAscii.set("011110", "T");
        brailleToAscii.set("101001", "U");
        brailleToAscii.set("111001", "V");
        brailleToAscii.set("010111", "W");
        brailleToAscii.set("101101", "X");
        brailleToAscii.set("101111", "Y");
        brailleToAscii.set("101011", "Z");
        brailleToAscii.set("000000", " ");
    

        brailleToUnicodeMap.put("100000", "\u2801"); // Unicode for Braille pattern dots-1
        brailleToUnicodeMap.put("110000", "\u2803"); // Unicode for Braille pattern dots-1-2
        brailleToUnicodeMap.put("100100", "\u2809"); // Unicode for Braille pattern dots-1-4
        brailleToUnicodeMap.put("100110", "\u280B"); // Unicode for Braille pattern dots-1-4-5
        brailleToUnicodeMap.put("100010", "\u2805"); // Unicode for Braille pattern dots-1-3
        brailleToUnicodeMap.put("110100", "\u280D"); // Unicode for Braille pattern dots-1-2-4
        brailleToUnicodeMap.put("110110", "\u280F"); // Unicode for Braille pattern dots-1-2-4-5
        brailleToUnicodeMap.put("110010", "\u2807"); // Unicode for Braille pattern dots-1-2-3
        brailleToUnicodeMap.put("010100", "\u280A"); // Unicode for Braille pattern dots-2-4
        brailleToUnicodeMap.put("010110", "\u280E"); // Unicode for Braille pattern dots-2-4-5
        brailleToUnicodeMap.put("101000", "\u2811"); // Unicode for Braille pattern dots-1-6
        brailleToUnicodeMap.put("111000", "\u2813"); // Unicode for Braille pattern dots-1-2-6
        brailleToUnicodeMap.put("101100", "\u2819"); // Unicode for Braille pattern dots-1-4-6
        brailleToUnicodeMap.put("101110", "\u281B"); // Unicode for Braille pattern dots-1-4-5-6
        brailleToUnicodeMap.put("101010", "\u2815"); // Unicode for Braille pattern dots-1-3-6
        brailleToUnicodeMap.put("111100", "\u281D"); // Unicode for Braille pattern dots-1-2-4-6
        brailleToUnicodeMap.put("111110", "\u281F"); // Unicode for Braille pattern dots-1-2-4-5-6
        brailleToUnicodeMap.put("111010", "\u2817"); // Unicode for Braille pattern dots-1-2-3-6
        brailleToUnicodeMap.put("011100", "\u280C"); // Unicode for Braille pattern dots-2-3-4
        brailleToUnicodeMap.put("011110", "\u280E"); // Unicode for Braille pattern dots-2-3-4-5
        brailleToUnicodeMap.put("101001", "\u2821"); // Unicode for Braille pattern dots-1-6-3
        brailleToUnicodeMap.put("111001", "\u2823"); // Unicode for Braille pattern dots-1-2-6-3
        brailleToUnicodeMap.put("010111", "\u282E"); // Unicode for Braille pattern dots-2-4-5-6
        brailleToUnicodeMap.put("101101", "\u2829"); // Unicode for Braille pattern dots-1-4-6-3
        brailleToUnicodeMap.put("101111", "\u282B"); // Unicode for Braille pattern dots-1-4-5-6-3
        brailleToUnicodeMap.put("101011", "\u2825"); // Unicode for Braille pattern dots-1-3-6-3
        brailleToUnicodeMap.put("000000", "\u2800"); // Unicode for Braille blank pattern

    }
   public static String toBraille(char letter) {
        String asciiBits = String.format("%8s", Integer.toBinaryString(letter)).replace(' ', '0');
        return asciiToBraille.get(asciiBits);
    }
  /**
   * Converts a Braille bit pattern to its corresponding ASCII character.
   * @param bits the Braille bit pattern
   * @return the ASCII character as a string
   */
  public static String toASCII(String bits) {
      return brailleToAscii.get(bits);
  }

  /**
   * Converts a Braille bit pattern to its corresponding Unicode Braille character.
   * @param bits the Braille bit pattern
   * @return the Unicode Braille character as a string
   */
  public static String toUnicode(String bits) {
    String unicodeChar = brailleToUnicodeMap.get(bits);
    if (unicodeChar == null) {
        System.err.println("Error: Bit pattern not found in Unicode mapping");
        return ""; 
    }
    return unicodeChar;
}


}