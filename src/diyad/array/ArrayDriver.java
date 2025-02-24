package diyad.array;

import java.io.*;
import java.util.*;
import diyad.FileChooser;

public class ArrayDriver {

	public static int read(File f) throws FileNotFoundException {
		Scanner scan = new Scanner(f);
		scan.useDelimiter("\\S+");
		int w = 0;
		while (scan.hasNext()) {
			String s = scan.next();
			w++;
		}
		scan.close();
		return w;
	}
	public static int readArray(File f) throws FileNotFoundException {
		Scanner scan = new Scanner(f);
		scan.useDelimiter("\\S+");
		
		//SimpleStringArrayList ssa = new SimpleStringArrayList();
		GrowableStringArrayList ssa = new GrowableStringArrayList();
		//ConformingArrayList<String> ssa = new ConformingArrayList<>();
		while (scan.hasNext()) {
			String s = scan.next();
			ssa.add(s);
		}
		scan.close();
		return ssa.size();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		File f = FileChooser.selectFile();
		double start = System.nanoTime();
		int count = read(f);
		double end = System.nanoTime();
		double time = (end-start)/1e9;
		
		System.out.printf("%2.3f for %d words\n", time,count);
		
		start = System.nanoTime();
        count = readArray(f);
		end = System.nanoTime();
		time = (end-start)/1e9;
		
		System.out.printf("%2.3f for %d words\n", time,count);
	}
}
