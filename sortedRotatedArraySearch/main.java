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
    return -1;
  }
}
