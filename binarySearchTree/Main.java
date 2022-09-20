package com.surenderthakran.codes.binarySearchTree;

import com.surenderthakran.codes.binarySearchTree.BinarySearchTree;
import com.surenderthakran.codes.binarySearchTree.BinarySearchTree.Node;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      testAddContainsRemove();
      testCreateBSTFromPreorderArray();
      testValidBST();
      testInValidBST();
      testValidBSTCreatedUsingInsertions();
      testValidBSTCreatedFromPreOrderArray();

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }

  private static void testAddContainsRemove() {
    BinarySearchTree tree = new BinarySearchTree();

    assert !tree.contains(5);

    tree.add(5);
    tree.add(4);

    assert tree.contains(5);

    tree.add(6);
    tree.remove(5);

    assert !tree.contains(5);
  }

  private static void testCreateBSTFromPreorderArray() {
    BinarySearchTree tree1 =
        BinarySearchTree.createBSTFromPreorderArray(new int[]{10, 5, 1, 7, 40, 50});

    assert tree1.isValidBSTInOrderTraversalMethod();
    assert tree1.isValidBSTRangeLimitMethod();

    BinarySearchTree tree2 =
        BinarySearchTree.createBSTFromPreorderArray(new int[]{10, 5, 1, 7});

    assert tree2.isValidBSTInOrderTraversalMethod();
    assert tree2.isValidBSTRangeLimitMethod();

    BinarySearchTree tree3 =
        BinarySearchTree.createBSTFromPreorderArray(new int[]{10, 40, 50});

    assert tree3.isValidBSTInOrderTraversalMethod();
    assert tree3.isValidBSTRangeLimitMethod();
  }

  private static void testValidBST() {
    Node root = new Node(5);
    BinarySearchTree tree = new BinarySearchTree(root);

    Node node3 = new Node(3);
    root.left = node3;

    Node node2 = new Node(2);
    node3.left = node2;

    Node node4 = new Node(4);
    node3.right = node4;

    Node node1 = new Node(1);
    node2.left = node1;

    Node node8 = new Node(8);
    root.right = node8;

    Node node7 = new Node(7);
    node8.left = node7;

    Node node6 = new Node(6);
    node7.left = node6;

    Node node9 = new Node(9);
    node8.right = node9;

    assert tree.contains(1);
    assert !tree.contains(10);

    assert tree.isValidBSTInOrderTraversalMethod();
    assert tree.isValidBSTRangeLimitMethod();
    assert Arrays.equals(
        tree.getNodesInOrder().stream().map(node -> node.value).toArray(Integer[]::new),
        new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

    // Delete root node.
    tree.remove(5);

    assert tree.isValidBSTInOrderTraversalMethod();
    assert tree.isValidBSTRangeLimitMethod();
    assert Arrays.equals(
        tree.getNodesInOrder().stream().map(node -> node.value).toArray(Integer[]::new),
        new Integer[]{1, 2, 3, 4, 6, 7, 8, 9});

    // Delete leaf node.
    tree.remove(1);

    assert tree.isValidBSTInOrderTraversalMethod();
    assert tree.isValidBSTRangeLimitMethod();
    assert Arrays.equals(
        tree.getNodesInOrder().stream().map(node -> node.value).toArray(Integer[]::new),
        new Integer[]{2, 3, 4, 6, 7, 8, 9});

    // Delete two child node.
    tree.remove(3);

    assert tree.isValidBSTInOrderTraversalMethod();
    assert tree.isValidBSTRangeLimitMethod();
    assert Arrays.equals(
        tree.getNodesInOrder().stream().map(node -> node.value).toArray(Integer[]::new),
        new Integer[]{2, 4, 6, 7, 8, 9});

    // Delete single child node.
    tree.remove(4);

    assert tree.isValidBSTInOrderTraversalMethod();
    assert tree.isValidBSTRangeLimitMethod();
    assert Arrays.equals(
        tree.getNodesInOrder().stream().map(node -> node.value).toArray(Integer[]::new),
        new Integer[]{2, 6, 7, 8, 9});
  }

  private static void testInValidBST() {
    Node root = new Node(3);
    BinarySearchTree tree = new BinarySearchTree(root);

    Node node2 = new Node(2);
    root.left = node2;

    Node node1 = new Node(1);
    node2.left = node1;

    Node node4 = new Node(4);
    node2.right = node4;

    Node node5 = new Node(5);
    root.right = node5;

    assert !tree.isValidBSTInOrderTraversalMethod();
    assert !tree.isValidBSTRangeLimitMethod();
  }

  private static void testValidBSTCreatedUsingInsertions() {
    BinarySearchTree tree = new BinarySearchTree();
    tree.add(10);
    tree.add(5);
    tree.add(15);
    tree.add(5);

    assert tree.isValidBSTInOrderTraversalMethod();
    assert tree.isValidBSTRangeLimitMethod();
    assert Arrays.equals(
        tree.getNodesInOrder().stream().map(node -> node.value).toArray(Integer[]::new),
        new Integer[]{5, 5, 10, 15});

    // Delete duplicate node.
    tree.remove(5);

    assert tree.isValidBSTInOrderTraversalMethod();
    assert tree.isValidBSTRangeLimitMethod();
    assert Arrays.equals(
        tree.getNodesInOrder().stream().map(node -> node.value).toArray(Integer[]::new),
        new Integer[]{5, 10, 15});
  }

  private static void testValidBSTCreatedFromPreOrderArray() {
    BinarySearchTree tree1 =
        BinarySearchTree.createBSTFromPreorderArray(new int[]{10, 5, 1, 7, 40, 50});

    assert tree1.isValidBSTInOrderTraversalMethod();
    assert tree1.isValidBSTRangeLimitMethod();

    BinarySearchTree tree2 =
        BinarySearchTree.createBSTFromPreorderArray(new int[]{10, 5, 1, 7});

    assert tree2.isValidBSTInOrderTraversalMethod();
    assert tree2.isValidBSTRangeLimitMethod();

    BinarySearchTree tree3 =
        BinarySearchTree.createBSTFromPreorderArray(new int[]{10, 40, 50});

    assert tree3.isValidBSTInOrderTraversalMethod();
    assert tree3.isValidBSTRangeLimitMethod();
  }
}