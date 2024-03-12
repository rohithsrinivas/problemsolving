package com.problem.leetcode150;

public class RotateAnArrayByKPlaces {

	public static void rotate(int[] nums, int k) {
		int[] rotatedArray = new int[nums.length];
		int numberOfRotations = 0;
		int newArrayIndex = nums.length;
		while(numberOfRotations <= k) {
			rotatedArray[newArrayIndex] = 
		}
	}
	
	public static void main(String[] args) {
		rotate(new int[] {1,2,3,4,5,6,7}, 3);
	}

}
