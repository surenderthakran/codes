package com.surenderthakran.coding.numberstringtowords;

/**
 * Given the following mapping between alphabets and numbers.
 *
 * <p>a -> 1, b -> 2, c -> 3,......, z -> 26
 *
 * <p>Identify how many ways a given number string can be decoded into a word.
 *
 * <p>ex: "12" can be decoded into "ab" or "l", hence the output should be 2.
 */
class Main {

  public static void main(String[] args) {
    boolean assertsEnabled = false;
    assert assertsEnabled = true;

    if (assertsEnabled) {
      long withoutMemoizationStartTime = System.nanoTime();

      assert SolutionWithoutMemoization.getNumberOfWays("1") == 1;
      assert SolutionWithoutMemoization.getNumberOfWays("12") == 2;
      assert SolutionWithoutMemoization.getNumberOfWays("123") == 3;
      assert SolutionWithoutMemoization.getNumberOfWays("01") == 0;
      assert SolutionWithoutMemoization.getNumberOfWays("1230") == 0;
      assert SolutionWithoutMemoization.getNumberOfWays("120") == 1;
      assert SolutionWithoutMemoization.getNumberOfWays("") == 1;

      System.out.println(System.nanoTime() - withoutMemoizationStartTime);

      long withMemoizationStartTime = System.nanoTime();

      assert SolutionWithMemoization.getNumberOfWays("1") == 1;
      assert SolutionWithMemoization.getNumberOfWays("12") == 2;
      assert SolutionWithMemoization.getNumberOfWays("123") == 3;
      assert SolutionWithMemoization.getNumberOfWays("01") == 0;
      assert SolutionWithMemoization.getNumberOfWays("1230") == 0;
      assert SolutionWithMemoization.getNumberOfWays("120") == 1;
      assert SolutionWithMemoization.getNumberOfWays("") == 1;

      System.out.println(System.nanoTime() - withMemoizationStartTime);

      System.out.println("All Assertions Succeeded!");

    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }
}
