package com.surenderthakran.coding.maxHeap;

import java.util.ArrayList;

public class Heap {

  private final ArrayList<Integer> heapList;

  public Heap() {
    this(new int[]{});
  }

  private Heap(int[] arr) {
    this.heapList = new ArrayList<>();
    for (int num : arr) {
      this.heapList.add(num);
    }
  }

  /**
   * Roughly half the nodes in a complete binary tree are parent nodes.
   * Since we sinkDown() all parent nodes then we are sinking down half the nodes
   * in the tree. That means that about half the nodes (leaf nodes) run in O(0) time.
   * The last layer of parents each run in O(1) time i.e. in total they run in O(n/2) = O(n) time.
   * The root node will run in O(log n) time.
   * But as we move up the tree the number of nodes also decrease.
   * On an amortized basis, the total time complexity is believed to be O(n).
   */
  public static Heap heapify(int[] arr) {
    Heap heap = new Heap(arr);
    int lastNodeIdx = heap.heapList.size() - 1;
    int lastParentIdx = Heap.getParentIdx(lastNodeIdx);
    for (int i = lastParentIdx; i >= 0; i--) {
      heap.sinkDown(i);
    }
    return heap;
  }

  /**
   * Time complexity: O(1)
   * Space complexity: O(1)
   */
  public int peek() {
    return this.heapList.get(0);
  }

  /**
   * Time complexity: To add a new node, it has to be bubbled up to its correct position.
   * In the worst case scenario we may end up bubbling it all the way up to the root node.
   * i.e. we travel the full height of the tree.
   * We know that at level d a perfect binary tree would have 2^d nodes.
   * We also know that a complete binary tree has about n / 2 nodes in the last level.
   * Hence, n / 2  = 2 ^ d
   * Solving for d we get d = (log n) -1.
   * Since the time complexity is the height of the tree O(d), it solves to O(log n).
   * Space Complexity: O(1)
   */
  public void add(int num) {
    this.heapList.add(num);
    this.bubbleUp(this.heapList.size() - 1);
  }

  /**
   * Similar to add() method.
   * Time complexity: O(log n)
   * Space complexity: O(1)
   */
  public int pull() {
    int result = this.heapList.get(0);
    this.swapNodes(0, this.heapList.size() - 1);
    this.heapList.remove(this.heapList.size() - 1);
    this.sinkDown(0);
    return result;
  }

  private static int getParentIdx(int childIdx) {
    return (childIdx - 1) / 2;
  }

  private void sinkDown(int idx) {
    int largestVal = this.heapList.get(idx);
    int largestIdx = idx;

    int leftIdx = (2 * idx) + 1;
    if (leftIdx <= this.heapList.size() - 1) {
      int leftVal = this.heapList.get(leftIdx);
      if (leftVal > largestVal) {
        largestVal = leftVal;
        largestIdx = leftIdx;
      }
    }

    int rightIdx = (2 * idx) + 2;
    if (rightIdx <= this.heapList.size() - 1) {
      int rightVal = this.heapList.get(rightIdx);
      if (rightVal > largestVal) {
        largestIdx = rightIdx;
      }
    }

    if (largestIdx != idx) {
      this.swapNodes(idx, largestIdx);
      this.sinkDown(largestIdx);
    }
  }

  private void bubbleUp(int idx) {
    if (idx == 0) {
      return;
    }

    int parentIdx = Heap.getParentIdx(idx);
    if (this.heapList.get(idx) > this.heapList.get(parentIdx)) {
      this.swapNodes(idx, parentIdx);
      this.bubbleUp(parentIdx);
    }
  }

  private void swapNodes(int firstIdx, int secondIdx) {
    int tmp = this.heapList.get(firstIdx);
    this.heapList.set(firstIdx, this.heapList.get(secondIdx));
    this.heapList.set(secondIdx, tmp);
  }
}
