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
}
