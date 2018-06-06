package com.problem.arrays;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstRepeatingElement {

	public static void main(String[] args) {
		findFirstRepeatingElement();
	}

	/* the idea is to form a map which contains the elements as a key and the 
	 * count of the occurences as the value, now check which elements have the count
	 * of more than 1 and print... for firt non repeating element, everything is same 
	 * but the count of the elements should be exactly 1..*/
	private static void findFirstRepeatingElement() {
		int a[] = {1,2,7,3,4,5,2,4};
		Map<Integer, Integer> values = new LinkedHashMap<>();
		for(int i=0;i<a.length;i++) {
			if(values.containsKey(a[i]))
				values.put(a[i], values.get(a[i])+1);
			else
				values.put(a[i], 1);
		}
		
		Iterator<Map.Entry<Integer, Integer>> iterator = values.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<java.lang.Integer, java.lang.Integer> entry = (Map.Entry<java.lang.Integer, java.lang.Integer>) iterator
					.next();
			if(entry.getValue() > 1) {
				System.out.println("the first non repeating element is "+entry.getKey());
				break;
			}
			
		}
		
	}
}
