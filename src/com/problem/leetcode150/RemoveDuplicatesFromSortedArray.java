package com.problem.leetcode150;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray {

	/**
	 * Given an integer array nums sorted in non-decreasing order, remove the
	 * duplicates in-place such that each unique element appears only once. The
	 * relative order of the elements should be kept the same. Then return the
	 * number of unique elements in nums.
	 * 
	 * Consider the number of unique elements of nums to be k, to get accepted, you
	 * need to do the following things:
	 * 
	 * Change the array nums such that the first k elements of nums contain the
	 * unique elements in the order they were present in nums initially. The
	 * remaining elements of nums are not important as well as the size of nums.
	 * Return k.
	 * 
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates(int[] nums) {
		/* First initialize the index for unique elements, and start the iteration from index 1 as we don't
		 * need it for 0th index, when the current element is not a duplicate, assign it to the index k and increment
		 * it */
		int k = 0;
		for(int i = 1 ; i < nums.length ; i++) {
			if(nums[i] != nums[k]) {
				nums[++k] = nums[i];
			}
		}
		return ++k;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		System.out.println("The number of unique elements in the array is " + removeDuplicates(nums));
	}

}
