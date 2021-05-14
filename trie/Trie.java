/**
 * Trie is a tree like data structure used to better structure a dictonary (set of words) so as to
 * make it easier to search for a given word. Other applications include auto complete, prefix based
 * search, spell check etc. Also, explore Aho-Corasick algorithm which is like an advanced Trie.
 *
 * <p>Complexity: Word Insertion: O(n) Search: O(n)
 */
package com.surenderthakran.coding.trie;

import java.util.ArrayList;
import java.util.HashMap;

class Trie {

  private Node root;

  Trie() {
    root = new Node();
  }

  void insert(ArrayList<String> words) {
    words.stream()
        .filter(word -> !word.isEmpty()) // Filter out empty words.
        .forEach(
            word -> {
              Node currentNode = this.root;
              for (char ch : word.toCharArray()) {
                if (currentNode.hasChild(ch)) {
                  currentNode = currentNode.getChild(ch);
                  continue;
                }

                Node newNode = new Node(ch);
                currentNode.addChild(newNode);
                currentNode = newNode;
              }
              currentNode.setIsLast(true);
            });
  }

  boolean contains(String word) {
    Node currentNode = this.root;
    for (char ch : word.toCharArray()) {
      if (!currentNode.hasChild(ch)) {
        return false;
      }

      currentNode = currentNode.getChild(ch);
    }

    return currentNode.isLast();
  }

  boolean delete(String word) {
    Node currentNode = this.root;
    for (char ch : word.toCharArray()) {
      if (!currentNode.hasChild(ch)) {
        return false;
      }

      currentNode = currentNode.getChild(ch);
    }

    // Return if the node containing the last character of the given word is not the last node of an
    // existing word in the trie dictionary. Meaning that the word to delete does not exists in the
    // trie.
    if (!currentNode.isLast()) {
      return false;
    }

    currentNode.setIsLast(false);

    while (!currentNode.isLast() && !currentNode.hasChildren()) {
      Node parent = currentNode.getParent();
      parent.removeChild(currentNode);
      currentNode = parent;
    }

    return true;
  }

  private class Node {

    private Character value;
    private HashMap<Character, Node> children;
    private Node parent;
    private boolean isLast;

    private Node() {
      this(null, false);
    }

    private Node(Character value) {
      this(value, false);
    }

    private Node(Character value, boolean isLast) {
      this.value = value;
      this.children = new HashMap<Character, Node>();
      this.parent = null;
      this.isLast = isLast;
    }

    private Character getValue() {
      return this.value;
    }

    private void addChild(Node child) {
      this.children.put(child.getValue(), child);
      child.parent = this;
    }

    private void removeChild(Node child) {
      this.children.remove(child.getValue());
      child.parent = null;
    }

    private boolean hasChild(Character value) {
      return this.children.containsKey(value);
    }

    private Node getChild(Character value) {
      return this.children.get(value);
    }

    private boolean hasChildren() {
      return !this.children.isEmpty();
    }

    private Node getParent() {
      return this.parent;
    }

    private boolean isLast() {
      return this.isLast;
    }

    private void setIsLast(boolean isLast) {
      this.isLast = isLast;
    }

    @Override
    public String toString() {
      return String.format(
          "Value: %s, Children: %s, Parent: %s, isLast: %s",
          this.value, this.children.keySet(), this.parent.getValue(), this.isLast);
    }
  }
}
