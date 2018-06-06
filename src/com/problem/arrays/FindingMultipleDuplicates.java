package com.problem.arrays;

import java.util.LinkedHashSet;
import java.util.Set;

public class FindingMultipleDuplicates {

	public static void main(String[] args) {
		findAllDuplicatesInTheArray();

	}
	/*this is yet to be solved####*/
	private static void findAllDuplicatesInTheArray() {
		int a[] = {1,5,3,8,3,9,1,11,35,11};
		Set<Integer> values = new LinkedHashSet<>();
		for(Integer i : a) {
			values.add(i);
		}
		
		System.out.println(values);
	}

}
