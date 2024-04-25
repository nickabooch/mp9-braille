/**
 * Main application for converting text between ASCII, Braille bit patterns, and Unicode Braille.
 * Author: [Your Name]
 */
public class BrailleASCII {

  /**
   * Main method to run the application. Expects two command-line arguments:
   * the first specifying the conversion type (braille, ascii, or unicode),
   * and the second the input text to convert.
   * @param args command-line arguments specifying conversion type and input text
   */
  public static void main(String[] args) {
    // Check if the correct number of command-line arguments is provided
    if (args.length != 2) {
        System.out.println("Usage: java BrailleASCII [braille|ascii|unicode] <text>");
        return;
    }

    String conversionType = args[0].toLowerCase(); // Convert conversion type to lowercase for consistency
    String inputText = args[1];
    String output = "";

    try {
        switch (conversionType) {
            case "braille":
                output = convertToBraille(inputText);
                break;
            case "ascii":
                output = convertToASCII(inputText);
                break;
            case "unicode":
                output = convertToUnicode(inputText);
                break;
            default:
                System.out.println("Invalid conversion type. Use 'braille', 'ascii', or 'unicode'.");
                return;
        }

        // Print the output of the conversion
        System.out.println("Output: " + output);
    } catch (IllegalArgumentException e) {
        // Handle invalid input text or unsupported characters
        System.out.println("Error: " + e.getMessage());
    } catch (Exception e) {
        // Handle any other unexpected errors
        System.out.println("Error during conversion: " + e.getMessage());
    }
}


private static String convertToBraille(String text) {
  StringBuilder braille = new StringBuilder();
  for (char c : text.toCharArray()) {
      if (c <= 127) { // Check if the character is within the ASCII range
          if (c == ' ') {
              // Append the Braille representation for space
              braille.append("000000 ");
          } else {
              // Convert ASCII character to Braille
              String brailleRepresentation = BrailleASCIITables.toBraille(c);
              if (brailleRepresentation != null && brailleRepresentation.length() == 6) {
                  braille.append(brailleRepresentation).append(" ");
              } else {
                  // Handle invalid Braille representation or unmapped characters
                  System.err.println("Invalid Braille representation for ASCII character: " + c);
              }
          }
      } else {
          // Handle non-ASCII characters (optional)
          System.err.println("Non-ASCII character detected: " + c);
      }
  }
  return braille.toString().trim();
}
private static String convertToASCII(String braille) {
  StringBuilder ascii = new StringBuilder();
  for (String b : braille.split("\\s+")) {
      if (b.equals("000000")) {
          // Append a space character
          ascii.append(" ");
      } else if (b.length() == 6) {
          // Convert Braille to ASCII only if the bit pattern length is 6
          String asciiChar = BrailleASCIITables.toASCII(b);
          if (!asciiChar.isEmpty()) {
              ascii.append(asciiChar);
          } else {
              // Handle unsupported characters
              System.err.println("Unsupported Braille bit pattern: " + b);
          }
      } else {
          // Handle invalid bit pattern length
          System.err.println("Invalid Braille bit pattern length: " + b);
      }
  }
  return ascii.toString();
}

private static String convertToUnicode(String braille) {
  StringBuilder unicode = new StringBuilder();
  for (String b : braille.split("\\s+")) {
      System.out.println("Braille bit pattern: " + b);
      String unicodeChar = BrailleASCIITables.toUnicode(b);
      if (!unicodeChar.isEmpty()) {
          System.out.println("Unicode Braille character: " + unicodeChar);
          unicode.append(unicodeChar).append(" "); // Append a space between each Unicode Braille character
      } else {
          // Handle missing Unicode mappings
          System.err.println("Unicode mapping not found for bit pattern: " + b);
      }
  }
  return unicode.toString().trim(); // Trim any leading or trailing spaces
}


}
