/**
 * For a given string, alphabetize (sort alphabetically) lowercase characters.
 * ex: "Google Mail" should return "Gaegil Mloo"
 */

import java.util.ArrayList;
import java.util.List;

class Main {
  public static void main(String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      assert alphabetizeLowercaseChars("Google Mail").equals("Gaegil Mloo");

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }

  static String alphabetizeLowercaseChars(String str) {
    // Read all lowercase characters from the string in a list.
    List<Character> lowercaseChars = new ArrayList<>();
    for (int i = 0; i < str.length(); i++) {
      int charValue = (int) str.charAt(i);
      if (charValue >= 97 && charValue <= 122) {
        lowercaseChars.add(str.charAt(i));
      }
    }

    // Time complexity: O(n log(n))
    lowercaseChars.sort(null);
    // Or use something like MergeSort which also operates with a time complexity of O(n log(n)).

    // Since Strings are immutable, we create a StringBuilder from the given String.
    StringBuilder strBuilder = new StringBuilder(str);

    // Counter on the lowercase characters' list.
    int j = 0;

    // Replace all lowercase characters in the StringBuilder with the characters from the sorted
    // list.
    for (int k = 0; k < strBuilder.length(); k++) {
      int charValue = (int) strBuilder.charAt(k);
      if (charValue >= 97 && charValue <= 122) {
        strBuilder.setCharAt(k, lowercaseChars.get(j));
        j++;
      }
    }

    return strBuilder.toString();
  }
}
