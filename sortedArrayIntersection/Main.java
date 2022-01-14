/**
 * Given two sorted integer arrays, find their intersection.
 */

package com.surenderthakran.codes.sortedarrayintersection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
  public static void main(String[] args) {
    boolean assertsEnabled = false;
    assert assertsEnabled = true;

    if (assertsEnabled) {
      assert Arrays.equals(
          getIntersection(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 6, 7}),
          new int[]{3, 4, 5});

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }

  static int[] getIntersection(int[] one, int[] two) {
    // Counters for both the arrays.
    int i = 0, j = 0;
    List<Integer> result = new ArrayList<>();

    // Iterate while neither of the two arrays have been fully read.
    while (i < one.length && j < two.length) {

      // If the elements at both arrays' head is equal, move it to the result set and increment both
      // counters else increment the counter with the smaller value.
      if (one[i] == two[j]) {
        result.add(one[i]);
        i++;
        j++;
      } else if (one[i] < two[j]) {
        i++;
      } else if (one[i] > two[j]) {
        j++;
      }
    }

    return result.stream().mapToInt(Integer::intValue).toArray();
  }
}
