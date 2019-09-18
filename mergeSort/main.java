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

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }

  static void mergeSort(int[] nums, int left, int right) {
    if (nums.length == 0) return;

    if (left < right) {
      // The number of splits needed until we reach sub-array size 1 is `n log(n)`.
      int mid = (left + right) / 2;

      // Recursively sort the left half.
      mergeSort(nums, left, mid);

      // Recursively sort the right half.
      mergeSort(nums, mid + 1, right);

      // Merge the sorted left and right halves.
      merge(nums, left, mid, right);
    }
  }

  /**
   * Merging the two arrays needs us to visit each element in the two arrays atleast once.
   * Hence, it takes O(n) time complexity.
   */
  static void merge(int[] nums, int left, int mid, int right) {
    // Create temporary arrays to hold left and right halves.
    int[] tmpLeft = new int[mid - left + 1];
    int[] tmpRight = new int[right - mid];

    for (int i = left; i <= mid; i++) {
      tmpLeft[i - left] = nums[i];
    }
    for (int i = mid + 1; i <= right; i++) {
      tmpRight[i - mid - 1] = nums[i];
    }

    // Counters for left and right temporary arrays.
    int tmpL = 0;
    int tmpR = 0;

    // While neither of the two temporary arrays have been fully read.
    while (tmpL < tmpLeft.length && tmpR < tmpRight.length) {
      // Move the smaller of the two elements at the head of left and right temporray arrays to the
      // main array.
      if (tmpLeft[tmpL] <= tmpRight[tmpR]) {
        nums[left] = tmpLeft[tmpL];
        tmpL++;
        left++;
        continue;
      } else {
        nums[left] = tmpRight[tmpR];
        tmpR++;
        left++;
        continue;
      }
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
