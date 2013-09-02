package jgt.util;

public class CollisionUtil {

	public static boolean pointIsInBuffer(int px, int py, int buffer, int x, int y, int width, int height) {
		return px + buffer > x && px - buffer < x + width && py + buffer > y && py - buffer < y + height;
	}

	public static boolean pointIsInOrTouching(int px, int py, int x, int y, int width, int height) {
		return pointIsInBuffer(px, py, 1, x, y, width, height);
	}

	public static boolean pointIsIn(int px, int py, int x, int y, int width, int height) {
		return pointIsInBuffer(px, py, 0, x, y, width, height);
	}
	
}
