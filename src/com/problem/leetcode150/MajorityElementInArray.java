package com.problem.leetcode150;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementInArray {

	/**
	 * Given an array nums of size n, return the majority element.
	 * 
	 * The majority element is the element that appears more than ⌊n / 2⌋ times. You
	 * may assume that the majority element always exists in the array.
	 * 
	 * @param nums
	 * @return
	 */
	public static int majorityElementUsingMap(int[] nums) {
		Map<Integer, Integer> frequencies = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(frequencies.containsKey(nums[i])) {
				frequencies.put(nums[i], frequencies.get(nums[i]) + 1);
			}
			else {
				frequencies.put(nums[i], 1);
			}
		}
		for(Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
			if(entry.getValue() > nums.length / 2) {
				return entry.getKey();
			}
		}

		return -1;
	}
	
	// Need to understand the Moore's voting algorithm to optimize the performance. The above solution is taking a 
	// lot of time.

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 2, 1, 1, 1, 2, 2 };
		System.out.println("Majority element in the array is " + majorityElementUsingMap(nums));
	}

}
