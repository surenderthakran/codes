/**
 * Given two hexadecimal strings, return their sum in hexadecimal format.
 */

import java.util.ArrayList;
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
    StringBuilder oneBuilder = new StringBuilder(one.toLowerCase());
    StringBuilder twoBuilder = new StringBuilder(two.toLowerCase());
    StringBuilder result = new StringBuilder();

    char carry = '0';
    while (oneBuilder.length() > 0 || twoBuilder.length() > 0) {
      char first = '0';
      if (oneBuilder.length() > 0) {
        first = oneBuilder.charAt(oneBuilder.length() - 1);
        oneBuilder.deleteCharAt(oneBuilder.length() - 1);
      }

      char second = '0';
      if (twoBuilder.length() > 0) {
        second = twoBuilder.charAt(twoBuilder.length() - 1);
        twoBuilder.deleteCharAt(twoBuilder.length() - 1);
      }

      String sum = addHexaNumbers(carry, first, second);
      carry = sum.charAt(0);
      result.append(sum.charAt(1));
    }

    return result.toString();
  }

  private static String addHexaNumbers(char carry, char first, char second) {
    List<Character> hexadecimals = new ArrayList<>();
    hexadecimals.add('0');
    hexadecimals.add('1');
    hexadecimals.add('2');
    hexadecimals.add('3');
    hexadecimals.add('4');
    hexadecimals.add('5');
    hexadecimals.add('6');
    hexadecimals.add('7');
    hexadecimals.add('8');
    hexadecimals.add('9');
    hexadecimals.add('a');
    hexadecimals.add('b');
    hexadecimals.add('c');
    hexadecimals.add('d');
    hexadecimals.add('e');
    hexadecimals.add('f');
    return "00";
  }
}
