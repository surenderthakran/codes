package com.surenderthakran.codes.subsetwithgivensuminarray;

import java.util.HashMap;

class SecondProblemSolutionWithDP {

  static int hasSubsetWithGivenSum(int[] arr, int target) {
    if (arr.length == 0) {
      return target == 0 ? 1 : 0;
    }

    HashMap<String, Integer> memoMatrix = new HashMap<>();

    return numberOfSubsetsWithGivenSum(arr, 0, target, memoMatrix);
  }

  static int numberOfSubsetsWithGivenSum(
      int[] arr, int beginIndex, int target, HashMap<String, Integer> memoMatrix) {
    if (target == 0) {
      return 1;
    }

    if (beginIndex == arr.length - 1) {
      return arr[beginIndex] == target ? 1 : 0;
    }

    if (memoMatrix.containsKey(String.format("%s_%s", beginIndex, target))) {
      return memoMatrix.get(String.format("%s_%s", beginIndex, target));
    }

    // Either the current element is part of the subset or it is not. Recursively check the
    // remaining array to the right for both the scenarios.
    int result =
        numberOfSubsetsWithGivenSum(arr, beginIndex + 1, target - arr[beginIndex], memoMatrix)
            + numberOfSubsetsWithGivenSum(arr, beginIndex + 1, target, memoMatrix);

    memoMatrix.put(String.format("%s_%s", beginIndex, target), result);

    return result;
  }
}
