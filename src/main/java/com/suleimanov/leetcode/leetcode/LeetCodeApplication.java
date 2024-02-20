package com.suleimanov.leetcode.leetcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.Period;
import java.util.Arrays;

@SpringBootApplication
public class LeetCodeApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(LeetCodeApplication.class, args);
  }

  @Autowired
  Solutions solutions;

  @Override
  public void run(String... args) throws Exception {

    System.out.println(solutions.missingNumber(new int[]{3, 0, 1}));

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
