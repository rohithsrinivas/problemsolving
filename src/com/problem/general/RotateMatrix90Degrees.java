package com.problem.general;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RotateMatrix90Degrees {

	private int[][] rotateMatrix90DegreeToLeft(int[][] input) {

		/*
		 * first step is to transpose the matrix, i.e rows will be columns and columns
		 * will be rows
		 */
		for (int i = 0; i < input.length; i++) {
			for (int j = i; j < input.length; j++) {
				int temp = input[i][j];
				input[i][j] = input[j][i];
				input[j][i] = temp;
			}
		}

		for (int i = 0; i < input.length; i++) {
			for (int j = 0, k = input.length - 1; j < k; j++, k--) {
				int temp = input[k][i];
				input[k][i] = input[j][i];
				input[j][i] = temp;
			}
		}

		return input;
	}

	private int[][] rotateMatrix90DegreeToRight(int[][] input) {

		for (int i = 0; i < input.length; i++) {
			for (int j = i; j < input.length; j++) {
				int temp = input[i][j];
				input[i][j] = input[j][i];
				input[j][i] = temp;
			}
		}

		for (int i = 0, k = input.length - 1; i < k; i++, k--) {
			for (int j = 0; j < input.length; j++) {
				int temp = input[i][k];
				input[i][k] = input[i][j];
				input[i][j] = temp;

			}
		}

		return input;
	}

	public static void main(String[] args) {
		int[][] input = new int[3][3];
		input[0][0] = 1;
		input[0][1] = 2;
		input[0][2] = 3;
		input[1][0] = 4;
		input[1][1] = 5;
		input[1][2] = 6;
		input[2][0] = 7;
		input[2][1] = 8;
		input[2][2] = 9;
		System.out.println("before rotating matrix");
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
		int[][] result = new RotateMatrix90Degrees().rotateMatrix90DegreeToLeft(input);
		System.out.println("after rotating matrix");
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		
		List<Integer> list = new LinkedList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			Integer number = iterator.next();
			System.out.println(number);
			iterator.remove();
		}
		
		System.out.println(list);
	}

}
