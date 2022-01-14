package com.surenderthakran.codes.findbestapartment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Given a linear street of city blocks with a number of buildings in each block, find the block
 * best suited to buy an apartment in.<br>
 * You regularly visit a few types of building every week and would like to buy an apartment in a
 * block from where the maximum distance you have to travel to any building is the minimum.<br>
 * Ex: If the distance you need to travel to school from a block is 2, store is 1 and office is 2.
 * Then the maximum distance that you need to travel to any building is 2.<br>
 * The input would be a list of buildings you travel to regularly and a list of block details where
 * each detail object mentions if that block contains a building or not.<br>
 *
 * <p>Notes:
 *
 * <ul>
 *   <li>You can assume that each block details object has entry for each of the required buildings.
 *   <li>If there are multiple best blocks, return any one.
 * </ul>
 */
class Main {

  public static void main(String[] args) {
    boolean assertsEnabled = false;
    assert assertsEnabled = true;

    if (assertsEnabled) {
      HashMap<String, Boolean> block1 = new HashMap<>();
      block1.put("gym", false);
      block1.put("school", true);
      block1.put("store", false);

      HashMap<String, Boolean> block2 = new HashMap<>();
      block2.put("gym", true);
      block2.put("school", false);
      block2.put("store", false);

      HashMap<String, Boolean> block3 = new HashMap<>();
      block3.put("gym", true);
      block3.put("school", true);
      block3.put("store", false);

      HashMap<String, Boolean> block4 = new HashMap<>();
      block4.put("gym", false);
      block4.put("school", true);
      block4.put("store", false);

      HashMap<String, Boolean> block5 = new HashMap<>();
      block5.put("gym", false);
      block5.put("school", true);
      block5.put("store", true);

      assert Solution.getBestBlock(
              new ArrayList<>(Arrays.asList(block1, block2, block3, block4, block5)),
              new String[] {"gym", "school", "store"})
          == 3;

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }
}
