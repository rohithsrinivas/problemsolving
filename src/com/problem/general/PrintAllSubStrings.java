package com.problem.general;

public class PrintAllSubStrings {

	private void printAllSubStrings(String input) {
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j <= input.length(); j++) {
				System.out.println(input.substring(i, j));
			}
		}
	}
	
//	private void printAllSubStringsWithoutSubStr(String input) {
//		for(int i = 0 ; i < input.length() ; i++) {
//			for(int j = 0 ; j <= input.length() - i ; j++) {
//				int len = i + j;
//				for(int k = i ; k < len ; k++) {
//					System.out.println(input.charAt(k));
//				}
//			}
//		}
//	}

	public static void main(String[] args) {
		PrintAllSubStrings printAllSubStrings = new PrintAllSubStrings();
		printAllSubStrings.printAllSubStrings("rohith");
	}

}
