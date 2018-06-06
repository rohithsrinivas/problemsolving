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
		int b[] = { 6, 7, 20, 80, 100 ,10};
		int c[] = { 3, 4, 15, 20, 30, 70, 80, 120 ,10};
		values = new HashMap<>();
		insertIntoMap(a);
		insertIntoMap(b);
		insertIntoMap(c);
		for(Map.Entry<Integer, Integer> entry : values.entrySet()) {
			Map.Entry<Integer, Integer> element = entry;
			if(element.getValue()>1)
				System.out.println(element.getKey());
			Arrays.sort(a);
		}
	}

	private static void insertIntoMap(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (values.containsKey(a[i])) {
				values.put(a[i], values.get(a[i]) + 1);
			} else
				values.put(a[i], 1);
		}
	}

}
