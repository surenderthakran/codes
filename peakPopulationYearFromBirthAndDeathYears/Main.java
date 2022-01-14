package com.surenderthakran.codes.peakpopulationyearfrombirthanddeathyears;

import java.util.Arrays;

/**
 * Given birth and death years of a group of people, find the year(s) when most people were alive
 * i.e. the year[s) with the highest population.
 *
 * <p>Assumptions:
 *
 * <ul>
 *   <li>A person is assumed to be alive on their birth year and their death year.
 * </ul>
 */
class Main {

  public static void main(String[] args) {
    boolean assertsEnabled = false;
    assert assertsEnabled = true;

    if (assertsEnabled) {
      assert areEqualIgnoringOrder(
          SolutionBruteForce.getPeakPopulationYears(
              new int[][] {
                {1905, 1947},
                {1857, 1910},
                {1863, 1921},
                {1814, 1899},
                {1914, 1945},
                {1918, 1961},
                {1801, 1813},
                {2000, 2021},
                {1857, 1911},
                {1905, 1921}
              }),
          new int[] {
            1905, 1906, 1907, 1908, 1909, 1910, 1918, 1919, 1920, 1921
          }); // peak population is 5.

      System.out.println("All Assertions Succeeded!");
    } else {
      System.out.println("Asserions not enabled! Results not verified!");
    }
  }

  private static boolean areEqualIgnoringOrder(int[] first, int[] second) {
    Arrays.sort(first);
    Arrays.sort(second);
    return Arrays.equals(first, second);
  }
}
