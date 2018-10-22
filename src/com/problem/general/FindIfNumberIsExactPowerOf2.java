package com.problem.general;

public class FindIfNumberIsExactPowerOf2 {

	float decimalNumber;

	private boolean findIfNumberIsExactPowerOf2(int number) {
//		while (number != 1) {
//			if (number % 2 != 0) {
//				return false;
//			}
//			number = number / 2;
//
//		}

		return checkRecursively(number);
	}

	private boolean checkRecursively(int number) {
		if (number != 1) {
			if (number % 2 != 0) {
				return false;
			} else {
				return checkRecursively(number / 2);
			}
		}
		return true;

	}

	public static void main(String[] args) {
		boolean findIfNumberIsExactPowerOf2 = new FindIfNumberIsExactPowerOf2().findIfNumberIsExactPowerOf2(64);
		System.out.println(findIfNumberIsExactPowerOf2);
	}

}
