package diyad.set;

import java.util.*;

/**
 * This class implements a set of generic
 * Java types using an ArrayList. 
 * As a result, most operations are O(n)
 * @author ola

 */

public class ArraySet<Type> implements Iterable<Type>{
	
	private ArrayList<Type> myElements;
	
	public ArraySet() {
		myElements = new ArrayList<>();
	}
	
	/**
	 * Determine if an element is in this set
	 * @param elt is the query element
	 * @return true if elt in set, else false
	 */
	public boolean contains(Type elt){
		for(Type e : myElements) {
			if (e.equals(elt)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns size of set
	 * @return number of elements in this set
	 */
	public int size() {
		return myElements.size();
	}
	
	/**
	 * Remove an element from the set (mirrors
	 * method from java.util.Set)
	 * @param o object to be removed
	 * @return true if object removed, false otherwise
	 */
	public boolean remove(Object o) {
		for(Type e : myElements) {
			if (e.equals(o)) {
				myElements.remove(o);
				return true;
			}
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
	 * Return iterator for this set
	 * @return the iterator for all elements of this set
	 */
	public Iterator<Type> iterator() {
		return myElements.iterator();
	}
	
	/**
	 * Add an element to the set
	 * @param elt to be added
	 * @return true if element added, false if not
	 */
	public boolean add(Type elt){
		if (contains(elt)) {
			return false;
		}
		myElements.add(elt);
		return true;
	}
	
	/**
	 * Make this set empty
	 */
	public void clear() {
		myElements.clear();
	}
}
