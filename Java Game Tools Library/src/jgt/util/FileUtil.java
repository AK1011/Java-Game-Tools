package jgt.util;

import java.io.File;
import java.util.ArrayList;

public class FileUtil {
	
	public static String[] getFilesIn(String dir) {
		File directory = new File(dir);
		return directory.list();
	}

	public static ArrayList<String> getTxtFileNames(String[] files, String fileType) {
		ArrayList<String> names = new ArrayList<String>();
		if (files == null) {
			return null;
		}
		for (String s : files) {
			if (s.endsWith(fileType)) {
				s = s.substring(0, s.length() - 4);
				names.add(s);
			}
		}
		return names;
	}
}
