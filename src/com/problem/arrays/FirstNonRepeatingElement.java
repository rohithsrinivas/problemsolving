package com.problem.arrays;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingElement {

	public static void main(String[] args) {
		findFirstNonRepeatingElement();

	}

	private static void findFirstNonRepeatingElement() {
		int a[] = {1,1,2,7,3,4,5,2,4};
		Map<Integer, Integer> values = new LinkedHashMap<>();
		for(int i=0;i<a.length;i++) {
			if(values.containsKey(a[i]))
				values.put(a[i], values.get(a[i])+1);
			else
				values.put(a[i], 1);
		}
		
		Iterator<Map.Entry<Integer, Integer>> mapIterator = values.entrySet().iterator();
		while (mapIterator.hasNext()) {
			Map.Entry<java.lang.Integer, java.lang.Integer> entry = (Map.Entry<java.lang.Integer, java.lang.Integer>) mapIterator
					.next();
			if(entry.getValue()==1) {
				System.out.println("first non repeating element is "+entry.getKey());
				break;
			}
		}
		
	}

}
