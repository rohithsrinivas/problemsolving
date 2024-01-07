package com.interview.microsoft;

public class NumberOfIslandsInMatrix {

	public int numIslands(char[][] grid) {
		int count = 0;
		for(int i = 0 ; i < grid.length ; i++) {
			for(int j = 0 ; j < grid[i].length ; j++) {
				if(grid[i][j] == 1) {
					++count;
					markAdjacentOnes(i,j,grid);
				}
			}
		}
		return count;

	}

	private void markAdjacentOnes(int i, int j, char[][] grid) {
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
			return;
		grid[i][j] = '0';
		markAdjacentOnes(i + 1, j, grid);
		markAdjacentOnes(i - 1, j, grid);
		markAdjacentOnes(i, j + 1, grid);
		markAdjacentOnes(i, j - 1, grid);
	}

}
