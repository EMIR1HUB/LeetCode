package com.suleimanov.leetcode.leetcode;

import org.springframework.stereotype.Component;

@Component
public class Solutions {


  // day01 Majority Element https://leetcode.com/problems/majority-element/description/
  public int majorityElement(int[] nums) {
    int n = nums.length;  // Сортировка перемешиванием
    int left = 0;
    int right = n - 1;

    while (left <= right) {
      for (int i = right; i > left; --i) {
        if (nums[i - 1] > nums[i]) {
          int temp = nums[i - 1];
          nums[i - 1] = nums[i];
          nums[i] = temp;
        }
      }
      ++left;
      for (int i = left; i < right; ++i) {
        if (nums[i] > nums[i + 1]) {
          int temp = nums[i + 1];
          nums[i + 1] = nums[i];
          nums[i] = temp;
        }
      }
      --right;
    }
    return nums[n / 2];
  }
}
