package com.surenderthakran.codes.trie;

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

    List<String> words = new ArrayList<>();
    words.add("abc");
    words.add("abd");
    words.add("abcd");
    words.add("babc");
    words.add("");
    words.add("bbc");
    words.add("bcda");
    words.add("cabd");

    trie.insert(words);

    assert trie.contains("abcd");
    assert !trie.contains("bbcd");

    assert trie.containsRecursively("abcd");
    assert !trie.containsRecursively("bbcd");

    assert trie.deleteIteratively("abcd");
    assert !trie.contains("abcd");

    trie.deleteRecursively("babc");
    assert !trie.contains("babc");
  }
}
