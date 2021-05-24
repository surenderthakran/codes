package com.surenderthakran.coding.findnumberofsmallstringpermutationsinlargestring;

import java.util.Arrays;

/**
 * Given a large string and a small string as inputs, find the permutations of the small string
 * which are substrings of the large string.<br>
 * Assumptions:<br>
 *
 * <ul>
 *   <li>The large string is always longer than the small string.
 * </ul>
 */
class Main {

  public static void main(String[] args) {
    boolean assertsEnabled = false;
    assert assertsEnabled = true;

    if (assertsEnabled) {
      assert areEqualIgnoringOrder(
          Solution.getSubstringPermutations("cbabcacabca", "abc"),
          new String[] {"cba", "abc", "bca", "cab", "abc", "bca"});

      assert areEqualIgnoringOrder(
          Solution.getSubstringPermutations("cbabcacabca", "acc"), new String[] {"cac"});

      assert areEqualIgnoringOrder(
          Solution.getSubstringPermutations("aaaaaaa", "aaa"),
          new String[] {"aaa", "aaa", "aaa", "aaa", "aaa"});

      assert areEqualIgnoringOrder(
          Solution.getSubstringPermutations("cbabcacabca", "def"), new String[] {});

      assert areEqualIgnoringOrder(
          Solution.getSubstringPermutations("cbabcacabca", "a"), new String[] {"a", "a", "a", "a"});

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }

  private static boolean areEqualIgnoringOrder(String[] first, String[] second) {
    Arrays.sort(first);
    Arrays.sort(second);
    return Arrays.equals(first, second);
  }
}
