package com.surenderthakran.coding.findbestapartment;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * If `n` is the number of blocks and `m` is the number of required buildings.<br>
 * Time complexity of the first pass is `O(n.m)` and same for the second pass.<br>
 * The overall time complexity is `O(2.n.m) = O(n.m)`<br>
 * Space complexity is also `O(n.m)` because of the distanceMatrix we use to hold distances.
 */
class Solution {

  static int getBestBlock(ArrayList<HashMap<String, Boolean>> blocks, String[] requiredBuildings) {
    int[][] distanceMatrix = new int[blocks.size()][];

    // Iterate all blocks from left to right in first pass.
    for (int block = 0; block < blocks.size(); block++) {
      distanceMatrix[block] = new int[requiredBuildings.length];

      // Iterate through each required building.
      for (int requirement = 0; requirement < requiredBuildings.length; requirement++) {
        // Initialize each buildings distance from the current block with -1. It signifies unknown.
        distanceMatrix[block][requirement] = -1;

        // For first block from left, simply set distance to 0 for buildings present in the block
        // itself.
        if (block == 0) {
          if (blocks.get(block).get(requiredBuildings[requirement])) {
            distanceMatrix[block][requirement] = 0;
          }
        } else {
          // For remaining blocks, if the building is not present in the current block, check the
          // block on the left if it has the required building and set distance accordingly.
          if (blocks.get(block).get(requiredBuildings[requirement])) {
            distanceMatrix[block][requirement] = 0;
          } else if (distanceMatrix[block - 1][requirement] != -1) {
            distanceMatrix[block][requirement] = distanceMatrix[block - 1][requirement] + 1;
          }
        }
      }
    }

    int minMaxDistanceToBeTravelled = getMax(distanceMatrix[blocks.size() - 1]);
    int bestBlock = blocks.size() - 1;

    // Iterate all blocks from right to left in second pass, except for the last block since no
    // distances would be updated for it in the second pass.
    for (int block = blocks.size() - 2; block >= 0; block--) {

      // Iterate through each required building.
      for (int requirement = 0; requirement < requiredBuildings.length; requirement++) {
        if (distanceMatrix[block][requirement] == -1
            && distanceMatrix[block + 1][requirement] != -1) {
          // If the building is not present in the current block but is present in the block to the
          // right or the block knows the distance to that building, update distance accordingly.
          distanceMatrix[block][requirement] = distanceMatrix[block + 1][requirement] + 1;
        } else if (distanceMatrix[block][requirement] != -1
            && distanceMatrix[block + 1][requirement] != -1) {
          // If we know the distance to the required building on the left of the current block (from
          // first pass) and the block on the right also has the building or knows the distance to
          // the building, use the shortest of the two paths.
          distanceMatrix[block][requirement] =
              getMin(
                  distanceMatrix[block][requirement], distanceMatrix[block + 1][requirement] + 1);
        }
      }

      int maxDistanceToBeTravelled = getMax(distanceMatrix[block]);
      if (maxDistanceToBeTravelled < minMaxDistanceToBeTravelled) {
        minMaxDistanceToBeTravelled = maxDistanceToBeTravelled;
        bestBlock = block;
      }
    }

    return bestBlock;
  }

  static int getMax(int[] numbers) {
    int max = -1;

    for (int number : numbers) {
      if (number > max) {
        max = number;
      }
    }
    return max;
  }

  static int getMin(int first, int second) {
    return first < second ? first : second;
  }

  static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.printf("%d, ", matrix[i][j]);
      }
      System.out.println("");
    }
    System.out.println("--------------");
  }
}
