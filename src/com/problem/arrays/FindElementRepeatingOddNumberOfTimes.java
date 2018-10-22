package com.problem.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindElementRepeatingOddNumberOfTimes {
	
	public void findElementRepeatingOddNumberOfTimes(int[] c) {
		List<Integer> integers = Arrays.asList(3, 4, 3, 15,15,15,15,22,15,4, 30,3, 70,70, 120,120,30);
		Set<Integer> integerSet = new HashSet<>();
		integers.stream().forEach(integer -> {
			if(integerSet.contains(integer))
				integerSet.remove(integer);
			else
				integerSet.add(integer);
		});
		integerSet.stream().forEach(System.out::println);
	}

	public static void main(String[] args) {
		int c[] = { 3, 4, 15, 20, 30, 70, 80, 120 ,10};
		new FindElementRepeatingOddNumberOfTimes().findElementRepeatingOddNumberOfTimes(c);
	}

}
