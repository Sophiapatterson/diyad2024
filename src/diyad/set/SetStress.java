package diyad.set;

import java.util.HashSet;

public class SetStress {
	public static HashSet<String> ourWords = new HashSet<>();

	public static void loadSet(int words) {
		ourWords.clear();
		for(int k=10000; k < 10000+words; k++) {
			ourWords.add(Integer.toString(k));
		}
	}
	public static double stress(LinkHashStringSet set) {
		double start = System.nanoTime();
		assert(set.size() == 0);
		for(String s : ourWords) {
			set.add(s);
		}
		for(String s : ourWords) {
			boolean val = set.add(s);
			assert(val == false);
		}
		assert(set.size() == ourWords.size());
		for(String s : ourWords) {
			set.remove(s);
		}
		assert(set.size() == 0);
		
		
		double end = System.nanoTime();
		return (end-start)/1e9;
	}
	
	public static void main(String[] args) {
		
		
		for(int k=10000; k <= 80000; k += 10000) {
			LinkHashStringSet set = new LinkHashStringSet();
			//ArraySet set = new ArraySet();
			//SimpleHashSet<String> set = new SimpleHashSet<>();
			loadSet(k);
			double time = stress(set);
			System.out.printf("%d\t%1.3f\n", k,time);
		}
	}

}
