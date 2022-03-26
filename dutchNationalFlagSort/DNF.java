package com.surenderthakran.codes.dutchNationalFlagSort;

class DNF {

  static int[] sort(int[] nums) {
    if (nums.length <= 1) {
      return nums;
    }

    int low = 0;
    int mid = 1;
    int high = nums.length - 1;
    while (mid < high) {
      if (nums[mid] == 0) {
        swap(nums, low, mid);
        low++;
      } else if (nums[mid] == 1) {
        mid++;
      } else if (nums[mid] == 2) {
        swap(nums, mid, high);
        high--;
      }
    }

    return nums;
  }

  static void swap(int[] nums, int first, int second) {
    int tmp = nums[first];
    nums[first] = nums[second];
    nums[second] = tmp;
  }
}
