package diyad.set;

public class IteratorDemo {
	public static void main(String[] args) {
		ArraySet<String> set = new ArraySet<>();
		set.add("apple");
		set.add("lemon");
		set.add("orange");
		
		for(String s : set) {
			System.out.println(s);
		}
	}
}
