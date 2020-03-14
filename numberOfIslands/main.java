/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is
 * surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
*/

import java.util.HashSet;
import java.util.Set;

class Point {
  int row, column;

  Point(int row, int column) {
    this.row = row;
    this.column = column;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (obj == null || obj.getClass() != this.getClass()) {
      return false;
    }

    Point p = (Point) obj;
    return p.row == this.row && p.column == this.column;
  }

  @Override
  public int hashCode() {
    return this.row + this.column;
  }
}

class Main {
  public static void main(String[] args) {
    boolean assertsEnabled = false;
    assert assertsEnabled = true;

    if (assertsEnabled) {
      char[][] grid1 = {
        {'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}};
      assert numIslands(grid1) == 1;

      char[][] grid2 = {
        {'1','1','0','0','0'},
        {'1','1','0','0','0'},
        {'0','0','1','0','0'},
        {'0','0','0','1','1'}};
      assert numIslands(grid2) == 3;

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }

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
      if (currPoint.column + 1 < grid[currPoint.row].length && grid[currPoint.row][currPoint.column + 1] == '1') {
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
