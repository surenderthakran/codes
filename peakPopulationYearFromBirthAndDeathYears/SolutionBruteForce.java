package com.surenderthakran.codes.peakpopulationyearfrombirthanddeathyears;

import java.util.HashMap;
import java.util.HashSet;

class SolutionBruteForce {

  static int[] getPeakPopulationYears(int[][] persons) {
    HashMap<Integer, Integer> yearToPopulationMap = new HashMap<>();
    HashSet<Integer> yearsWithPeakPopulations = new HashSet<>();
    int peakPopulation = 0;

    for (int[] person : persons) {
      for (int year = person[0]; year <= person[1]; year++) {
        if (yearToPopulationMap.containsKey(year)) {
          int population = yearToPopulationMap.get(year) + 1;
          yearToPopulationMap.put(year, population);

          if (population > peakPopulation) {
            peakPopulation = population;
            yearsWithPeakPopulations.clear();
            yearsWithPeakPopulations.add(year);
          } else if (population == peakPopulation) {
            yearsWithPeakPopulations.add(year);
          }
        } else {
          yearToPopulationMap.put(year, 1);
        }
      }
    }

    System.out.printf("peakPopulation: %d \n", peakPopulation);
    int[] years = new int[yearsWithPeakPopulations.size()];
    int i = 0;
    for (int year : yearsWithPeakPopulations) {
      years[i] = year;
      i++;
    }
    return years;
  }
}
