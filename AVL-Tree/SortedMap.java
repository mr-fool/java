package cpsc331.collections;

import cpsc331.collections.Map;
import java.util.NoSuchElementException;

/**
 *
 * Provides a simplfied finite SortedMap Inteface. Like the Map inteface,
 * which ite extends, this supports both Bounded and Unbounded SortedMaps.
 * <br />
 *
 * <p>
 *  <strong>SortedMap Interface:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The Set Invariant is satisfied. </li>
 * <li> The type K of keys  for the map being represented has a total
 *      ordering, so that it is meaningful to ask whether one element of
 *      this type is &ldquo;less than or equal to&rdquo; another. </li>
 * </ol>
 *
 * <p>
 *  <strong>Note:</strong> The Iterator for a SortedMap should list keys
 *  (for which values are defined) in increasing order.
 * </p>
 *
 */

public interface SortedMap<K extends Comparable<K>, V> extends Map<K, V> {

  /**
 *
 * Returns the ranking of a given key in the set of keys for which values
 * are defined by this map, returning $minus;1 * if the input key has no
 * value defined for it.
 * <br />
 *
 * <p>
 *  <strong>Precondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The SortedMap invariant is satisfeid. </li>
 * <li> An element k with type K is given a sinput. </li>
 * </ol>
 * <p>
 *  <strong>Postcondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The SortedMap invvariant is satisfied. </li>
 * <li> This SortedMap has not been changed. </li>
 * <li> If the input key&nbsp;k has a value defined for it, in this
 *      SortedMap, then the number of other keys having defined for them
 *      by this SortedMap that are strictly less than it (that is, the
 *      &ldquo;ranking&rdquo; of this key) is returned as output.
 *      The value &minus;1 is returned otherwise.
 * </li>
 * </ol>
 *
 * @param k A key of type K
 * @return The number of other keys for which values are defined by this
 *     SortedMap that are less than it, if a value is define for k;
 *     &minus;1, otherwise
 *
 */

  int indexOf(K k);

 /**
 *
 * Returns the key for which a value is defined, by this SortedMap, with
 * a given ranking.
 * <br />
 *
 * <p>
 *  <strong>Precondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The SortedMap invariant is satisfied. </li>
 * <li> An integer index is given as input. </li>
 * </ol>
 * <p>
 *  <strong>Postcondition:</strong>
 * </p>
 * <ol style="text-align: left">
 * <li> The SortedMap invariant is satisfied. </li>
 * <li> This SortedMap has not been changed. </li>
 * <li> If 0 <= index < this.size() then the key, for which a value is
 *      defined by thie SortedMap, such that exactly index&minus;1 other keys
 *      with values defined by this SortedMap are less than it (that is,
 *      the key with &ldquo;ranking&rdquo; index) is returned as output.
 *      An IndexOutOfBoundsException is thrown otherwise.
 * </li>
 * <?ol>
 *
 * @param index an integer
 * @return The key (for which a value is defined by this SortedMap) with the
 *     given index
 * @throws IndexOutOfBoundsException if index &lt; 0 or index &ge; this.size()
 *
 */

  K get(int index) throws IndexOutOfBoundsException;;

 /**
 *
 * Returns the largest key, for which a value is defined in this SortedMap,
 * that is strictly less than than the given key.
 * <br />
 *
 * <p>
 *  <strong>Precondition:</strong>
 * </p>
 * <ol style="text-align: center">
 * <li> The SortedMap Invariant is satisfied. </li>
 * <li> An key k of type K is given as input. </li>
 * </ol>
 * <p>
 * <strong>Postcondition:</strong>
 * </p>
 * <ol style="text-align: center">
 * <li> The SortedMap Invariant is satisfied. </li>
 * <li> This SortedMap has not been changed. </li>
 * <li> If there is a key that is less than the input k such that a
 *      value is defined for this key in this SortedMap, then the largest such
 *      key is returned as output. A NoSuchElementException is thrown
 *      otherwise. </li>
 * </ol>
 *
 * @param k a key of type K
 * @return the largest key that is less than the input key, for which a
 *       value is defined by this SortedMap
 * @throws NoSuchElementException if there is no key, that is less than the
 *       input key, for which a value is defined by this SortedMap
 *
 */

 K before(K k) throws NoSuchElementException;

 /**
 *
 * Returns the smallest key, for which a value is defined in this SortedMap,
 * that is strictly greater than than the given key.
 * <br />
 *
 * <p>
 *  <strong>Precondition:</strong>
 * </p>
 * <ol style="text-align: center">
 * <li> The SortedMap Invariant is satisfied. </li>
 * <li> An key k of type K is given as input. </li>
 * </ol>
 * <p>
 *  <strong>Postcondition:</strong>
 * </p>
 * <ol style="text-align: center">
 * <li> The SortedMap Invariant is satisfied. </li>
 * <li> This SortedMap has not been changed. </li>
 * <li> If there is a key that is greater than the input k such that a
 *      value is defined for this key in this SortedMap, then the smallest such
 *      key is returned as output. A NoSuchElementException is thrown
 *      otherwise. </li>
 * </ol>
 *
 * @param k a key of type K
 * @return the smallest key that is greater than the input key, for which a
 *       value is defined by this SortedMap
 * @throws NoSuchElementException if there is no key, that is greater than the
 *       input key, for which a value is defined by this SortedMap
 *
 */

  K after(K k) throws NoSuchElementException;

}
