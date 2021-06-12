package com.surenderthakran.coding.zerooneknapsackproblem;

/**
 * The solution uses tabulation dynamic programming technique.<br>
 * We create a 2D array of values where the number of rows are (number of items available + 1) and
 * the number of columns are (max knapsack weight capacity + 1).<br>
 * Each cell {i, j} in the table holds the maximum value that can be added in the knapsack of
 * capacity `j` if the first `i` items were considered for inclusion.<br>
 */
class Solution {
  static int getMaxValue(int[] values, int[] weights, int maxWeight) {
    int[][] memoMatrix = new int[values.length + 1][maxWeight + 1];

    for (int item = 1; item <= values.length; item++) {
      for (int capacity = 1; capacity <= maxWeight; capacity++) {
        // If the weight of the current item is greater than the knapsack's current capacity, it
        // cannot be included in the knapsack and the maximum value that can be gained is the value
        // in the matrix for the current capacity's knapsack without the current item.
        if (weights[item - 1] > capacity) {
          memoMatrix[item][capacity] = memoMatrix[item - 1][capacity];
        } else {
          // Otherwise, the maximum value to be gained is greater of:
          // 1. Value in the matrix for the current capacity's knapsack without the current item and
          // 2. Value of the current item + maximum value that can be accommodated in the remaining
          // weight in the knapsack without the current element.
          memoMatrix[item][capacity] =
              Math.max(
                  memoMatrix[item - 1][capacity],
                  values[item - 1] + memoMatrix[item - 1][capacity - weights[item - 1]]);
        }
      }
    }

    return memoMatrix[values.length][maxWeight];
  }
}
