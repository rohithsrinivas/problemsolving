package com.problem.leetcode150;

public class RemoveElementFromArray {

	/**
	 * Given an integer array nums and an integer val, remove all occurrences of val
	 * in nums in-place. The order of the elements may be changed. Then return the
	 * number of elements in nums which are not equal to val.
	 * 
	 * Consider the number of elements in nums which are not equal to val be k, to
	 * get accepted, you need to do the following things:
	 * 
	 * Change the array nums such that the first k elements of nums contain the
	 * elements which are not equal to val. The remaining elements of nums are not
	 * important as well as the size of nums. Return k.
	 * 
	 * @param nums
	 * @param val
	 * @return
	 */
	/*
	 * The idea is to just loop through the array and find values which are not equal to val
	 * and keep assigning them to the array using another index k.
	 * */
	/* Don't use an extra storage here, because we just need to track the duplicates, we can use the second index for that*/
	public static int removeElement(int[] nums, int val) {
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[k] = nums[i];
				k++;
			}
		}
		return k;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {0,1,2,2,3,0,4,2};
		System.out.println("Number of the elements other than val is " + removeElement(nums, 2));
	}

}
