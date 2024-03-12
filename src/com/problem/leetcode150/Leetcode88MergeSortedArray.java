package com.problem.leetcode150;

public class Leetcode88MergeSortedArray {

	/**
	 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
	 * order, and two integers m and n, representing the number of elements in nums1
	 * and nums2 respectively.
	 * 
	 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
	 * 
	 * The final sorted array should not be returned by the function, but instead be
	 * stored inside the array nums1. To accommodate this, nums1 has a length of m +
	 * n, where the first m elements denote the elements that should be merged, and
	 * the last n elements are set to 0 and should be ignored. nums2 has a length of
	 * n.
	 * 
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = 0, j = 0, k = 0;
		int[] result = new int[nums1.length];
		while(i < m && j < n) {
			if (nums1[i] <= nums2[j]) {
				result[k] = nums1[i++];
			} else {
				result[k] = nums2[j++];
			}
			k++;
		}
		while(i < m) {
			result[k++] = nums1[i++];
		}
		while (j < n) {
			result[k++] = nums2[j++];
		}
		for(int p = 0 ; p < result.length ; p++) {
			nums1[p] = result[p];
		}
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = new int[] { 2, 5, 6 };
		merge(nums1, 3, nums2, 3);
	}

}
