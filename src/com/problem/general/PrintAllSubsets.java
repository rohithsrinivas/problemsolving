package com.problem.general;

public class PrintAllSubsets {
	
	private void printAllSubsets(int[] input,int startingIndex,int endingIndex) {
		if(endingIndex > input.length - 1)
			return;
		for(int i = startingIndex;i<=endingIndex;i++) {
			System.out.print(input[i]+" ");
		}
		System.out.println();
		printAllSubsets(input, startingIndex, ++endingIndex);
	}

	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6};
		new PrintAllSubsets().printAllSubsets(input,0,0);
	}

}
