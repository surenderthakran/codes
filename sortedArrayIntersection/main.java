/**
 * Given two sorted integer arrays, find their intersection.
 */

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
    int i = 0, j = 0;
    List<Integer> result = new ArrayList<>();;

    while (i < one.length && j < two.length) {
      if (one[i] == two[j]) {
        result.add(one[i]);
        i++;
        j++;
        continue;
      }

      if (one[i] < two[j]) {
        i++;
        continue;
      }

      if (one[i] > two[j]) {
        j++;
        continue;
      }
    }

    return result.stream().mapToInt(Integer::intValue).toArray();
  }
}
