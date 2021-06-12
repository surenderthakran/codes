package com.surenderthakran.coding.comparekeypressarrays;

class Solution1 {

  static boolean areKeypressArraysEqual(char[] one, char[] two) {
    return getPrintableString(one).equals(getPrintableString(two));
  }

  private static String getPrintableString(char[] keypresses) {
    StringBuilder stringBuilder = new StringBuilder();

    // Appending and deleting characters from StringBuilder takes constant time `O(n)`.
    for (char key : keypresses) {
      if (key == '#') {
        if (stringBuilder.length() > 0) {
          stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
      } else {
        stringBuilder.append(key);
      }
    }

    return stringBuilder.toString();
  }
}
