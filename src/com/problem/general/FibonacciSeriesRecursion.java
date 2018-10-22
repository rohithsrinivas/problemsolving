package com.problem.general;

public class FibonacciSeriesRecursion {
	
	int sum;
	
	private void printFibonacciNumbers(int limit) {
		for(int i = 1;i<=limit;i++)
			System.out.println(generateFibonacciNumbers(i));
	}
	
	

	private int generateFibonacciNumbers(int number) {
		if( number == 0 || number == 1) {
			return number;
		}
			return generateFibonacciNumbers(number - 1) + generateFibonacciNumbers(number - 2);
	}
	
	private void fibonacciUsingRecursion(int limit) {
		int a = 0,b=1;
		int sum = 0;
		for(int i = 0;i<limit;i++) {
			System.out.println(a);
			sum = a+b;
			a = b;
			b = sum;
		}
	}



	public static void main(String[] args) {
		new FibonacciSeriesRecursion().printFibonacciNumbers(5);
		System.out.println("_______");
		new FibonacciSeriesRecursion().fibonacciUsingRecursion(5);
	}

}
