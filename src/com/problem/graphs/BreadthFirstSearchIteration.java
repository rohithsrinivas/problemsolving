package com.problem.graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class BreadthFirstSearchIteration {

	private int numberOfVertices;

	private LinkedList<Integer> adj[];

	public BreadthFirstSearchIteration(int v) {
		this.numberOfVertices = v;
		this.adj = new LinkedList[v];
		for (int i = 0; i < this.numberOfVertices; i++)
			adj[i] = new LinkedList<>();
	}

	private void BFSUtil(int vertex, boolean[] visited) {

		/*
		 * this queue is for storing all the vertices which need to be visited, we add
		 * the source initially in this queue, mark it as visited, then pop the queue
		 * and iterate through all the vertices and push it to the queue if it is
		 * unvisited
		 */
		LinkedList<Integer> queue = new LinkedList<>();
		/*
		 * initially make the source vertex as visited and add it to the queue. then
		 * after that pop the source vertex and push all the unvisited adjacent vertices
		 * to the queue.
		 */
		visited[vertex] = true;
		queue.add(vertex);

		while (queue.size() > 0) {
			/*
			 * polling in a list is popping in the queue. pop the queue for the element,
			 * print it and then visit all its adjacent vertices and add it if it is
			 * unvisited
			 */
			vertex = queue.poll();
			System.out.println(vertex + "  ");

			/*
			 * now iterate through the adjacent vertices of each vertex and then add it to
			 * the queue if it is unvisited
			 */
			Iterator<Integer> iterator = adj[vertex].iterator();
			while (iterator.hasNext()) {
				Integer currentVertex = (Integer) iterator.next();
				if (!visited[currentVertex]) {
					visited[currentVertex] = true;
					queue.add(currentVertex);
				}
			}
		}

	}

	private void performBFS(int source) {
		boolean[] visited = new boolean[numberOfVertices];
		BFSUtil(source, visited);
	}

	private void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	public static void main(String[] args) {
		BreadthFirstSearchIteration bfs = new BreadthFirstSearchIteration(6);
		bfs.addEdge(1, 2);
		bfs.addEdge(1, 3);
		bfs.addEdge(2, 4);
		bfs.addEdge(2, 5);
		bfs.performBFS(1);
	}

}
