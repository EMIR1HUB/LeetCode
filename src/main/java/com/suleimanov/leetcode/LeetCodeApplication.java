package com.suleimanov.leetcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

@SpringBootApplication
public class LeetCodeApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(LeetCodeApplication.class, args);
  }

  @Autowired
  Solutions solutions;

  @Override
  public void run(String... args) throws Exception {

    List<Integer> ls = new ArrayList<>();
    List<Integer> ls1 = new ArrayList<>();
    ls.add(1);
    ls.add(1);
    ls.add(3);
    ls.add(4);
    ls.add(2);

    System.out.println(ls);
    ls.remove((Integer) 2);
    System.out.println(ls);

    System.out.println(solutions.lengthOfLastWord("Hello World"));

//    System.out.println(solutions.strStr("sadbutsad", "sad"));

//    System.out.println(solutions.mergeTwoLists(
//            solutions.new ListNode(1,
//                    solutions.new ListNode(2,
//                            solutions.new ListNode(4))),
//            solutions.new ListNode(1,
//                    solutions.new ListNode(3,
//                            solutions.new ListNode(4)))));


//    System.out.println(solutions.mySqrt(2147395600));

//    System.out.println(solutions.reverseList(solutions.new ListNode(1,
//            solutions.new ListNode(2,
//                    solutions.new ListNode(3,
//                            solutions.new ListNode(4))))));


//    System.out.println(solutions.containsDuplicate(new int[] {1,2,3,4}));

//    System.out.println(solutions.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));

//    System.out.println(solutions.removeDuplicates(new int[]{1,1,2}));

//    System.out.println(solutions.searchInsert(new int[]{1,3,5,6}, 7));

//    System.out.println(Arrays.toString(solutions.plusOne(new int[]{1, 9})));

//    System.out.println(solutions.longestCommonPrefix(new String[]{"dog","racecar","car"}));

//    System.out.println(solutions.findJudge(3, new int[][]{{1, 3}, {2, 3}}));

//    System.out.println(solutions.romanToInt("LVIII"));

//    System.out.println(solutions.missingNumber(new int[]{3, 0, 1}));

//    System.out.println(solutions.isValid("()[]{}"));

//    System.out.println(solutions.isPalindrome(121));

//    System.out.println(solutions.largestPerimeter(new int[]{1,2,1,10}));

//    System.out.println(Arrays.toString(solutions.twoSum(new int[]{3,2,4}, 6)));

//    String[] words = {"abc", "po", "car","ada","racecar","cool"};
//    System.out.println(solutions.firstPalindrome(words));

//    int[] nums = {3, 2, 3};
//    System.out.println(solutions.majorityElement(nums));
  }
}
