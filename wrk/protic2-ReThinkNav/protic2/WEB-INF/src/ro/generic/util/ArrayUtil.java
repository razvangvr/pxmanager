package ro.generic.util;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * @author Ciprian Popa (cyparu)
 * @version 1.0, Jul 23, 2004
 */
public class ArrayUtil {

	//--------------------------------------------------------//
	//                        CONSTANTS                       //
	//--------------------------------------------------------//

	// specialized empty arrays
	public static final byte[] EMPTY_ARRAY_BYTE = new byte[0];
	public static final char[] EMPTY_ARRAY_CHAR = new char[0];
	public static final short[] EMPTY_ARRAY_SHORT = new short[0];
	public static final int[] EMPTY_ARRAY_INT = new int[0];
	public static final long[] EMPTY_ARRAY_LONG = new long[0];
	public static final float[] EMPTY_ARRAY_FLOAT = new float[0];
	public static final double[] EMPTY_ARRAY_DOUBLE = new double[0];
	public static final Object[] EMPTY_ARRAY_OBJECT = new Object[0];
	public static final String[] EMPTY_ARRAY_STRING = new String[0];
	public static final Class[] EMPTY_ARRAY_CLASS = new Class[0];

	/**
	 * Identity comparator
	 */
	public static final Comparator IDENTITY_COMPARATOR = new Comparator() {

		//--------------------------------------------------------//
		//                   IMPLEMENTS 'Comparator'              //
		//--------------------------------------------------------//

		public int compare (Object o1, Object o2) {
			return o1 == o2 ? 0 : 1;
		}

	};

	//--------------------------------------------------------//
	//                      CONSTRUCTORS                      //
	//--------------------------------------------------------//

	/**
	 * Private constructor used to disable instance creation for this class
	 */
	private ArrayUtil () {
	}

	//--------------------------------------------------------//
	//                        STATIC METHODS                  //
	//--------------------------------------------------------//

	/**
	 * Add a new element in the array at the specified position and return the new array.
	 *
	 * @param array array to add the element
	 * @param index index in array (could exced capacity, new array created) where the object should be set
	 * @param obj   object to be added to array
	 * @return
	 */
	public static final Object[] set (Object[] array, int index, Object obj) {
		if (index < 0) {
			throw new IllegalArgumentException("Invalid index for array: ".concat(String.valueOf(index)));
		}
		if (index >= array.length) {
			array = resize(array, index + 1);
		}
		array[index] = obj;
		return array;
	}

	/**
	 * Remove an element at the specified index from an array and rearange the array (move the elements)
	 *
	 * @param array to remove from
	 * @param index index to be removed
	 * @return true if object is removed oherwise false
	 */
	public static final boolean remove (Object[] array, int index) {
		boolean removed = index >= 0 && index < array.length;
		if (removed) {
			int len = array.length;
			int moved = len - index - 1;
			if (moved != 0) {
				System.arraycopy(array, index + 1, array, index, moved);
			}
			array[len - 1] = null; // remove tail reference
		}
		return removed;
	}

	/**
	 * Resize an array to the specified size and return the new array.
	 *
	 * @param array array to be resized
	 * @param size  new size for array
	 * @return return new shrinked/extended array
	 */
	public static final Object[] resize (Object[] array, int size) {
		if (size < 0) {
			throw new IllegalArgumentException("Invalid new size for the array: ".concat(String.valueOf(size)));
		}
		int len = array.length;
		Object newArray[] = (size != len) ? (Object[])Array.newInstance(array.getClass().getComponentType(), size) : array;
		if (size != 0 && size != len) {
			System.arraycopy(array, 0, newArray, 0, len);
		}
		return newArray;
	}

	/**
	 * Return a sub-array from the specified array
	 *
	 * @param array  array to be resized
	 * @param offset start offset in array
	 * @param count  number of elements to be copyed
	 * @return return new created sub-array with the same contents in the original array
	 */
	public static final Object[] copy (Object[] array, int offset, int count) {
		int len = array.length;
		offset = (offset < 0) ? 0 : offset;
		count = (count > len - offset) ? len - offset : count;
		Object[] newArray = (Object[])Array.newInstance(array.getClass().getComponentType(), count);
		System.arraycopy(array, offset, newArray, 0, count);
		return newArray;
	}

	/**
	 * Search an object (based on identity not equality) in an array and return its position in array
	 *
	 * @param array      array to search in
	 * @param fromOffset start index in array
	 * @param toOffset   stop index in array
	 * @param obj        object to find
	 * @return index in the array of the object or -1 if not found
	 */
	public static final int indexOf (Object[] array, int fromOffset, int toOffset, Object obj) {
		return indexOf(array, fromOffset, toOffset, obj, IDENTITY_COMPARATOR);
	}

	/**
	 * Search an object (based on identity not equality) in an array and return its position in array
	 *
	 * @param array      array to search in
	 * @param fromOffset start index in array
	 * @param toOffset   stop index in array
	 * @param obj        object to find
	 * @param comp       comparator used fo search, if null , the IDENTITY_COMPARATOR will be used instead
	 * @return index in the array of the object or -1 if not found
	 */
	public static final int indexOf (Object[] array, int fromOffset, int toOffset, Object obj, Comparator comp) {
		int index = -1;
		if (array != null) {
			comp = (comp == null) ? IDENTITY_COMPARATOR : comp;
			fromOffset = (fromOffset < 0) ? 0 : fromOffset;
			toOffset = (toOffset >= array.length) ? array.length - 1 : toOffset;
			for (int i = fromOffset; i <= toOffset; i++) {
				if (comp.compare(array[i], obj) == 0) {
					index = i;
					break;
				}
			}
		}
		return index;
	}

}
