package com.surenderthakran.coding.findnumberofsmallstringpermutationsinlargestring;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {

  static String[] getSubstringPermutations(String large, String small) {
    if (small.isEmpty()) {
      return new String[] {};
    }

    HashMap<Character, Integer> smallStringCharacterFrequencyMap =
        getStringCharacterFrequencyMap(small);
    HashMap<Character, Integer> windowCharacterFrequencyMap = new HashMap<>();
    int numberOfMatchingCharacter = 0;
    ArrayList<String> matchingPermutations = new ArrayList<>();

    // Iterate over the large string in a sliding window of size = small string's length.
    for (int i = 0; i < large.length() - small.length() + 1; i++) {
      // End index of the current window.
      int j = i + small.length() - 1;
      System.out.println("window: " + i + " - " + j);

      if (i == 0) {
        // Populate the window frequency map for the first sliding window.

        // Iterate over every character of the current window.
        for (int k = i; k <= j; k++) {
          // Add/update current character in the window's frequency map.
          char currentChar = large.charAt(k);
          addOrUpdateCharacterToFrequencyMap(windowCharacterFrequencyMap, currentChar);

          // Update the matching character count after change in window's frequency map for the
          // above character's frequency.
          if (smallStringCharacterFrequencyMap.containsKey(currentChar)) {
            int frequencyInWindow = windowCharacterFrequencyMap.get(currentChar);
            int frequencyInSmallString = smallStringCharacterFrequencyMap.get(currentChar);
            if (frequencyInWindow == frequencyInSmallString) {
              numberOfMatchingCharacter++;
            } else if (frequencyInWindow == frequencyInSmallString + 1) {
              numberOfMatchingCharacter--;
            }
          }
        }
      } else {
        // Update the window frequency map for a window slide.

        // Add new character (the right-most) to the map.
        char newChar = large.charAt(j);
        addOrUpdateCharacterToFrequencyMap(windowCharacterFrequencyMap, newChar);

        // Update the matching character count after change in window's frequency map for the above
        // character's frequency.
        if (smallStringCharacterFrequencyMap.containsKey(newChar)) {
          int frequencyInWindow = windowCharacterFrequencyMap.get(newChar);
          int frequencyInSmallString = smallStringCharacterFrequencyMap.get(newChar);
          if (frequencyInWindow == frequencyInSmallString) {
            numberOfMatchingCharacter++;
          } else if (frequencyInWindow == frequencyInSmallString + 1) {
            numberOfMatchingCharacter--;
          }
        }

        // Remove old character (the one to the left of the window) from the map.
        char oldChar = large.charAt(i - 1);
        int currentFrequencyOfOldChar = windowCharacterFrequencyMap.get(oldChar);
        windowCharacterFrequencyMap.put(oldChar, currentFrequencyOfOldChar - 1);

        // Update the matching character count after change in window's frequency map for the above
        // character's frequency.
        if (smallStringCharacterFrequencyMap.containsKey(oldChar)) {
          int frequencyInWindow = windowCharacterFrequencyMap.get(oldChar);
          int frequencyInSmallString = smallStringCharacterFrequencyMap.get(oldChar);
          if (frequencyInWindow == frequencyInSmallString) {
            numberOfMatchingCharacter++;
          } else if (frequencyInWindow + 1 == frequencyInSmallString) {
            numberOfMatchingCharacter--;
          }
        }
      }

      System.out.println(numberOfMatchingCharacter);
      if (numberOfMatchingCharacter == smallStringCharacterFrequencyMap.keySet().size()) {
        matchingPermutations.add(large.substring(i, j + 1));
      }
    }

    System.out.println(matchingPermutations);
    return matchingPermutations.toArray(new String[matchingPermutations.size()]);
  }

  static HashMap<Character, Integer> getStringCharacterFrequencyMap(String str) {
    HashMap<Character, Integer> stringCharacterFrequency = new HashMap<>();
    for (char ch : str.toCharArray()) {
      if (stringCharacterFrequency.containsKey(ch)) {
        stringCharacterFrequency.put(ch, stringCharacterFrequency.get(ch) + 1);
      } else {
        stringCharacterFrequency.put(ch, 1);
      }
    }

    return stringCharacterFrequency;
  }

  static void addOrUpdateCharacterToFrequencyMap(
      HashMap<Character, Integer> frequencyMap, char ch) {
    if (frequencyMap.containsKey(ch)) {
      frequencyMap.put(ch, frequencyMap.get(ch) + 1);
    } else {
      frequencyMap.put(ch, 1);
    }
  }
}
