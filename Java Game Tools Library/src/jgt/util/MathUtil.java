package jgt.util;

public class MathUtil {
	
	public static int roundTo(int num, int precision) {
		int remainder = num % precision;
		if (remainder >= precision / 2.0) {
		num += (precision - remainder);
		} else {
		num -= remainder;
		}
		return num;
	}
	
	public static double distance(int x1, int y1, int x2, int y2) {
		int dx = Math.abs(x1 - x2);
		int dy = Math.abs(y1 - y2);
		return (double) Math.sqrt(dx * dx + dy * dy);
	}
	
	public static double sum(double ... nums) {
		double sum = 0;
		for (double d : nums) {
			sum += d;
		}
		return sum;
	}
	
	public static double average(double ... nums) {
		double sum = sum(nums);
		return sum / nums.length;
	}
}
