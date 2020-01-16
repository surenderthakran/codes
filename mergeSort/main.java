/**
 * Merge sorts implements in `O(n log(n))` time complexity in all three cases.
 *
 * At each recursion level two operations take place:
 * 1. The recursion input is split in half
 * 2. The sorted halves are merged back.
 *
 * For an input array of size n, if we keep splitting it in half until we get sub-arrays of size 1,
 * we will be splitting `log2(n)` times.
 * And at each split level we merge/combine back ALL the elements of subarrays which would need visiting each element once.
 * Hence at each level we visit n elements.
 *
 * Hence the total time complexity of merge sort is `O(n) * O(log(n)) = O(n log(n))`.
 */

import java.util.Arrays;

class Main {
  public static void main (String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      int[] nums = {1, 9, 2, -8, 3, 7, -4, 6, -5};
      mergeSort(nums);
      assert Arrays.equals(nums, new int[]{-8, -5, -4, 1, 2, 3, 6, 7, 9});

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }

  static void mergeSort(int[] nums) {
    mergeSort(nums, 0, nums.length - 1);
  }

  /**
   * Splits the given array between the given bounds recursively until each split's size is 1 and
   * then merges them into sorted arrays.
   * The number of times this method is needed to be called for an array of size n until we reach
   * sub-arrays of size 1 is `log(n)`.
   */
  static void mergeSort(int[] nums, int left, int right) {
    if (nums.length == 0) return;

    int mid = (left + right) / 2;

    // Recursively sort the left half if it's length is greater than 1.
    if (left < mid) {
      mergeSort(nums, left, mid);
    }

    // Recursively sort the right half if it's length is greater than 1.
    if (mid + 1 < right) {
      mergeSort(nums, mid + 1, right);
    }

    // Merge the sorted left and right halves.
    mergeSortedSubArrays(nums, left, mid, right);
  }

  /**
   * Merges the left and right sorted sub-arrays in-place.
   *
   * Merging the two arrays needs us to visit each element in the two arrays atleast once.
   * Hence, it takes O(n) time complexity.
   *
   * @param nums Array to be sorted.
   * @param left Index where the left sorted sub-array begins.
   * @param mid Index separating the left and right sorted sub-arrays.
   * @param right Index where the right sorted sub-array ends.
   */
  static void mergeSortedSubArrays(int[] nums, int left, int mid, int right) {
    // Create temporary arrays to hold left and right halves.
    int[] tmpLeft = new int[mid - left + 1];
    int[] tmpRight = new int[right - mid];
    for (int i = left; i <= mid; i++) {
      tmpLeft[i - left] = nums[i];
    }
    for (int i = mid + 1; i <= right; i++) {
      tmpRight[i - (mid + 1)] = nums[i];
    }

    // Counters for left and right temporary arrays.
    int tmpL = 0;
    int tmpR = 0;

    // While neither of the two temporary arrays have been fully read.
    while (tmpL < tmpLeft.length && tmpR < tmpRight.length) {
      // Move the smaller of the two elements at the head of left and right temporary arrays to the
      // main array.
      if (tmpLeft[tmpL] <= tmpRight[tmpR]) {
        nums[left] = tmpLeft[tmpL];
        tmpL++;
      } else {
        nums[left] = tmpRight[tmpR];
        tmpR++;
      }
      left++;
    }

    // Merge all remaining elements of left array if any.
    while (tmpL < tmpLeft.length) {
      nums[left] = tmpLeft[tmpL];
      tmpL++;
      left++;
    }

    // Merge all remaining elements of right array if any.
    while (tmpR < tmpRight.length) {
      nums[left] = tmpRight[tmpR];
      tmpR++;
      left++;
    }
  }
}
