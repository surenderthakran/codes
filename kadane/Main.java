package com.surenderthakran.codes.kadane;

/**
 * Kadane's algorithm is used to find the sum of the sub array with the largest sum in a given
 * array. It works using the rolling window technique but instead of tracking the window's start and
 * end indices, it works by tracking the sum of the current window. For each new element it
 * encounters, the algorithm checks if it yeild a larger window sum by adding the new element to the
 * existing window or by starting a new window from the new element.
 * <p>
 * It has two problem variations:
 * 1. Where the sum of a zero length sub-array as result is allowed.
 * 2. Where the sum of a zero length sub-array as result is not allowed.
 * <p>
 * Time Complexity: O(n) Space Complexity: O(1)
 */
class Main {

  public static void main(String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      assert KadaneZeroLengthSubArrayAllowed.getLargestSubstringSum(
          new int[]{-3, 8, 1, -9, 5, 8, 3, 0, -5}) == 16;
      assert KadaneZeroLengthSubArrayNotAllowed.getLargestSubstringSum(
          new int[]{-3, 8, 1, -9, 5, 8, 3, 0, -5}) == 16;

      assert KadaneZeroLengthSubArrayAllowed.getLargestSubstringSum(
          new int[]{-3, -8, -1, -9, -5, -8, -3, 0, -5}) == 0;
      assert KadaneZeroLengthSubArrayNotAllowed.getLargestSubstringSum(
          new int[]{-3, -8, -1, -9, -5, -8, -3, 0, -5}) == 0;

      assert KadaneZeroLengthSubArrayAllowed.getLargestSubstringSum(
          new int[]{-3, -8, -1, -9, -5, -8, -3, -5}) == 0;
      assert KadaneZeroLengthSubArrayNotAllowed.getLargestSubstringSum(
          new int[]{-3, -8, -1, -9, -5, -8, -3, -5}) == -1;

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Assertions not enabled! Results not verified!");
    }
  }
}