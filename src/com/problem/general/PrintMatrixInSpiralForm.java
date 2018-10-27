package com.problem.general;

public class PrintMatrixInSpiralForm {

	private void printMatrixInSpiralForm(int[][] input, int rows, int columns) {
		int i = 0, rowIndex = 0, columnIndex = 0;
		while (rowIndex < rows && columnIndex < columns) {
			/* we need to print the first row first, so the rowIndex will be fixed */
			for (i = columnIndex; i < columns; i++)
				System.out.print(input[rowIndex][i] + " ");
			/* as we are printing the first row, increment the rowIndex*/
			rowIndex++;
			/*now we should print the last column, so the column index will be columns - 1*/
			for (i = rowIndex; i < rows; i++)
				System.out.print(input[i][columns-1] + " ");
			/* decrement the columns as we are printing from last*/
			columns--;
			/* to avoid overlooping*/
			if (rowIndex < rows) {
				/* now print the last row*/
				for (i = columns - 1; i >= columnIndex; i--)
					System.out.print(input[rows-1][i] + " ");
				rows--;
			}
			if (columnIndex < columns) {
				/* now print the first column*/
				for (i = rows - 1; i >= rowIndex; i--)
					System.out.print(input[i][columnIndex] + " ");
				columnIndex++;
			}
		}

	}

	public static void main(String[] args) {
		int rows = 3;
		int columns = 6;
		int input[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
		new PrintMatrixInSpiralForm().printMatrixInSpiralForm(input, rows, columns);
	}

}
