package com.surenderthakran.codes.kadane;

public class KadaneZeroLengthSubArrayAllowed {

  public static int getLargestSubstringSum(int[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    int globalMax = 0;
    int currentMax = 0;
    for (int i = 0; i < arr.length; i++) {
      currentMax = Math.max(currentMax + arr[i], arr[i]);
      globalMax = Math.max(globalMax, currentMax);
    }

    return globalMax;
  }
}
