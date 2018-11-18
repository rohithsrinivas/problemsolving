package com.problem.general;

public class ManipulateDate {

	private String changeDate(String date, int n) {
		String[] dateValues = date.split("-");
		String newDate;
		Integer dayOfMonth = Integer.parseInt(dateValues[0]);
		Integer monthOfYear = Integer.parseInt(dateValues[1]);
		Integer year = Integer.parseInt(dateValues[2]);
		if (dayOfMonth + n >= getNumberOfDaysInMonth(monthOfYear) && monthOfYear == 12) {
			dayOfMonth = dayOfMonth + n - getNumberOfDaysInMonth(monthOfYear);
			monthOfYear = 1;
			year++;
		} else if (dayOfMonth + n >= getNumberOfDaysInMonth(monthOfYear) && monthOfYear != 12) {
			dayOfMonth = dayOfMonth + n - getNumberOfDaysInMonth(monthOfYear);
			monthOfYear++;
		} else {
			dayOfMonth += n;
		}

		return dayOfMonth + "-" + monthOfYear + "-" + year;
	}

	public int getNumberOfDaysInMonth(int month) {
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			return 28;
		default:
			return 0;
		}
	}

	public static void main(String[] args) {
		System.out.println(new ManipulateDate().changeDate("29-12-2018", 5));
	}

}
