package com.surenderthakran.codes.dutchNationalFlagSort;

import java.util.Arrays;

class Main {

  public static void main(String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      assert Arrays.equals(DNF.sort(new int[]{2, 1, 0, 1, 0, 0, 0, 1, 2, 1, 0, 2, 2, 1, 0}),
          new int[]{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2});

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Assertions not enabled! Results not verified!");
    }
  }
}