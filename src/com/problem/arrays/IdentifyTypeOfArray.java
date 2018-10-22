package com.problem.arrays;

public class IdentifyTypeOfArray {
	
	private String identifyTypeOfArray(int[] input) {
		if(input[0] > input[input.length/2 + 1] && input[input.length/2 + 1] > input[input.length - 1])
			return "decreasing";
		if(input[0] < input[input.length/2 + 1] && input[input.length/2 + 1] < input[input.length - 1])
			return "increasing";
		if(input[0] < input[input.length/2 + 1] && input[input.length/2 + 1] > input[input.length - 1])
			return "increasing and then decreasing";
		if(input[0] > input[input.length/2 + 1] && input[input.length/2 + 1] < input[input.length - 1])
			return "decreasing and then increasing";
		
		return "none";
		
	}

	public static void main(String[] args) {
		int input[] = {100,80,70,60,50,44,33,22,1};
		System.out.println(new IdentifyTypeOfArray().identifyTypeOfArray(input));
	}

}
