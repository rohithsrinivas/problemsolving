package com.problem.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MakeRowAndColumnZeroIfElementIsZero {
	
	/* the idea is to maintain a set which will store the row and column number of all the indexes where there is a zero
	 * in our input matrix, but this will take a lot of space and time*/
	private int[][] makeRowAndColumnZeroIfElementIsZero(int[][] inputMatrix){
		Set<List<Integer>> zeroLocations = new HashSet<>();
		for(int i = 0 ; i < inputMatrix.length ; i++) {
			for(int  j = 0; j < inputMatrix[0].length ; j++) {
				if(inputMatrix[i][j] == 0) {
					List<Integer> index = new ArrayList<>();
					index.add(i);
					index.add(j);
					zeroLocations.add(index);
				}
			}
		}
		for(int i = 0 ; i < inputMatrix.length ; i++) {
			for(int j = 0 ; j < inputMatrix[0].length ; j++) {
				List<Integer> index = new ArrayList<>();
				index.add(i);
				index.add(j);
				if(inputMatrix[i][j] == 0 && zeroLocations.contains(index)) {
					int rowIndex = i,columnIndex = j;
					for(int k = 0 ; k < inputMatrix[0].length ; k++) 
						inputMatrix[rowIndex][k] = 0;
					for(int l = 0 ; l < inputMatrix.length ; l++)
						inputMatrix[l][columnIndex] = 0;
				}
			}
		}
		
		return inputMatrix;
	}
	
	/* the important point here is that as soon as we find a zero we simply need to make the whole row and column empty,
	 * so we first make 2 1d arrays for rows and columns marked as 1 for the rows and columns containing zeroes, then we have the
	 * row and column numbers where the zeroes are present, now we iterate through the array as usual and check if the row index
	 * or the column index is zero, then we simply assign it to zero, so for all the elements in a row which contains zero,
	 * the value of rowsWithZeroes[i] will always be zero, so the whole row for all the columns will be assigned with zero, then the
	 * same applies for columns, for a column, no matter the corresponding row, columnsWithZeroes[i] will be 1, hence making the
	 * whole column as zero*/
	private int[][] makeRowAndColumnZeroWithLessSpace(int[][] inputMatrix){
		int[] rowsWithZeroes = new int[inputMatrix.length];
		int[] columnsWithZeroes = new int[inputMatrix[0].length];
		for(int i = 0 ; i  < inputMatrix.length ; i++) {
			for(int  j = 0 ; j < inputMatrix[0].length ; j++) {
				if(inputMatrix[i][j] == 0) {
					rowsWithZeroes[i] = 1;
					columnsWithZeroes[j] = 1;
				}
			}
		}
		
		for(int i = 0 ; i < inputMatrix.length ; i++) {
			for(int j = 0 ; j < inputMatrix[0].length ; j++) {
				if(rowsWithZeroes[i] == 1 || columnsWithZeroes[j] == 1)
					inputMatrix[i][j] = 0;
			}
		}
		
		return inputMatrix;
	}
	
	private static void printMatrix(int[][] input) {
		for(int i = 0 ; i < input.length ; i++) {
			for(int j = 0 ; j < input[0].length ; j++)
				System.out.print(input[i][j]+" ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		MakeRowAndColumnZeroIfElementIsZero transform = new MakeRowAndColumnZeroIfElementIsZero();
		int[][] input = {{1,1,1},{1,0,1},{1,1,1}};
		System.out.println("before replacing zeroes");
		printMatrix(input);
		System.out.println("after replacing zeroes");
		printMatrix(transform.makeRowAndColumnZeroWithLessSpace(input));
	}

}
