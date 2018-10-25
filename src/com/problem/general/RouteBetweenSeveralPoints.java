package com.problem.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class RouteBetweenSeveralPoints {
	
	public List<List<Integer>> getBestRouteForDestinations(List<List<Integer>> locations, int numberOfDestinations) {
		List<Integer> initialSource = new ArrayList<>();
		initialSource.add(0);
		initialSource.add(0);
		return getBestRouteForDestinations(locations, numberOfDestinations,initialSource,new ArrayList<>());
	}

	private List<List<Integer>> getBestRouteForDestinations(List<List<Integer>> locations, int numberOfDestinations,
			List<Integer> source, List<List<Integer>> shortestRoute) {
		if(numberOfDestinations == 0)
			return shortestRoute;
		List<Integer> shortestFromSource = null;
			shortestFromSource = findLeastDistanceLocation(source, locations);
			locations.remove(shortestFromSource);
			shortestRoute.add(shortestFromSource);

		return getBestRouteForDestinations(locations, --numberOfDestinations,shortestFromSource,shortestRoute);
	}

	private List<Integer> findLeastDistanceLocation(List<Integer> source, List<List<Integer>> locations) {
		TreeMap<Double, List<Integer>> distances = new TreeMap<>();
		locations.stream().forEach(location -> {
			distances.put(findDistance(source, location), location);
		});
		return distances.pollFirstEntry().getValue();
	}

	private Double findDistance(List<Integer> source, List<Integer> destination) {
		Integer x = source.get(0) - destination.get(0);
		Integer y = source.get(1) - destination.get(1);
		return Math.sqrt(x * x + y * y);
	}

	public static void main(String[] args) {
		RouteBetweenSeveralPoints routeBetweenSeveralPoints = new RouteBetweenSeveralPoints();
		List<List<Integer>> locations = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Random random = new Random();
			List<Integer> location = new ArrayList<>();
			location.add(random.nextInt(20));
			location.add(random.nextInt(10));
			locations.add(location);
		}
		List<List<Integer>> bestRouteForDestinations = routeBetweenSeveralPoints.getBestRouteForDestinations(locations, 10);
		System.out.println("the best route for given locations is ");
		bestRouteForDestinations.stream().forEach(location -> {
			System.out.print(location+" --> ");
		});
		System.out.println("DONE");
	}

	

}
