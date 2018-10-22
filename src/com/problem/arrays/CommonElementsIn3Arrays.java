package com.problem.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommonElementsIn3Arrays {

	private static Map<Integer, Integer> values;

	public static void main(String[] args) {
		findCommonElementsIn3Arrays();

	}

	private static void findCommonElementsIn3Arrays() {
		int a[] = { 1, 5, 10, 20, 40, 80 };
		int b[] = { 6, 7, 20, 80, 100, 10 };
		int c[] = { 3, 4, 15, 20, 30, 70, 80, 120, 10 };
		int i = 0, j = 0, k = 0;
		/*
		 * the idea is to traverse through all the arrays at once and increment the
		 * index of the array, from which the smallest element is found , so that at
		 * some point, there may be a chance of a common element to occur in the array
		 * for which the index was incremented, this will only applied for sorted
		 * arrays, in case the arrys are not sorted, then we need to use a map to
		 * iterate through arrays and add them into map and finally get a count of each
		 * element from the three arrays.
		 */
		while (i < a.length && j < b.length && k < c.length) {
			/* now check the case when all of them are equal */
			if (a[i] == b[j] && b[j] == c[k]) {
				System.out.println(a[i] + " ");
				i++;
				j++;
				k++;
			}

			/*
			 * if the first array element is less than the second array element, then
			 * increment the index of the first array, because there may be a chance that a
			 * common element may occur further in the first array matching with the second
			 * element
			 */
			else if (a[i] < b[j])
				i++;

			/* the same logic applies even for the second and third arrays */
			else if (b[j] < c[k])
				j++;

			/*
			 * if the above three conditionals did not get executed, then it obviously menas
			 * that the element from the third array is the smallest, so increment its index
			 */
			else
				k++;
		}

	}

}
