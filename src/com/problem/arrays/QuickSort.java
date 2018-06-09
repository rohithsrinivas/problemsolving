package com.problem.arrays;

public class QuickSort {
	
	
	int[] sortedArray;

	/*
	 * partition the array on the basis of a value called pivot and divide the array
	 * into sub array such that all the elements to the left of the pivot are less
	 * than the pivot and all the elements to the right of the pivot are greater
	 * than the pivot, then apply the same algorithm for each sub array, until we
	 * have one element in each subarray, in which case it is already sorted.
	 */

	public void quickSort(int[] input, int low, int high) {
		if(sortedArray == null) {
			sortedArray = new int[input.length];
		}
		if (low < high) {
			/*
			 * dont consider pivot here for looping because it is not part of it, it is used
			 * only as a dividing element for partitioning the array
			 */
			int pivotIndex = partition(input, low, high);
			quickSort(input, low, pivotIndex - 1);
			quickSort(input, pivotIndex + 1, high);
		}
		sortedArray = input;
	}

	/* we usually choose the last element as pivot in each array and then initialize the partition index as this function is supposed to return the value
	 * with which the array is to be partitioned, so we set it to 0 initially, then we start looping from low index to high index and if an element
	 * is less than the pivot, then the partition index is incremented and it is swapped with the element present in the partition index. the main thing
	 * is that at any stage, all the elements before the partition index should be lesser than the pivot. Never touch or swap the pivot with any element
	 * it is only meant as a factor for comparisons*/
	private int partition(int[] input, int low, int high) {
		int pivot = input[high];
		int partitionIndex = low;
		for (int j = low; j < high; j++) {
			if (input[j] < pivot) {
				/* now we and swap the element at the partition index and the element which is less than the pivot increment the partition index */
				int temp = input[partitionIndex];
				input[partitionIndex] = input[j];
				input[j] = temp; 
				partitionIndex++;
			}
		}
		
		/* now the partition index is decided after the loop, now all the elements before the partition index are lesser than the pivot and all the 
		 * elements and the pivot itself are after the partition index, now we still have one thing to do. The pivot is still in the last position, but
		 * it should be in the middle of the array because the array was partitioned on the basis of pivot, so swap the element on high index with the
		 * element on the partition index*/
		int temp = input[partitionIndex];
		input[partitionIndex] = input[high];
		input[high] = temp;
		
		return partitionIndex;
	}
	
	private void print() {
		for(int i : sortedArray) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int[] input = {3,4,8,5,1,7,6,2};
		quickSort.quickSort(input, 0, input.length-1);
		quickSort.print();
	}

}
