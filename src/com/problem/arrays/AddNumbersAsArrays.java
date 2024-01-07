package com.problem.arrays;

import java.util.ArrayList;
import java.util.List;

public class AddNumbersAsArrays {
	
	public int[] plusOneWithFixedResultSize(int[] digits) {
        
        boolean firstDigit = true;
        int carry = 1;
        int sum = 0;
        for(int i = digits.length - 1; i >= 0 ; i--){
            sum = carry + digits[i];
            if(sum >= 10){
                carry = sum / 10;
            }
            digits[i] = sum % 10;
            
        }
        if(carry > 0) {
        	int[] result = new int[digits.length + 1];
        	result[0] = carry;
        	for(int i=0 ; i < digits.length ; i++) result[i+1] = digits[i];
            return result;
        }
        return digits;
    }
	
	public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        List<Integer> list = new ArrayList<>();
        boolean firstDigit = true;
        int carry = 0;
        int sum = 0;
        for(int i = digits.length - 1; i >= 0 ; i--){
            sum = firstDigit ? digits[i] + 1 : carry + digits[i];
            firstDigit = false;
            if(sum >= 10){
                carry = sum / 10;
            }
            result[i + 1] = sum % 10;
            list.add(i, sum % 10);
            
        }
        return null;
    }
	
	public static void main(String[] args) {
		int[] plusOne = new AddNumbersAsArrays().plusOneWithFixedResultSize(new int[] {1,7,9});
		for(int i : plusOne) {
			System.out.print(i + " ");
		}
	}

}
