package com.surenderthakran.codes.subsetwithgivensuminarray;

class FirstProblemSolution {

  static boolean hasSubsetWithGivenSum(int[] arr, int target) {
    if (arr.length == 0) {
      return target == 0 ? true : false;
    }

    return hasSubsetWithGivenSum(arr, 0, target);
  }

  static boolean hasSubsetWithGivenSum(int[] arr, int beginIndex, int target) {
    if (target == 0) {
      return true;
    }

    if (beginIndex == arr.length - 1) {
      return arr[beginIndex] == target ? true : false;
    }

    // Either the current element is part of the subset or it is not. Recursively check the
    // remaining array to the right for both the scenarios.
    return hasSubsetWithGivenSum(arr, beginIndex + 1, target - arr[beginIndex])
        || hasSubsetWithGivenSum(arr, beginIndex + 1, target);
  }
}
