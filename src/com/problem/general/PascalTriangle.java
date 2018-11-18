package com.problem.general;

public class PascalTriangle {

	private void printPascalTriangle(int depth) {
		int c = 1;
		for (int i = 0; i < depth; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == 0 || j == 0)
					c = 1;
				else
					c = c * (i - j + 1) / j;
				System.out.print(c+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new PascalTriangle().printPascalTriangle(5);
	}

}
