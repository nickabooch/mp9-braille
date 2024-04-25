/**
 * This interface represents a node in a binary tree structure used for storing bit-encoded data.
 * Author: [Your Name]
 */
public interface BitTreeNode {
  void set(String bits, int index, String value);
  String get(String bits, int index);
}

/**
* This class represents an interior node in a binary tree that holds no value itself but points to other nodes.
* Author: [Your Name]
*/
class BitTreeInteriorNode implements BitTreeNode {
  private BitTreeNode left = null;
  private BitTreeNode right = null;

  @Override
  public void set(String bits, int index, String value) {
      if (index >= bits.length()) {
          throw new IllegalArgumentException("Attempt to set value beyond expected bit string length");
      }
      if (bits.charAt(index) == '0') {
          if (left == null) {
              left = (index == bits.length() - 1) ? new BitTreeLeaf() : new BitTreeInteriorNode();
          }
          left.set(bits, index + 1, value);
      } else {
          if (right == null) {
              right = (index == bits.length() - 1) ? new BitTreeLeaf() : new BitTreeInteriorNode();
          }
          right.set(bits, index + 1, value);
      }
  }

  @Override
  public String get(String bits, int index) {
      if (index >= bits.length()) throw new IllegalArgumentException("Invalid bit length at index " + index);
      BitTreeNode next = (bits.charAt(index) == '0') ? left : right;
      if (next == null) throw new NullPointerException("No path exists for given bit sequence");
      return next.get(bits, index + 1);
  }
}




/**
* This class represents a leaf node in a binary tree that stores a value corresponding to a bit-encoded string.
* Author: [Your Name]
*/
class BitTreeLeaf implements BitTreeNode {
  private String value;

  @Override
  public void set(String bits, int index, String value) {
      if (index == bits.length()) this.value = value;
      else throw new IllegalArgumentException("Leaf reached too early");
  }

  @Override
  public String get(String bits, int index) {
      if (index == bits.length()) return value;
      else throw new IllegalArgumentException("Extra bits in leaf");
  }
}
