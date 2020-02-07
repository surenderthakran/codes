/**
 * Given a rotated sorted array, find the index of a given element.
 *
 * The method used in this solution is:
 * 1. Determine if the array is actually rotated. If not, move to step 5. (O (1))
 * 2. If the array is rotated, find the pivot point (largest number) in the array. (O (log n))
 * 2. Determine which side of the pivot would the required number fall. (O (1))
 * 3. Perform a binary search for the number on that sorted portion of the array. (O (log n))
 *
 * Total time complexity: O (log n)
 */

class Main {
  public static void main(String[] args) {
    boolean assertsEnabled = false;
    assert assertsEnabled = true;

    if (assertsEnabled) {
      assert indexOf(3, new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3}) == 8;
      assert indexOf(30, new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3}) == -1;
      assert indexOf(10, new int[]{30, 40, 50, 10, 20}) == 3;

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }

  static int indexOf(int num, int[] array) {
    // If the array is not rotated.
    if (array[0] < array[array.length - 1]) {
      return binarySearch(num, array);
    }

    // Find the pivot point in the array using binary search.
    int pivot = -1;
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = (left + right)/2;

      // If mid itself has the required number, we return mid as result from here itself.
      if (array[mid] == num) {
        return mid;
      }

      // If mid itself is the pivot.
      if (array[mid] > array[mid + 1]) {
        pivot = mid;
        break;
      }

      if (array[left] > array[mid - 1]) {   // Pivot lies on the left of the mid.
        right = mid - 1;
        continue;
      } else {                              // Pivot lies on the right of the mid.
        left = mid + 1;
        continue;
      }
    }

    // Determine which side of the pivot would the required number fall.

    return -1;
  }
}
