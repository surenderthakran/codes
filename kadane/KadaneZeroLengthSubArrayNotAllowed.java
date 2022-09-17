package com.surenderthakran.codes.kadane;

public class KadaneZeroLengthSubArrayNotAllowed {

  public static int getLargestSubstringSum(int[] arr) {
    // No need to check if the input array is empty since a zero length sub-array as result is not
    // allowed, hence it should not be a part of the input.
    int globalMax = arr[0];
    int currentMax = arr[0];
    for (int i = 1; i < arr.length; i++) {
      currentMax = Math.max(currentMax + arr[i], arr[i]);
      globalMax = Math.max(globalMax, currentMax);
    }

    return globalMax;
  }
}
