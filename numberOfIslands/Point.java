package com.surenderthakran.coding.numberofislands;

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
