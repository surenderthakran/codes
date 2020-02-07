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
      assert indexOf(5, new int[]{2, 3, 5, 6, 7, 8, 9, 10, 1}) == 2;
      assert indexOf(5, new int[]{10, 1, 2, 3, 5, 6, 7, 8, 9}) == 4;
      assert indexOf(10, new int[]{30, 40, 50, 10, 20}) == 3;
      assert indexOf(0, new int[]{2, 2, 2, 2, 2, 2, 2, 2, 0, 2}) == 8;
      assert indexOf(0, new int[]{2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}) == 1;

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }

  static int indexOf(int num, int[] arr) {
    // If the array is not rotated.
    if (arr[0] < arr[arr.length - 1]) {
      return binarySearch(num, arr);
    }

    // Find the pivot point in the array using binary search.
    int pivot = -1;
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int mid = (left + right)/2;

      // If mid itself has the required number, we return mid as result from here itself.
      if (arr[mid] == num) {
        return mid;
      }

      // If mid itself is the pivot.
      if (arr[mid] > arr[mid + 1]) {
        pivot = mid;
        break;
      }

      // Reset left or right index to continue searching for pivot.
      if (left == mid - 1 && arr[left] > arr[mid]) {  // If left side has only one element. Check.
        pivot = left;
        break;
      } else if (arr[left] > arr[mid - 1]) {          // Pivot lies on the left of the mid.
        right = mid - 1;
      } else if (arr[mid + 1] > arr[right]) {         // Pivot lies on the right of the mid.
        left = mid + 1;
      }
    }

    // Determine which side of the pivot would the required number fall and perform a binary search
    // for the number on that side.
    if (pivot > 0 && arr[0] <= num && num <= arr[pivot - 1]) {
      return binarySearch(num, arr, 0, pivot - 1);
    } else if (
        pivot < arr.length - 1 && arr[pivot + 1] <= num && num <= arr[arr.length - 1]) {
      return binarySearch(num, arr, pivot + 1, arr.length - 1);
    }

    return -1;
  }

  static int binarySearch(int num, int[] arr) {
    return binarySearch(num, arr, 0, arr.length - 1);
  }

  static int binarySearch(int num, int[] arr, int left, int right) {
    while (left <= right) {
      int mid = (left + right)/2;
      if (arr[mid] == num) {
        return mid;
      } else if (num < arr[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}
