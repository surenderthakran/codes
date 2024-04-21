package com.surenderthakran.codes.rabinkarp;

/**
 * The single pattern search works broadly as follows:
 *
 * <ol>
 *   <li>Calculate the hash of the pattern
 *   <li>Calculate the hash of the pattern-lengthed window in the given text.
 *   <li>If the pattern's hash and hash of the text in the window match, check if the strings also
 *       match.
 *   <li>If the string's match, return true.
 *   <li>If not, slide the window forward by one index and repeat step 2.
 * </ol>
 * <p>
 * hash[a,b,c] = 'a'.p^2 + 'b'.p^1 + 'c'.p^0<br>
 * where, p = size of the character set
 *
 * <p>To calculate the hash of a window ("bcd") from the hash of the previous window ("abc"):<br>
 * hash[b,c,d] = (hash[a,b,c] - 'a'.p^2) * p + 'd'.p^0
 *
 * <p>Time Complexity:
 *
 * <p>Worst case is when we always see a hash collision between pattern and window's text<br>
 * i.e. the hashes match but the strings are not equal.<br>
 * Time complexity in worst case would be O(nm)<br>
 * where, n is the length of the text and m is length of the pattern.
 *
 * <p>Average case is when we have little to no hash collisions.<br>
 * Time complexity in average case would be O(m + n + m) = O(2m + n) = O(m + n).
 */
class SinglePatternSearchSolutionWithoutMod {

  private static final int CHARACTER_SET_SIZE = 26;

  static boolean patternExistsInText(String pattern, String text) {
    // Create pattern's hash
    int patternHash = getRabinFingerprint(pattern, 0, pattern.length() - 1);

    // Slide a pattern sized window of substrings over text and check for match.
    int windowHash = 0;
    for (int i = 0; i <= text.length() - pattern.length(); i++) {
      // Create substring's hash.
      if (i == 0) {
        windowHash = getRabinFingerprint(text, 0, pattern.length() - 1);
      } else {
        int hashOfPreviousFirstChar =
            (int)
                (getIntValue(text.charAt(i - 1))
                    * Math.pow(CHARACTER_SET_SIZE, pattern.length() - 1));
        int hashOfNewChar = getIntValue(text.charAt(i + pattern.length() - 1));
        windowHash = (windowHash - hashOfPreviousFirstChar) * CHARACTER_SET_SIZE + (hashOfNewChar);
      }

      // If substring's hash matches with pattern's hash, confirm string match through iteration.
      if (patternHash == windowHash) {
        boolean stringsMatch = compareStrings(pattern, text, i, pattern.length() - 1);
        if (stringsMatch) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * hash[a,b,c] = intVal(a).p^2 + intVal(b).p^1 + intVal(c).p^0 p = size of character set.
   */
  private static int getRabinFingerprint(String text, int start, int end) {
    int hash = 0;
    for (int i = start; i <= end; i++) {
      hash += (int) (getIntValue(text.charAt(i)) * Math.pow(CHARACTER_SET_SIZE, end - start - i));
    }

    return hash;
  }

  /**
   * Returns 1 for 'a', 2 for 'b' and so on.
   */
  private static int getIntValue(char ch) {
    return ch - 'a' + 1;
  }

  /**
   * Time complexity: O(m) where m is length of the pattern.
   */
  private static boolean compareStrings(String pattern, String text, int start, int end) {
    for (int i = 0; i < pattern.length(); i++) {
      if (pattern.charAt(i) != text.charAt(start + i)) {
        return false;
      }
    }
    return true;
  }
}
