package com.problem.arrays;

public class LargestProductSubArray {
	
	private int findLargestProductSubArrayForPositive(int[] input) {
		int maxUptoNow = 1,maxCurrent = 1;
		for(int i = 0;i<input.length;i++) {
			maxCurrent = maxCurrent * input[i];
			if(maxCurrent < 0)
				maxCurrent = 1;
			if(maxCurrent > maxUptoNow)
				maxUptoNow = maxCurrent;
		}
		System.out.println(maxUptoNow);
		return maxUptoNow;
	}

	public static void main(String[] args) {
		int[]  input = {10,0,20,0,5,8,12,0,3,4,100,40,0};
		new LargestProductSubArray().findLargestProductSubArrayForPositive(input);

	}

}
