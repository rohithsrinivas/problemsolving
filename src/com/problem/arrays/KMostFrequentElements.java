package com.problem.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class KMostFrequentElements {

	public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
		Comparator<K> valueComparator = new Comparator<K>() {
			public int compare(K k1, K k2) {
				int compare = map.get(k1).compareTo(map.get(k2));
				if (compare == 0)
					return 1;
				else
					return compare;
			}
		};

		Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}

	private void printKMostFrequentElements(int k) {
		List<Integer> input = Arrays.asList(1, 2, 6, 3, 2, 8, 9, 3, 5, 5, 3, 1, 1);
		TreeMap<Integer, Integer> elementCounts = new TreeMap<Integer, Integer>();
		input.stream().forEach(element -> {
			if (elementCounts.containsKey(element)) {
				elementCounts.put(element, elementCounts.get(element).intValue() + 1);
			} else {
				elementCounts.put(element, 1);
			}
		});
		System.out.println("these are the frequencies ____");
		elementCounts.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
		System.out.println("after sorting by values");
		TreeMap<Integer, Integer> tempMap = (TreeMap<Integer, Integer>) sortByValues(elementCounts);
		tempMap.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
		// elementCounts.entrySet().stream().sorted(new ValueComparator()).map(entry ->
		// entry).collect(Collectors.toMap(Entry::getKey,Entry::getValue));
		for (int i = 1; i <= k; i++)
			System.out.println(tempMap.pollLastEntry().getKey());

	}

	class ValueComparator implements Comparator<Map.Entry<Integer, Integer>> {

		@Override
		public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
			return (o1.getValue().compareTo(o2.getValue()));
		}

	}

	private void printKMostFrequentElementsWithoutComparator(int k) {
		List<Integer> input = Arrays.asList(1, 2, 6, 3, 2, 8, 9, 3, 5, 5, 3, 1, 1);
		/* O(n) for finding frequencies into the map and O(n) space complexity for the storage of map*/
		Map<Integer, Integer> elementCounts = new HashMap<Integer, Integer>();
		/* first maintain a map with all the keys with their respective frequencies */
		input.stream().forEach(element -> {
			if (elementCounts.containsKey(element)) {
				elementCounts.put(element, elementCounts.get(element).intValue() + 1);
			} else {
				elementCounts.put(element, 1);
			}
		});
		/*
		 * now maintain an array of lists, such that the index will be the frequency of
		 * a particular number in the array and the value at the index will be number
		 * which is occuring "index" number of times
		 */
		/*
		 * the reason we need to have input.size() + 1, is because we dont want any
		 * numbers which are occurring 0 number of times
		 * 
		 * the array should be such that, the index will be the number of times the
		 * particular element at the index occurred.
		 */
		ArrayList<Integer> frequencies[] = new ArrayList[input.size() + 1];
		for (int i = 0; i < frequencies.length; i++) {
			frequencies[i] = new ArrayList<Integer>();
		}
		/* instantiate all the indexes in the array with arraylist instances */
		elementCounts.entrySet().stream().forEach(entry -> {
			ArrayList<Integer> listOfKeys = frequencies[entry.getValue()];
			listOfKeys.add(entry.getKey());
		});
		for (int i = 0; i < frequencies.length; i++) {
			if (frequencies[i].size() > 0) {
				System.out.print("elements ");
				frequencies[i].stream().forEach(integer -> System.out.print(" " + integer));
				System.out.print(" have occured " + i + " times");
				System.out.println("\n");
			}
		}

		System.out.println(k + " elements occuring most frequently are : ");
		int printedElementCount = 0;

		for (int i = frequencies.length - 1; i > 0; i--) {

			if (frequencies[i].size() != 0) {
				for (Integer number : frequencies[i]) {
					if (printedElementCount < k) {
						System.out.println(number);
						printedElementCount++;
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		new KMostFrequentElements().printKMostFrequentElementsWithoutComparator(2);
	}
}
