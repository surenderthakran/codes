package com.surenderthakran.codes.findwordsinnumber;

import java.util.Arrays;

/**
 * In 9k keypads in older phone, same keys were used to type both numbers and characters.<br>
 * <code>
 * -------------------------
 * |   1   |   2   |   3   |
 * |       |  abc  |  def  |
 * -------------------------
 * |   4   |   5   |   6   |
 * |  ghi  |  jkl  |  mno  |
 * -------------------------
 * |   7   |   8   |   9   |
 * |  pqrs |  tuv  |  wxyz |
 * -------------------------
 *         |   0   |
 *         |       |
 *         ---------
 * </code><br>
 * As such, it was possible to represent phone numbers with words.<br>
 * ex: 73542623 could be represented with "reliance".
 *
 * <p>Given a phone number and a list of words, determine which of the given words is a substring of
 * the word represented by the number.<br>
 * ex: For phone number 73542623 and list of words ["lia", "rela", "ance", "ounce"], the output
 * would be ["lia", "ance"].
 *
 * <p>Assumptions:<br>
 *
 * <ul>
 *   <li>All words are in lowercase alphabets only.
 *   <li>Phone number is not very huge.
 * </ul>
 */
class Main {

  public static void main(String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      assert areEqualIgnoringOrder(
          Solution.findWordsInNumber("73542623", new String[] {"lia", "rela", "ance", "ounce"}),
          new String[] {"lia", "ance"});

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Assertions not enabled! Results not verified!");
    }
  }

  private static boolean areEqualIgnoringOrder(String[] first, String[] second) {
    Arrays.sort(first);
    Arrays.sort(second);
    return Arrays.equals(first, second);
  }
}
