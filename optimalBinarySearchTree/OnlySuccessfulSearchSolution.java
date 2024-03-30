package com.surenderthakran.codes.optimalBinarySearchTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The optimal search cost for a given array of elements when organized in a BST can be calculated using
 * a divide and conquer recursive method.
 * To identify the optimal BST organization we attempt to pick every element in the input as parent node at every level
 * and pick the cost of the structure with the smallest cost.
 
 * Before we begin, let us calculate the search cost of a single element.
 * For this solution we pick the root node's level as 1.
 * The search cost of an element = level * search frequency.
 * i.e. the search cost of an element at level 2 with a search frequency of 4 is 2 * 4 = 8.
 * Hence, the search cost the of the following tree structure with search frequencies is:
 * elements = [1, 2, 3], frequencies = [2, 3, 1]
 * 
 *      level 1      2
 *                  / \
 *      level 2    1   3
 * 
 * search cost = (2 * 2) + (1 * 3) + (2 * 1) = 9
 * 
 * Now for the final part, the optimal search cost (OC) of a (sub)tree is: 
 * OC of left subtree + sum of frequencies of all elements in the left subtree + 
 * OC of right subtree + sum of frequencies of all elements in the right subtree + 
 * freq of the parent
 * 
 * Why add frequencies of all elements in the right and left subtree?
 * The OC of the left and right subtree were computed assuming that their parent is at the root (i.e. level 1).
 * However, when they are beng used to compute the OC of their parent, all the elements in both the subtree move down by one
 * i.e. the search cost of every element in both the subtrees increases by one.
 * 
 * Since we are adding the frequencies of left and right subtree along with the frequency of the parent element,
 * we are essentially adding the frequencies of all elements in the tree under the parent.
 * Hence, the final equation is:
 * OC[i..j] = OC[i..r-1] + OC[r+1..j] + sum of frequencies of i to j
 * where,
 * i and j are the starting and ending index for the current tree in the sorted input array,
 * r is the index of the parent in the array
 * 
 * Ref: https://www.javatpoint.com/optimal-binary-search-tree,
 * https://www.geeksforgeeks.org/optimal-binary-search-tree-dp-24/
 */
class OnlySuccessfulSearchSolution {

  public static int optimalSearchCost(int[] keys, int[] freq) {
    // Since the input array can be unsorted, we will first sort it
    // and rearrange the frequencies array according to the final sorted array.
    Map<Integer, Integer> keyFreqMap = new HashMap<>();
    for (int i = 0; i <= keys.length - 1; i++) {
      keyFreqMap.put(keys[i], freq[i]);
    }

    Arrays.sort(keys);

    for (int i = 0; i <= keys.length - 1; i++) {
      freq[i] = keyFreqMap.get(keys[i]);
    }

    // A particular trio of parent, left and right child and re-occur during the program's run,
    // however their OC will be same each time regardless of at which level they occur since OC is
    // also computed assuming that the parent is at the root.
    // Hence, we will use the memoization technique to store their result to avoid re-computation.
    Map<String, Integer> memo = new HashMap<>();

    return optimalCost(freq, 0, freq.length - 1, memo);
  }

  private static int optimalCost(int[] freq, int i, int j, Map<String, Integer> memo) {
    // If the (sub)tree has only one element i.e. the parent
    if (i == j) {
      return freq[i];
    }

    // If the tree has no elements.
    if (i > j) {
      return 0;
    }

    String key = String.format("%d_%d", i, j);
    if (memo.containsKey(key)) {
      return memo.get(key);
    }

    int freqSum = freqSum(freq, i, j);
    int optimalCost = Integer.MAX_VALUE;
    for (int r = i; r <= j; r++) {
      optimalCost = 
          Math.min(
            optimalCost, 
            optimalCost(freq, i, r - 1, memo) + optimalCost(freq, r + 1, j, memo) + freqSum);
    }
    memo.put(key, optimalCost);

    return optimalCost;
  }

  private static int freqSum(int[] freq, int i, int j) {
    int sum = 0;
    for (int k = i; k <= j; k++) {
      sum += freq[k];
    }

    return sum;
  }
}
