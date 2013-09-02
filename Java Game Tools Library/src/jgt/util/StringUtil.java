package jgt.util;


public class StringUtil {
	

	public static String[] splitLineIntoArray(String s) {
		String[] content = s.split(",");
		for (int i = 0; i < content.length; i++) {
			content[i] = content[i].trim(); // TODO, not sure if it does it or just
			// returns it to be assigned
		}
		return content;
	}

	public static int[] splitLineIntoIntArray(String line) {
		return stringArrayAsIntArray(splitLineIntoArray(line));
	}

	public static int[] stringArrayAsIntArray(String[] s) {
		int[] content = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			content[i] = Integer.parseInt(s[i]); // TODO, not sure if it does it or
			// just returns it to be
			// assigned
		}
		return content;
	}

	public static String intArrayAsStringArray(int[] array) {
		String s = "" + array[0];
		for (int i = 1; i < array.length; i++) {
			s += "," + array[i];
		}
		return s;
	}
	
}
