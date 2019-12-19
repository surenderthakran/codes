/**
 * Given a set of characters, rearrange them so that same character does not occurs in a given
 * window n.
 * Note: A set can have multiple such rearrangements.
 *
 * ex: Set {a,a,a,b,b,c} and window = 2 can give: [a,b,a,b,a,c]
 * ex: Set {a,a,a,a,b,b,b,c,c,4} and window = 3 can give: [a,b,c,a,b,c,a,b,4,a]
 * ex: Set {a,a,a,a,b,b,b,c,c} and window = 2 can give: [a,b,a,c,b,a,c,b,a]
 * ex: Set {g,e,e,k,s,f,o,r,g,e,e,k,s} and window = 3 can give: [e,g,k,e,s,g,e,k,s,e,f,o,r]
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {
  public static void main(String[] args) {
    System.out.println(separateCharactersByWindow(new char[]{'a', 'a', 'a', 'b', 'b', 'c'}, 2));
  }

  static Character[] separateCharactersByWindow(char[] inputs, int window) {
    List<Character> response = new ArrayList<>();

    // create map with character frequency.
    Map<Character, Integer> frequencyMap = new HashMap<>();
    for (char c : inputs) {
      if (frequencyMap.containsKey(c)) {
        frequencyMap.put(c, frequencyMap.get(c) + 1);
        continue;
      }
      frequencyMap.put(c, 1);
    }

    for (char c : inputs) {
      //decide eligible chars
      //pick one with highest frequency
      //add to response.
    }

    return response.stream().toArray(Character[]::new);
  }
}
