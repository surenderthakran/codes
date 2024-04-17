package com.surenderthakran.codes.heapsort;

import java.util.Arrays;

/**
 * HeapSort is an in-place sorting algorithm.
 * To sort an input array in ascending order we use a Max heap and a Min Heap to sort it in
 * descending order.
 * <p>
 * The steps involved are:
 * 1. Create a heap for the given input array. i.e. heapify the array in-place. Also maintain a
 *    marker to the last index of the heap which will initially be the last index of the array.
 * 2. Swap the first and last elements of the heap. i.e. in a Max Heap, swap the largest element
 *    which is at the root with the element at the last index marker.
 * 3. Decrement the last index marker of the heap by one. i.e. remove the last element from the heap
 *    but not from the array.
 * 4. Sink down the element at the root to its correct position to legalize the heap.
 * 5. Continue with step 2 if the heap has more than 1 element.
 * <p>
 * Time Complexity: O(n log n)
 * Space Complexity: O(log n)
 */
public class Main {

  public static void main(String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      int[] nums = {1, 9, 2, -8, 3, 7, -4, 6, -5};
      heapSort(nums);
      assert Arrays.equals(nums, new int[] {-8, -5, -4, 1, 2, 3, 6, 7, 9});

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Assertions not enabled! Results not verified!");
    }
  }

  private static void heapSort(int[] nums) {
    MaxHeap heap = new MaxHeap(nums);
    heap.sort();
  }
}

class MaxHeap {

  private final int[] heapArray;
  private int lastIndex;

  MaxHeap(int[] nums) {
    this.heapArray = nums;
    lastIndex = this.heapArray.length - 1;

    this.heapify();
  }

  /**
   * Roughly half the nodes in a complete binary tree are parent nodes.
   * Since we sinkDown() all parent nodes then we are sinking down half the nodes
   * in the tree. That means that about half the nodes (leaf nodes) run in O(0) time.
   * The last layer of parents each run in O(1) time i.e. in total they run in O(n/2) = O(n) time.
   * The root node will run in O(log n) time.
   * But as we move up the tree the number of nodes also decrease.
   * On an amortized basis, the total time complexity is believed to be O(n).
   * <p>
   * Heapifying involves sinking down the nodes which is a recursive process.
   * For the root node it could mean traversing the entire height of the tree i.e. log n
   * The maximum call stack size required will be log n.
   * Hence, space complexity: O(log n)
   */
  private void heapify() {
    if (this.lastIndex <= 1) {
      return;
    }

    int lastParentIndex = this.getParentIdx(this.lastIndex);
    for (int i = lastParentIndex; i >= 0; i--) {
      this.sinkDown(i);
    }
  }

  private void sinkDown(int idx) {
    int largestIdx = idx;
    int largestValue = this.heapArray[idx];

    int leftIdx = this.getLeftChildIdx(idx);
    if (leftIdx != -1 && this.heapArray[leftIdx] > largestValue) {
      largestValue = this.heapArray[leftIdx];
      largestIdx = leftIdx;
    }

    int rightIdx = this.getRightChildIdx(idx);
    if (rightIdx != -1 && this.heapArray[rightIdx] > largestValue) {
      largestIdx = rightIdx;
    }

    if (idx == largestIdx) {
      return;
    }

    this.swapNodes(idx, largestIdx);
    this.sinkDown(largestIdx);
  }

  /**
   * During the course of sorting, we remove each node one by one. The time complexity of removing
   * a node from a heap is O(log n) where n is the number of nodes in the heap.
   * However, after each removal the number of nodes in the heap also reduce by 1.
   * Hence, the time complexity of removing all n nodes from a heap is:
   * O(log n + log n-1 + log n-2 + ... + 1)
   * => O(log n * n-1 * n-2...1)
   * => O(log n!)
   * <p>
   * Using Stirling's approximation, we deduce that
   * O(log n!) is effectively O(n log n)
   * <p>
   * Removal is a recursive process where the maximum size of the call stack can be log n for the
   * first element to be removed.
   * <p>
   * Time complexity: O(n log n)
   * Space complexity: O(log n)
   */
  void sort() {
    while (this.lastIndex > 0) {
      this.remove();
    }
  }

  /**
   * To remove a node we sink it down to the bottom of the heap which in worst case would mean
   * traversing the entire height of the heap i.e. log n.
   * <p>
   * Removal is a recursive process where the maximum size of the call stack can be log n.
   * <p>
   * Time complexity: O(log n)
   * Space complexity: O(log n)
   */
  private void remove() {
    int root = this.heapArray[0];
    this.heapArray[0] = this.heapArray[this.lastIndex];
    this.heapArray[this.lastIndex] = root;

    this.lastIndex--;
    this.sinkDown(0);
  }

  private int getParentIdx(int idx) {
    if (idx == 0) {
      return -1;
    }

    return (idx - 1) / 2;
  }

  private int getLeftChildIdx(int idx) {
    int leftIdx = (2 * idx) + 1;
    return leftIdx <= this.lastIndex ? leftIdx : -1;
  }

  private int getRightChildIdx(int idx) {
    int rightIdx = (2 * idx) + 2;
    return rightIdx <= this.lastIndex ? rightIdx : -1;
  }

  private void swapNodes(int first, int second) {
    int tmp = this.heapArray[first];
    this.heapArray[first] = this.heapArray[second];
    this.heapArray[second] = tmp;
  }
}
