import java.util.NoSuchElementException;
import java.util.Iterator;
/**
 * The ArrayList class allows storage of Objects in a list. It allows 
 * random-access of these Objects inside the list.
 * 
 * @author Hoi Kin Cheng.
 * @date 3/2/2017.
 */
public class ArrayList implements Iterable {
    
    /**
     * The ArrayListIterator class contains methods that help to iterate 
     * through the ArrayList.
     * 
     * @author Hoi Kin Cheng.
     * @date 3/2/2017.
     */
    private class ArrayListIterator implements Iterator {
        private int cursor;
        private boolean nextCalled;

        /**
        * This constructor initializes the cursor location to just before the 
        * zeroth index, and initializes and nextCalled boolean to false.
        * 
        * @param Nothing.
        * @return Nothing.
        */
        public ArrayListIterator() {
            this.cursor = -1;
            nextCalled = false;
        }
        
        /**
        * This method checks if the next index exists in the ArrayList.
        * 
        * @param Nothing.
        * @return boolean This returns true if the next index exists in the 
        * ArrayList, returns false otherwise.
        */
        @Override
        public boolean hasNext() {
            return cursor < data.length - 1;
        }
        
        /**
        * This method moves the iterator cursor forward by one index and returns 
        * the Object contained in that index.
        * 
        * @param Nothing.
        * @return Object This is the Object being returned by moving the cursor.
        */
        @Override
        public Object next() throws NoSuchElementException {
            if(hasNext()) {
                cursor++;
                nextCalled = true;
                return data[cursor];
            } else {
                throw new NoSuchElementException
                ("Iterator has traversed to the end of ArrayList.");
            }
        }
        
        /**
        * This method removes the last element called by the next() method in 
        * the ArrayList. Will throw IllegalStateException if this method 
        * has already been called without calling next() again, or next() 
        * has never been called.
        * 
        * @param Nothing.
        * @return Nothing.
        * @exception IllegalStateException On this method has already been 
        * called without calling next() again, or next() has never been 
        * called.
        */
        @Override
        public void remove() throws IllegalStateException {
            if (nextCalled) {
                Object[] temp = new Object[data.length - 1];
                for (int i = 0; i < cursor; i++) {
                    temp[i] = data[i];
                }
                for (int j = cursor; j < temp.length; j++) {
                    temp[j] = data[j + 1];
                }
                data = temp;
                nextCalled = false;
            } else {
                String message = "The next method has not been called, or ";
                message += "the remove method has already been called after ";
                message += "the last call to the next method.";
                throw new IllegalStateException(message);
            }
        
        }
    }
    
    Object[] data;
    
    /**
    * This method returns an ArrayListIterator.
    * 
    * @param Nothing.
    * @return Iterator This is the iterator for the ArrayList.
    */
    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }
    
    /**
    * This is the default "no-arg" constructor.
    * 
    * @param Nothing.
    * @return Nothing.
    */
    public ArrayList() {
        data = new Object[0];
    }
    
    /**
    * This method inserts an Object into a specified index.
    * 
    * @param obj This is the object to be stored in ArrayList.
    * @param index This is the index for which the object is to be stored 
    * in the ArrayList.
    * @return Nothing.
    * @exception IndexOutOfBoundsException On negative index or index 
    * that is greater than the ArrayList's size error.
    */
    public void insert(Object obj, int index) throws 
                IndexOutOfBoundsException {
        if (index >= 0 && index <= data.length) {
            Object[] temp = new Object[data.length + 1];
            for (int i = 0; i < index; i++) {
                temp[i] = data[i];
            }
            temp[index] = obj;
            for (int i = index + 1; i < temp.length; i++) {
                temp [i] = data[i - 1];
            }
            data = temp;
        } else {
            throw new IndexOutOfBoundsException
                      ("Error: index out of bounds.");
        }
    }
    
    /**
    * This method removes an Object from a specified index.
    * 
    * @param index This is the index for which the object is to be removed 
    * from the ArrayList.
    * @return Object This returns the Object that is being removed.
    * @exception IndexOutOfBoundsException On negative index or index 
    * that is greater than or equal to the ArrayList's size error.
    */
    public Object remove(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < data.length) {
            Object[] temp = new Object[data.length - 1];
            for (int i = 0; i < index; i++) {
                temp[i] = data[i];
            }        
            for (int i = index; i < temp.length; i++) {
                temp [i] = data[i + 1];
            }            
            Object tempObj = data[index];
            data = temp;
            return tempObj;
        } else {
            throw new IndexOutOfBoundsException
                      ("Error: index out of bounds.");
        }
    }
    
    /**
    * This method returns the size of the ArrayList.
    * 
    * @param Nothing.
    * @return int This returns the size of the ArrayList.
    */
    public int size() {
        return data.length;
    }
    
    /**
    * This method returns all elements in the ArrayList in an organized String.
    * 
    * @param Nothing.
    * @return String This returns all elements in the ArrayList as a String.
    */
    @Override
    public String toString() {
        String str = "{";
        if (data.length != 0) {
            for (int i = 0; i < data.length - 1; i++) {
                str += data[i] + ", ";
            }
            str += data[data.length - 1];
        }
        str += "}";
        return str;
    }
    
    /**
    * This method checks if the ArrayList is empty.
    * 
    * @param Nothing.
    * @return boolean This returns true if the ArrayList is empty, returns 
    * false otherwise.
    */
    public boolean isEmpty() {
        return size() == 0;
    }
    
    /**
    * This method finds the index of a specified Object.
    * 
    * @param target This is the Object that is being asked to find 
    * the index of.
    * @return int This returns the index of the specified Object in 
    * the ArrayList, returns -1 if Object is not found in the ArrayList.
    */
    public int indexOf(Object target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
    * This method checks if this ArrayList is equal to another ArrayList.
    * 
    * @param other This is the other ArrayList to compare.
    * @return boolean This returns true if all elements in this ArrayList 
    * equals to all elements in the other ArrayList, returns false otherwise.
    */
    @Override
    public boolean equals(Object other) {
        ArrayList otherAL = (ArrayList) other;
        if (data.length == otherAL.size()) {
            for (int i = 0; i < data.length; i++) {
                if (!data[i].equals(otherAL.get(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
    
    /**
    * This method returns the element in ArrayList using the specified index.
    * 
    * @param index This specifies which index's Object the method should get.
    * @return Object This returns the Object of the specified index.
    * @exception IndexOutOfBoundsException On negative index or index 
    * that is greater than or equal to the ArrayList's size error.
    */
    public Object get(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < data.length) {
            return data[index];
        } else {
            throw new IndexOutOfBoundsException
                      ("Error: index out of bounds.");
        }
    }
}
