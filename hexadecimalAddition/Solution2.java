package com.surenderthakran.coding.hexadecimaladdition;

class Solution2 {
  private static final String HEXADECIMAL_CHARS = "0123456789abcdef";

  static String hexadecimalAddition(String first, String second) {
    first = first.toLowerCase();
    second = second.toLowerCase();

    return decimalToHexa(hexaToDecimal(first) + hexaToDecimal(second));
  }

  private static int hexaToDecimal(String str) {
    int i = str.length() - 1;
    int decimal = 0;
    while (i >= 0) {
      decimal += HEXADECIMAL_CHARS.indexOf(str.charAt(i)) * Math.pow(16, str.length() - 1 - i);
      i--;
    }

    return decimal;
  }

  private static String decimalToHexa(int decimal) {
    String hexadecimal = "";
    while (decimal > 0) {
      int remainder = decimal % 16;
      decimal /= 16;
      hexadecimal = HEXADECIMAL_CHARS.charAt(remainder) + hexadecimal;
    }
    return hexadecimal;
  }
}
