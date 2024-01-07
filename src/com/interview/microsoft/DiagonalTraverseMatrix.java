package com.interview.microsoft;

public class DiagonalTraverseMatrix {
	

	// you can also use imports, for example:
	// import java.util.*;
	    public static void main(String[] args) {
	    	DiagonalTraverseMatrix sl = new DiagonalTraverseMatrix();
	        int[][] input1 = {{1,2,3},{4,5,6},{7,8,9}};
	        int[][] input2 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
	        int[][] input3 = {{1,2},{4,5},{7,8}};
	        int[][] input4 = {{1},{2},{3},{4}};
	        int[][] input5 = {{1,2,3,4}};
	        sl.findDiagonalOrder(input1);
	        sl.findDiagonalOrder(input2);
	        sl.findDiagonalOrder(input3);
	        sl.findDiagonalOrder(input4);
	        sl.findDiagonalOrder(input5);
	    }

	    public int[] findDiagonalOrder(int[][] mat) {
	        int count = 0;
	        for(int i = 0, j = 0 ; i < mat.length && j < mat[0].length;){
	            if(count % 2 == 0){
	                while(i >= 0 && j < mat[0].length - 1){
	                    System.out.println(mat[i][j]);
	                    if(i > 0)   i--;
	                    if(j < mat[0].length - 1) j++;
	                }
	                j++;
	                count++;
	                
	            }
	            else{
	                while(i < mat.length - 1 && j >= 0){
	                    System.out.println(mat[i][j]);
	                    if(i < mat.length - 1) i++;
	                    if(j > 0) j--;
	                }
	                i++;
	                count++;
	            }
	        }
	        return null;
	    }


}
