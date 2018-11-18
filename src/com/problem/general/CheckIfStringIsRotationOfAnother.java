package com.problem.general;

public class CheckIfStringIsRotationOfAnother {

	/*
	 * The problem is to check if a string is rotation of another i.e if a string is
	 * rotated from an index then another is string is created, example pleap is a
	 * rotation of apple, and hithro is a rotation of rohith, rotated on an index,
	 * so for any rotation, if we concat the first string with itself, we will again
	 * definitely have the full string in it, if it is a rotation, eg : hithrohithro
	 * will have rohith which is the original string, so simply concat first with
	 * itself and check if second is a substring of the first
	 */
	private boolean isStringRotationOfAnother(String first, String second) {
		int firstLength = first.length();
		if (firstLength == second.length() && firstLength > 0) {
			String firstDual = first + first;
			return firstDual.contains(second);
		}
		return false;
	}
	

	public static void main(String[] args) {
		System.out.println(new CheckIfStringIsRotationOfAnother().isStringRotationOfAnother("apple", "pplae"));
	}

}
