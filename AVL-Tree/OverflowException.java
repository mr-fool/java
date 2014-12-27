package cpsc331.collections;

/**
* Exception to be thrown if an attempt to add an element to a bounded
* structure would cause its capacity to be exceeded
*
* @author Wayne Eberly
*/

public class OverflowException extends RuntimeException {

 /**
 * Constructs an OverflowException
 */

 public OverflowException() {
   super();
 }

 /**
 * Constructs an OverflowException with the specified
 * message.
 */

 public OverflowException(String message) {
  super(message);
 };

}
