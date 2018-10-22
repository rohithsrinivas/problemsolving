package com.problem.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class KLargestElements {

	private void printKLargestElements(int k, int[] input) {
		List<Integer> inputs = Arrays.asList( 32, 8, 1, 6, 4, 23, 46, 12 );
		TreeSet<Integer> values = new TreeSet<>();
		values.addAll(inputs);
		for(int i =1;i<=k;i++)
			System.out.println(values.pollLast());
	}

	public static void main(String[] args) {
		int[] input = { 32, 8, 1, 6, 4, 23, 46, 12 };
		new KLargestElements().printKLargestElements(3, input);
	}

}
