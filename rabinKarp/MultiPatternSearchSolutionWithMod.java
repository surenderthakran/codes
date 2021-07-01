package com.surenderthakran.coding.rabinkarp;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * A variation of the SinglePatternSearchSolutionWithMod which is used to fetch a list of patterns
 * which exist in the given text out of a given list of patterns.
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
final class MultiPatternSearchSolutionWithMod {

  private static final int CHARACTER_SET_SIZE = 26;
  private static final int MOD_DIVISOR = (int) 1e9 + 7;

  static String[] patternsInText(String[] patterns, String text) {
    ArrayList<String> matchedPatterns = new ArrayList<>();

    // Create a set of hashs of all the given patterns.
    HashSet<Integer> patternHashs = getRabinFingerprints(patterns);

    // We have assumed that all patterns are of equal length.
    int patternLength = patterns[0].length();

    // We need this multiple while rolling the window and calculating the new hash from the old
    // hash. This is the value by which the most significant char is multiplied while calculating a
    // string's hash with mod.
    int mostSignificantCharMultiple = 1;
    // Note: We iterate one less than the length of the pattern.
    for (int i = 1; i < patternLength; i++) {
      mostSignificantCharMultiple =
          Math.floorMod((mostSignificantCharMultiple * CHARACTER_SET_SIZE), MOD_DIVISOR);
    }

    // Iterate over the whole text with a sliding window of length equal to the length of the
    // patterns.
    int windowHash = 0;
    for (int i = 0; i < text.length() - patternLength; i++) {
      // Find the hash of the substring currently in the window.
      if (i == 0) {
        windowHash = getRabinFingerprint(text, 0, patternLength - 1);
      } else {
        // The rolling hash can be netter explained with an example.
        // Note: Below we have a simplified example with the mod. Using mod makes it slightly more
        // complicated but the idea remians the same.
        // hash[a,b,c] = 'a'.p^2 + 'b'.p^1 + 'c'.p^0
        // hash[b,c,d] = ((hash[a,b,c] - 'a'.p^2) * p) + 'd'.p^0
        // where, p is the size of the characterset.
        // With modding, the hash rolling equation changes a little but the idea remains the same.
        // hash[b,c,d] = ((hash[a,b,c] - 'a'.<max modded power of p>) * p + 'd'.p^0) % q
        // where, q is the mod divisor.
        int hashOfPreviousFirstChar = getIntValue(text.charAt(i - 1)) * mostSignificantCharMultiple;
        int hashOfNewChar = getIntValue(text.charAt(i + patternLength - 1));
        windowHash =
            Math.floorMod(
                ((windowHash - hashOfPreviousFirstChar) * CHARACTER_SET_SIZE) + hashOfNewChar,
                MOD_DIVISOR);
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

  private static HashSet<Integer> getRabinFingerprints(String[] patterns) {
    HashSet<Integer> patternHashs = new HashSet<>();

    for (String pattern : patterns) {
      patternHashs.add(getRabinFingerprint(pattern, 0, pattern.length() - 1));
    }

    return patternHashs;
  }

  /**
   * Returns the hash of the substring of the given text between the given bounds.
   *
   * <p>For a non-modded case, the following would be the hash of a string 'abc':<br>
   * hash[a,b,c] = 'a'.p^2 + 'b'.p^1 + 'c'.p^0 where, p is the size of the characterset.
   *
   * <p>But the above could very easily exceed the integer limit in Java. To work around that
   * problem, we mod every intermediate hash and use that to calculate the next iteration's hash.
   *
   * <p>hash = (hash.p + 'new char') % q<br>
   * where, q is the mod divisor.
   *
   * <p>The 'mod divisor' is suggested to be as large a prime number as possible to avoid hash
   * collisions as much as possible.
   */
  private static int getRabinFingerprint(String text, int start, int end) {
    int hash = 0;
    for (int i = start; i <= end; i++) {
      hash = Math.floorMod((hash * CHARACTER_SET_SIZE) + getIntValue(text.charAt(i)), MOD_DIVISOR);
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
