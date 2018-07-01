package com.problem.graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class DepthFirstSearchRecursion {

	private int numberOfVertices;

	/* we need to maintain an array of linked lists for each vertex, so that we have a chained list of all the vertices that have edges with each vertex,
	 * so that whenever we add an edge for a given vertex, then we add that vertex to the list of adjacent vertices for the source vertex*/
	private LinkedList<Integer> adj[];

	public DepthFirstSearchRecursion(int v) {
		this.adj = new LinkedList[v];
		this.numberOfVertices = v;
		for (int i = 0; i < v; i++)
			adj[i] = new LinkedList<>();
	}

	private void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	private void DFSUtil(int vertex, boolean[] visited) {
		/* first we visit the vertex and then print it to know the order and then iterate through its adjacent vertices and call the same function recursively
		 * for the first adjacent vertex, if it has not already been visited, this is done by using the visited boolean array.*/
		visited[vertex] = true;
		System.out.println(vertex + "   ");
		
		
		Iterator<Integer> adjacentVertices = adj[vertex].iterator();
		
		while (adjacentVertices.hasNext()) {
			Integer adjacentVertex = (Integer) adjacentVertices.next();
			/* check if the vertex was visited and then call the same function if it was not already visited*/
			if(!visited[adjacentVertex])
				DFSUtil(adjacentVertex, visited);
			
		}
		
	}

	private void performDFS(int source) {
		boolean visited[]  = new boolean[numberOfVertices];
		DFSUtil(source,visited);
	}

	public static void main(String[] args) {
		DepthFirstSearchRecursion dfs = new DepthFirstSearchRecursion(6);
		dfs.addEdge(1, 2);
		dfs.addEdge(1, 3);
		dfs.addEdge(2, 4);
		dfs.addEdge(2, 5);
		dfs.performDFS(1);
	}

}
