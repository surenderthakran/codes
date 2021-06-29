package com.surenderthakran.coding.rabinkarp;

/**
 * Given a string pattern, determine if it exists in another given string using the Rabin-Karp
 * Algorithm.
 */
class Main {
  public static void main(String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      assert SinglePatternSearchSolutionWithoutMod.patternExistsInText("abc", "bdabcce") == true;
      assert SinglePatternSearchSolutionWithoutMod.patternExistsInText("abd", "bdabcce") == false;

      assert SinglePatternSearchSolutionWithMod.patternExistsInText("abc", "bdabcce") == true;
      assert SinglePatternSearchSolutionWithMod.patternExistsInText("abd", "bdabcce") == false;

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }
}
