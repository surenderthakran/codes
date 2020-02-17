/**
 * Given a rotated sorted array, find the index of a given element.
 *
 * The method used in this solution is:
 * 1. Determine if the array is actually rotated. If not, move to step 5. (O (1))
 * 2. If the array is rotated, find the pivot index (index with a smaller number on it's right) in
 *    the array. (O (log n))
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
    // If array is empty.
    if (arr.length == 0) {
      return -1;
    }

    // If array has only one element.
    if (arr.length == 1) {
      return arr[0] == num ? 0 : -1;
    }

    // If the array is not rotated.
    if (arr[0] < arr[arr.length - 1]) {
      return binarySearch(num, arr);
    }

    // Note: Since the array is rotated, pivot can never be the last index of the array.
    int pivot = getPivotIndex(arr);

    if (arr[pivot] == num) {
      return pivot;
    }

    // Determine which side of the pivot would the required number fall and perform a binary search
    // for the number on that side.
    if (pivot > 0 && arr[0] <= num && num <= arr[pivot - 1]) {
      return binarySearch(num, arr, 0, pivot - 1);
    } else if (arr[pivot + 1] <= num && num <= arr[arr.length - 1]) {
      return binarySearch(num, arr, pivot + 1, arr.length - 1);
    }

    return -1;
  }

  static int getPivotIndex(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    return getPivotIndex(arr, left, right);
  }

  static int getPivotIndex(int[] arr, int left, int right) {
    if (left > right) {
      return -1;
    }

    if (left == right) {
      return left;
    }

    int mid = (left + right) / 2;

    // If mid itself is the pivot.
    if (arr[mid] > arr[mid + 1]) {
      return mid;
    }

    int pivotOnLeft = -1;
    int pivotOnRight = -1;

    if (left < mid) {
      if (left == mid - 1) {
        if(arr[left] > arr[mid]) {
          return left;
        }
      } else if (arr[left] >= arr[mid - 1]) {           // Search for pivot in the left half only if
                                                        // it is not irrefutably sorted.
        pivotOnLeft = getPivotIndex(arr, left, mid - 1);
      }
    }

    if (right == mid + 1) {
      // Since we had earlier established that the array is rotated, hence the pivot cannot be the
      // last index of the array.
      if (right != arr.length - 1 && arr[right] > arr[right + 1]) {
        return right;
      }
    } else if (arr[mid + 1] >= arr[right]) {          // Search for pivot in the right half only if
                                                      // it is not irrefutably sorted.
      pivotOnRight = getPivotIndex(arr, mid + 1, right);
    }

    return pivotOnLeft > pivotOnRight ? pivotOnLeft : pivotOnRight;
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
