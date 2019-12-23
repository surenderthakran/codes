/**
 * Given a set of characters, rearrange them so that same character does not occurs in a given
 * window n.
 * Note: A set can have multiple such rearrangements.
 *
 * ex: Set {a,a,a,b,b,c} and window = 2 can give: [a,b,a,b,a,c]
 * ex: Set {a,a,a,a,b,b,b,c,c,d} and window = 3 can give: [a,b,c,a,b,c,a,b,d,a]
 * ex: Set {a,a,a,a,b,b,b,c,c} and window = 2 can give: [a,b,a,c,b,a,c,b,a]
 * ex: Set {g,e,e,k,s,f,o,r,g,e,e,k,s} and window = 3 can give: [e,g,k,e,s,g,e,k,s,e,f,o,r]
 *
 * Also, for impossible solutions, it should return an empty array.
 * ex: Set {a,a,a} and window = 2
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Main {
  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(separateCharactersByWindow(new char[]{'a', 'a', 'a', 'b', 'b', 'c'}, 2)));

    System.out.println(
        Arrays.toString(separateCharactersByWindow(
            new char[]{'a', 'a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'd'}, 3)));

    System.out.println(
        Arrays.toString(separateCharactersByWindow(
            new char[]{'a', 'a', 'a', 'a', 'b', 'b', 'b', 'c', 'c'}, 2)));

    System.out.println(
        Arrays.toString(separateCharactersByWindow(
            new char[]{'g', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'g', 'e', 'e', 'k', 's'}, 3)));

    System.out.println(
        Arrays.toString(separateCharactersByWindow(
            new char[]{'a', 'a', 'a'}, 2)));
  }

  static Character[] separateCharactersByWindow(char[] inputs, int window) {
    List<Character> response = new ArrayList<>();

    // Create map with character frequency.
    Map<Character, Integer> frequencyMap = new HashMap<>();
    for (char c : inputs) {
      if (frequencyMap.containsKey(c)) {
        frequencyMap.put(c, frequencyMap.get(c) + 1);
        continue;
      }
      frequencyMap.put(c, 1);
    }

    List<Character> charactersAlreadyInCurrentWindow = new ArrayList<>();

    // For each position in the response list.
    for (int i = 0; i < inputs.length; i++) {
      // Identify characters already in the current window.
      charactersAlreadyInCurrentWindow.clear();
      for (int j = i - 1; j >= i - (window - 1); j--) {
        if (j < 0) {
          break;
        }
        charactersAlreadyInCurrentWindow.add(response.get(j));
      }

      // Pick a character with highest frequency which is not in current window.
      Character highestFrequencyCharacter = new Character('\0');
      int currentHighestFrequency = 0;
      for (Entry<Character, Integer> entry : frequencyMap.entrySet()){
        if (!charactersAlreadyInCurrentWindow.contains(entry.getKey())
            && entry.getValue() > currentHighestFrequency) {
          currentHighestFrequency = entry.getValue();
          highestFrequencyCharacter = entry.getKey();
        }
      }

      // If no character is found, return empty Character array.
      if (highestFrequencyCharacter == '\0') {
        return new Character[0];
      }

      // Add selected character to response.
      response.add(highestFrequencyCharacter);

      // Update frequency map to reduce frequency of the selected character by 1.
      frequencyMap.put(highestFrequencyCharacter, currentHighestFrequency - 1);
    }

    // Convert List<Character> to Character[] and return.
    return response.stream().toArray(Character[]::new);
  }
}
