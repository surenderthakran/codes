package com.surenderthakran.coding.subsetwithgivensuminarray;

import java.util.HashMap;

class FirstProblemSolutionWithDP {

  static boolean hasSubsetWithGivenSum(int[] arr, int target) {
    if (arr.length == 0) {
      return target == 0 ? true : false;
    }

    HashMap<String, Boolean> memoMatrix = new HashMap<>();

    return hasSubsetWithGivenSum(arr, 0, target, memoMatrix);
  }

  static boolean hasSubsetWithGivenSum(
      int[] arr, int beginIndex, int target, HashMap<String, Boolean> memoMatrix) {
    if (target == 0) {
      return true;
    }

    if (beginIndex == arr.length - 1) {
      return arr[beginIndex] == target ? true : false;
    }

    if (memoMatrix.containsKey(String.format("%s_%s", beginIndex, target))) {
      return memoMatrix.get(String.format("%s_%s", beginIndex, target));
    }

    // Either the current element is part of the subset or it is not. Recursively check the
    // remaining array to the right for both the scenarios.
    boolean result =
        hasSubsetWithGivenSum(arr, beginIndex + 1, target - arr[beginIndex], memoMatrix)
            || hasSubsetWithGivenSum(arr, beginIndex + 1, target, memoMatrix);

    memoMatrix.put(String.format("%s_%s", beginIndex, target), result);

    return result;
  }
}
