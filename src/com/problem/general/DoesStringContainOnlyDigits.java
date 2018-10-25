package com.problem.general;

public class DoesStringContainOnlyDigits {
	
	private boolean doesStringContainOnlyDigits(String input) {
		try {
			Double.parseDouble(input);
		}
		catch(NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new DoesStringContainOnlyDigits().doesStringContainOnlyDigits("-1234565.45674"));
	}

}
