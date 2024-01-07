package com.problem.arrays;

public class RaisingPowerProblem {
	
	/*
	 * Raise the power of each element to the next element and get the max index
	 * based on the maximum power value
	 * */
	public int raisingPowers(int[] numbers) {
		int maxIndex = 0;
		int maxValue = 0;
		int power = 0;
		for(int i = 0 ; i < numbers.length - 1; i++) {
			power = calculatePower(numbers[i], numbers[i + 1]);
			if(power > maxValue) {
				maxIndex = i;
				maxValue = power;
			}
		}
		return maxIndex + 1;
	}
	
	public int calculatePower(int x, int y) {
		int product = 1;
		for(int i = 0 ; i < y ; i++) {
			product *= x;
		}
		return product;
	}
	
	public static void main(String[] args) {
		RaisingPowerProblem raisingPower = new RaisingPowerProblem();
		System.out.println("The max index is " + raisingPower.raisingPowers(new int[] {4,3,7,2}));
	}

}
