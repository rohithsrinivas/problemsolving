package com.problem.arrays;

public class MaxSubArraySum {
	
	/* maintain a record of the current largest value and the largest value recorded till now,
	 * if the current large value is less than 0, we make it 0 since we already know that it wont be 
	 * the max sum, if large_current is greater than large_upto_now, then assign it to large_upto_now, as now
	 * it will be the largest*/
	private int calculateMaxSubArraySum(int input[]) {
		int large_upto_now = 0,large_current = 0;
		for(int i = 0;i<input.length;i++) {
			large_current = large_current + input[i];
			if(large_current < 0) {
				large_current = 0;
			}
			if(large_upto_now < large_current) {
				large_upto_now = large_current;
			}
		}
		return large_upto_now;
	}

	public static void main(String[] args) {
		int input[] = {-2,-3,4,-1,-2,1,5,-3};
		System.out.println("max sum of sub array is "+new MaxSubArraySum().calculateMaxSubArraySum(input));
	}

}
