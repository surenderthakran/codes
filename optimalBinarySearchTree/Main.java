package com.surenderthakran.codes.optimalBinarySearchTree;

public class Main {

  public static void main(String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      onlySuccesfulSearchTest();
      successfulAndUnsuccessfulSearchTest();

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Assertions not enabled! Results not verified!");
    }
  }

  /**
   * An Optimal Binary Search Tree is a tree for which when given a list of it's elements in an array and 
   * their corresponding search frequencies, the cost of searching all those elements is minimum.
   * Since for a given set of elements there could be multiple Binary Search Tree organizations,
   * however the average cost of search will be different for different tree organizations even when each element 
   * is searched only once.
   * But the difference in cost of search between different BST organizations become even more stark when 
   * the elements have varying search frequencies.
   * 
   * Given an array of elements in a BST and their corresponding frequencies in a separate array, 
   * find the optimal (minimum) cost of searching the given elements when compared to different tree organizations.
   */
  private static void onlySuccesfulSearchTest() {
    int[] keys = {10, 20, 30, 40};
    int[] freq = {4, 2, 6, 3};
    assert OnlySuccessfulSearchSolution.optimalSearchCost(keys, freq) == 26;

    keys = new int[] {10, 12, 20};
    freq = new int[] {34, 8, 50};
    assert OnlySuccessfulSearchSolution.optimalSearchCost(keys, freq) == 142;
  }

  /**
   * Given an array of elements in a BST, their corresponding search frequencies and 
   * the search frequency of all elements in between those elements which will constitute as unsuccessful searches, 
   * an Optimal Binary Search Tree is a tree with a BST organization with minimum search cost.
   */
  private static void successfulAndUnsuccessfulSearchTest() {
    int[] keys = new int[] {10, 20};
    double[] sFreq = new double[] {3, 3};
    double[] fFreq = new double[] {2, 3, 1};
    double result = SuccessfulAndUnsuccessfulSearchSolution.optimalSearchCost(keys, sFreq, fFreq);
    assert result == 19;

    keys = new int[] {10, 20, 30, 40};
    sFreq = new double[] {3, 3, 1, 1};
    fFreq = new double[] {2, 3, 1, 1, 1};
    result = SuccessfulAndUnsuccessfulSearchSolution.optimalSearchCost(keys, sFreq, fFreq);
    assert result == 32;
  }
}