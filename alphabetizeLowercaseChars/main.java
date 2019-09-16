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
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }

  static String alphabetizeLowercaseChars(String str) {
    List<Character> lowercaseChars = new ArrayList<>();
    for (int i = 0; i < str.length(); i++) {
      int charValue = (int) str.charAt(i);
      if (charValue >= 97 && charValue <= 122) {
        lowercaseChars.add(str.charAt(i));
      }
    }

    // Time complexity: O(n log(n))
    lowercaseChars.sort(null);

    StringBuilder strBuilder = new StringBuilder(str);
    int j = 0;
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
