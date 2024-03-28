package com.surenderthakran.codes.minimumAdjacentSwapsToMakePalindrome;

// https://molchevskyi.medium.com/best-solutions-for-microsoft-interview-tasks-min-swaps-to-make-palindrome-e931689f8cae

/*
 * Given a string, return the count of minimum adjacent swaps required to make it a palindrome
 * else return -1 if it is not possible for the string to be made into a palindrome.
 *
 * In the solution we first check the frequencies of the characters in the string to determine if it
 * is even possible to convert the string into a palindrome.
 * After that we start comparing characters at both ends by keeping one pointer each at both ends.
 * 1. If characters at both ends are equal we move both the pointers one step inwards.
 * 2. If characters at both end are not equal, we attempt to find the index of character between the
 *    two pointers which is equal to the one at start pointer.
 * 2a. If such an index is found, we move it to the end using swaps and count the number of swap
 *     operations.
 * 2b. If no such index is found, then it means that the character at the start itself isnot in its
 *     correct position. Hence, we move the character one step inwards. Only one step because we do
 *     not yet know it's correct position.
 * 3. Move both pointers inwards and move back to step 1. if start pointer is less than end pointer.
 */

import java.util.HashMap;
import java.util.Map;

class Main {

  public static void main(String[] args) {
    boolean assertsEnabled = false;
    assert assertsEnabled = true;

    if (assertsEnabled) {
      assert getAdjacentSwapsToMakePalindrome("abcabc") == 3;
      assert getAdjacentSwapsToMakePalindrome("mamad") == 3;
      assert getAdjacentSwapsToMakePalindrome("asflkj") == -1;
      assert getAdjacentSwapsToMakePalindrome("aabb") == 2;
      assert getAdjacentSwapsToMakePalindrome("ntiin") == 1;

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Assertions not enabled! Results not verified!");
    }
  }

  /**
   * Time complexity; O(n^2)
   * Space complexity: O(n)
   */
  private static int getAdjacentSwapsToMakePalindrome(String str) {
    if (str.length() < 2) {
      return 0;
    }

    // check if the input string has characters in the appropriate frequency to be a palindrome.
    if (!isShuffledPalindrome(str)) {
      return -1;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    char[] chars = str.toCharArray();

    int swapCount = 0;

    // start matching the input string's characters from both ends.
    int start = 0;
    int end = chars.length - 1;

    // This loops n/2 times. And each time it traverses n-2, n-4, n-6 ... 1 characters.
    // Hence, total cost of this loop is (n-2) + (n-4) + ... + 1 = n(n-1)/4
    // Time complexity: O(n(n-1)/4) => O(n^2)
    // Space complexity: O(1) since no extra space is used.
    while (start < end) {

      // If characters at the both pointers are same than do nothing and move pointers inwards.
      if (chars[start] == chars[end]) {
        start++;
        end--;
        continue;
      }

      // If the characters at both end are not same than find the character between the pointers
      // which is equal to the character at the start pointer.
      int current = end - 1;
      while (current > start) {
        // If character at current is equal to character at start than exit the loop.
        if (chars[current] == chars[start]) {
          break;
        }
        current--;
      }

      // If current reached start but no character equal to the character at start other than the
      // one at start was found than it means that the character at start itself if not in its
      // correct position and needs to be swapped inwards.
      if (current == start) {
        swap(chars, start, start + 1);
        swapCount++;
        continue;
      }

      // If a character equal to the one at start is found between the two pointers, move it to the
      // end pointer using swaps and increment the swap counter by one after each swap.
      while (current < end) {
        swap(chars, current, current + 1);
        current++;
        swapCount++;
      }
    }

    return swapCount;
  }

  /**
   * Time complexity: O(1)
   * Space complexity: O(1)
   */
  private static void swap(char[] chars, int first, int second) {
    char tmp = chars[first];
    chars[first] = chars[second];
    chars[second] = tmp;
  }

  /**
   * Time complexity: O(n)
   * Space complexity: O(n)
   */
  private static boolean isShuffledPalindrome(String str) {
    // Create frequency map of characters.
    Map<Character, Integer> freqMap = new HashMap<>();
    for (char ch : str.toCharArray()) {
      freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
    }

    // Count number of characters with odd frequency.
    int oddFreq = 0;
    for (int freq : freqMap.values()) {
      if (freq % 2 != 0) {
        oddFreq++;
      }
    }

    // For input string with even length, the number of characters with odd frequencies can be 0, 2, 4, etc.
    // Having a string with 0 characters with odd frequency is a valid palindrome, anything else is not a valid palindrome.
    // For input string with odd length, the number of characters with odd frequencies can be 1, 3, 5, etc.
    // Having a string with 1 character with odd frequency is a valid palindrome, anything else is not a valid palindrome.
    // Hence, for both even and odd length strings, having < 2 characters with odd frequencies is a valid palindrome.
    return oddFreq <= 1;
  }
}
