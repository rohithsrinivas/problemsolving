package com.interview.microsoft;

public class SearchInRotatedSortedArray {

	public int search(int[] nums, int target) {
		int pivotIndex = getPivotIndex(nums);
		if (pivotIndex == -1)
			pivotIndex = nums.length - 1;
		if (target == nums[pivotIndex])
			return pivotIndex;
		if (target >= nums[0]) {
			return binarySearch(0, pivotIndex - 1, target, nums);
		} else {
			return binarySearch(pivotIndex + 1, nums.length - 1, target, nums);
		}
	}

	private int getPivotIndex(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				return nums.length - i;
			}
		}
		return -1;
	}

	private int binarySearch(int low, int high, int key, int[] input) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (key == input[mid])
			return mid;
		if (key > input[mid]) {
			return binarySearch(mid + 1, high, key, input);
		} else {
			return binarySearch(low, mid - 1, key, input);
		}
	}

	public static void main(String[] args) {
		System.out.println(new SearchInRotatedSortedArray().search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 6));
	}

}
