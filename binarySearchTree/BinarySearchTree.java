package com.surenderthakran.codes.binarySearchTree;

import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {

  Node root;

  public BinarySearchTree() {}

  public BinarySearchTree(Node root) {
    this.root = root;
  }

  /**
   * Inserts new node in the tree.
   * A new node is always inserted at the leaf.
   *
   * @param value New node's value.
   * @return Newly inserted Node.
   */
  public Node add(int value) {
    Node node = new Node(value);

    if (this.root == null) {
      this.root = node;
    } else {
      // New node will be added in the tree which has current as root.
      Node current = this.root;

      while (true) {
        if (value <= current.value) {
          if (current.left != null) {
            // New node will be added in the tree which has current.left as root.
            current = current.left;
          } else {
            current.left = node;
            break;
          }
        } else {
          if (current.right != null) {
            // New node will be added in the tree which has current.right as root.
            current = current.right;
          } else {
            current.right = node;
            break;
          }
        }
      }
    }

    return node;
  }

  /**
   * Checks if the binary search tree contains the given integer.
   *
   * @param value Integer to check for existence.
   * @return True if the integer exists in the tree, else false;
   */
  public boolean contains(int value) {
    return find(value) != null;
  }

  private Node find(int value) {
    Node current = this.root;

    while (true) {
      if (current == null) {
        return null;
      } else if (current.value == value) {
        return current;
      } else if (value < current.value) {
        current = current.left;
      } else {
        current = current.right;
      }
    }
  }

  /**
   * Deletes a node with the given value from the whole tree.
   *
   * @param value Value of the node to be deleted.
   */
  public void remove(int value) {
    if (this.root == null) {
      return;
    }

    this.root = remove(value, this.root);
  }

  /**
   * Deletes a node with the given value in the subtree under the given node.
   *
   * To delete a node with no children, we simply return a null to the parent recursion so that it
   * gets set as the current subtree's reference and the reference to the node is lost.
   * To delete a node with one child, we promote the sole child to it's parent's position by
   * returning the child's reference to the parent recursion.
   * To delete a node with two children, we find the in-order successor (i.e. the smallest node in
   * the right subtree) of the node and replace the current node's value with the successor's value
   * and then delete the successor from the right subtree. An in-order predecessor (i.e. the
   * largest node in the left subtree) could also be used as the replacement candidate.
   *
   * @param value Value of the node to be deleted.
   * @param current Root of the subtree from which the node is to be deleted.
   * @return Returns the latest root of the subtree after the node is deleted.
   */
  private Node remove(int value, Node current) {
    if (current == null) {
      return null;
    }

    if (current.value == value) {
      if (current.left == null && current.right == null) {
        return null;
      } else if (current.left == null) {
        return current.right;
      } else if (current.right == null) {
        return current.left;
      } else {
        Node inOrderSuccessor = getSmallestNodeInTree(current.right);
        current.value = inOrderSuccessor.value;
        // Delete the successor from the right subtree and set the updated subtree as the new
        // right child of the current node.
        current.right = this.remove(inOrderSuccessor.value, current.right);
      }
    } else if (value < current.value) {
      current.left = remove(value, current.left);
    } else {
      current.right = remove(value, current.right);
    }

    return current;
  }

  private Node getSmallestNodeInTree(Node current) {
    Node smallest = current;
    while (smallest.left != null) {
      smallest = smallest.left;
    }
    return smallest;
  }

  /**
   * Returns a Binary Search Tree created from a given array of node values in pre-order.
   *
   * @param preorder Array of node values in pre-order
   * @return A BinarySearchTree
   */
  public static BinarySearchTree createBSTFromPreorderArray(int[] preorder) {
    BinarySearchTree tree = new BinarySearchTree();

    if (preorder.length == 0) {
      return tree;
    }

    tree.root = createBSTFromPreorderArray(preorder, 0, preorder.length - 1);

    return tree;
  }

  /**
   * Returns a Binary Search Tree created from a given (sub-)array of node values in pre-order.
   *
   * @param preorder Array of node values in pre-order
   * @param first Index of first value in the preorder array.
   * @param last Index of last value in the preorder array.
   * @return A BinarySearchTree
   */
  private static Node createBSTFromPreorderArray(int[] preorder, int first, int last) {
    if (first > last) {
      return null;
    }

    // First element in a pre-order array (or sub-array) is the root/parent.
    Node parent = new Node(preorder[first]);

    // Identify the index till where the elements for the left subtree exist.
    int leftSubtreeEndIndex = first;
    for (int i = first + 1; i <= last; i++) {
      if (preorder[i] > preorder[first]) {
        break;
      }
      leftSubtreeEndIndex = i;
    }

    parent.left = createBSTFromPreorderArray(preorder, first + 1, leftSubtreeEndIndex);
    parent.right = createBSTFromPreorderArray(preorder, leftSubtreeEndIndex + 1, last);

    return parent;
  }

  /**
   * Determines validity of the whole Binary Search Tree using the range limiting method.
   *
   * For a valid Binary Search Tree, each node should fall within the limits defined by its parents.
   * And all nodes in it's left subtree should fall between current nodes minimum range value and
   * current nodes value. Similarly, for right subtree, all nodes should fall between current nodes
   * value and current nodes maximum range value.
   *
   * @return True if the tree is a valid Binary Search Tree, else false.
   */
  public boolean isValidBSTRangeLimitMethod() {
    return this.isValidBSTRangeLimitMethod(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  /**
   * Determines validity of the Binary Search Tree with the given node as parent and given min & max
   * values using the range limiting method.
   *
   * @return True if the tree is a valid Binary Search Tree, else false.
   */
  private boolean isValidBSTRangeLimitMethod(Node parent, int minValue, int maxValue) {
    if (parent == null) {
      return true;
    }

    if (parent.value > maxValue || parent.value < minValue) {
      return false;
    }

    return this.isValidBSTRangeLimitMethod(parent.left, minValue, parent.value)
        && this.isValidBSTRangeLimitMethod(parent.right, parent.value + 1, maxValue);
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
  public boolean isValidBSTInOrderTraversalMethod() {
    if (this.root == null) {
      return true;
    }

    List<Node> inorder = this.getNodesInOrder();

    if (inorder.size() == 1) {
      return true;
    }

    // Check if in-order list of nodes is sorted.
    for (int i = 0; i < inorder.size() - 1; i++) {
      if (inorder.get(i).value > inorder.get(i + 1).value) {
        return false;
      }
    }

    return true;
  }

  public List<Node> getNodesInOrder() {
    return this.getNodesInOrder(this.root);
  }

  /**
   * Returns an in-order List of all nodes of the tree which has the given node as root.
   *
   * @param parent Root node of the current (sub-)tree.
   * @return In-order list of nodes.
   */
  private List<Node> getNodesInOrder(Node parent) {
    if (parent == null) {
      return null;
    }

    List<Node> inorder = new LinkedList<>();

    List<Node> leftSubtreeInorder = this.getNodesInOrder(parent.left);
    if (leftSubtreeInorder != null) {
      inorder.addAll(leftSubtreeInorder);
    }

    inorder.add(parent);

    List<Node> rightSubtreeInorder = this.getNodesInOrder(parent.right);
    if (rightSubtreeInorder != null) {
      inorder.addAll(rightSubtreeInorder);
    }

    return inorder;
  }

  static class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
      this.value = value;
    }
  }
}
