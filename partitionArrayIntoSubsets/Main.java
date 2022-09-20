package com.surenderthakran.codes.partitionArrayIntoSubsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello World!");

    int[][] result = partition(new int[] {1, 2, 3, 4}, 3);
    for (int[] ints : result) {
      System.out.println(Arrays.toString(ints));
    }
  }

  public static int[][] partition(int[] nums, int n) {
    List<List<Integer>> buckets = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      buckets.add(new ArrayList<Integer>());
    }

    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    double average = (double) sum / n;

    HashMap<Double, int[][]> result = new HashMap<>();

    partitionRecursive(0, nums, buckets, average, result);

    double key = 0;
    for (double sd : result.keySet()) {
      key = sd;
    }
    return result.get(key);
  }

  private static void partitionRecursive(
      int current, int[] nums, List<List<Integer>> buckets, double average, HashMap<Double, int[][]> result) {

    if (current == nums.length) {
      updateResult(buckets, result, average);
      return;
    }

    for (List<Integer> bucket : buckets) {
      bucket.add(nums[current]);

      partitionRecursive(current + 1, nums, buckets, average, result);

      bucket.remove(bucket.size() - 1);
    }
  }

  private static void updateResult(List<List<Integer>> buckets, HashMap<Double, int[][]> result, double average) {
    int numberOfBuckets = buckets.size();

    double totalSD = 0;

    int[][] bucketArr = new int[numberOfBuckets][];
    for (int i= 0; i < numberOfBuckets; i++) {
      List<Integer> bucket = buckets.get(i);
      int[] tmp = new int[bucket.size()];

      int sum = 0;

      for (int j = 0; j < tmp.length; j++) {
        tmp[j] = bucket.get(j);
        sum += bucket.get(j);
      }

      bucketArr[i] = tmp;
      totalSD += Math.abs(average - sum);
    }

    if (result.size() == 0) {
      result.put(totalSD, bucketArr);
    } else {
      double key = 0;
      for (double sd : result.keySet()) {
        key = sd;
      }

      if (totalSD < key) {
        result.remove(key);
        result.put(totalSD, bucketArr);
      }
    }
  }
}