package com.surenderthakran.codes.hexadecimaladdition;

// O(n)
class Solution1 {
  static String hexadecimalAddition(String first, String second) {
    if (first.length() == 0 && second.length() == 0) {
      return "0";
    }
    if (first.length() == 0) {
      return second;
    }
    if (second.length() == 0) {
      return first;
    }

    String hexadecimals = "0123456789abcdef";

    first = first.toLowerCase();
    second = second.toLowerCase();

    int i = first.length() - 1;
    int j = second.length() - 1;

    int carry = 0;
    StringBuilder resultBuilder = new StringBuilder();

    while (i >= 0 || j >= 0) {
      int sum = carry;
      if (i >= 0) {
        sum += toDecimal(first.charAt(i));
      }
      if (j >= 0) {
        sum += toDecimal(second.charAt(j));
      }
      carry = 0;

      while (sum > 15) {
        sum -= 16;
        carry++;
      }
      resultBuilder.insert(0, hexadecimals.charAt(sum));

      i--;
      j--;
    }

    return resultBuilder.toString();
  }

  private static int toDecimal(char ch) {
    if (ch >= '0' && ch <= '9') {
      return ch - '0';
    } else {
      return (ch - 'a') + 10;
    }
  }
}
