/**
 * Implementing a Binary Search Tree.
 *
 * For a tree to be a binary search tree, it must be:
 *  1. A binary tree
 *  2. For each node, the left child should be smaller than the current node.
 *  3. For each node, the right child should be greater than the current node.
 *  4. For each node, every node in the left subtree should be smaller than the current node.
 *  5. For each node, every node in the right subtree should be smaller than the current node.
 *
 *  Simply making sure that each node's left child is smaller and right child is larger is not
 *  enough, since a left child can be smaller than the current node but the left child's right
 *  child could be greater than its grand parent node.
 *
 *  There are two methods for validating a Binary Search Tree:
 *  1. In-Order Traversal Method
 *  2. Range Limit Method
 */

import java.util.ArrayList;
import java.util.List;

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

  /**
   * Checks if the binary search tree contains the given integer.
   *
   * @param num Integer to check for existence.
   * @return True if the integer exists in the tree, else false;
   */
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

  /**
   * Determines validity of the Binary Search Tree using the in-order traversal method.
   *
   * For a valid Binary Search Tree, in-order traversal should mean a sorted traversal. In this
   * method, we will traverse the tree in-order and check if each encountered node is larger than
   * or equal to the previous node.
   *
   * @return True if the tree is a valid Binary Search Tree, else false.
   */
  boolean isValidBSTInOrderTraversalMethod() {
    List<Node> inOrderNodes = getNodesInOrder();
    Node lastNode = null;

    // Check if in-order list of nodes is sorted.
    for (Node node : inOrderNodes) {
      if (lastNode != null && lastNode.getValue() > node.getValue()) {
        return false;
      }
      lastNode = node;
    }

    return true;
  }

  /**
   * Returns an in-order  List of all nodes of the tree.
   */
  List<Node> getNodesInOrder() {
    return getNodesInOrder(this.root);
  }

  /**
   * Returns an in-order List of all nodes of the tree which has the given node as root.
   *
   * @param node Root node of the current (sub-)tree.
   * @return In-order list of nodes.
   */
  List<Node> getNodesInOrder(Node node) {
    List<Node> inOrderNodes = new ArrayList<>();

    // Add nodes from left sub-tree.
    if (node.getLeft() != null) {
      inOrderNodes.addAll(getNodesInOrder(node.getLeft()));
    }

    // Add current node.
    inOrderNodes.add(node);

    // Add nodes from right sub-tree.
    if (node.getRight() != null) {
      inOrderNodes.addAll(getNodesInOrder(node.getRight()));
    }

    return inOrderNodes;
  }

  /**
   * Determines validity of the whole Binary Search Tree using the range limiting method.
   *
   * For a valid Binary Search Tree, each node should fall within the limits defined by its parents.
   * And all nodes in it's left sub-tree should fall between current nodes minimum range value and
   * current nodes value. Similarly for right sub-tree, all nodes should fall between current nodes
   * value and current nodes maximum range value.
   *
   * @return True if the tree is a valid Binary Search Tree, else false.
   */
  boolean isValidBSTRangeLimitMethod() {
    return isValidBSTRangeLimitMethod(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  /**
   * Determines validity of the Binary Search Tree with the given node as root and given min & max
   * values using the range limiting method.
   *
   * @return True if the tree is a valid Binary Search Tree, else false.
   */
  boolean isValidBSTRangeLimitMethod(Node node, int min, int max) {
    // Check if current node is in the range.
    if (node.getValue() < min || node.getValue() > max) {
      return false;
    }

    // Check if the left sub-tree is in range.
    if (node.getLeft() != null
        && !isValidBSTRangeLimitMethod(node.getLeft(), min, node.getValue())) {
      return false;
    }

    // Check if the right sub-tree is in range.
    if (node.getRight() != null
        && !isValidBSTRangeLimitMethod(node.getRight(), node.getValue(), max)) {
      return false;
    }

    return true;
  }
}

class Main {
  public static void main(String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      createFirstBinaryTreeAndRunAssertions();
      createSecondBinaryTreeAndRunAssertions();

      // Create BST from a pre-order list of node values.
      BinarySearchTree tree = createBSTFromPreOrderArray(new int[]{10, 5, 1, 7, 40, 50});
      // Assert is tree is a valid Binary Search Tree.
      assert tree.isValidBSTInOrderTraversalMethod() == true;
      assert tree.isValidBSTRangeLimitMethod() == true;

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }

  /**
   * Returns a Binary Seart Tree created from a given array of node values in pre-order.
   *
   * @param preorder Array of node values in pre-order
   * @return A BinarySearchTree
   * @throws IllegalArgumentException
   */
  static BinarySearchTree createBSTFromPreOrderArray(int[] preorder) {
    return createBSTFromPreOrderArray(preorder, 0, preorder.length - 1);
  }

  /**
   * Returns a Binary Seart Tree created from a given (sub-)array of node values in pre-order.
   *
   * @param preorder Array of node values in pre-order
   * @param first Index of first value in the preorder array.
   * @param last Index of last value in the preorder array.
   * @return A BinarySearchTree
   * @throws IllegalArgumentException
   */
  static BinarySearchTree createBSTFromPreOrderArray(int[] preorder, int first, int last) {
    if (preorder.length == 0) {
      throw new IllegalArgumentException("Empty preorder array.");
    }

    // First element in a pre-order array is the root.
    Node root = new Node(preorder[first]);
    BinarySearchTree tree = new BinarySearchTree(root);

    // If pre-order array had only one element, we can return here itself.
    if (first == last) {
      return tree;
    }

    // Identify the index from where the elements for the right sub-tree would begin.
    int rightChildIndex = -1;
    for (int i = first + 1; i <= last; i++) {
      if (preorder[i] > preorder[first]) {
        rightChildIndex = i;
        break;
      }
    }

    // If the sub-array for the left sub-tree values has adequate number of values, create a BST
    // from them and set it's root as current root's left child.
    if (first + 1 <= rightChildIndex - 1) {
      root.setLeft(createBSTFromPreOrderArray(preorder, first + 1, rightChildIndex - 1).getRoot());
    }

    // Create a BST from the right sub-tree elements in the pre-order array and set it's root as
    // current root's right child.
    root.setRight(createBSTFromPreOrderArray(preorder, rightChildIndex, last).getRoot());

    return tree;
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

    assert tree.isValidBSTInOrderTraversalMethod() == true;
    assert tree.isValidBSTRangeLimitMethod() == true;
  }

  static void createSecondBinaryTreeAndRunAssertions() {
    Node root = new Node(3);
    BinarySearchTree tree = new BinarySearchTree(root);

    Node node2 = new Node(2);
    root.setLeft(node2);

    Node node1 = new Node(1);
    node2.setLeft(node1);

    Node node4 = new Node(4);
    node2.setRight(node4);

    Node node5 = new Node(5);
    root.setRight(node5);

    assert tree.isValidBSTInOrderTraversalMethod() == false;
    assert tree.isValidBSTRangeLimitMethod() == false;
  }
}
