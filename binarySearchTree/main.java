/**
 * Implementing a Binary Search Tree.
 */

import java.util.Arrays;

class Node {
  private int value;
  private Node leftChild;
  private Node rightChild;

  Node(int value) {
    this.value = value;
  }

  int getValue() {
    return this.value;
  }

  Node getLeft() {
    return this.leftChild;
  }

  void setLeft(Node node) {
    this.leftChild = node;
  }

  Node getRight() {
    return this.rightChild;
  }

  void setRight(Node node) {
    this.rightChild = node;
  }
}

class BinarySearchTree {
  private Node root;

  BinarySearchTree(Node root) {
    this.root = root;
  }

  Node getRoot() {
    return this.root;
  }

  boolean contains(int num) {
    Node current = this.root;
    while (true) {
      if (current.getValue() == num) {
        return true;
      } else if (current.getValue() > num && current.getLeft() != null) {
        current = current.getLeft();
        continue;
      } else if (current.getValue() < num && current.getRight() != null) {
        current = current.getRight();
        continue;
      } else {
        return false;
      }
    }
  }
}

class Main {
  public static void main(String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      createFirstBinaryTreeAndRunAssertions();

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }

  static void createFirstBinaryTreeAndRunAssertions() {
    Node root = new Node(5);
    BinarySearchTree tree = new BinarySearchTree(root);

    Node node3 = new Node(3);
    root.setLeft(node3);

    Node node2 = new Node(2);
    node3.setLeft(node2);

    Node node4 = new Node(4);
    node3.setRight(node4);

    Node node1 = new Node(1);
    node2.setLeft(node1);

    Node node8 = new Node(8);
    root.setRight(node8);

    Node node7 = new Node(7);
    node8.setLeft(node7);

    Node node6 = new Node(6);
    node7.setLeft(node6);

    Node node9 = new Node(9);
    node8.setRight(node9);

    assert tree.contains(1) == true;
    assert tree.contains(10) == false;

    // assert tree.isValidBinarySearchTree() == true;

    // This is sorted since the tree is a binary search tree.
    // assert Arrays.equals(tree.getDataInorder(), new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
  }
}
