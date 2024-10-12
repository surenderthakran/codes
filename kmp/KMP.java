package com.surenderthakran.codes.kmp;

/**
 * Knuth-Morris-Pratt Algorithm is an optimization over the naive approach for
 * searching a smaller string pattern W in a largest text T.
 * Unlike the naive approach where while matching characters of W in T and
 * encountering a mismatch we start matching W from the beginning, KMP attempts
 * to resume character matching from a later position in W.
 *
 * For a given W "abcdabcef", we can see that substring "abc" at the beginning
 * of W also occurs inside it. Hence, if while character matching we encounter
 * a mismatch after "abcdabc", instead of resuming matching from index 0 we can
 * resume from index 3 because "abc" is already matched. Another way of looking
 * at it is that while having a positive match with "abcdabc", we are also
 * having a positive match with the prefix "abc" of W. So when a mismatch happens
 * we can fall back to assuming that the current positive match is for prefix "abc"
 * and resume character matching after "abc".
 *
 * KMP does this by pre-processing W to identify substrings inside W which are
 * same as a substring in the beginning of W and marking the index positions
 * we should fall back to if a mismatch occurs at a certain index.
 * The result of this pre-processing is
 * LPS (Longest Proper Prefix that is also a Proper Suffix) table.
 *
 * The LPS table is a 0-indexed table but the characters start from index 1.
 * For the above example the LPS table looks like:
 * Indices:   0 1 2 3 4 5 6 7 8 9
 * W:           a b c d a b c e f
 * LPS vals: -1 0 0 0 0 1 2 3 0 0
 * The LPS value in the above table indicates that if a mismatch occurs at
 * index 7, we should resume character matching from index 3 in W.
 *
 * Another way of looking at it is that at any index i, what length of proper prefix
 * of W[0..i] is same as proper suffix of W[0..i].
 * Proper prefixes or suffixes of a string are all prefixes and suffixes except
 * for the string itself. For example, all prefixes of "abc" are
 * "", "a", "ab", "abc"
 * whereas proper prefixes are
 * "", "a", "ab".
 *
 * Using the above example W with the example T = "bdabcdabcdabcefabd",
 * we begin matching from index 0 in T with index 0 in W.
 *    _
 * T: b d a b c d a b c d a b c e f a b d
 * W: a b c d a b c e f
 *    -
 * The first characters itself do not match i.e. T[0] != W[0] so we slide
 * W by 1.
 *      _
 * T: b d a b c d a b c d a b c e f a b d
 * W:   a b c d a b c e f
 *      -
 * Again T[1] != W[0] so we slide again.
 *        _ _ _ _ _ _ _ _
 * T: b d a b c d a b c d a b c e f a b d
 * W:     a b c d a b c e f
 *        - - - - - - - -
 * This time the characters start matching until T[9] != W[7], however
 * this time instead of sliding W by 1 and starting matching from
 * T[4] and W[0], we refer to the LPS table for value of index 7 which is 3.
 * We slide W and starting matching from T[9] and W[3].
 *                      -
 * T: b d a b c d a b c d a b c e f a b d
 * W:             a b c d a b c e f
 *                      -
 * This time we see all characters in W matching in T and conclude that
 * W exists in T.
 *
 * TC: O(m + n)
 * SC: O(m)
 * where n is the length of the larger string and
 * m is the length of the smaller string
 *
 * Ref: https://www.baeldung.com/cs/knuth-morris-pratt
 */
class KMP {

    /**
     * While pattern matching after generating the LPS table, we iterate over
     * the larger string only once even though we might be visiting same
     * indices of the smaller string again and again but for each element
     * of the larger string we only perform constant time operations.
     *
     * TC: O(m + n)
     * SC: O(m)
     * where n is the length of the larger string and
     * m is the length of the smaller string
     */
    static boolean patternExistsInText(String pattern, String text) {
        int[] lps = generateLPSTable(pattern);

        int i = 0;
        int j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    return true;
                }

                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = lps[j];
            }
        }

        return false;
    }

    /**
     * While creating LPS for a string we only iterate over the string once
     * from beginning to end.
     * In the inner loop we might be moving value of j back to 0 but the i
     * only moves forward.
     *
     * TC: O(m)
     * SC: O(m)
     * where m is the length of the pattern.
     */
    static int[] generateLPSTable(String pattern) {
        int[] lps = new int[pattern.length() + 1];
        lps[0] = -1;
        lps[1] = 0;

        int i = 1;
        int j = 0;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i + 1] = j + 1;
                i++;
                j++;
            } else if (j == 0) {
                lps[i + 1] = 0;
                i++;
            } else {
                j = 0;
            }
        }

        return lps;
    }
}
