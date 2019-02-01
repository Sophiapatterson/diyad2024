package diyad.set;

import java.util.ArrayList;


public class SimpleHashSet<Type> {
	protected ArrayList<ArrayList<Type>> myElements;
	protected int mySize;
	public static int BUCKET_SIZE = 10000;
	
	private int getHash(Type elt){
		int hval = Math.abs(elt.hashCode());
		return hval % myElements.size();
	}
	
	public SimpleHashSet() {
		myElements = new ArrayList<ArrayList<Type>>();
		for(int k=0; k < BUCKET_SIZE; k++) {
			myElements.add(new ArrayList<>());
		}
		mySize = 0;
	}
	
	/**
	 * Determine if an element is in this set
	 * @param elt is the query element
	 * @return true if elt in set, else false
	 */
	public boolean contains(Type elt){
		int index = getHash(elt);
		return myElements.get(index).contains(elt);
	}
	
	/**
	 * Returns size of set
	 * @return number of elements in this set
	 */
	public int size() {
		return mySize;
	}
	
	/**
	 * Remove an element from the set (mirrors
	 * method from java.util.Set)
	 * @param o object to be removed
	 * @return true if object removed, false otherwise
	 */
	public boolean remove(Object o) {
		int index = getHash((Type) o);
		if (myElements.get(index).contains(o)) {
			myElements.get(index).remove(o);
			return true;
		}
		return false;
	}
	
	/**
	 * Determine if this set is empty
	 * @return true if set empty, otherwise false
	 */
	public boolean isEmpty() {
		return size() == 0;
	}
	
	/**
	 * Add an element to the set
	 * @param elt to be added
	 * @return true if element added, false if not
	 */
	public boolean add(Type elt){
		int index = getHash(elt);
		
		if (myElements.get(index).contains(elt)) {
			return false;
		}
		myElements.get(index).add(elt);
		mySize++;
		return true;
	}
	
	/**
	 * Make this set empty
	 */
	public void clear() {
		for(int k=0; k < myElements.size(); k++) {
			myElements.get(k).clear();
		}
		mySize = 0;
	}
}
