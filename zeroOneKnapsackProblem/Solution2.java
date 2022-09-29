package com.surenderthakran.codes.zerooneknapsackproblem;

/**
 * This solution builds upon the solution previously explained in Solution.java.
 * This is an improvement over the previous solution in regards that it uses a<br>
 * single one-dimensional array instead of a two-dimensional array. Hence, it has works with a<br>
 * better space complexity.
 *
 * Complexities:
 * Time complexity: O(n.w)
 * Space complexity: O(w)
 * where n is the number of items and w is the maxWeight.
 */
class Solution2 {

  static int getMaxValue(int[] values, int[] weights, int maxWeight) {
    int[] memo = new int[maxWeight + 1];
    for (int i = 0; i < values.length; i++) {
      // Iterate through the current weights of the knapsack in reverse order because in the
      // 0-1 knapsack problem's solution we only refer to values of the previous row for weights
      // less than or equal to the current weight.
      for (int currentSackWeight = maxWeight; currentSackWeight > 0; currentSackWeight--) {
        // If the weight of the current item is greater than the knapsack's current capacity, it
        // cannot be included in the knapsack and the maximum value that can be gained is the value
        // in the matrix for the current capacity's knapsack without the current item which is a
        // value already in the memo array.
        if (weights[i] > currentSackWeight) {
          continue;
        }

        // Otherwise, the maximum value to be gained is greater of:
        // 1. Value in the matrix for the current capacity's knapsack without the current item and
        // 2. Value of the current item + maximum value that can be accommodated in the remaining
        // weight in the knapsack without the current element.
        memo[currentSackWeight] =
            Math.max(memo[currentSackWeight], values[i] + memo[currentSackWeight - weights[i]]);
      }
    }

    return memo[maxWeight];
  }
}