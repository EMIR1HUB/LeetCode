package com.suleimanov.leetcode;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@Component
public class Solutions {

  // day10 Longest Common Prefix https://leetcode.com/problems/longest-common-prefix/description/
  public String longestCommonPrefix(String[] strs) {
    Arrays.sort(strs);
    String sFirst = strs[0];
    String sLast = strs[strs.length - 1];
    int indx = 0;
    while (indx < sFirst.length() && indx < sLast.length()) {
      if (sFirst.charAt(indx) == sLast.charAt(indx)) {
        indx++;
      } else {
        break;
      }
    }
    return sFirst.substring(0, indx);
  }

  // day09 Find the Town Judge https://leetcode.com/problems/find-the-town-judge/description/
  public int findJudge(int n, int[][] trust) {
    int[] degrees = new int[n + 1]; // Чтобы включить индекс, основанный на 0

    // количество входящих и исходящих степеней для каждого человека
    for (int[] relation : trust) {
      degrees[relation[0]]--; // Out-degree
      degrees[relation[1]]++; // In-degree
    }

    // Поиск городского судьи
    for (int i = 1; i <= n; i++) {
      if (degrees[i] == n - 1) {
        return i;
      }
    }

    return -1;
  }

  // day08 Roman to Integer https://leetcode.com/problems/roman-to-integer/description/
  public int romanToInt(String s) {
    int sum = 0;
    char[] romani = s.toCharArray();
    for (int i = 0; i < romani.length; i++) {
      if (romani[i] == 'I') {
        if (i + 1 < romani.length && (romani[i + 1] == 'V' || romani[i + 1] == 'X')) {
          sum -= 1;
        } else {
          sum += 1;
        }
      } else if (romani[i] == 'V') {
        sum += 5;
      } else if (romani[i] == 'X') {
        if (i + 1 < romani.length && (romani[i + 1] == 'L' || romani[i + 1] == 'C')) {
          sum -= 10;
        } else {
          sum += 10;
        }
      } else if (romani[i] == 'L') {
        sum += 50;
      } else if (romani[i] == 'C') {
        if (i + 1 < romani.length && (romani[i + 1] == 'D' || romani[i + 1] == 'M')) {
          sum -= 100;
        } else {
          sum += 100;
        }
      } else if (romani[i] == 'D') {
        sum += 500;
      } else if (romani[i] == 'M') {
        sum += 1000;
      }
    }
    return sum;
  }

  // day07 Missing Number https://leetcode.com/problems/missing-number/description/
  public int missingNumber(int[] nums) {
    int n = nums.length;
    int total = (n * (n + 1)) / 2;
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    return total - sum;
  }

  // day06 Valid Parentheses https://leetcode.com/problems/valid-parentheses/description/
  public boolean isValid(String s) {
    if (s.length() % 2 != 0)
      return false;

    Stack<Character> openBrackets = new Stack<Character>();
    for (char c : s.toCharArray()) {
      if (c == '(') {
        openBrackets.push(')');
      } else if (c == '[') {
        openBrackets.push(']');
      } else if (c == '{') {
        openBrackets.push('}');
      } else if (openBrackets.empty() || openBrackets.pop() != c) {
        return false;
      }
    }
    return openBrackets.empty();
  }

  // day05 Palindrome Number https://leetcode.com/problems/palindrome-number/description/
  public boolean isPalindrome(int x) {
    if (x < 0 || x % 10 == 0 && x != 0)
      return false;
    int reverse = 0;
    int temp = x;
    while (temp != 0) {
      int remainder = temp % 10;
      reverse = reverse * 10 + remainder;
      temp /= 10;
    }
    return x == reverse;
  }

  // day04 Largest Perimeter Triangle https://leetcode.com/problems/largest-perimeter-triangle/description/
  public int largestPerimeter(int[] nums) {
    Arrays.sort(nums);
    for (int i = nums.length - 1; i >= 2; i--) {
      if (nums[i - 2] + nums[i - 1] > nums[i]) {
        return nums[i - 2] + nums[i - 1] + nums[i];
      }
    }
    return 0;
  }

  // day03 Two Sum  https://leetcode.com/problems/two-sum/description/?source=submission-noac
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int current = nums[i];
      // current + x = target
      // x = target - current
      int x = target - current;
      if (map.containsKey(x)) {
        return new int[]{i, map.get(x)};
      }
      map.put(current, i);
    }
    return null;
  }

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
