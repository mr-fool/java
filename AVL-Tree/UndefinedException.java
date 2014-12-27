package cpsc331.collections;

/**
* Exception to be thrown on an attempt to obtain the value defined
* in a Map for a given key, if no such value is defined
*
* @author Wayne Eberly
*/

public class UndefinedException  extends Exception {

/**
 *
 * Constructions an UndefinedException with no information
 *
 */

  public UndefinedException() {
    super();
  }

 /**
 * Constructs an UndefinedException  with the specified
 * message.
 */

 public UndefinedException(String message) {
  super(message);
 };

}
