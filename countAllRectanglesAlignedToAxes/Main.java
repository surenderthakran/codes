package com.surenderthakran.coding.countallrectanglesalignedtoaxes;

/**
 * Given a series of points on the XY cartesian plane, identify the maximum number of rectangles
 * that can be forwed with those points whose edges are aligned to the X and Y axes.
 *
 * <p>Assumptions:
 *
 * <ul>
 *   <li>Points have integer coordinates.
 * </ul>
 */
class Main {
  public static void main(String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      assert SolutionBruteForce.countAllRectaglesAlignedToAxes(
              new int[][] {
                {5, 5}, {0, 5}, {0, 0}, {5, 0}, {2, 3}, {5, 3}, {0, 3}, {-2, 0}, {-2, 3}, {-2, -3}
              })
          == 5;
      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Assertions not enabled! Results not verified!");
    }
  }
}
