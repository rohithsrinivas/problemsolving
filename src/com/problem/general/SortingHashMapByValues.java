package com.problem.general;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class SortingHashMapByValues {
	
	public Map<String, Integer> sortHashmapByValues(Map<String, Integer> input){
		List<Entry<String, Integer>> entrySet = new LinkedList<Entry<String, Integer>>(input.entrySet());
		Collections.sort(entrySet, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		entrySet.stream().forEach(entry -> {
			sortedMap.put(entry.getKey(), entry.getValue());
		});
		return sortedMap;
		
	}
	
	public Map<String, Integer> sortHashmapByValuesJava8(Map<String, Integer> input){
		List<Entry<String, Integer>> entrySet = new LinkedList<Entry<String, Integer>>(input.entrySet());
		LinkedHashMap<String, Integer> sorted = entrySet.stream().sorted((e1,e2) -> {
			return e1.getValue().compareTo(e2.getValue());
		}).collect(Collectors.toMap(Entry::getKey, Entry::getValue, (a,b) -> b, LinkedHashMap::new));
		return sorted;
	}
	public static void main(String[] args) {
		Map<String, Integer> input = new HashMap<>();
		input.put("aaaa",5);
		input.put("bbbb",4);
		input.put("ccc", 6);
		System.out.println(new SortingHashMapByValues().sortHashmapByValuesJava8(input));
	}

}
