package com.problem.arrays;

public class ReplaceElementWithSumOfOtherElements {

	private int[] replaceElementsWithSumOfOthers(int[] numbers) {
		int[] numbers2 = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			numbers2[i] = numbers[i];
		}
		for (int i = 0; i < numbers2.length; i++) {
			numbers[i] = getSumOfAllElements(numbers2) - numbers2[i];
		}
		return numbers;
	}

	private int getSumOfAllElements(int[] numbers) {
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		return sum;
	}
	
	private void printArray(int[] numbers) {
		for(int i=0;i<numbers.length;i++)
			System.out.println(numbers[i]);
	}

	public static void main(String[] args) {
		int[] numbers = new int[5];
		for (int i = 10, j = 0; i <= 50 && j < 5; i = i + 10, j++)
			numbers[j] = i;
		ReplaceElementWithSumOfOtherElements array = new ReplaceElementWithSumOfOtherElements();
		array.printArray(numbers);
		int[] newNumbers = array.replaceElementsWithSumOfOthers(numbers);
		System.out.println("replacing each element with the sum of other elements ________");
		array.printArray(newNumbers);
		
	}

}
