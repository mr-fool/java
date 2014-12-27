package cpsc331.collections;

import java.util.Iterator;
import cpsc331.collections.OverflowException;
import cpsc331.collections.UndefinedException;

/**
 *
 * Provides a simplified finite Map inteface. Like the interface
 * in the Java Collections Framework, this supports both Bounded Maps
 * and Unbounded Maps.
 * <br />
 *
 * <p>
 *  <strong>Map Invariant:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> A finite function, mapping values (called &ldquo;keys&rdquo;)
 *      of type&nbsp;K to values of type&nbsp;V, is represented. </li>
 * <li> If this Map is a Bounded Map then the number of keys
 *      for which values are defined (thta is, the &ldquo;size&rdquo;
 *      of this Map) is less than or equal to its capacity. </li>
 * </ol>
 *
 * <p>
 *  Additional Notes:
 * </p>
 * 
 * <p>
 *  A constructor that creates an empty map should be provided. if
 *  Bounded Map is be3ing implemented then a positive integer
 *  capacity should be included as an input.
 * </p>
 *
 */

public interface Map<K, V> {

 /**
 *
 * Returns the number of elements in this map (its cardinality).
 * <br />
 *
 * <p>
 *  <strong>Precondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The Map invariant is satisfied. </li>
 * </ol><br />
 * <p>
 *  <strong>Postcondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The Map invariant is satisfied. </li>
 * <li> The number of elements in the map being represented
 *      is returned as output. </li>
 * <li> The represented map has not been changed. </li>
 * </ol>
 *
 * @return The size of the set being represented
 *
 */

 int size ();

 /**
 *
 * Reports whether the given key has a value defined for it in this map.
 * <br />
 *
 * <p>
 *  <strong>Precondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The Map invariant is satisfied. </li>
 * <li> An element k of type K has been supplied as input. </li>
 * </ol>
 * <p>
 *  <strong>Postcondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The Map invariant is satisfied </li>
 * <li> The Map being represented has not been changed </li>
 * <li> The value true is returned as output if a value is
 *      defined for the input key k, and false is returned
 *      otherwise.
 * </li>
 * </ol>
 *
 * @param k A key whose inclusion in the Map is being queried
 * @return true if a value is defined for the key k, and false otherwise
 *
 */

 boolean defined(K k);
 
 /**
 *
 * Reports the value defined for a given key.
 * <br />
 *
 * <p>
 *  <strong>Precondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The Map invariant is satisfied. </li>
 * <li> An element k of type K has been supplied as input. </li>
 * </ol><br />
 * <p>
 *  <strong>Postcondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The Map invariant is satisfied. </li>
 * <li> The Map being represented has not been changed. </li>
 * <li> If a value is defined for the input key k then this
 *      value is returned as output. An UndefinedException
 *      is thrown, otherwise. </li>
 * </ol>
 *
 * @param k A key whose inclusion in the Map is being queried
 * @return The value associated with this key in this Map
 * @throws UndefinedException if no value is sssocated with this
 *     key in this Map
 *
 */

 V get(K k) throws UndefinedException;

  /**
 *
 * Defines or changes the value associated with a given key.
 * <br />
 *
 * <p>
 *  <strong>Precondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The Map invariant is satisfied. </li>
 * <li> A key k of type K and value v of type V are supplied as input. </li>
 * </ol>
 * <p>
 *  <strong>Postcondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The Map invariant is satisfied. </li>
 * <li> If this is a Bounded Map, there is no value already associated
 *      with the input key k, and the size of this map is less than its
 *      capacity, then the input value is associated (under this map)
 *      to the input key k. If there is no value already associated
 *      with the input key and the size of this Map is already equal to
 *      its capacity, then an OverflowException is thrown and the
 *      represented map is not changes. Finally, if there is already a
 *      value associated with the input key k then this value is replaced
 *      by the input value v.
 * </li>
 * <li> If this is an Unbounded Map and there is no value already
 *      associated with the input key ke, then the input value v
 *      is associated with the input key. If there is already a value
 *      assocated with the input key k then this value is replaced
 *      by the input value v.
 * </li>
 *  </ol>
 *
 * @param k the key whose value is to be defined
 * @param v the value to be associated with the input key
 * @throws OverflowException if this is a Bounded Map, k does not already
 *      have a value associated with it, and the Bounded Map&rsquo;Set
 *      size is already equal to its capacity
 *
 */

 void set(K k, V v) throws OverflowException;

  /**
 *
 * Removes the value associated with an input key (effectively causing
 * the mapping to be &ldquo;undefined&rdquo; at the input key, if a value
 * is already associated with the input key
 * <br />
 *
 * <p>
 *  <strong>Precondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The Map invariant is satisfied. </li>
 * <li> A key k of type K is supplied as input. </li>
 * </ol>
 * <p>
 *  <strong>Postcondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The Map invariant is satisfied. </li>
 * <li> If there is currently a value associated with the input key k
 *      then this part of the mapping is removed, so that the
 *      mapping is now &ldquo;undefined&rdquo; at&nbsp;k.
 *      Otherwise the mapping is not changed.
 * </li>
 * </ol>
 *
 * @param k for which the mapping should now become &ldquo;undefined&rdquo;
 *
 */

 void unset(K k);


 /**
 *
 *  Returns an iterator over the keys for which the mappins is defined.
 *  The keys are returned in no particular order (unless this Map
 *  is also an instance of some class that provides a guarantee).
 *  <br />
 *
 *  <p>
 *   <strong>Preconditon:</strong>
 *  </p>
 *  <ol style="list-style-type: lower-alpha">
 *  <li> The Map invariant is satisfied. </li>
 *  </ol>
 *  <p>
 *   <strong>Postcondition:</strong>
 *  </p>
 *  <ol style="list-style-type: lower-alpha">
 *  <li> The Map invariant is satisfied. </li>
 *  <li> An Iterator over the keys for which values are defined
 *       is returned as output. </li>
 *  <li> The Map being represented has not been changed. </li>
 *  </ol>
 *
 *  @return an iterator over the keys for which values are defined
 *
 */

 Iterator<K> iterator();

}
