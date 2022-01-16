package com.surenderthakran.codes.dijkstra;

import java.util.Arrays;

class Main {

  public static void main(String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      assert areEqualIgnoringOrder(
          DijkstraBasic.findShortestPaths(
              new int[][]{{0, 1, 4}, {0, 7, 8}, {1, 7, 11}, {1, 2, 8}, {7, 8, 7}, {7, 6, 1},
                  {2, 8, 2}, {8, 6, 6}, {2, 3, 7}, {2, 5, 4}, {6, 5, 2}, {3, 5, 14}, {3, 4, 9},
                  {5, 4, 10}}, 0),
          new int[]{0, 4, 12, 19, 21, 11, 9, 8, 14});

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Assertions not enabled! Results not verified!");
    }
  }

  private static boolean areEqualIgnoringOrder(int[] first, int[] second) {
    Arrays.sort(first);
    Arrays.sort(second);
    return Arrays.equals(first, second);
  }
}