package com.surenderthakran.coding.subsetwithgivensuminarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an array of integers and a target integer.<br>
 * Problem 1: Check if the array has any subsets whose elements add up to the target.<br>
 * Problem 2: Return the number of subsets of the array whose elements add up to the target.
 */
class Main {

  public static void main(String[] args) {
    boolean assertsEnabled = false;
    assert assertsEnabled = true;

    if (assertsEnabled) {
      assert FirstProblemSolution.hasSubsetWithGivenSum(new int[] {2, 4, 6, 10}, 16) == true;
      assert FirstProblemSolution.hasSubsetWithGivenSum(new int[] {2, 4, 6}, 16) == false;

      assert FirstProblemSolution.hasSubsetWithGivenSum(new int[] {3, 34, 4, 12, 5, 2}, 9) == true;
      assert FirstProblemSolution.hasSubsetWithGivenSum(new int[] {3, 34, 4, 12, 5, 2}, 30) == false;

      assert FirstProblemSolutionWithDP.hasSubsetWithGivenSum(new int[] {2, 4, 6, 10}, 16) == true;
      assert FirstProblemSolutionWithDP.hasSubsetWithGivenSum(new int[] {2, 4, 6}, 16) == false;

      assert FirstProblemSolutionWithDP.hasSubsetWithGivenSum(new int[] {3, 34, 4, 12, 5, 2}, 9) == true;
      assert FirstProblemSolutionWithDP.hasSubsetWithGivenSum(new int[] {3, 34, 4, 12, 5, 2}, 30) == false;

      assert SecondProblemSolutionWithDP.hasSubsetWithGivenSum(new int[] {2, 4, 6, 10}, 16) == 2;
      assert SecondProblemSolutionWithDP.hasSubsetWithGivenSum(new int[] {3, 34, 4, 12, 5, 2}, 9) == 2;

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }
}
