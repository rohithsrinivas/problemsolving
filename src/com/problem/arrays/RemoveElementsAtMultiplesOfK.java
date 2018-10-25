package com.problem.arrays;

import java.util.ArrayList;
import java.util.List;

public class RemoveElementsAtMultiplesOfK {

	private List<Integer> removeElementsAtMultiplesOfK(List<Integer> input, int k) {
		List<Integer> result = new ArrayList<>();
		result.addAll(input);
		for (int i = k-1; i < input.size();) {
			result.remove(input.get(i));
			i+=k;
		}
		return result;
	}

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>();
		for (int i = 10; i <= 100; i = i + 10)
			input.add(i);
		System.out.println(new RemoveElementsAtMultiplesOfK().removeElementsAtMultiplesOfK(input, 2));
	}

}
