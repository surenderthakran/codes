/**
 * Trie is a tree like data structure used to better structure a dictonary (set of words) so as to
 * make it easier to search for a given word. Other applications include auto complete, prefix based
 * search, spell check etc. Also, explore Aho-Corasick algorithm which is like an advanced Trie.
 * <p>
 * Time Complexity:
 *   Word Insertion: O(n)
 *   Search: O(n)
 *   where n is the size of the word.
 */
package com.surenderthakran.codes.trie;

import java.util.List;
import java.util.HashMap;

class Trie {

  private final Node root;

  Trie() {
    root = new Node();
  }

  void insert(List<String> words) {
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
              currentNode.isLast = true;
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

    return currentNode.isLast;
  }

  boolean containsRecursively(String word) {
    if (word.isEmpty()) {
      return false;
    }

    return containsRecursivelyHelper(word, 0, this.root);
  }

  private boolean containsRecursivelyHelper(String word, int currentIdx, Node node) {
    if (currentIdx == word.length()) {
      return node.isLast;
    }

    if (!node.hasChild(word.charAt(currentIdx))) {
      return false;
    }

    Node child = node.getChild(word.charAt(currentIdx));
    return containsRecursivelyHelper(word, currentIdx + 1, child);
  }

  boolean deleteIteratively(String word) {
    Node currentNode = this.root;
    for (char ch : word.toCharArray()) {
      if (!currentNode.hasChild(ch)) {
        return false;
      }

      currentNode = currentNode.getChild(ch);
    }

    // Return if the node containing the last character of the given word is not the last node of an
    // existing word in the trie dictionary. Meaning that the word to delete does not exist in the
    // trie.
    if (!currentNode.isLast) {
      return false;
    }

    currentNode.isLast = false;

    while (!currentNode.isLast && !currentNode.hasChildren()) {
      Node parent = currentNode.parent;
      parent.removeChild(currentNode);
      currentNode = parent;
    }

    return true;
  }

  void deleteRecursively(String word) {
    if (word.isEmpty()) {
      return;
    }

    deleteRecursively(word, 0, this.root);
  }

  private boolean deleteRecursively(String word, int startFrom, Node node) {
    if (startFrom == word.length()) {
      if (node.isLast) {
        node.isLast = false;
        return !node.hasChildren();
      }
      return false;
    }

    if (node.hasChild(word.charAt(startFrom))) {
      Node childNode = node.getChild(word.charAt(startFrom));
      boolean deleteChildNode = deleteRecursively(word, startFrom + 1, childNode);
      if (deleteChildNode) {
        node.removeChild(childNode);
        return !node.isLast && !node.hasChildren();
      }
      return false;
    }

    return false;
  }

  private static class Node {

    private final Character value;
    private final HashMap<Character, Node> children;
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
      this.children = new HashMap<>();
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

    @Override
    public String toString() {
      return String.format(
          "{Value: %s, Children: %s, Parent: %s, isLast: %s}",
          this.value, this.children.keySet(), this.parent != null ? this.parent.getValue() : null, this.isLast);
    }
  }
}
