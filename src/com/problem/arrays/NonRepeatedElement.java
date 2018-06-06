package com.problem.arrays;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NonRepeatedElement {
	
	public static void main(String[] args) {
		findTheNonRepeatedElement();
	}
	
	/*the idea is to use a map rather than nested for loops, simply iterate through
	 * the array and insert the key as the integer and the value as the number of 
	 * occurences of that number,
	 * if it already exists, then increment the value, else add to the map, and filter
	 * the map and display the keys whose value is 1...*/

	private static void findTheNonRepeatedElement() {
		int a[] = {1,2,3,5,6,2,1};
		Map<Integer, Integer> values = new HashMap<>();
		for(int i=0;i<a.length;i++) {
			if(!values.containsKey(a[i]))
				values.put(a[i], 1);
			else {
				values.put(a[i], values.get(a[i])+1);
			}
		}
		
		System.out.println("non repeated characters are...");
		Iterator<Map.Entry<Integer, Integer>> mapIterator = values.entrySet().iterator();
		while (mapIterator.hasNext()) {
			Map.Entry<java.lang.Integer, java.lang.Integer> entry = (Map.Entry<java.lang.Integer, java.lang.Integer>) mapIterator
					.next();
			if(entry.getValue()==1)
				System.out.println(entry.getKey());
			
		}
		
		
	}

}
