package com.interview.microsoft;

import java.util.HashSet;
import java.util.Set;

public class SumOfNumbersInArray {
	
	public boolean findPairsToSum(int[] input, int k) {
		Set<Integer> numberSet = new HashSet<>();
		for(int i : input) {
			if(numberSet.contains(k - i)) return true;
			numberSet.add(i);
		}
		return false;
	}
	
	public boolean findPairsToSumSorted(int[] input, int k) {
		for(int i = 0, j = input.length - 1 ; i < j ; ) {
			if(input[i] + input[j] < k) i++;
			else if(input[i] + input[j] > k) j--;
			else return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new SumOfNumbersInArray().findPairsToSum(new int[] {3,5,1,68,7,18,6}, 86));
		System.out.println(new SumOfNumbersInArray().findPairsToSum(new int[] {3,5,7,68,78,98,106}, 75));

	}

}
