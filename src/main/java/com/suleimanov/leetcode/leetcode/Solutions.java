package com.suleimanov.leetcode.leetcode;

import org.springframework.stereotype.Component;

@Component
public class Solutions {

  // day02 Find First Palindromic String in the Array https://leetcode.com/problems/find-first-palindromic-string-in-the-array/description/
  public String firstPalindrome(String[] words) {
    for (String word : words) {
      if (isPalindrome(word)) {
        return word;
      }
    }
    return "";
  }

  public boolean isPalindrome(String str) {
    for (int i = 0; i < str.length() / 2; i++) {
      char start = str.charAt(i);
      char end = str.charAt(str.length() - 1 - i);
      if (start != end) {
        return false;
      }
    }
    return true;
  }


  // day01 Majority Element https://leetcode.com/problems/majority-element/
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
