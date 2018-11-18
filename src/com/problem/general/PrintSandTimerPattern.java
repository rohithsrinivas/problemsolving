package com.problem.general;

public class PrintSandTimerPattern {
	
	private void printSandTimerPattern(int n) {
		int i = 0 , j = 0;
		for(i = n ; i > 0 ; i--) {
			for(j = 0; j < n - i ; j++)
				System.out.print(" ");
			for(int k = 0 ; k < i ; k++)
				System.out.print("* ");
			System.out.println();
		}
		for(i = i+2 ; i <= n ; i++) {
			for(int l = 0 ; l < n - i ; l++)
				System.out.print(" ");
			for(j = 0 ; j < i ; j++)
				System.out.print("* ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new PrintSandTimerPattern().printSandTimerPattern(5);
	}

}
