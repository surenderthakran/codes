/**
 * Merge Sort
 */

class Main {
  public static void main (String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      assert Arrays.equals(
          mergeSort(new int[]{1, 9, 2, -8, 3, 7, -4, 6, -5}),
          new int[]{-8, -5, -4, 1, 2, 3, 6, 7, 9})
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }

  static int[] mergeSort(int[] nums) {}
}
