package com.problem.arrays;

import java.util.Stack;

public class RotateArrayByKPlaces {
	
	public void rotate(int[] nums, int k) {
		if(k > nums.length)
			k = k % nums.length;
       reverse(nums, 0, nums.length - 1);
       reverse(nums, 0, k - 1);
       reverse(nums, k, nums.length - 1);
        
    }
	
	public void reverse(int[] nums, int left, int right) {
		int temp;
		while(left < right) {
			temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}
	
	public static void main(String[] args) {
		int[] input = new int[] {1,2,3,4,5,6,7};
		new RotateArrayByKPlaces().rotate(input, 10);
		for(int i : input) System.out.println(i + " ");
	}

}
