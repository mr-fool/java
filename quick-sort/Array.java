package cpsc331.collections;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * Provides an Object with behaviour and performance resembling that of
 * an array
 * <br />
 *
 * <p>
 *  <strong>Array Invariant:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> this.LENGTH is a nonnegative integer constant </li>
 * <li> this.data is an ArrayList with base type E and size this.LENGTH
 * <li> For every integer i between 0 qnd this.LENGTH - 1 (inclusive) the
 *      i<sup>th</sup> entry in this Array is a variable with type E,
 *      that is stored at the i<sup>th</sup> position of data </li>
 * </ol>
 *
 */

public class Array<E> {

  // Data Fields:
  private final int LENGTH;
  private ArrayList<E> data;
  
  /**
 *
 * Constructs an Array with a given length
 * <br />
 *
 * <p>
 *  <strong>Precondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> length is an integer input </li>
 * </ol>
 *
 * <p>
 *  <strong>Postcondition:</strong>
 *  <ol style="list-style-type: lower-alpha">
 *  <li> length is an integer input </li>
 *  <li> If length &lt; 0 then an IllegalArgumentException is thrown
 *       and an Array is not created </li>
 *  <li> If length &ge; 0 then an Array with the given length (satisfying
 *       the Array Invariant) that is filled with null entries is created </li>
 *  </ol
 *
 *  @param length the length of the Array to be created
 *  @throws IllegalArgumentException if length &lt; 0
 *
 */
 
  public Array(int length) throws IllegalArgumentException {

    if (length < 0) {

      Integer Length = new Integer(length);
      throw new IllegalArgumentException(Length.toString());

    } else {

      this.LENGTH = length;
      this.data = new ArrayList<E>(length);;

      int i = 0;

      // Loop Invariant:
      // a) length is a positive integer input
      // b) i is an integer variable such thst 0 <= i <= length
      // c) this.data  is an ArrayList with base type E
      // d) this.data has capacity length
      // e) this.data  has size i
      // f) For every integer j such that 0 <= j <= i-1, the
      //    entry of this.data in position j is null
      //
      // Bound Function: length - i

      // Assertion for the Beginning of the Loop:
      // a) The loop invariant is satisfied
      // b) i = 0

      while (i < length) {

        // Assertion for the Beginning of the Loop Body:
        // a) The loop invariant is satisfied
        // b) 0 <= i <= length - 1

        this.data.add(null);
        i = i+1;

        // Assertion for the End of the Loop Body:
        // a) The loop invariant is satisfied
        // b) 1 <= i <= length

      }

      // Assertion for the End of the Loop:
      // a) The loop invariant is satisfied
      // b) i = length - so that this.data now has size length
      //     and its jth entry is null for every integer j such
      //     that 0 <= j <= length - 1

    }

  }

  /**
 *
 * Returns the length of this Array.
 * <br />
 *
 * <p>
 *  <strong>Precondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The class invariant is satisfied </li>
 * </ol>
 *
 * <p>
 *  <strong>Postcondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The class invariant is satisfied </li>
 * <li> This Array has not been changed. </li>
 * <li> The length of this Array has been returned as output. </li>
 * </ol>
 *
 * @return the length of this Array
 *
 */

  public int length() {

    return this.LENGTH;

  }

  /**
 *
 * Returns the value at position index for a give index
 * <br />
 *
 * <p>
 *  <strong>Precondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The class invariant is satisfied </li>
 * <li> index is an integer input </li>
 * </ol>
 *
 * <p>
 *  <strong>Postcondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The class invariant is satisfied </li>
 * <li> index is an integer input </li>
 * <li> If 0 &le; index &le; this.LENGTH &minus; 1 then the entry of
 *      this Array at position&nbsp;index is returned as output. An
 *      ArrayIndexOutOfBoundsException is returned otherwise </li>
 * <li> This Array has not been changed </li>
 * </ol>
 *
 * @param index a position in this Array
 * @return the value stored at the given index
 * @throws ArrayIndexOutOfBoundsException if index &lt; 0 or index is greater than
 *        or equal to the length of this Array
 *
 */

  public E get(int index) throws ArrayIndexOutOfBoundsException {

    if ((index < 0) || (index >= this.LENGTH)) {

      Integer Index = new Integer(index);
      throw new ArrayIndexOutOfBoundsException(Index.toString());

    } else {

      return this.data.get(index);

    }

  }

  /**
 *
 * Sets to the value of this Array at the given index to be the given value
 * <br />
 *
 * <p>
 *  <strong>Precondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The class invariant is satisfied </li>
 * <li> index is an integer input </li>
 * <li> e is an input with type E </li>
 * </ol>
 *
 * <p>
 *  <strong>Postcondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The class invariant is satisfied </li>
 * <li> index is an integer input </li>
 * <li> e is an input with type E </li>
 * <li> If 0 &le; index &le; this.LENGTH &minus;1 then
 *      the entry of this Array in position index is
 *      set to be e (and the Array is otherwise unchanged). 
 *      Otherwise an ArrayIndexOutOfBoundsException
 *      is thrown and this Array is not changed. </li>
 * </ol>
 *
 * @param index a position in this Array
 * @param e a value with type E (the base type of this Array)
 * @throws ArrayIndexOutOfBoundsException if index &lt; 0 or index is greater than
 *         or equal to the length of this Array
 *
 */

  public void set(int index, E e) throws ArrayIndexOutOfBoundsException {

    if ((index < 0) || (index >= this.LENGTH )) {

      Integer Index = new Integer(index);
      throw new ArrayIndexOutOfBoundsException(Index.toString());

    } else {

       data.set(index, e);

    }

  }

  /**
 *
 * Returns a ListIterator for this Array.
 * <br />
 *
 * <p>
 *  <strong>Precondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The class invariant is satisfied </li>
 * </ol>
 *
 * <p>
 *  <strong>Postcondition:</strong>
 * </p>
 * <ol style="text-align: left">
 * <li> The class invariant is satisfied </li>
 * <li> This Array has not been changed </li>
 * <li> A ListIterator for this Array has been returned as output </li>
 * </ol>
 *
 */
 
  public ListIterator<E> listIterator() {

    ListIterator<E> iter = this.data.listIterator();
    return iter;

  }
}
