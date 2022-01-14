package com.surenderthakran.codes.findwordsinnumber;

import java.util.ArrayList;
import java.util.Arrays;

class Trie {
  private Node root;

  Trie(String[] words) {
    this.root = new Node();
    for (String word : words) {
      this.addWord(word);
    }
  }

  void addWord(String word) {
    Node currentNode = this.root;
    for (char ch : word.toCharArray()) {
      if (currentNode.hasChild(ch)) {
        currentNode = currentNode.getChild(ch);
        continue;
      }
      Node newChild = new Node(ch);
      currentNode.addChild(newChild);
      currentNode = newChild;
    }
    currentNode.setLast(true);
  }

  /**
   * Returns array of full words that exist in the Trie dictionary which started with the character
   * at the given index in the given char[].
   *
   * @param phoneNumber
   * @param index
   * @return
   */
  String[] findWordsStartingWithIndex(char[] phoneNumber, int index) {
    ArrayList<String> resultList = new ArrayList<>();
    Node currentNode = this.root;
    for (int i = index; i < phoneNumber.length; i++) {
      if (currentNode.hasChild(phoneNumber[i])) {
        currentNode = currentNode.getChild(phoneNumber[i]);
        if (currentNode.isLast()) {
          resultList.add(new String(currentNode.getPrefix()));
        }
        continue;
      }
      break;
    }

    String[] result = new String[resultList.size()];
    return resultList.toArray(result);
  }

  private class Node {
    private char value;
    private char[] prefix; // To easily determine the path each Node followed from root.
    private Node[] children;
    private boolean isLast;

    Node() {
      this('\0'); // '\0' is null character.
    }

    Node(char value) {
      this.value = value;
      this.prefix = new char[] {};

      // 10 because for the current problem there are only 10 possible children of every Node i.e.
      // 0, 1, 2, ...., 9.
      this.children = new Node[10];

      this.isLast = false;
    }

    private boolean hasChild(char value) {
      return this.children[value - '0'] != null;
    }

    private Node getChild(char value) {
      return this.children[value - '0'];
    }

    private void addChild(Node child) {
      char[] childPrefix = Arrays.copyOf(this.prefix, this.prefix.length + 1);
      childPrefix[childPrefix.length - 1] = child.getValue();
      child.setPrefix(childPrefix);
      this.children[child.getValue() - '0'] = child;
    }

    private char getValue() {
      return this.value;
    }

    private boolean isLast() {
      return this.isLast;
    }

    private void setLast(boolean isLast) {
      this.isLast = isLast;
    }

    private char[] getPrefix() {
      return this.prefix;
    }

    private void setPrefix(char[] prefix) {
      this.prefix = prefix;
    }
  }
}
