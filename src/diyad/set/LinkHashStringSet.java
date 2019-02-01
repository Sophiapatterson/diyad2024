package diyad.set;

/**
 * Simple hash table using array of linked-lists
 * where each linked list is a node with a reference
 * to the next node in the linked list
 * @author ola
 *
 */

public class LinkHashStringSet {
    private static int SIZE = 100000;
    
    private class Node{
        String info;
        Node next;
        public Node(String key){
            this.info = key;
            this.next = null;
        }
    }
    private Node[] myElements;
    private int mySize;
    
    public LinkHashStringSet(){
        myElements = new Node[SIZE];
        mySize = 0;
    }
    
    private int getHash(String key){
        return Math.abs(key.hashCode()) % SIZE;
    }
    
    /**
     * Helper method to find node containing a key
     * @param key being searched for
     * @return node containing key, or null if not found
     */
    private Node getNode(String key){
        int bucketIndex = getHash(key);
        Node list = myElements[bucketIndex];
        while (list != null){
            if (list.info.equals(key)) return list;
            list = list.next;
        }
        return null;
    }
    
    /**
     * Determines if key is in this set
     * @param key element searched for
     * @return true if key in set, else false
     */
    public boolean contains(String key) {
        return getNode(key) != null;
    }

    /**
     * Add element to this set (don't add duplicate)
     * @param key is element added to set
     * @return true if element added, false if already in set
     */
    public boolean add(String key) {
        int bucketIndex = getHash(key);
        Node list = myElements[bucketIndex];
        while (list != null){
            if (list.info.equals(key)) {
                return false;
            }
            list = list.next;
        }
        list = new Node(key);
        list.next = myElements[bucketIndex];
        myElements[bucketIndex] = list;
        mySize++;
        return true;
    }

    /**
     * Returns number elements in this set
     * @return number of elements in this set
     */
    public int size() {
        return mySize;
    }
    
    /**
     * Clear this set so that no elements remain
     */
    public void clear(){
        myElements = new Node[SIZE];
        mySize = 0;
    }

    /**
     * Remove o from this set
     * @param o element being removed (must be String)
     * @return true if element removed, else false
     */
    public boolean remove(Object o) {
    		int index = getHash((String) o);
    		
    		Node list = myElements[index];
    		
    		if (list == null) return false;
    		
    		// check first node as a special case
    		// has nothing before it
    		if (list.info.equals(o)) {
    			myElements[index] = myElements[index].next;
    			mySize--;
    			return true;
    		}
    		while (list.next != null) {
    			if (list.next.info.equals(o)) {
    				list.next = list.next.next;
    				mySize--;
    				return true;
    			}
    			list = list.next;
    		}  		
    		return false;
    }
}
