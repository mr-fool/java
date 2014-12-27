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
 * Tests for insertions into an AVL tree
 */

public class testInsert {

  /*
 * Test for insertions into an empty tree
 */

  @Test
  public void TestInsertEmpty() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    Integer ONE = new Integer(1);
    T.set(ZERO, ONE);
    AVLUtils<Integer, Integer> utils =
       new AVLUtils<Integer, Integer>();
    assertTrue(utils.isAVL(T));
  }

  @Test
  public void TestInsertEmpty2() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    Integer ONE = new Integer(1);
    T.set(ZERO, ONE);
    assertTrue(T.size() == 1);
  }

  @Test
  public void TestInsertEmpty3() throws UndefinedException {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    Integer ONE = new Integer(1);
    T.set(ZERO, ONE);
    assertTrue(ONE.equals(T.get(ZERO)));
  }

  @Test
  public void TestInsertEmpty4() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    Integer ONE = new Integer(1);
    T.set(ZERO, ONE);
    assertTrue(T.indexOf(ZERO) == 0);
  }

  @Test
  public void TestInsertEmpty5() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    Integer ONE = new Integer(1);
    T.set(ZERO, ONE);
    assertTrue(ZERO.equals(T.get(0)));
  }

/*
 * Tests for insertions that change an existing value
 */

  @Test
  public void TestReplace() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    T.set(ZERO, ONE);
    T.set(ZERO, TWO);
    AVLUtils<Integer, Integer> utils =
       new AVLUtils<Integer, Integer>();
    assertTrue(utils.isAVL(T));
  }

  @Test
  public void TestReplace2() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    T.set(ZERO, ONE);
    T.set(ZERO, TWO);
    assertTrue(T.size() == 1);
  }

  @Test
  public void TestReplace3() throws UndefinedException {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    T.set(ZERO, ONE);
    T.set(ZERO, TWO);
    assertTrue(TWO.equals(T.get(ZERO)));
  }

  @Test
  public void TestReplace4() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    T.set(ZERO, ONE);
    T.set(ZERO, TWO);
    assertTrue(T.indexOf(ZERO) == 0);
  }

  @Test
  public void TestReplace5() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    T.set(ZERO, ONE);
    T.set(ZERO, TWO);
    assertTrue(ZERO.equals(T.get(0)));
  }

  /*
 * Tests for insertion of a left child into a tree with size one
 */

  @Test
  public void TestAddLeft() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    T.set(TWO, ONE);
    T.set(ONE, ZERO);
    AVLUtils<Integer, Integer> utils =
       new AVLUtils<Integer, Integer>();
    assertTrue(utils.isAVL(T));
  }

  @Test
  public void TestAddLeft2() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    T.set(TWO, ONE);
    T.set(ONE, ZERO);
    assertTrue(T.size() == 2);
  }

  @Test
  public void TestAddLeft3a() throws UndefinedException {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    T.set(TWO, ONE);
    T.set(ONE, ZERO);
    assertTrue(ONE.equals(T.get(TWO)));
  }

  @Test
  public void TestAddLeft3b() throws UndefinedException {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    T.set(TWO, ONE);
    T.set(ONE, ZERO);
    assertTrue(ZERO.equals(T.get(ONE)));
  }

  @Test
  public void TestAddLeft4a() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    T.set(TWO, ONE);
    T.set(ONE, ZERO);
    assertTrue(T.indexOf(ONE) == 0);
  }

  @Test
  public void TestAddLeft4b() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    T.set(TWO, ONE);
    T.set(ONE, ZERO);
    assertTrue(T.indexOf(TWO) == 1);
  }

  @Test
  public void TestAddLeft5a() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    T.set(TWO, ONE);
    T.set(ONE, ZERO);
    assertTrue(ONE.equals(T.get(0)));
  }

  @Test
  public void TestAddLeft5b() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    T.set(TWO, ONE);
    T.set(ONE, ZERO);
    assertTrue(TWO.equals(T.get(1)));
  }

  /*
 * Tests for insertion of a right child into a tree with size one
 */

  @Test
  public void TestAddRight() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    Integer FOUR = new Integer(4);
    T.set(TWO, ONE);
    T.set(FOUR, TWO);
    AVLUtils<Integer, Integer> utils =
       new AVLUtils<Integer, Integer>();
    assertTrue(utils.isAVL(T));
  }

  @Test
  public void TestAddRight2() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    Integer FOUR = new Integer(4);
    T.set(TWO, ONE);
    T.set(FOUR, TWO);
    assertTrue(T.size() == 2);
  }

  @Test
  public void TestAddRight3a() throws UndefinedException {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    Integer FOUR = new Integer(4);
    T.set(TWO, ONE);
    T.set(FOUR, TWO);
    assertTrue(ONE.equals(T.get(TWO)));
  }

  @Test
  public void TestAddRight3b() throws UndefinedException {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    Integer FOUR = new Integer(4);
    T.set(TWO, ONE);
    T.set(FOUR, TWO);
    assertTrue(TWO.equals(T.get(FOUR)));
  }

  @Test
  public void TestAddRight4a() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    Integer FOUR = new Integer(4);
    T.set(TWO, ONE);
    T.set(FOUR, TWO);
    assertTrue(T.indexOf(TWO) == 0);
  }

  @Test
  public void TestAddRight4b() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    Integer FOUR = new Integer(4);
    T.set(TWO, ONE);
    T.set(FOUR, TWO);
    assertTrue(T.indexOf(FOUR) == 1);
  }

  @Test
  public void TestRight5a() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    Integer FOUR = new Integer(4);
    T.set(TWO, ONE);
    T.set(FOUR, TWO);
    assertTrue(TWO.equals(T.get(0)));
  }

  @Test
  public void TestAddRight5b() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    Integer FOUR = new Integer(4);
    T.set(TWO, ONE);
    T.set(FOUR, TWO);
    assertTrue(FOUR.equals(T.get(1)));
  }


  /*
 * Additional tests for insertions that do not require rotations
 */

  @Test
  public void TestInsertTree1() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer FIVE = new Integer(5);
    Integer THREE = new Integer(3);
    T.set(FIVE, THREE);
    assertTrue(utils.isAVL(T));
  }

  @Test
  public void TestInsertTree1b() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree3();
    Integer ONE = new Integer(1);
    Integer NEGONE = new Integer(-1);
    T.set(ONE, NEGONE);
    assertTrue(utils.isAVL(T));
  }

  @Test
  public void TestInsertTree1c() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree3();
    Integer NINE = new Integer(9);
    Integer SEVEN = new Integer(7);
    T.set(NINE, SEVEN);
    assertTrue(utils.isAVL(T));
  }


 /*
 * Tests for insertions requiring a rotation; 'left left" cae
 */

 @Test
 public void TestInsertTree1d() {
   AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
   AVLSortedMap<Integer, Integer> T = utils.buildTree1();
   Integer ONE = new Integer(1);
   Integer NEGONE = new Integer(-1);
   T.set(ONE, NEGONE);
   assertTrue(utils.isAVL(T));
  }

 @Test
 public void TestInsertTree1da() {
   AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
   AVLSortedMap<Integer, Integer> T = utils.buildTree1();
   Integer ONE = new Integer(1);
   Integer NEGONE = new Integer(-1);
   T.set(ONE, NEGONE);
   assertTrue(T.size() == 5);
  }

 @Test
  public void TestInsertTree2() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree2();
    Integer ONE = new Integer(1);
    Integer NEGONE = new Integer(-1);
    T.set(ONE, NEGONE);
    assertTrue(utils.isAVL(T));
  }

 @Test
  public void TestInsertTree2aa() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree2();
    Integer ONE = new Integer(1);
    Integer NEGONE = new Integer(-1);
    T.set(ONE, NEGONE);
    assertTrue(T.size() == 8);
  }

 /*
 * Tests for insertions requiring a rotation; 'left right' case
 */

 @Test
 public void TestInsertTree1e() {
   AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
   AVLSortedMap<Integer, Integer> T = utils.buildTree1();
   Integer THREE = new Integer(3);
   Integer ONE = new Integer(1);
   T.set(THREE, ONE);
   assertTrue(utils.isAVL(T));
  }

 @Test
 public void TestInsertTree1ea() {
   AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
   AVLSortedMap<Integer, Integer> T = utils.buildTree1();
   Integer THREE = new Integer(3);
   Integer ONE = new Integer(1);
   T.set(THREE, ONE);
   assertTrue(T.size() == 5);
  }

 @Test
  public void TestInsertTree2b() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree2();
    Integer THREE = new Integer(3);
    Integer ONE = new Integer(1);
    T.set(THREE, ONE);
    assertTrue(utils.isAVL(T));
  }

 @Test
  public void TestInsertTree2ba() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree2();
    Integer THREE = new Integer(3);
    Integer ONE = new Integer(1);
    T.set(THREE, ONE);
    assertTrue(T.size() == 8);
  }

  /*
 * Tests for insertions requiring a rotation: 'right right'case
 */

 @Test
 public void TestInsertTree3a() {
   AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
   AVLSortedMap<Integer, Integer> T = utils.buildTree3();
   Integer SIXTEEN = new Integer(16);
   Integer FOURTEEN = new Integer(14);
   T.set(SIXTEEN, FOURTEEN);
   assertTrue(utils.isAVL(T));
  }

 @Test
 public void TestInsertTree3aa() {
   AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
   AVLSortedMap<Integer, Integer> T = utils.buildTree3();
   Integer SIXTEEN = new Integer(16);
   Integer FOURTEEN = new Integer(14);
   T.set(SIXTEEN, FOURTEEN);
   assertTrue(T.size() == 5);
  }

 @Test
  public void TestInsertTree4() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree4();
    Integer SIXTEEN = new Integer(16);
    Integer FOURTEEN = new Integer(14);
    T.set(SIXTEEN, FOURTEEN);
    assertTrue(utils.isAVL(T));
  }

 @Test
  public void TestInsertTree4aa() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree4();
    Integer SIXTEEN = new Integer(16);
    Integer FOURTEEN = new Integer(14);
    T.set(SIXTEEN, FOURTEEN);
    assertTrue(T.size() == 8);
  }

  /*
 * Test for insertions requiring a rotation: 'right left' case
 */

 @Test
 public void TestInsertTree3b() {
   AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
   AVLSortedMap<Integer, Integer> T = utils.buildTree3();
   Integer THIRTEEN = new Integer(13);
   Integer ELEVEN = new Integer(11);
   T.set(THIRTEEN, ELEVEN);
   assertTrue(utils.isAVL(T));
  }

 @Test
 public void TestInsertTree3ba() {
   AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
   AVLSortedMap<Integer, Integer> T = utils.buildTree3();
   Integer THIRTEEN = new Integer(13);
   Integer ELEVEN = new Integer(11);
   T.set(THIRTEEN, ELEVEN);
   assertTrue(T.size() == 5);
  }

 @Test
  public void TestInsertTree4a() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree4();
    Integer THIRTEEN = new Integer(13);
    Integer ELEVEN = new Integer(11);
    T.set(THIRTEEN, ELEVEN);
    assertTrue(utils.isAVL(T));
  }

 @Test
  public void TestInsertTree4ab() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree4();
    Integer THIRTEEN = new Integer(13);
    Integer ELEVEN = new Integer(11);
    T.set(THIRTEEN, ELEVEN);
    assertTrue(T.size() == 8);
  }

  /*
 * Tests of larger trees
 */

  @Test
  public void TestLarger1() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree5();
    assertTrue(utils.isAVL(T));
  }

  @Test
  public void TestLarger2() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree6();
    assertTrue(utils.isAVL(T));
  }

}
