package com.problem.arrays;

public class PairsSumIsGivenNumberHighComplexity {
	
	public  static void main(String[] args) {
		findThePairsWhoseSumIsGivenNumber(23);
	}

	/* loop through the list and check that for each element with all other elements
	 * if the sum will the desired sum, to avoid duplicates, a[i] should not be equal to
	 * a[j] and to avoid a[i]+a[j] and a[j]+a[i], we assign 0 to a[i] so that it wont 
	 * be checked again, the time complexity is O(n*n) */
	private static void findThePairsWhoseSumIsGivenNumber(int desiredSum) {
		int a[] = {1,22,-7,9,10,12,4,3,3};
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]!=a[j]) {
				if((a[i]+a[j]) == desiredSum) {
					System.out.println("("+a[i]+","+a[j]+")");
				}
				}
			}
		}
		
	}

}
