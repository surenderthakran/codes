package com.surenderthakran.codes.segmentstringintodictionarywords;

class Solution {

  private TrieNode root;

  Solution() {
    this.root = new TrieNode('\0');
  }

  boolean canInputBeSegmentedInDictionaryWords(String input, String[] words) {
    // Add words to Trie dictionary
    this.populateDictionary(words);

    // Search words in dictionary from input starting  with given index.
    return this.canFormWordsStartingWithIndex(input.toCharArray(), 0);
  }

  /**
   * Search words in the Trie dictionary frm the given input starting with the given index. Returns
   * false if a full word is not found at the end of the input. Also, recursively calls itself if
   * more than one possible words set can be made from the input.
   *
   * @param input
   * @param index
   * @return
   */
  private boolean canFormWordsStartingWithIndex(char[] input, int index) {
    TrieNode currentNode = this.root;
    for (int i = index; i < input.length; i++) {
      if (currentNode.hasChild(input[i])) {
        TrieNode child = currentNode.getChild(input[i]);

        // If child creates a full word and no more characters are left in input.
        if (child.isLast() && i == input.length - 1) {
          return true;
        }

        // If child creates a full word but input has more characters left, try to find full words
        // from the remaining input characters after ending a word segment here itself.
        if (child.isLast() && i < input.length - 1) {
          if (this.canFormWordsStartingWithIndex(input, i + 1)) {
            // Look no further in the current method if the recursive method has returned true i.e.
            // the recursive method has been able to create full words from all of the remaining
            // input characters.;
            return true;
          }
        }

        // If child does not creates a full word and no more characters are left in input. This
        // means that the current method was unable to segment the input in such a way as to create
        // full words from the input characters.
        if (!child.isLast() && i == input.length - 1) {
          return false;
        }

        // If child does not creates a full word but input has more characters left, continue moving
        // down the Trie.
        currentNode = child;
      }
    }

    return false;
  }

  private void populateDictionary(String[] words) {
    for (String word : words) {
      if (word.length() == 0) {
        continue;
      }

      TrieNode currentNode = this.root;
      for (char ch : word.toCharArray()) {
        if (currentNode.hasChild(ch)) {
          currentNode = currentNode.getChild(ch);
          continue;
        }

        TrieNode child = new TrieNode(ch);
        currentNode.addChild(child);
        currentNode = child;
      }

      currentNode.setLast(true);
    }
  }

  private class TrieNode {

    private char value;
    private boolean isLast;
    private TrieNode[] children;

    TrieNode(char value) {
      this.value = value;
      this.isLast = false;
      this.children = new TrieNode[26]; // 26 because english alphabet has 26 characters.
    }

    boolean hasChild(char ch) {
      return this.children[ch - 'a'] != null ? true : false;
    }

    TrieNode getChild(char ch) {
      return this.children[ch - 'a'];
    }

    boolean isLast() {
      return this.isLast;
    }

    void setLast(boolean isLast) {
      this.isLast = isLast;
    }

    void addChild(TrieNode child) {
      this.children[child.value - 'a'] = child;
    }
  }
}
