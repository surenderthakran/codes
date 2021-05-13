package com.surenderthakran.coding.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Trie {

  private Node root;

  Trie() {
    root = new Node();
  }

  void insert(ArrayList<String> words) {
    words.stream().filter(word -> !word.isEmpty()).forEach(word -> {
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

  void delete(String word) {
    Node currentNode = this.root;
    for (char ch : word.toCharArray()) {
      if (!currentNode.hasChild(ch)) {
        return;
      }

      currentNode = currentNode.getChild(ch);
    }

    if (!currentNode.isLast()) {
      return;
    }

    currentNode.setIsLast(false);

    while (!currentNode.isLast() && !currentNode.hasChildren()) {
      System.out.println(currentNode);
      currentNode.getParent().removeChild(currentNode);
    }
  }

  HashSet<String> wordsByPrefix(String prefix) {
    return new HashSet<>();
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
