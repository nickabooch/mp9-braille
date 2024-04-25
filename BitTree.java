/**
 * This class defines a binary tree structure to map bit strings to values. It's designed to
 * facilitate encoding and decoding between different character sets, such as ASCII and Braille.
 * Author: @Rommin Adl
 */
public class BitTree {
  private BitTreeNode root;
  private final int expectedLength;

  /**
   * Constructs a new BitTree capable of storing bit strings of a specified length.
   * @param n the length of the bit strings that this tree will store
   */
  public BitTree(int n) {
      root = new BitTreeInteriorNode();
      expectedLength = n;
  }

  /**
   * Inserts a value into the tree based on the specified bit pattern.
   * @param bits a string of bits representing the path in the tree
   * @param value the value to store at the path specified by bits
   */
  public void set(String bits, String value) {
      if (bits.length() != expectedLength)
          throw new IllegalArgumentException("Bit string length must be " + expectedLength);
      root.set(bits, 0, value);
  }

  /**
   * Retrieves a value from the tree based on the specified bit pattern.
   * @param bits a string of bits representing the path in the tree
   * @return the value stored at the path specified by bits
   */
  public String get(String bits) {
      if (bits.length() != expectedLength)
          throw new IllegalArgumentException("Bit string length must be " + expectedLength);
      return root.get(bits, 0);
  }
}
