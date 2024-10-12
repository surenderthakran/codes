package com.surenderthakran.codes.kmp;

/**
 * Given a string pattern, determine if it exists in another given string using the
 * Knuth-Morris-Pratt Algorithm.
 */
class Main {

    public static void main(String[] args) {
        boolean assertEnabled = false;
        assert assertEnabled = true;

        if (assertEnabled) {
            assert equal(KMP.generateLPSTable("abcdabcef"), new int[] {-1, 0, 0, 0, 0, 1, 2, 3, 0, 0});
            assert equal(KMP.generateLPSTable("aabaaba"), new int[] {-1, 0, 1, 0, 1, 2, 3, 4});

            assert KMP.patternExistsInText("abc", "bdabcce");
            assert KMP.patternExistsInText("abcdabcef", "bdabcdabcdabcefabd");
            assert KMP.patternExistsInText("aabaaba", "aabaababc");
            assert KMP.patternExistsInText("aab", "aaaab");

            assert !KMP.patternExistsInText("abd", "bdabcce");
            assert !KMP.patternExistsInText("aabaabb", "aabaababc");

            System.out.println("All Assertions Succeeded!");
        } else {
            System.out.println("Assertions not enabled! Results not verified!");
        }
    }

    private static boolean equal(int[] first, int[] second) {
        if (first == null && second == null) {
            return true;
        }

        if (first == null || second == null) {
            return false;
        }

        if (first.length != second.length) {
            return false;
        }

        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }

        return true;
    }
}
