/**
 * Given two hexadecimal strings, return their sum in hexadecimal format.
 */

import java.util.Arrays;
import java.util.List;

class Main {

  private static final List<Character> hexadecimals =
      Arrays.asList(
          new Character[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'});

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
    StringBuilder oneBuilder = new StringBuilder(one.toLowerCase());
    StringBuilder twoBuilder = new StringBuilder(two.toLowerCase());
    StringBuilder result = new StringBuilder();

    char carry = '0';
    while (oneBuilder.length() > 0 || twoBuilder.length() > 0) {
      // Fetch least significant number from first hexadecimal string.
      char first = '0';
      if (oneBuilder.length() > 0) {
        first = oneBuilder.charAt(oneBuilder.length() - 1);
        oneBuilder.deleteCharAt(oneBuilder.length() - 1);
      }

      // Fetch least significant number for second hexadecimal string.
      char second = '0';
      if (twoBuilder.length() > 0) {
        second = twoBuilder.charAt(twoBuilder.length() - 1);
        twoBuilder.deleteCharAt(twoBuilder.length() - 1);
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
        hexadecimals.indexOf(carry) + hexadecimals.indexOf(first) + hexadecimals.indexOf(second);

    // Initialize hexadecimal carry value to 0.
    // Note: We could have initialized it to character type '0' as well but since we know that the
    // sum of three single digit hexadecimal numbers will not need a carry value greater than '2',
    // we can to use integer type.
    int hexCarry = 0;

    while (decimalSum > 15) {
      decimalSum -= 16;
      hexCarry++;
    }

    return hexCarry + hexadecimals.get(decimalSum).toString();
  }
}
