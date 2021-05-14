package com.surenderthakran.coding.alphabetizelowercasechars;

import java.util.ArrayList;

/**
 * For a given string, alphabetize (sort alphabetically) lowercase characters. ex: "Google Mail"
 * should return "Gaegil Mloo"
 */
class Main {
  public static void main(String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      assert alphabetizeLowercaseChars("Google Mail").equals("Gaegil Mloo");

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Assertions not enabled! Results not verified!");
    }
  }

  static String alphabetizeLowercaseChars(String str) {
    // Read all lowercase characters from the string in a list.
    ArrayList<Character> lowercaseCharsList = new ArrayList<>();
    for (int i = 0; i < str.length(); i++) {
      int charValue = str.charAt(i);
      if (charValue >= 'a' && charValue <= 'z') {
        lowercaseCharsList.add(str.charAt(i));
      }
    }

    Character[] lowercaseChars = new Character[lowercaseCharsList.size()];
    lowercaseCharsList.toArray(lowercaseChars);

    quickSort(lowercaseChars);

    // Since Strings are immutable, we create a StringBuilder from the given String.
    StringBuilder strBuilder = new StringBuilder(str);

    // Counter on the lowercase characters' list.
    int j = 0;

    // Replace all lowercase characters in the StringBuilder with the characters from the sorted
    // list.
    for (int k = 0; k < strBuilder.length(); k++) {
      int charValue = strBuilder.charAt(k);
      if (charValue >= 'a' && charValue <= 'z') {
        strBuilder.setCharAt(k, lowercaseChars[j]);
        j++;
      }
    }

    return strBuilder.toString();
  }

  private static void quickSort(Character[] input) {
    quickSort(input, 0, input.length - 1);
  }

  private static void quickSort(Character[] input, int begin, int end) {
    // Return early if the sub-array to be sorted has less than 2 elements.
    if (begin >= end) {
      return;
    }

    // Choose the last element as the pivot element.
    int currentPivotIndex = end;
    // Task is to create/identify new position for the pivot index.
    int newPivotIndex = begin;

    // Iterate from beginning to one position before the end.
    for (int i = begin; i < end; i++) {
      // Make sure the element encountered is moved to left of the newPivotIndex if it is smaller or
      // equal to it.
      if (input[i] <= input[currentPivotIndex]) {
        swapValues(input, i, newPivotIndex);
        newPivotIndex++;
      }
    }
    // Move pivot element to its newly identified position.
    swapValues(input, newPivotIndex, currentPivotIndex);

    quickSort(input, begin, newPivotIndex - 1);
    quickSort(input, newPivotIndex + 1, end);
  }

  private static void swapValues(Character[] input, int first, int second) {
    Character tmp = input[first];
    input[first] = input[second];
    input[second] = tmp;
  }
}
