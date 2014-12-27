package cpsc331.assignment3;

import org.junit.*;
import static org.junit.Assert.*;
import cpsc331.assignment3.FoundException;
import cpsc331.assignment3.NotFoundException;
import java.util.NoSuchElementException;
import java.util.Iterator;
import cpsc331.collections.SortedMap;
import cpsc331.collections.UndefinedException;
import cpsc331.assignment3.AVLSortedMap;
import cpsc331.assignment3.AVLUtils;

 /*
 * Tests of the "before" and "after" method
 */

public class testBeforeAfter {

  @Test (expected=NoSuchElementException.class)
  public void TestBefore1() throws NoSuchElementException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer ONE = new Integer(1);
    T.before(ONE);
  }

  @Test (expected=NoSuchElementException.class)
  public void TestBefore2() throws NoSuchElementException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer TWO = new Integer(2);
    T.before(TWO);
  }

  @Test 
  public void TestBefore3() throws NoSuchElementException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer TWO = new Integer(2);
    Integer THREE = new Integer(3);
    assertTrue(TWO.equals(T.before(THREE)));
  }

  @Test
  public void TestBefore4() throws NoSuchElementException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer TWO = new Integer(2);
    Integer FOUR = new Integer(4);
    assertTrue(TWO.equals(T.before(FOUR)));
  }

  @Test
  public void TestBefore5() throws NoSuchElementException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer FOUR = new Integer(4);
    Integer FIVE = new Integer(5);
    assertTrue(FOUR.equals(T.before(FIVE)));
  }

  @Test
  public void TestBefore6() throws NoSuchElementException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer FOUR = new Integer(4);
    Integer SIX = new Integer(6);
    assertTrue(FOUR.equals(T.before(SIX)));
  }

  @Test
  public void TestBefore7() throws NoSuchElementException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer SIX = new Integer(6);
    Integer SEVEN = new Integer(7);
    assertTrue(SIX.equals(T.before(SEVEN)));
  }

  @Test
  public void TestBefore8() throws NoSuchElementException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer SIX = new Integer(6);
    Integer EIGHT = new Integer(8);
    assertTrue(SIX.equals(T.before(EIGHT)));
  }

  @Test
  public void TestBefore9() throws NoSuchElementException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer EIGHT = new Integer(8);
    Integer NINE = new Integer(9);
    assertTrue(EIGHT.equals(T.before(NINE)));
  }

  @Test
  public void TestAfter1() throws NoSuchElementException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    assertTrue(TWO.equals(T.after(ONE)));
  }

  @Test
  public void TestAfter2() throws NoSuchElementException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer TWO = new Integer(2);
    Integer FOUR = new Integer(4);
    assertTrue(FOUR.equals(T.after(TWO)));
  }

  @Test
  public void TestAfter3() throws NoSuchElementException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer THREE = new Integer(3);
    Integer FOUR = new Integer(4);
    assertTrue(FOUR.equals(T.after(THREE)));
  }

  @Test
  public void TestAfter4() throws NoSuchElementException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer FOUR = new Integer(4);
    Integer SIX = new Integer(6);
    assertTrue(SIX.equals(T.after(FOUR)));
  }

  @Test
  public void TestAfter5() throws NoSuchElementException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer FIVE = new Integer(5);
    Integer SIX = new Integer(6);
    assertTrue(SIX.equals(T.after(FIVE)));
  }

  @Test
  public void TestAfter6() throws NoSuchElementException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer SIX = new Integer(6);
    Integer EIGHT = new Integer(8);
    assertTrue(EIGHT.equals(T.after(SIX)));
  }

  @Test
  public void TestAfter7() throws NoSuchElementException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer SEVEN = new Integer(7);
    Integer EIGHT = new Integer(8);
    assertTrue(EIGHT.equals(T.after(SEVEN)));
  }

  @Test (expected=NoSuchElementException.class)
  public void TestAfter8() throws NoSuchElementException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer EIGHT = new Integer(8);
    T.after(EIGHT);
  }

  @Test (expected=NoSuchElementException.class)
  public void TestAfter9() throws NoSuchElementException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer NINE = new Integer(9);
    T.after(NINE);
  }

}
