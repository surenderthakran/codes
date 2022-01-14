package com.surenderthakran.codes.hexadecimaladdition;

/** Given two hexadecimal strings, return their sum as string in hexadecimal format. */
class Main {
  public static void main(String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      assert Solution1.hexadecimalAddition("4a6", "1B3").equals("659");
      assert Solution1.hexadecimalAddition("4a6", "B3").equals("559");

      assert Solution2.hexadecimalAddition("4a6", "1B3").equals("659");
      assert Solution2.hexadecimalAddition("4a6", "B3").equals("559");

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }
}
