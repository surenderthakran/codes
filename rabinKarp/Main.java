package com.surenderthakran.codes.rabinkarp;

import java.util.Arrays;

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

      assert areEqualIgnoringOrder(
          MultiPatternSearchSolutionWithoutMod.patternsInText(
              new String[] {"this", "text", "used", "karp", "work", "pill"},
              "thisisarandomtextstringusedfortestingrabinkarpalgorithm"),
          new String[] {"this", "text", "used", "karp"});

      assert areEqualIgnoringOrder(
          MultiPatternSearchSolutionWithMod.patternsInText(
              new String[] {"this", "text", "used", "karp", "work", "pill"},
              "thisisarandomtextstringusedfortestingrabinkarpalgorithm"),
          new String[] {"this", "text", "used", "karp"});

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
