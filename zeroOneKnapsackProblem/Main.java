package com.surenderthakran.codes.zerooneknapsackproblem;

/**
 * Given a list of item where each item has a specified weight and value, find the maximum value
 * that can be gained when filling a knapsack with a limited weight capacity.<br>
 * We cannot partially add an item to the knapsack i.e. an item is either included or excluded in
 * the knapsack Hence, the name of the problem (0-1 Knapsack problem)
 */
class Main {

  public static void main(String[] args) {
    boolean assertsEnabled = false;
    assert assertsEnabled = true;

    if (assertsEnabled) {
      assert Solution.getMaxValue(new int[] {10, 40, 30, 50}, new int[] {5, 4, 6, 3}, 10) == 90;
      assert Solution2.getMaxValue(new int[] {10, 40, 30, 50}, new int[] {5, 4, 6, 3}, 10) == 90;

      assert Solution.getMaxValue(new int[] {60, 100, 120}, new int[] {10, 20, 30}, 50) == 220;
      assert Solution2.getMaxValue(new int[] {60, 100, 120}, new int[] {10, 20, 30}, 50) == 220;

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }
}
