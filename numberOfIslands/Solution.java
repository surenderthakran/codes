package com.surenderthakran.coding.numberofislands;

import java.util.HashSet;
import java.util.Set;

class Solution {
  static int numIslands(char[][] grid) {
    int numOfIslands = 0;

    // Iterate over every grid point.
    for (int row = 0; row < grid.length; row++) {
      for (int column = 0; column < grid[row].length; column++) {

        // If an island is found, increase the count and sink the island.
        if (grid[row][column] == '1') {
          numOfIslands++;
          sinkIsland(grid, new Point(row, column));
        }
      }
    }
    return numOfIslands;
  }

  /** Sets all points on the current island to 0. */
  static void sinkIsland(char[][] grid, Point p) {
    Set<Point> islandPoints = new HashSet<>();
    islandPoints.add(p);

    while (!islandPoints.isEmpty()) {
      Point currPoint = islandPoints.iterator().next();

      // Left neighbour
      if (currPoint.column - 1 >= 0 && grid[currPoint.row][currPoint.column - 1] == '1') {
        islandPoints.add(new Point(currPoint.row, currPoint.column - 1));
      }

      // Right neighbour
      if (currPoint.column + 1 < grid[currPoint.row].length
          && grid[currPoint.row][currPoint.column + 1] == '1') {
        islandPoints.add(new Point(currPoint.row, currPoint.column + 1));
      }

      // Top neighbour
      if (currPoint.row - 1 >= 0 && grid[currPoint.row - 1][currPoint.column] == '1') {
        islandPoints.add(new Point(currPoint.row - 1, currPoint.column));
      }

      // Bottom neighbour
      if (currPoint.row + 1 < grid.length && grid[currPoint.row + 1][currPoint.column] == '1') {
        islandPoints.add(new Point(currPoint.row + 1, currPoint.column));
      }

      // Sink current point and remove it from the island set.
      grid[currPoint.row][currPoint.column] = '0';
      islandPoints.remove(currPoint);
    }
  }
}
