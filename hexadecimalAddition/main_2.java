/**
 * Given two hexadecimal strings, return their sum in hexadecimal format.
 */

import java.lang.Math;
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
    hex = hex.toUpperCase();
    int decimal = 0;
    for (int i = 0; i < hex.length(); i++) {
      char c = hex.charAt(hex.length() - 1 - i);
      int charValue = (int) c;
      if (charValue >= 65 && charValue <= 90) {
        charValue = charValue - 55;
      } else {
        charValue = Integer.parseInt(String.valueOf(c));
      }
      decimal += charValue * Math.pow(16, i);
    }
    return decimal;
  }

  private static String decimalToHexadecimal(int decimal) {
    return "00";
  }
}
