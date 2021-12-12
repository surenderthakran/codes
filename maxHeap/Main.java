package com.surenderthakran.coding.maxHeap;

class Main {
  public static void main(String[] args) {
    boolean assertEnabled = false;
    assert assertEnabled = true;

    if (assertEnabled) {
      testMaxHeap();

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Assertions not enabled! Results not verified!");
    }
  }

  private static void testMaxHeap() {
    int[] arr = new int[]{3, 7, 1, 9, 5, 10, 2, 15, 8, 20};

    Heap heap = Heap.heapify(arr);

    assert heap.peek() == 20;

    heap.add(19);
    heap.add(25);
    heap.add(24);

    assert heap.peek() == 25;

    assert heap.pull() == 25;

    assert heap.peek() == 24;
  }
}