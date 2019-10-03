/**
 * Given two hexadecimal strings, return their sum in hexadecimal format.
 */

import java.util.Arrays;
import java.util.List;

class Main {
  public static void main(String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      assert hexadecimalAddition("4a6", "1B3").equals("659");
      assert hexadecimalAddition("4a6", "B3").equals("559");

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }

  private static String hexadecimalAddition(String one, String two) {
    return decimalToHexadecimal(hexadecimalToDecimal(one) + hexadecimalToDecimal(two));
  }

  private static int hexadecimalToDecimal(String hex) {
    hex = hex.toLowerCase();
  }

  private static String decimalToHexadecimal(int decimal) {}
}
