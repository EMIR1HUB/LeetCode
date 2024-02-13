package com.suleimanov.leetcode.leetcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeetCodeApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(LeetCodeApplication.class, args);
  }

  @Autowired Solutions solutions;

  @Override
  public void run(String... args) throws Exception{
    String[] words = {"abc", "po", "car","ada","racecar","cool"};
    System.out.println(solutions.firstPalindrome(words));

//    int[] nums = {3, 2, 3};
//    System.out.println(solutions.majorityElement(nums));
  }
}
