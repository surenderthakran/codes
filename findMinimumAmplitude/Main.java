package com.surenderthakran.codes.findMinimumAmplitude;

/**
 * Given an array of integers, find the minimum amplitude that we can get by changing values of
 * up to 'm' elements.
 * Amplitude is the difference between values of the largest and smallest elements in the array.
 */
public class Main {

  public static void main(String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      int[] input = new int[] {-1, 3, -1, 8, 5, 4};
      assert Solution1.findMinimumAmplitude(input, 3) == 2;
      assert Solution2.findMinimumAmplitude(input, 3) == 2;
      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Assertions not enabled! Results not verified!");
    }
  }
}
