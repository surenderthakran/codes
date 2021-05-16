package com.surenderthakran.coding.countallrectanglesalignedtoaxes;

import java.util.Map.Entry;
import java.util.HashMap;

/** Time Complexity: `O(n^2)` */
class Solution {

  static int countAllRectaglesAlignedToAxes(int[][] points) {
    HashMap<String, Integer> parallelLinesMap = new HashMap<>();

    for (int[] upperPoint : points) {
      for (int[] lowerPoint : points) {
        // Find all downward facing distinct vertical lines.
        if (upperPoint[0] == lowerPoint[0] && upperPoint[1] > lowerPoint[1]) {

          // Store y coordinates of adjacent parallel vertical lines with their frequency in a
          // HashMap.
          String key = String.format("%d_%d", upperPoint[1], lowerPoint[1]);
          int count = parallelLinesMap.get(key) == null ? 0 : parallelLinesMap.get(key);
          parallelLinesMap.put(String.format("%d_%d", upperPoint[1], lowerPoint[1]), ++count);
        }
      }
    }

    // Count number of rectangles that can be formed with each set of adjacent parallel vertical
    // lines and add them.
    int numberOfRectangles =
        parallelLinesMap.entrySet().stream()
            .mapToInt(
                entry ->
                    (entry.getValue() * (entry.getValue() - 1))
                        / 2) // if r = 2 in nCr, nC2 = n(n-1)/2
            .sum();

    return numberOfRectangles;
  }
}
