package com.surenderthakran.coding.comparekeypressarrays;

class Solution2 {

  static boolean areKeypressArraysEqual(char[] one, char[] two) {
    int i = one.length - 1;
    int j = two.length - 1;

    while (i >= 0 || j >= 0) {
      int onesBackspaceCount = 0;

      while (i >= 0 && (one[i] == '#' || onesBackspaceCount > 0)) {
        if (one[i] == '#') {
          onesBackspaceCount++;
        } else if (onesBackspaceCount > 0) {
          onesBackspaceCount--;
        }
        i--;
      }

      int twosBackspaceCount = 0;

      while (j >= 0 && (two[j] == '#' || twosBackspaceCount > 0)) {
        if (two[j] == '#') {
          twosBackspaceCount++;
        } else if (twosBackspaceCount > 0) {
          twosBackspaceCount--;
        }
        j--;
      }

      if (i == -1 && j == -1) {
        return true;
      }

      if ((i == -1 && j != -1) || (i != -1 && j == -1) || one[i] != two[j]) {
        return false;
      }

      i--;
      j--;
    }

    return i == -1 && j == -1;
  }
}
