package diyad.set;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Extend the SimpleHashSet by creating an inner
 * class that implements Iterator, so that this
 * class can implement the Iterable interface
 * @author ola
 * @version 1.0, October 2, 2018
 *
 * @param <Type> is what this class/collection stores
 */


public class IterableSimpleHashSet<Type> 
    extends SimpleHashSet<Type> implements Iterable<Type> {
	
	private class NestedIterator implements Iterator<Type> {
		int myIndex;
		Iterator<Type> mySingleArrayListIterator;
		
		public NestedIterator() {
			myIndex = -1;
			mySingleArrayListIterator = null;
			advance();
		}
		/**
		 * Called when current bucket's iterator is exhausted.
		 * 
		 * Advance to next bucket in hash table that is not empty.
		 * Change state so that myIndex is index of current bucket
		 * and mySingleArrayListIterator is for current bucket. If there
		 * is no next bucket, last bucket iterator will be exhausted
		 */
		private void advance() {
			myIndex += 1;
			while (myIndex < myElements.size()) {
				mySingleArrayListIterator = myElements.get(myIndex).iterator();
				if (mySingleArrayListIterator.hasNext()) {
					break;
				}
				myIndex += 1;
			}
		}
		@Override
		public boolean hasNext() {
			return mySingleArrayListIterator != null && 
				   mySingleArrayListIterator.hasNext();
		}

		@Override
		public Type next() {
			Type current = mySingleArrayListIterator.next();
			if (! mySingleArrayListIterator.hasNext()) {
				//System.out.printf("advance on %d\n", myIndex);
				advance();
			}
			return current;
		}	
	}
		
	/**
	 * This set is empty, but usable
	 */
	public IterableSimpleHashSet() {
		super();
	}
	
	/**
	 * Returns an iterator set for first element of this set
	 * or an "empty" iterator if this set is empty.
	 * @return new iterator for this set
	 */
	public Iterator<Type> iterator() {
		return new NestedIterator();
	}
}
