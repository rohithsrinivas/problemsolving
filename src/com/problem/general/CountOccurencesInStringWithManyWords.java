package com.problem.general;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class CountOccurencesInStringWithManyWords {

	private void findOccurences(String input) {
		String[] words = input.split("\\s");
		Map<String, Integer> counts = new LinkedHashMap<>();
		for (String word : words) {
			if (counts.containsKey(word))
				counts.put(word, counts.get(word) + 1);
			else
				counts.put(word, 1);
		}

		System.out.println("the number of individual strings are " + words.length);
		Iterator<Map.Entry<String, Integer>> mapIterator = counts.entrySet().iterator();
		while (mapIterator.hasNext()) {
			Entry<String, Integer> entry = mapIterator.next();
			System.out.println(entry.getKey() + " occured " + entry.getValue() + " time(s)");
		}
	}

	public static void main(String[] args) {
		new CountOccurencesInStringWithManyWords()
				.findOccurences("these are words from a very good" + " text book and they are worth giving a shot");
	}

}
