package diyad.set;

import java.util.*;

public class SimpleSetBenchmark {
	
	/**
	 * Create list of random "strings" to return
	 * @param factor how many times each element is added
	 * @param unique # different/unique elements to add
	 * @return list of factor*unique elements, with 
	 * # different elements equal to unique
	 */
	static ArrayList<String> getBenchData(int factor, int unique) {
		ArrayList<String> ret = new ArrayList<>();
		
		for(int k=0; k < unique; k++) {
			String s = Integer.toString(k);
			for(int j=0; j < factor; j++) {
				ret.add(s);
			}
		}	
		return ret;
	}
	
	/**
	 * Add all elements of data to set
	 * @param dat list of strings to add to set
	 * @param set being added to
	 * @return time to add all elements
	 */
	static double benchmarkArray(ArrayList<String> data, ArraySet<String> set) {
		double start = System.nanoTime();
		for(String s : data) {
			set.add(s);
		}
		double end = System.nanoTime();
		return (end-start)/1e9;
	}
	
	/**
	 * Add all elements of data to set
	 * @param dat list of strings to add to set
	 * @param set being added to
	 * @return time to add all elements
	 */
	static double benchmarkHash(ArrayList<String> data, SimpleHashSet<String> set) {
		double start = System.nanoTime();
		for(String s : data) {
			set.add(s);
		}
		double end = System.nanoTime();
		return (end-start)/1e9;
	}
	
	public static void main(String[] args) {
		
		ArraySet<String> aset = new ArraySet<>();
		SimpleHashSet<String> hset = new SimpleHashSet<>();
		
		for(int k=10000; k <= 100000; k += 10000) {
			ArrayList<String> data = getBenchData(4,k);
			double atime = benchmarkArray(data,aset);
			double htime = benchmarkHash(data,hset);
			
			if (aset.size() != k) {
				System.out.printf("failed for array %d with %d\n",k,aset.size());
			}
			if (hset.size() != k) {
				System.out.printf("failed for hash %d with %d\n",k,hset.size());
			}
			aset.clear();
			hset.clear();
			System.out.printf("%d,%1.3f,%1.3f\n",k,atime,htime);
		}
	}
}
