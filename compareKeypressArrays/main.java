/**
 * Given two arrays of keypresses, determine if they would print the same string.
 *
 * The keypress arrays can only contain lowercase characters and backspace character represented by
 * '#';
 */

class Main {
  public static void main(String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      assert
          isKeypressArraysEqual(
              new char[]{'a', 'b', 'c', '#', 'd'},
              new char[]{'a', 'c', '#', 'b', 'd'}) == true;

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }

  private static boolean isKeypressArraysEqual(char[] one, char[] two) {
    return getPrintableString(one).equals(getPrintableString(two));
  }

  private static String getPrintableString(char[] keypresses) {
    StringBuilder stringBuilder = new StringBuilder();

    // Appending and deleting characters from StringBuilder takes constant time `O(n)`.
    for (char key : keypresses) {
      if (key == '#' && stringBuilder.length() > 0) {
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
      } else {
        stringBuilder.append(key);
      }
    }

    return stringBuilder.toString();
  }
}
