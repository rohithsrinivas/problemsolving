package com.problem.general;

public class PrintName100TimesWithoutLoop {
	
	private void printName(String name , int count) {
		if(count > 100)
			return;
		System.out.println(name +" "+count);
		printName(name, ++count);
	}

	public static void main(String[] args) {
		new PrintName100TimesWithoutLoop().printName("rohith", 1);
	}

}
