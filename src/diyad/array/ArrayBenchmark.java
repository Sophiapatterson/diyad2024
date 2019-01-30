package diyad.array;

public class ArrayBenchmark {
	
	public static double addStrings(int n){
		//System.gc();
		double start = System.nanoTime();
		GrowableStringArrayList gsa = new GrowableStringArrayList();
		for(int k=0; k < n; k++) {
			//gsa.add(0,"hello");
			gsa.add("hello");
		}
		double end = System.nanoTime();
		if (gsa.size() != n) {
			throw new RuntimeException(String.format("bad size %d expected %d",gsa.size(),n));
		}
		return (end-start)/1e9;
	}
	
	public static void main(String[] args){
		
		int start = 100000;
		int end = 1000000;
		int incr = 100000;
		
		System.out.printf("size\ttime\n");
		for(int size = start; size <= end; size += incr){
			double time = addStrings(size);
			System.out.printf("%10d\t%2.3f\n",size,time);
		}
	}
}
