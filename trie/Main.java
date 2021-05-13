package com.surenderthakran.coding.trie;

import java.util.ArrayList;
import java.util.List;

class Main {
  public static void main(String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      testTrie();

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }

  static void testTrie() {
    Trie trie = new Trie();

    ArrayList<String> words = new ArrayList<>();
    words.add("abc");
    words.add("abd");
    words.add("abcd");
    words.add("babc");
    words.add("");
    words.add("bbc");
    words.add("bcda");
    words.add("cabd");

    trie.insert(words);

    assert trie.contains("abcd") == true;
    assert trie.contains("bbcd") == false;

    trie.delete("abcd");

    assert trie.contains("abcd") == false;
  }
}
