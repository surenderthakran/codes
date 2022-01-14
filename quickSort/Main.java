package com.surenderthakran.codes.quicksort;

import java.util.Arrays;

/**
 * Quicksort is an in-place sorting algorithm.
 * Also called partition-exchange algorithm.
 * It employs divide-and-conquer strategy.
 *
 * Time Complexity:
 * Average case: O(n log n)
 * Worst case: O(n^2)
 *
 * Space Complexity:
 * O(1) since it is an in-place algorithm.
 */
class Main {
  public static void main(String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      int[] nums = {1, 9, 2, -8, 3, 7, -4, 6, -5};
      quickSort(nums);
      assert Arrays.equals(nums, new int[] {-8, -5, -4, 1, 2, 3, 6, 7, 9});

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Assertions not enabled! Results not verified!");
    }
  }

  private static void quickSort(int[] input) {
    quickSort(input, 0, input.length - 1);
  }

  private static void quickSort(int[] input, int begin, int end) {
    // Return early if the sub-array to sort has less than two elements.
    if (begin >= end) {
      return;
    }

    // Pick the last element of the sub-array as the pivot element.
    int currentPivotIndex = end;
    // Pick the first index of the sub-array as the initial new position for the pivot element.
    int newPivotIndex = begin;

    // Iterate through the whole sub-array except for the pivot element.
    for (int i = begin; i < end; i++) {
      // Any element smaller than the pivot element should be moved left of the new pivot index.
      if (input[i] <= input[currentPivotIndex]) {
        swapValues(input, i, newPivotIndex);
        newPivotIndex++;
      }
    }
    // Move pivot element to its newly created/identified index.
    swapValues(input, newPivotIndex, currentPivotIndex);

    // Divide the array into smaller sub-arrays by pivot index and recursively sort them.
    quickSort(input, begin, newPivotIndex - 1);
    quickSort(input, newPivotIndex + 1, end);
  }

  private static void swapValues(int[] input, int first, int second) {
    int tmp = input[first];
    input[first] = input[second];
    input[second] = tmp;
  }
}
