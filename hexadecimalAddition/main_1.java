/**
 * Given two hexadecimal strings, return their sum in hexadecimal format.
 *
 * Method: Adding least significant numbers one by one.
 */

import java.util.Arrays;
import java.util.List;

class Main {

  private static final String HEXADECIMAL_CHARS = "0123456789abcdef";

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
    one = one.toLowerCase();
    two = two.toLowerCase();
    StringBuilder result = new StringBuilder();

    int onesLsbIndex = one.length() - 1;
    int twosLsbIndex = two.length() - 1;

    char carry = '0';
    while (onesLsbIndex >= 0 || twosLsbIndex >= 0) {
      // Fetch least significant number from first hexadecimal string.
      char first = '0';
      if (onesLsbIndex >= 0) {
        first = one.charAt(onesLsbIndex);
        onesLsbIndex--;
      }

      // Fetch least significant number for second hexadecimal string.
      char second = '0';
      if (twosLsbIndex >= 0) {
        second = two.charAt(twosLsbIndex);
        twosLsbIndex--;
      }

      String sum = addSingleDigitHexaNumbers(carry, first, second);

      // Update hexadecimal carry value.
      carry = sum.charAt(0);

      // Insert hexadecimal character at the beginning of the result string.
      result.insert(0, sum.charAt(1));
    }

    // If carry is available, insert it in the most significant position.
    if (carry != '0') {
      result.insert(0, carry);
    }

    return result.toString();
  }

  private static String addSingleDigitHexaNumbers(char carry, char first, char second) {
    // Calculate decimal sum of all three hexadecimal characters.
    int decimalSum =
        HEXADECIMAL_CHARS.indexOf(carry) + HEXADECIMAL_CHARS.indexOf(first)
        + HEXADECIMAL_CHARS.indexOf(second);

    // Initialize hexadecimal carry value to 0.
    // Note: We could have initialized it to character type '0' as well but since we know that the
    // sum of three single digit hexadecimal numbers will not need a carry value greater than '2',
    // we can to use integer type.
    int hexCarry = 0;

    while (decimalSum > 15) {
      decimalSum -= 16;
      hexCarry++;
    }

    return hexCarry + String.valueOf(HEXADECIMAL_CHARS.charAt(decimalSum));
  }
}
