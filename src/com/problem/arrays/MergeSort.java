package com.problem.arrays;

public class MergeSort {

	int[] sortedArray; 
	int lengthOfArray;
	int[] unsortedArray;
	int[] tempArray;
	
	private void sortUsingMergeSort(int[] input, int low, int high) {
		this.sortedArray = new int[input.length];
		this.lengthOfArray = input.length;
		this.unsortedArray = input;
		tempArray = new int[lengthOfArray];
		sortWithMergeSort(low,high);
		printArray(sortedArray);
	}
	
	
	private void sortWithMergeSort(int low, int high) {
		
		if(low < high) {
			int mid = low+(high-low)/2;
			sortWithMergeSort(low, mid);
			sortWithMergeSort(mid+1, high);
			merge(low,mid,high);
		}
		
	}

	private void merge(int low, int mid, int high) {
		
		
		for(int i=low;i<=high;i++)
			tempArray[i] = unsortedArray[i];
		int i=low,k=low,j=mid+1;
		while(i <= mid && j <= high) {
			if(tempArray[i] <= tempArray[j]) {
				sortedArray[k] = tempArray[i];
				i++;
			}
			
			else {
				sortedArray[k] = tempArray[j];
				j++;
			}
			
			k++;
		}
		
		while(i <= mid) {
			sortedArray[k] = tempArray[i];
			i++;
			k++;
		}
		
		while(j <= high-mid) {
			sortedArray[k] = tempArray[j];
			j++;
			k++;
		}
		
	}

	private void printArray(int[] input) {
		for(int i=0;i<input.length;i++) {
			System.out.println(input[i]);
		}
	}
	
	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] input = {3, 4, 1,7,2,6,8,5};
		mergeSort.sortUsingMergeSort(input, 0,input.length-1);

	}

}
