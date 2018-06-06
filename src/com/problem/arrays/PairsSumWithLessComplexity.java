package com.problem.arrays;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PairsSumWithLessComplexity {

	public static void main(String[] args) {
		findPairsWithDesiredSum(5);
	}

	/* this has lesser time complexity O(N) when compared to the regular iterative app
	 * roach, the idea is to insert elements into a set and check if the matching pair
	 * is available in the set or not..., if available then print the pair*/
	private static void findPairsWithDesiredSum(int desiredSum) {
		int a[] = {1,22,-7,9,10,12,4,3};
		Set<Integer> values = new HashSet<Integer>();
		for(int i : a) 
			values.add(i);
		Iterator<Integer> iterator = values.iterator();
		
		while(iterator.hasNext()) {
			Integer i = iterator.next();
			if(values.contains(desiredSum - i)) {
				System.out.println("("+i+","+(desiredSum-i)+")");
				iterator.remove();
			}
		}
		
		
	}

}
