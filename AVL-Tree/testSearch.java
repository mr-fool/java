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
 * Tests for searches and reports of sizein AVL trees
 */

public class testSearch {

  /*
 * Tests for searches in an empty tree
 */

  @Test
  public void TestEmptyTree() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    AVLUtils<Integer, Integer> utils =
       new AVLUtils<Integer, Integer>();
    assertTrue(utils.isAVL(T));
  }

  @Test
  public void TestEmptySize() {
    AVLSortedMap<Integer, Integer> T = 
       new AVLSortedMap<Integer, Integer>();
    assertTrue(T.size() == 0);
  }

  @Test (expected=UndefinedException.class)
  public void TestEmptySearch() throws UndefinedException {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    T.get(ZERO);
  }

  @Test
  public void TestEmptyDefined() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    assertFalse(T.defined(ZERO));
  }

  @Test
  public void TestEmptyIndexOf() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    assertTrue(T.indexOf(ZERO) == -1);
  }

  @Test (expected=IndexOutOfBoundsException.class)
  public void TestEmptyGetIndex() throws IndexOutOfBoundsException {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    T.get(0);
  }

  @Test (expected=NoSuchElementException.class)
  public void TestEmptyBefore() throws NoSuchElementException {
     AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    T.before(ZERO);
  }

  @Test (expected=NoSuchElementException.class)
  public void TestEmptyAfter() throws NoSuchElementException {
     AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    T.after(ZERO);
  }

  /*
 * Tests for searches in a small AVL tree
 */

  @Test
  public void TestTree1() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    assertTrue(utils.isAVL(T));
  }

  @Test
   public void testTree1size() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    assertTrue(T.size()  == 4);
  }

  @Test (expected=UndefinedException.class)
  public void TestSizeOneSearch1get() throws UndefinedException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer ONE = new Integer(1);
    T.get(ONE);
  }

  @Test
  public void TestSizeOneSearch1defined(){
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer ONE = new Integer(1);
    assertFalse(T.defined(ONE));
  }

  @Test
  public void TestSizeOneSearch1IndexOf() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer ONE = new Integer(1);
    assertTrue(T.indexOf(ONE) == -1);
  }

  @Test (expected=IndexOutOfBoundsException.class)
  public void TestSizeOneSearch1GetIndex() throws IndexOutOfBoundsException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer ONE = new Integer(1);
    T.get(-1);
  }

  @Test 
  public void TestSizeOneSearch2get() throws UndefinedException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer TWO = new Integer(2);
    Integer ZERO = new Integer(0);
    assertTrue(ZERO.equals(T.get(TWO)));
  }

  @Test
  public void TestSizeOneSearch2defined(){
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer TWO = new Integer(2);
    assertTrue(T.defined(TWO));
  }

  @Test
  public void TestSizeOneSearch2IndexOf() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer TWO = new Integer(2);
    assertTrue(T.indexOf(TWO) == 0);
  }

  @Test 
  public void TestSizeOneSearch2GetIndex() throws IndexOutOfBoundsException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer TWO = new Integer(2);
    assertTrue(TWO.equals(T.get(0)));
  }
  @Test (expected=UndefinedException.class)
  public void TestSizeOneSearch3get() throws UndefinedException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer THREE = new Integer(3);
    T.get(THREE);
  }

  @Test
  public void TestSizeOneSearch3defined(){
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer THREE = new Integer(3);
    assertFalse(T.defined(THREE));
  }

  @Test
  public void TestSizeOneSearch3IndexOf() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer THREE = new Integer(3);
    assertTrue(T.indexOf(THREE) == -1);
  }

  @Test
  public void TestSizeOneSearch4get() throws UndefinedException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer FOUR = new Integer(4);
    Integer TWO = new Integer(2);
    assertTrue(TWO.equals(T.get(FOUR)));
  }

  @Test
  public void TestSizeOneSearch4defined(){
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer FOUR = new Integer(4);
    assertTrue(T.defined(FOUR));
  }

  @Test
  public void TestSizeOneSearch4IndexOf() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer FOUR = new Integer(4);
    assertTrue(T.indexOf(FOUR) == 1);
  }

  @Test
  public void TestSizeOneSearch4GetIndex() throws IndexOutOfBoundsException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer FOUR = new Integer(4);
    assertTrue(FOUR.equals(T.get(1)));
  }

  @Test (expected=UndefinedException.class)
  public void TestSizeOneSearch5get() throws UndefinedException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer FIVE = new Integer(5);
    T.get(FIVE);
  }

  @Test
  public void TestSizeOneSearch5defined(){
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer FIVE = new Integer(5);
    assertFalse(T.defined(FIVE));
  }

  @Test
  public void TestSizeOneSearch5IndexOf() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer FIVE = new Integer(5);
    assertTrue(T.indexOf(FIVE) == -1);
  }

  @Test
  public void TestSizeOneSearch6get() throws UndefinedException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer SIX = new Integer(6);
    Integer FOUR = new Integer(4);
    assertTrue(FOUR.equals(T.get(SIX)));
  }

  @Test
  public void TestSizeOneSearch6defined(){
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer SIX = new Integer(6);
    assertTrue(T.defined(SIX));
  }

  @Test
  public void TestSizeOneSearch6IndexOf() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer SIX = new Integer(6);
    assertTrue(T.indexOf(SIX) == 2);
  }

  @Test
  public void TestSizeOneSearch6GetIndex() throws IndexOutOfBoundsException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer SIX = new Integer(6);
    assertTrue(SIX.equals(T.get(2)));
  }
  @Test (expected=UndefinedException.class)
  public void TestSizeOneSearch7get() throws UndefinedException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer SEVEN = new Integer(7);
    T.get(SEVEN);
  }

  @Test
  public void TestSizeOneSearch7defined(){
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer SEVEN = new Integer(7);
    assertFalse(T.defined(SEVEN));
  }

  @Test
  public void TestSizeOneSearch7IndexOf() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer SEVEN = new Integer(7);
    assertTrue(T.indexOf(SEVEN) == -1);
  }

  @Test
  public void TestSizeOneSearch8get() throws UndefinedException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer EIGHT = new Integer(8);
    Integer SIX = new Integer(6);
    assertTrue(SIX.equals(T.get(EIGHT)));
  }

  @Test
  public void TestSizeOneSearch8defined(){
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer EIGHT = new Integer(8);
    assertTrue(T.defined(EIGHT));
  }

  @Test
  public void TestSizeOneSearch8IndexOf() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer EIGHT = new Integer(8);
    assertTrue(T.indexOf(EIGHT) == 3);
  }

  @Test
  public void TestSizeOneSearch8GetIndex() throws IndexOutOfBoundsException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer EIGHT = new Integer(8);
    assertTrue(EIGHT.equals(T.get(3)));
  }
  @Test (expected=UndefinedException.class)
  public void TestSizeOneSearch9get() throws UndefinedException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer NINE = new Integer(9);
    T.get(NINE);
  }

  @Test
  public void TestSizeOneSearch9defined(){
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer NINE = new Integer(9);
    assertFalse(T.defined(NINE));
  }

  @Test
  public void TestSizeOneSearch9IndexOf() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer NINE = new Integer(9);
    assertTrue(T.indexOf(NINE) == -1);
  }

  @Test (expected=IndexOutOfBoundsException.class)
  public void TestSizeOneSearch9GetIndex() throws IndexOutOfBoundsException {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer NINE = new Integer(9);
    T.get(4);
  }

}
