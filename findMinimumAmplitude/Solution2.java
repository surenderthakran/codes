package com.surenderthakran.codes.findMinimumAmplitude;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The minimum amplitude of an array can be achieved by changing the values of the smallest and/or
 * the largest elements in the array with any other non-extreme element's value.
 * We do not care which element's value is used since by changing the values we effectively
 * eliminate the smallest and largest elements from the equation.
 * <p>
 * This solution uses the backtracking method with tree pruning.
 * Essentially, when changing value of extreme element from a given array, we only have two options:
 * either change value of leftmost or the rightmost element.
 * This method works by attempting both changes recursively for each change until all changes are
 * made and calculating the amplitude of the remaining array. After that it backtracks one step and
 * attempts the other change.
 * It effectively creates a perfect binary tree of method calls where the amplitude is calculated at
 * the leaves.
 * The height of the tree is m where m is the number of maximum changes allowed.
 * The number of leaf nodes are 2^m.
 * However, it is possible that some subtree can be repeated for a large enough m. To prevent
 * re-computation of amplitude for that tree we use memoization to prune the tree i.e. use the
 * previous result of the subtree.
 */
public class Solution2 {

  public static int findMinimumAmplitude(int[] arr, int changesRemaining) {
    if (arr.length <= (changesRemaining + 1)) {
      return 0;
    }

    // O(n log n)
    Arrays.sort(arr);

    Map<String, Integer> memo = new HashMap<>();

    return findMinimumAmplitude(arr, changesRemaining, 0, arr.length - 1, memo);
  }

  private static int findMinimumAmplitude(int[] arr, int changesRemaining, int start, int end, Map<String, Integer> memo) {
    if (changesRemaining == 0) {
      return arr[end] - arr[start];
    }

    String memoKey = String.format("%s_%s_%s", start, end, changesRemaining);
    if (memo.containsKey(memoKey)) {
      return memo.get(memoKey);
    }

    int leftAmplitude = findMinimumAmplitude(arr, changesRemaining - 1, start + 1, end, memo);
    int rightAmplitude = findMinimumAmplitude(arr, changesRemaining - 1, start, end - 1, memo);

    int minimumAmplitude = Math.min(leftAmplitude, rightAmplitude);
    memo.put(memoKey, minimumAmplitude);

    return minimumAmplitude;
  }
}
