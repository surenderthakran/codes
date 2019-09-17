/**
 * Merge sorts implements in `O(n log(n))` time complexity in all three cases.
 *
 * For an input array of size n, if we keep splitting it in half until we get sub-arrays of size 1,
 * we will be splitting `log(n)` times.
 * At each split level we merge/combine back ALL the subarrays, so the combined merging time at each
 * level is `O(n)`.
 *
 * Hence the total time complexity of merge sort is `O(n log(n))`.
 */

import java.util.Arrays;

class Main {
  public static void main (String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      int[] nums = new int[]{1, 9, 2, -8, 3, 7, -4, 6, -5};
      mergeSort(nums, 0, nums.length - 1);
      assert Arrays.equals(nums, new int[]{-8, -5, -4, 1, 2, 3, 6, 7, 9});
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }

  static void mergeSort(int[] nums, int left, int right) {
    if (nums.length == 0) return;

    if (left < right) {
      int mid = (left + right) / 2;

      mergeSort(nums, left, mid);
      mergeSort(nums, mid + 1, right);

      merge(nums, left, mid, right);
    }
  }

  static void merge(int[] nums, int left, int mid, int right) {}
}
