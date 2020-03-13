/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is
 * surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
*/

import java.util.HashSet;
import java.util.Set;

class Point {
  int i, j;

  Point(int i, int j) {
    this.i = i;
    this.j = j;
  }
}

class Main {
  public static void main(String[] args) {
    boolean assertsEnabled = false;
    assert assertsEnabled = true;

    if (assertsEnabled) {
      char[][] grid = {
        {'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}};
      assert numIslands(grid) == 1;

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }

  static int numIslands(char[][] grid) {
    int numOfIslands = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          numOfIslands++;
          sinkIsland(grid, new Point(i, j));
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
      if (currPoint.j - 1 >= 0 && grid[currPoint.i][currPoint.j - 1] == '1') {
        islandPoints.add(new Point(currPoint.i, currPoint.j - 1));
      }

      // Right neighbour
      if (currPoint.j + 1 < grid[currPoint.i].length && grid[currPoint.i][currPoint.j + 1] == '1') {
        islandPoints.add(new Point(currPoint.i, currPoint.j + 1));
      }

      // Top neighbour
      if (currPoint.i - 1 >= 0 && grid[currPoint.i - 1][currPoint.j] == '1') {
        islandPoints.add(new Point(currPoint.i - 1, currPoint.j));
      }

      // Bottom neighbour
      if (currPoint.i + 1 < grid.length && grid[currPoint.i + 1][currPoint.j] == '1') {
        islandPoints.add(new Point(currPoint.i + 1, currPoint.j));
      }

      grid[currPoint.i][currPoint.j] = '0';
      islandPoints.remove(currPoint);
    }
  }
}
