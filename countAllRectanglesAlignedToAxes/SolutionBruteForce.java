package com.surenderthakran.codes.countallrectanglesalignedtoaxes;

/** Time Complexity: `O(n^4)` */
class SolutionBruteForce {

  static int countAllRectaglesAlignedToAxes(int[][] points) {
    int numberOfRectangles = 0;
    for (int i = 0; i < points.length; i++) {
      int[] topLeft = points[i];

      for (int j = 0; j < points.length; j++) {
        if (points[j][0] == topLeft[0] && points[j][1] < topLeft[1]) {
          int[] bottomLeft = points[j];

          for (int k = 0; k < points.length; k++) {
            if (points[k][1] == bottomLeft[1] && points[k][0] > bottomLeft[0]) {
              int[] bottomRight = points[k];

              for (int l = 0; l < points.length; l++) {
                if (points[l][0] == bottomRight[0] && points[l][1] == topLeft[1]) {
                  numberOfRectangles++;
                }
              }
            }
          }
        }
      }
    }
    return numberOfRectangles;
  }
}
