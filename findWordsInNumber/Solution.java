package com.surenderthakran.codes.findwordsinnumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {

  private static HashMap<String, String> numberToWordMap = new HashMap<>();

  static String[] findWordsInNumber(String phoneNumber, String[] words) {
    // Convert words to their numberString representation.
    String[] numberWords = new String[words.length];
    for (int i = 0; i < words.length; i++) {
      numberWords[i] = getNumberWord(words[i]);
    }

    // Create a Trie dictionary of numberString words.
    Trie dictionary = new Trie(numberWords);

    // Convert phoneNumber to char[] representation.
    char[] phoneNumberArray = phoneNumber.toCharArray();

    // Iterate over each index of the phoneNumber and try to find word starting at that index in the
    // Trie.
    HashSet<String> resultSet = new HashSet<>();
    for (int i = 0; i < phoneNumberArray.length; i++) {
      for (String word : dictionary.findWordsStartingWithIndex(phoneNumberArray, i)) {
        resultSet.add(word);
      }
    }

    // Convert numberWords back to words.
    String[] result = new String[resultSet.size()];
    int i = 0;
    for (String numberWord : resultSet) {
      result[i] = numberToWordMap.get(numberWord);
      i++;
    }

    return result;
  }

  // Converts a given word to it's numberWord representation.
  private static String getNumberWord(String word) {
    char[] map =
        new char[] {
          '2', '2', '2', '3', '3', '3', '4', '4', '4', '5', '5', '5', '6', '6', '6', '7', '7', '7',
          '7', '8', '8', '8', '9', '9', '9', '9',
        };

    char[] numberWord = new char[word.length()];
    for (int i = 0; i < word.length(); i++) {
      numberWord[i] = map[word.charAt(i) - 'a'];
    }

    // Store the conversion in a map for reverse conversion in future.
    numberToWordMap.put(new String(numberWord), word);

    return new String(numberWord);
  }
}
