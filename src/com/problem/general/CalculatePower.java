package com.problem.general;

public class CalculatePower {

	/* this algorithm will take an average case complexity of theta(y)*/
	public Long calculatePower(int x, int y) {
		Long product = 1l;
		for (int i = 0; i < y; i++) {
			product *= x;
		}
		return product;
	}

	/*
	 * this will further reduce the complexity, we can make it logarthamic by first
	 * recursively computing the power by reducing it to half, then check, if it is
	 * even, then just square it, if it is odd, then we need to multiply it with x
	 * again i.e 2 power 5 5/2 = 2 --> 2/2 = 1 --> 1/2 = 0 --> return 1, moving up,
	 * y = 1, 1 is odd, so 1*1*2 i.e 2 power 1 =2, then moving up again, temp = 2, y
	 * = 2, y is even so 2*2 = 4, moving up again,... finally we get 2 power 5 is 32
	 */
	public Long calculatePowerRecursion(int x, int y) {
		long temp = 0;
		if (y == 0)
			return 1l;
		temp = calculatePower(x, y / 2);
		if (y % 2 == 0)
			return temp * temp;
		else
			return temp * temp * x;

	}

	public static void main(String[] args) {
		System.out.println(new CalculatePower().calculatePowerRecursion(3, 5));

	}
}
