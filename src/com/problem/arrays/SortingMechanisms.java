package com.problem.arrays;

public class SortingMechanisms {
	
	
	
	/* bubble sort uses time complexity of O(N^2).. and is the least efficient sorting mechanism
	 * bubble sort uses the idea of comparing every element with its next element, if the current element
	 * is greater than the next element, then both are swapped, hence bringing the lesser element to the left side
	 * this is continued until the whole array is sorted.
	 */
	private void sortUsingBubbleSort(int[] input){
		for(int i=0;i<input.length-1;i++) {
			for(int j=i+1;j<input.length;j++) {
				if(input[i] > input[j]) {
					int temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
		}
		printArray(input);
	}
	
	/* in selection sort, the minimum element is picked and it will be added to the sorted array i.e whenever the minimum element is found, it is swapped
	 * with the first position, hence adding it to the sorted array, it is incremented then and so on until the list is sorted..*/
	private void sortUsingSelectionSort(int[] input) {
		for(int i=0;i<input.length-1;i++) {
			int minimumValueIndex = i;
			for(int j=i+1;j<input.length;j++) {
				if(input[j] < input[minimumValueIndex]) {
					minimumValueIndex = j;
				}
			}
			
			int temp = input[i];
			input[i] = input[minimumValueIndex];
			input[minimumValueIndex] = temp;
		}
		
		printArray(input);
	}
	
	

	private void printArray(int[] input) {
		for(int i=0;i<input.length;i++) {
			System.out.println(input[i]);
		}
	}

	public static void main(String[] args) {
		int[] input = {3,4,1,7,8,5,2,6};
		SortingMechanisms sortingMechanisms = new SortingMechanisms();
//		System.out.println("sorting using bubble sort");
//		sortingMechanisms.sortUsingBubbleSort(input);
//		System.out.println("_______________");
//		System.out.println("sorting using selection sort");
//		sortingMechanisms.sortUsingSelectionSort(input);
//		System.out.println("_______________");
		System.out.println("sorting using merge sort...");
		//sortingMechanisms.sortUsingMergeSort(input, 0, input.length-1);
//		System.out.println("_______________");
//		sortingMechanisms.printArray(input);

//		printArray(sortedArray);
		//sortingMechanisms.printArray();
		sortingMechanisms.sortUsingSelectionSort(input);
	}

}
