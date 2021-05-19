package com.surenderthakran.coding.numberstringtowords;

class SolutionWithMemoization {

  static int getNumberOfWays(String numberString) {
    Integer[] memoizedResults = new Integer[numberString.length()];
    return getNumberOfWaysRecursive(numberString.toCharArray(), 0, memoizedResults);
  }

  private static int getNumberOfWaysRecursive(
      char[] numbers, int startingIndex, Integer[] memoizedResults) {
    // If character array under process is effectively empty.
    if (startingIndex >= numbers.length) {
      return 1;
    }

    if (numbers[startingIndex] == '0') {
      return 0;
    }

    if (memoizedResults[startingIndex] != null) {
      return memoizedResults[startingIndex];
    }

    // First way to form a word is to only map the first character to an alphabet.
    int numberOfWays = getNumberOfWaysRecursive(numbers, startingIndex + 1, memoizedResults);

    // Second way to form a word is to map first two characters to an alphabet.
    // Two conditions need to be met for the second way to be possible:
    // 1. There should be atleast two characters left to process.
    // 2. The first two characters should be mappable to an alphabet.
    if (startingIndex < numbers.length - 1
        && (numbers[startingIndex] == '1'
            || (numbers[startingIndex] == '2'
                && numbers[startingIndex + 1] >= '0'
                && numbers[startingIndex + 1] <= '6'))) {
      numberOfWays += getNumberOfWaysRecursive(numbers, startingIndex + 2, memoizedResults);
    }

    memoizedResults[startingIndex] = numberOfWays;
    return numberOfWays;
  }
}
