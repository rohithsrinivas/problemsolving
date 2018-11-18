package com.problem.general;

public class FloydsTriangle {

	/*
	 * 1
	 * 2 3
	 * 4 5 6
	 * 7 8 9 10
	 * we need to print the above pattern, simply have a counter and increment it after printing it*/
	private void printFloydsTriangle(int n) {
		int k = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(k+ " ");
				k++;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new FloydsTriangle().printFloydsTriangle(5);
	}

}
