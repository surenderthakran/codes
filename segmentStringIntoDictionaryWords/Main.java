package com.surenderthakran.coding.segmentstringintodictionarywords;

/**
 * Given an input string and a list of words, determnine if the whole input string can be used to
 * create sub-strings which are all words from the list.
 *
 * <p>ex: For input string "ilikedogs" and strings list {"i", "like", "liked", "dogs"}, the input
 * string can be divided into words "i", "like" and "dogs" which are all part of the input list of
 * words.
 *
 * <p>Assumptions:
 *
 * <ul>
 *   <li>The input and words are composed of only lowercase english alphabet.
 * </ul>
 */
class Main {

  public static void main(String[] args) {
    boolean assertsEnabled = false;
    assert assertsEnabled = true;

    if (assertsEnabled) {
      assert new Solution()
              .canInputBeSegmentedInDictionaryWords(
                  "ilikedogs", new String[] {"i", "like", "liked", "dogs"})
          == true;
      assert new Solution()
              .canInputBeSegmentedInDictionaryWords(
                  "ilikedogs", new String[] {"i", "liked", "dogs"})
          == false;
      assert new Solution()
              .canInputBeSegmentedInDictionaryWords(
                  "sachintendulkar", new String[] {"sachin", "ramesh", "tendulkar"})
          == true;

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }
}
