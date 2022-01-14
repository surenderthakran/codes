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
 *   <li>If not, slide the window forward by one index and repeate step 2.
 * </ol>
 *
 * Note: Go through the `WithoutMod` solution to better understand the current solution.
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
class SinglePatternSearchSolutionWithMod {

  private static final int CHARACTER_SET_SIZE = 26;
  private static final int MOD_DIVISOR = (int) 1e9 + 7;

  static boolean patternExistsInText(String pattern, String text) {
    // Create pattern's hash
    int patternHash = getRabinFingerprint(pattern, 0, pattern.length() - 1);

    // We need this multiple while rolling the window and calculating the new hash from the old
    // hash. This is the value by which the most significant char is multiplied while calculating a
    // string's hash with mod.
    int mostSignificantCharMultiple = 1;
    // Note: We iterate one less than the length of the pattern.
    for (int i = 1; i < pattern.length(); i++) {
      mostSignificantCharMultiple =
          Math.floorMod((mostSignificantCharMultiple * CHARACTER_SET_SIZE), MOD_DIVISOR);
    }

    // Slide a pattern sized window of substrings over text and check for match.
    int windowHash = 0;
    for (int i = 0; i <= text.length() - pattern.length(); i++) {
      // Create substring's hash.
      if (i == 0) {
        windowHash = getRabinFingerprint(text, 0, pattern.length() - 1);
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
        int hashOfNewChar = getIntValue(text.charAt(i + pattern.length() - 1));
        windowHash =
            Math.floorMod(
                ((windowHash - hashOfPreviousFirstChar) * CHARACTER_SET_SIZE) + hashOfNewChar,
                MOD_DIVISOR);
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

  private static boolean compareStrings(String pattern, String text, int start, int end) {
    for (int i = 0; i < pattern.length(); i++) {
      if (pattern.charAt(i) != text.charAt(start + i)) {
        return false;
      }
    }
    return true;
  }
}
