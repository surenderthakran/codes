package com.surenderthakran.codes.optimalBinarySearchTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Refer to the Optimal Binary Search Tree solution for only successful searches before starting the current solution.
 * 
 * The optimal search cost for a given array of elements when organized in a BST can be calculated using
 * a divide and conquer recursive method.
 * To identify the optimal BST organization we attempt to pick every element in the input as parent node at every level
 * and pick the cost of the structure with the smallest cost.
 * 
 * For this solution we pick the root node's level as 1.
 * 
 * For an array of elements i to j, successful search frequencies P for each element and 
 * unsuccessful search frequencies Q for elements in between those elements can be represented as:
 * 
 *        i       i+1       i+2       ...       j
 *        Pi      Pi+1      Pi+2                Pj
 *    Qi     Qi+1      Qi+2      Qi+3       Qj      Qj+1
 * 
 * The cost of searching a tree with single element i is
 * OC[i..i] = Pi + Qi + Qi+1
 * 
 * And the optimal cost of tree with elements i to j is 
 * OC[i..j] = OC[i..r-1] + OC[r+1..j] + sum of P[i..j] + sum of Q[i..j+1]
 * where,
 * i and j are the starting and ending index for the current tree in the sorted input array,
 * r is the index of the parent in the array
 * 
 * Why add frequencies of all successful and unsuccessful elements in the right and left subtree?
 * The OC of the left and right subtree were computed assuming that their parent is at the root (i.e. level 1).
 * However when they are being used to compute the OC of their parent, all the successful and unsuccessful elements 
 * in both the subtree move down by one
 * i.e. the search cost of every successful and unsuccessful element in both the subtrees increases by one.
 * 
 * Since we are adding the frequencies of left and right subtree alongwith the frequency of the parent element,
 * we are essentially adding the frequencies of all elements in the tree under the parent.
 * 
 * Ref: https://www.javatpoint.com/optimal-binary-search-tree,
 * https://www.geeksforgeeks.org/optimal-binary-search-tree-dp-24/
 */
class SuccessfulAndUnsuccessfulSearchSolution {

  public static double optimalSearchCost(int[] keys, double[] sFreq, double[] fFreq) {
    // A particular trio of parent, left and right child and re-occur during the program's run,
    // however their OC will be same each time regardless of at which level they occur since OC is
    // also computed assuming that the parent is at the root.
    // Hence we will use the memoization technique to store their result so as to avoid re-computation.
    Map<String, Double> memo = new HashMap<>();

    return optimalCost(sFreq, fFreq, 0, sFreq.length - 1, memo);
  }

  private static double optimalCost(double[] sFreq, double[] fFreq, int i, int j, Map<String, Double> memo) {
    // If the (sub)tree has only one element i.e. the parent.
    if (i == j) {
      return sFreq[i] + fFreq[i] + fFreq[i + 1];
    }

    // If the tree has no elements.
    if (i > j) {
      return 0;
    }

    String key = String.format("%d_%d", i, j);
    if (memo.containsKey(key)) {
      // System.out.println(key);
      return memo.get(key);
    }

    double freqSum = freqSum(sFreq, fFreq, i, j);
    double optimalCost = Double.MAX_VALUE;
    for (int r = i; r <= j; r++) {
      optimalCost = 
          Math.min(
            optimalCost, 
            optimalCost(sFreq, fFreq, i, r - 1, memo) + optimalCost(sFreq, fFreq, r + 1, j, memo) + freqSum);
    }
    memo.put(key, optimalCost);

    return optimalCost;
  }

  private static double freqSum(double[] sFreq, double[] fFreq, int i, int j) {
    double sum = 0;
    for (int k = i; k <= j; k++) {
      sum += sFreq[k];
    }
    for (int k = i; k <= j + 1; k++) {
      sum += fFreq[k];
    }

    return sum;
  }
}