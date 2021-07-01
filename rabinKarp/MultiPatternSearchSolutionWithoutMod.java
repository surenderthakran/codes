package com.surenderthakran.coding.rabinkarp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * A variation of the SinglePatternSearchSolutionWithoutMod which is used to fetch a list of
 * patterns which exist in the given text out of a given list of patterns.
 *
 * <p>Assupmtions:
 *
 * <ul>
 *   <li>All patters are of equal length.
 * </ul>
 *
 * Time Complexity:
 *
 * <p>In worst case, every window substring's hash would be equal to hash of one of the given
 * pattern and we would be forced to test for string equality every time. In such a scenario the
 * time complexity would be: O(km + nk) = O(k(m + n)) where,<br>
 * k is number of given patterns,<br>
 * m is length of each pattern and<br>
 * n is length of the given text.
 *
 * <p>In average case, the hash of the window's substring would be equal to hash of one of the given
 * pattern only when those two strings are actually equal. So we would need to check for string
 * equality only when there is a real match. Hence the time complexity would be: O(km + n + lk),
 * where,<br>
 * l is the number of hash matches found.
 */
class MultiPatternSearchSolutionWithoutMod {

  private static final int CHARACTER_SET_SIZE = 26;

  static String[] patternsInText(String[] patterns, String text) {
    List<String> matchedPatterns = new ArrayList<>();

    // Create a set of hashs of all the given patterns.
    HashSet<Integer> patternHashs = getRabinFingerPrints(patterns);

    // We have assumed that all patterns are of equal length.
    int patternLength = patterns[0].length();

    // Iterate over the whole text with a sliding window of length equal to the length of the
    // patterns.
    int windowHash = 0;
    for (int i = 0; i < text.length() - patternLength; i++) {
      // Find the hash of the substring currently in the window.
      if (i == 0) {
        windowHash = getRabinFingerPrint(text, 0, patternLength - 1);
      } else {
        int hashOfPreviousFirstChar =
            (int)
                (getIntValue(text.charAt(i - 1)) * Math.pow(CHARACTER_SET_SIZE, patternLength - 1));
        int hashOfNewChar = getIntValue(text.charAt(i + patternLength - 1));
        windowHash = (windowHash - hashOfPreviousFirstChar) * CHARACTER_SET_SIZE + (hashOfNewChar);
      }

      // If the calculated hash of the window's substring exists in the set of patterns, determine
      // if the two texts are actually equal.
      if (patternHashs.contains(windowHash)) {
        String windowString = text.substring(i, i + patternLength);
        if (containsString(patterns, windowString)) {
          matchedPatterns.add(windowString);
        }
      }
    }

    return matchedPatterns.toArray(new String[0]);
  }

  private static HashSet<Integer> getRabinFingerPrints(String[] patterns) {
    HashSet<Integer> patternHashs = new HashSet<>();

    for (String pattern : patterns) {
      patternHashs.add(getRabinFingerPrint(pattern, 0, pattern.length() - 1));
    }

    return patternHashs;
  }

  /** hash[a,b,c] = intVal(a).p^2 + intVal(b).p^1 + intVal(c).p^0 p = size of characterset */
  private static int getRabinFingerPrint(String text, int start, int end) {
    int hash = 0;
    for (int i = start; i <= end; i++) {
      hash += (int) (getIntValue(text.charAt(i)) * Math.pow(CHARACTER_SET_SIZE, end - start - i));
    }
    return hash;
  }

  private static int getIntValue(char ch) {
    return ch - 'a' + 1;
  }

  private static boolean containsString(String[] patterns, String text) {
    for (String pattern : patterns) {
      if (pattern.equals(text)) {
        return true;
      }
    }
    return false;
  }
}
