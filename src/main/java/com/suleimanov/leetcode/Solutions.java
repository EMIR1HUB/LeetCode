package com.suleimanov.leetcode;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Solutions {

  //day31 Max Consecutive Ones https://leetcode.com/problems/max-consecutive-ones/description/
  public int findMaxConsecutiveOnes(int[] nums) {
    int maxCount = 0;
    int count = 0;

    for (int elem : nums) {
      if(elem == 0){
        if (maxCount < count){
          maxCount = count;
        }
        count = 0;
      }
      else {
        count++;
      }
    }
    return maxCount > count ? maxCount : count;
  }

  //day30 Summary Ranges https://leetcode.com/problems/summary-ranges/description/
  public List<String> summaryRanges(int[] nums) {
    List<String> ranges = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      StringBuilder builder = new StringBuilder();
      builder.append(nums[i]);
      Integer lastNumber = null;
      while (nums.length > (i + 1) && nums[i + 1] - nums[i] == 1) {
        lastNumber = nums[i + 1];
        i++;
      }
      if (lastNumber != null) {
        builder.append("->").append(lastNumber);
      }
      ranges.add(builder.toString());
    }
    return ranges;
  }

  //day29 Single Number https://leetcode.com/problems/single-number/description/
  public int singleNumber(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; i += 2) {
      if (nums[i] != nums[i + 1]) {
        return nums[i];
      }
    }
    return nums[nums.length - 1];
  }

  //day28 Maximum Depth of Binary Tree https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
  public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    // Hypothesis
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    // Induction
    return Math.max(left, right) + 1;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  //day27 Valid Palindrome https://leetcode.com/problems/valid-palindrome/description/
  public boolean isPalindrome(String s) {
    String inputStr = s.toLowerCase().replaceAll("[^a-z0-9]", "");
    StringBuilder sb = new StringBuilder(inputStr);
    String ans = sb.reverse().toString();
    for (int i = 0; i < inputStr.length(); i++) {
      if (inputStr.charAt(i) != ans.charAt(i)) {
        return false;
      }
    }
    return true;
  }

  //day26 Remove Duplicates from Sorted List https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode prev = head;
    ListNode curr = head.next;
    while (curr != null) {
      if (curr.val == prev.val) {
        curr = curr.next;
        prev.next = curr;
      } else {
        prev = curr;
        curr = curr.next;
      }
    }
    return head;
  }

  //day25 Keyboard Row https://leetcode.com/problems/keyboard-row/description/
  public String[] findWords(String[] words) {
    List<String> newWords = new ArrayList<>();
    for (String word : words) {
      if (word.toLowerCase().matches("[qwertyuiop]*")
              || word.toLowerCase().matches("[asdfghjkl]*")
              || word.toLowerCase().matches("[zxcvbnm]*")) {
        newWords.add(word);
      }
    }
    return newWords.toArray(new String[0]);
  }

  //day24 Happy Number https://leetcode.com/problems/happy-number/description/
  public boolean isHappy(int n) {
    while (n != 1 && n != 4) {
      int sum = 0;
      while (n != 0) {
        int a = n % 10;
        sum += (a * a);
        n /= 10;
      }
      n = sum;
    }
    return n == 1;
  }

  //day23 Find the Pivot Integer https://leetcode.com/problems/find-the-pivot-integer/description/
  public int pivotInteger(int n) {
    int s1 = 0;
    int s2 = 0;
    int result = -1;
    for (int i = 1; i <= n; i++) {
      s1 = i * (i + 1) / 2;
      s2 = n * (n + 1) / 2 - i * (i - 1) / 2;
      if (s1 == s2)
        result = i;
    }
    return result;
  }

  //day22  Climbing Stairs https://leetcode.com/problems/climbing-stairs/description/
  public int climbStairs(int n) {
    if (n == 1 || n == 2)
      return n;

    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  //day21 Add binary https://leetcode.com/problems/add-binary/description/
  public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int i = a.length() - 1, j = b.length() - 1, carry = 0;
    while (i >= 0 || j >= 0) {
      int sum = carry;
      if (j >= 0) {
        sum += b.charAt(j--) - '0';
      }
      if (i >= 0) {
        sum += a.charAt(i--) - '0';
      }
      sb.append(sum % 2);
      carry = sum / 2;
    }
    if (carry != 0) {
      sb.append(carry);
    }
    return sb.reverse().toString();
  }

  //day20 Length of Last Word https://leetcode.com/problems/length-of-last-word/description/
  public int lengthOfLastWord(String s) {
    String[] str = s.split(" ");
    return str[str.length - 1].length();
  }

  //day19 Find the Index of the First Occurrence in a String https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
  public int strStr(String haystack, String needle) {
    if (haystack.length() < needle.length()) {
      return -1;
    }
    for (int i = 0, j = needle.length(); j <= haystack.length(); i++, j++) {
      if (haystack.substring(i, j).equals(needle)) {
        return i;
      }
    }
    return -1;
  }

  //day18 Merge Two Sorted Lists https://leetcode.com/problems/merge-two-sorted-lists/description/
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        list1.next = mergeTwoLists(list1.next, list2);
        return list1;
      } else {
        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
      }
    }
    if (list1 == null) {
      return list2;
    }
    return list1;
  }

  // day17 Sqrt(x) https://leetcode.com/problems/sqrtx/description/
  public int mySqrt(int x) {
    if (x <= 1) return x;
    long i = 0, sq = 1;

    while (true) {
      if (i * i > x) {
        return (int) i - 1;
      }
      i++;
    }
  }


  // day16 Reverse Linked List https://leetcode.com/problems/reverse-linked-list/description/
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode current = head;

    while (current != null) {
      ListNode next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  // day15 Contains Duplicate https://leetcode.com/problems/contains-duplicate/description/
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> visited = new HashSet<>();
    for (Integer num : nums) {
      if (!visited.add(num)) return true;
    }
    return false;
  }

  // day14 Remove Element https://leetcode.com/problems/remove-element/description/
  public int removeElement(int[] nums, int val) {
    int i = 0;
    for (int j = 0; j < nums.length; j++) {
      if (nums[j] != val) {
        nums[i] = nums[j];
        i++;
      }
    }
    return i;
  }

  // day13 Remove Duplicates from Sorted Array https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
  public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[i] != nums[j]) {
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }

  // day12 Search Insert Position https://leetcode.com/problems/search-insert-position/description/
  public int searchInsert(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= target) return i;
    }
    return nums.length;
  }

  // day11 Plus One https://leetcode.com/problems/plus-one/description/
  public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      }
      digits[i] = 0;
    }

    int result[] = new int[digits.length + 1];
    result[0] = 1;
    return result;
  }

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
      if (checkPalindrome(word)) {
        return word;
      }
    }
    return "";
  }

  public boolean checkPalindrome(String str) {
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
