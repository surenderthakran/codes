package com.surenderthakran.coding.trie;

import java.util.ArrayList;
import java.util.HashMap;

class Trie {

  private Node root;

  Trie() {
    root = new Node(false);
  }

  private class Node {

    private HashMap<Character, Node> children;
    private boolean isLast;

    private Node(boolean isLast) {
      children = new HashMap<Character, Node>();
      isLast = isLast;
    }
  }

  void insert(ArrayList<String> words) {
  }

  boolean contains(String word) {
    return false;
  }
}