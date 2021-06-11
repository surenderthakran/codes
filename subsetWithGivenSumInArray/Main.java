package com.surenderthakran.coding.subsetwithgivensuminarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Main {

  public static void main(String[] args) {
    boolean assertsEnabled = false;
    assert assertsEnabled = true;

    if (assertsEnabled) {
      assert Solution.hasSubsetWithGivenSum(new int[] {2, 4, 6, 10}, 16) == true;
      assert Solution.hasSubsetWithGivenSum(new int[] {2, 4, 6}, 16) == false;

      assert Solution.hasSubsetWithGivenSum(new int[] {3, 34, 4, 12, 5, 2}, 9) == true;
      assert Solution.hasSubsetWithGivenSum(new int[] {3, 34, 4, 12, 5, 2}, 30) == false;

      assert SolutionWithDP.hasSubsetWithGivenSum(new int[] {2, 4, 6, 10}, 16) == true;
      assert SolutionWithDP.hasSubsetWithGivenSum(new int[] {2, 4, 6}, 16) == false;

      assert SolutionWithDP.hasSubsetWithGivenSum(new int[] {3, 34, 4, 12, 5, 2}, 9) == true;
      assert SolutionWithDP.hasSubsetWithGivenSum(new int[] {3, 34, 4, 12, 5, 2}, 30) == false;

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }
}
