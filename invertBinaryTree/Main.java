package com.surenderthakran.codes.invertBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      Node node4 = new Node(4);
      BinaryTree tree = new BinaryTree(node4);

      Node node2 = new Node(2);
      node4.left = node2;

      Node node6 = new Node(6);
      node4.right = node6;

      node2.right = new Node(3);

      node6.right = new Node(7);

      List<Integer> previousInOrder = tree.inorder();
      tree.invert();
      List<Integer> newInOrder = tree.inorder();

      assert previousInOrder.size() == newInOrder.size();
      assert previousInOrder.reversed().equals(newInOrder);

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Assertions not enabled! Results not verified!");
    }
  }

  static class BinaryTree {

    Node root;

    BinaryTree(Node root) {
      this.root = root;
    }

    List<Integer> inorder() {
      List<Integer> result = new ArrayList<>();
      inorder(root, result);
      return result;
    }

    void inorder(Node node, List<Integer> result) {
      if (node == null) {
        return;
      }

      inorder(node.left, result);
      result.add(node.key);
      inorder(node.right, result);
    }

    // Time complexity: O(n)
    void invert() {
      invert(root);
    }

    Node invert(Node node) {
      if (node == null) {
        return null;
      }

      Node left = node.left;
      node.left = invert(node.right);
      node.right = invert(left);

      return node;
    }
  }

  static class Node {

    Node left;
    Node right;
    int key;

    Node(int key) {
      this.key = key;
    }
  }
}
