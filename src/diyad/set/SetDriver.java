package diyad.set;

public class SetDriver {
	public static void main(String[] args) {
		ArraySet<String> set = new ArraySet<>();
		//SimpleHashSet<String> set = new SimpleHashSet<>();
		String[] elts = {"ant", "bat", "cat", "dog"};
		
		for(String s : elts) {
			System.out.printf("%s %s\n", s,set.add(s));
		}
		
		for(String s : elts) {
			System.out.printf("%s %s\n", s,set.add(s));
		}
		
		for(String s : elts) {
			System.out.printf("%s %s\n", s,set.remove(s));
		}
		
		for(String s : elts) {
			System.out.printf("%s %s\n", s,set.remove(s));
		}
	}
}
