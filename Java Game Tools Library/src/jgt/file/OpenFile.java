package jgt.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class OpenFile {
	
	private String name;
	private ArrayList<String> lines;
	private int line;
	
	public OpenFile(String name) {
		this(name, new ArrayList<String>());
	}
	
	public OpenFile(String name, ArrayList<String> lines) {
		this.name = name;
		this.lines = lines;
		this.line = 0;
	}
	
	public String readLine(int line) {
		this.line = line;
		return lines.get(this.line++);
	}
	
	public String readLine() {
		return readLine(this.line);
	}
	
	public void writeLine(String line, int index) {
		lines.add(index, line);
	}
	
	public void writeLine(String line) {
		lines.add(line);
	}
	
	public void overwriteLine(String line, int index) {
		lines.set(index,  line);
	}
	
	public static OpenFile openFile(String filename) {
		ArrayList<String> lines = new ArrayList<String>();
		try {
			Scanner infile = new Scanner (new File(filename));
			while (infile.hasNextLine()) {
				lines.add(infile.nextLine());
			}
			infile.close();
		} catch (FileNotFoundException e) {
			createFile(filename);
		}
		return new OpenFile(filename, lines);
	}
	
	public static OpenFile createFile(String filename) {
		try {
			int lastDir = filename.lastIndexOf("/");
			File file = new File(filename.substring(0, lastDir));
			if (lastDir != -1) {
				file.mkdir();
			}
			PrintWriter writer = new PrintWriter(filename);
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error creating file: " + filename);			
		}
		return new OpenFile(filename);
	}
	
	public static OpenFile loadExistingFile(String filename) {
		ArrayList<String> lines = new ArrayList<String>();
		try {
			Scanner infile = new Scanner (new File(filename));
			while (infile.hasNextLine()) {
				lines.add(infile.nextLine());
			}
			infile.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error reading file: " + filename);
		}
		return new OpenFile(filename, lines);
	}
	
	public static void saveFile(OpenFile file) {
		try {
			PrintWriter writer = new PrintWriter(file.name);
			for (String line : file.lines) {
				writer.println(line);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error reading file: " + file.name);
		}
		
	}
	
}
