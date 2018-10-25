package com.problem.general;

public class PrintMatrixInSpiralForm {

	private void printMatrixInSpiralForm(int[][] input, int rows, int columns) {
		int i = 0, rowIndex = 0, columnIndex = 0;
		while (rowIndex < rows && columnIndex < columns) {
			/* initially print the first row */
			for (i = columnIndex; i < columns; i++)
				System.out.print(input[rowIndex][i] + " ");
			/* increment the row index, because we finished printing one row */
			rowIndex++;
			/* now print the last column */
			for (i = rowIndex; i < rows; i++)
				System.out.print(input[i][columns - 1] + " ");
			/* increment the column index, as we finished printing the last column */
			columns--;
			/* now print the last row */
			if (rowIndex < rows) {
				for (i = columns - 1; i >= columnIndex; i--)
					System.out.print(input[rows - 1][i] + " ");
				rows--;
			}
			/* now print the first column */
			if (columnIndex < columns) {
				for (i = rows-1; i >= rowIndex; i--)
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
