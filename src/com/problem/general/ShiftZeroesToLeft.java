package com.problem.general;

public class ShiftZeroesToLeft {
	
	private int[] shiftAllZeroesToLeft(int[] input) {
		int j = input.length-1;
		for(int i = input.length-1;i >= 0 ;i--) {
			if(input[i] == 0)
				continue;
			
			input[j] = input[i];
			j--;
			
		}
		
		while(j >= 0) {
			input[j] = 0;
			j--;
		}
		return input;
		
	}

	public static void main(String[] args) {
		int[] input = {1,0,1,0,0,1,1};
		int[] result = new ShiftZeroesToLeft().shiftAllZeroesToLeft(input);
		for(int i = 0;i< result.length;i++)
			System.out.println(result[i]);;
	}

}
