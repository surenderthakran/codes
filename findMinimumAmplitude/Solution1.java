package com.surenderthakran.codes.findMinimumAmplitude;

import java.util.Arrays;

/**
 * The minimum amplitude of an array can be achieved by changing the values of the smallest and/or
 * the largest elements in the array with any other non-extreme element's value.
 * We do not care which element's value is used since by changing the values we effectively
 * eliminate the smallest and largest elements from the equation.
 * <p>
 * This solution uses the sliding window method. It starts by first sorting the array.
 * Now we know that the elements to be changed can all be from the beginning of the array, or the
 * end of the array or some combination of distribution between beginning and end.
 * So we create a sliding window of size n - m where n is the size of input array and m is the
 * maximum number of value changes allowed.
 * We slide the window from beginning to end while calculating the amplitude at each step and
 * comparing with the previous minimum to reach a final minimum possible amplitude.
 * However, since the window is of size n - m sliding in a larger window of size n, it can only
 * slide m steps.
 * <p>
 * One exception case is when the input array is too small compared to the number of changes allowed.
 * In this case all elements' values can be changed to same value making the amplitude 0.
 * <p>
 * Time complexity: O((n log n) + m)
 * Space complexity: O(1)
 */
public class Solution1 {

  public static int findMinimumAmplitude(int[] arr, int maxChangesAllowed) {
    if (arr.length <= (maxChangesAllowed + 1)) {
      return 0;
    }

    // O(n log n)
    Arrays.sort(arr);

    int minimumAmplitude = Integer.MAX_VALUE;
    // O(m)
    for (int i = 0; i <= maxChangesAllowed; i++) {
      minimumAmplitude =
          Math.min(minimumAmplitude, arr[arr.length - 1 - maxChangesAllowed + i] - arr[i]);
    }

    return minimumAmplitude;
  }
}
