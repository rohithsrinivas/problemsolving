package com.problem.arrays;

public class MergeSort {
	
	int[] sortedAarray;
	
	public void mergeSort(int input[],int low,int high) {
		if(sortedAarray ==  null)
			this.sortedAarray = new int[input.length];
		
		if(low < high) {
			int mid = (low + high)/2;
			mergeSort(input, low, mid);
			mergeSort(input, mid+1, high);
			merge(input,low,mid,high);
		}
	}
	
	public void merge(int[] input, int low, int mid, int high) {
		
		/* declare the sizes of the sub arrays*/
		int size1 = mid- low + 1;
		int size2 = high - mid;
		
		/* initialize the sub arrays with the above defined sizes*/
		int leftArray[] = new int[size1];
		int rightArray[] = new int[size2];
		
		/* copy data from the actual array into the sub array*/
		for(int i=0;i<size1;i++)
			leftArray[i] = input[low+i];
		for(int j=0;j<size2;j++)
			rightArray[j] = input[mid+1+j];
		
		/* initialize looping variables*/
		int i=0,j=0;
		
		/* this is for the indexing of final sorted array*/
		int k = low;
		
		/* now loop through both the sub arrays one by one and put the smaller element in each comparison
		 * into the sorted array*/
		while(i < size1 && j < size2) {
			if(leftArray[i] < rightArray[j]) {
				input[k] = leftArray[i];
				i++;
			}
			else {
				input[k] = rightArray[j];
				j++;
			}
			
			k++;
		}
		
		/* add the remaining elements if any, from the left sub array*/
		while(i < size1) {
			input[k] = leftArray[i];
			i++;
			k++;
		}
		
		/* add the remaining elements if any, from the right sub array*/
		while(j < size2) {
			input[k] = rightArray[j];
			j++;
			k++;
		}
		
		this.sortedAarray = input;
	}
	
	public void printSortedArray() {
		for(int i : this.sortedAarray) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] input = {22,56,12,34,27,13,32,9};
		mergeSort.mergeSort(input, 0, input.length-1);
		mergeSort.printSortedArray();
	}
}
