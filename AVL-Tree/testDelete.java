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
 * Tests for deletions from an AVL tree
 */

public class testDelete {

  /*
 * Test for deletion from an empty tree
 */

  @Test
  public void TestDeleteEmpty() {
    AVLSortedMap<Integer, Integer> T =
       new AVLSortedMap<Integer, Integer>();
    Integer ZERO = new Integer(0);
    T.unset(ZERO);
    AVLUtils<Integer, Integer> utils =
       new AVLUtils<Integer, Integer>();
    assertTrue(utils.isAVL(T));
  }

  /*
 * Tests for a deletion that does not require a rotation, when the deleted
 * node is a leaf
 */

  @Test
  public void TestDeleteTree1() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer TWO = new Integer(2);
    T.unset(TWO);
    assertTrue(utils.isAVL(T));
  }

  @Test
  public void TestDeleteTree1x() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer TWO = new Integer(2);
    T.unset(TWO);
    assertFalse(T.defined(TWO));
  }

  @Test
  public void TestDeleteTree1y() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer TWO = new Integer(2);
    T.unset(TWO);
    assertTrue(T.size() == 3);
  }

  /*
 * Tests for a deletion that does not require a rotation, when the
 * value to be removed is at a node with a left child, but not a right
 */

  @Test 
  public void TestDeleteTree1_2() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer FOUR = new Integer(4);
    T.unset(FOUR);
    assertFalse(T.defined(FOUR));
  }

  @Test
  public void TestDeleteTree1_2x() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer FOUR = new Integer(4);
    T.unset(FOUR);
    assertTrue(T.size() == 3);
  }

  @Test
  public void TestDeleteTree1_2y() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer FOUR = new Integer(4);
    T.unset(FOUR);
    assertTrue(utils.isAVL(T));
  }

 /*
 * Tests for a deletion that does not require a rotation, when the
 * value to be removed is at a node with a right child, but not a left
 * child
 */

  @Test 
  public void TestDeleteTree3() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree3();
    Integer TWELVE = new Integer(12);
    T.unset(TWELVE);
    assertTrue(utils.isAVL(T));
  }

  @Test
  public void TestDeleteTree3x() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree3();
    Integer TWELVE = new Integer(12);
    T.unset(TWELVE);
    assertFalse(T.defined(TWELVE));
  }

  @Test
  public void TestDeleteTree3y() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree3();
    Integer TWELVE = new Integer(12);
    T.unset(TWELVE);
    assertTrue(T.size() == 3);
  }

 /*
 * Tests for a deletion that does not require a roation, when the value
 * to be deleted is at a node with two children
 */

 @Test
  public void TestDeleteTree3_a() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree3();
    Integer TEN = new Integer(10);
    T.unset(TEN);
    assertTrue(utils.isAVL(T));
  }

 @Test
  public void TestDeleteTree3_ax() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree3();
    Integer TEN = new Integer(10);
    T.unset(TEN);
    assertFalse(T.defined(TEN));
  }

 @Test
  public void TestDeleteTree3_ay() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree3();
    Integer TEN = new Integer(10);
    T.unset(TEN);
    assertTrue(T.size() == 3);
  }

  /*
 * Tests for a deletion that requires a rotation: left-left case
 */

  @Test
  public void TestDeleteTree1_ab() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer EIGHT = new Integer(8);
    T.unset(EIGHT);
    assertTrue(utils.isAVL(T));
  }

  @Test
  public void TestDeleteTree2ab() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree2();
    Integer EIGHT = new Integer(8);
    T.unset(EIGHT);
    assertTrue(utils.isAVL(T));
  }

  @Test
  public void TestDeleteTree2abx() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree2();
    Integer EIGHT = new Integer(8);
    T.unset(EIGHT);
    assertFalse(T.defined(EIGHT));
  }

  @Test
  public void TestDeleteTree2aby() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree2();
    Integer EIGHT = new Integer(8);
    T.unset(EIGHT);
    assertTrue(T.size() == 6);
  }

  /*
 * Tests for a deletion that requires a rotation: left-right case
 */

 @Test
 public void TestDelete1a_a() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer THREE = new Integer(3);
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    Integer EIGHT= new Integer(8);
    T.set(THREE, ONE);
    T.unset(TWO);
    T.unset(EIGHT);
    assertTrue(utils.isAVL(T));
  }

 @Test
 public void TestDelete2a_a() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree2();
    Integer THREE = new Integer(3);
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    Integer EIGHT= new Integer(8);
    T.set(THREE, ONE);
    T.unset(TWO);
    T.unset(EIGHT);
    assertTrue(utils.isAVL(T));
  }

 @Test
 public void TestDelete2a_ax() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree2();
    Integer THREE = new Integer(3);
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    Integer EIGHT= new Integer(8);
    T.set(THREE, ONE);
    T.unset(TWO);
    T.unset(EIGHT);
    assertFalse(T.defined(EIGHT));
  }

 @Test
 public void TestDelete2a_ay() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree2();
    Integer THREE = new Integer(3);
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    Integer EIGHT= new Integer(8);
    T.set(THREE, ONE);
    T.unset(TWO);
    T.unset(EIGHT);
    assertTrue(T.size() == 6);
  }

  /*
 * Tests for a deletion that requires a roation: left-equals case
 */

 @Test
 public void TestDelete1a_b() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree1();
    Integer THREE = new Integer(3);
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    Integer EIGHT= new Integer(8);
    T.set(THREE, ONE);
    T.unset(EIGHT);
    assertTrue(utils.isAVL(T));
  }

 @Test
 public void TestDelete2a_b() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree2();
    Integer THREE = new Integer(3);
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    Integer EIGHT= new Integer(8);
    T.set(THREE, ONE);
    T.unset(EIGHT);
    assertFalse(T.defined(EIGHT));
  }

 @Test
 public void TestDelete2a_bx() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree2();
    Integer THREE = new Integer(3);
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    Integer EIGHT= new Integer(8);
    T.set(THREE, ONE);
    T.unset(EIGHT);
    assertTrue(T.size() == 7);
  }

 @Test
 public void TestDelete2a_by() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree2();
    Integer THREE = new Integer(3);
    Integer ONE = new Integer(1);
    Integer TWO = new Integer(2);
    Integer EIGHT= new Integer(8);
    T.set(THREE, ONE);
    T.unset(EIGHT);
    assertTrue(utils.isAVL(T));
  }

  /*
 * Tests for a deletion that requires a rotation: right-right case
 */

  @Test
  public void TestDeleteTree3_b() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree3();
    Integer EIGHT = new Integer(8);
    T.unset(EIGHT);
    assertTrue(utils.isAVL(T));
  }

  @Test
  public void TestDeleteTree4() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree4();
    Integer EIGHT = new Integer(8);
    T.unset(EIGHT);
    assertTrue(utils.isAVL(T));
  }

  @Test
  public void TestDeleteTree4x() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree4();
    Integer EIGHT = new Integer(8);
    T.unset(EIGHT);
    assertFalse(T.defined(EIGHT));
  }

  @Test
  public void TestDeleteTree4y() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree4();
    Integer EIGHT = new Integer(8);
    T.unset(EIGHT);
    assertTrue(T.size() == 6);
  }

  /*
 * Tests for a deletion that requires a rotation: right-left case
 */

 @Test
 public void TestDelete3a_c() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree3();
    Integer SEVEN = new Integer(7);
    Integer FIVE = new Integer(5);
    Integer FOURTEEN = new Integer(14);
    Integer TWO= new Integer(2);
    T.set(SEVEN, FIVE);
    T.unset(FOURTEEN);
    T.unset(TWO);
    assertTrue(utils.isAVL(T));
  }

 @Test
 public void TestDelete4a_c() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree4();
    Integer SEVEN = new Integer(7);
    Integer FIVE = new Integer(5);
    Integer FOURTEEN = new Integer(14);
    Integer TWO= new Integer(2);
    T.set(SEVEN, FIVE);
    T.unset(FOURTEEN);
    T.unset(TWO);
    assertTrue(utils.isAVL(T));
  }

 @Test
 public void TestDelete4a_cx() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree4();
    Integer SEVEN = new Integer(7);
    Integer FIVE = new Integer(5);
    Integer FOURTEEN = new Integer(14);
    Integer TWO= new Integer(2);
    T.set(SEVEN, FIVE);
    T.unset(FOURTEEN);
    T.unset(TWO);
    assertFalse(T.defined(TWO));
  }

 @Test
 public void TestDelete4a_cy() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree4();
    Integer SEVEN = new Integer(7);
    Integer FIVE = new Integer(5);
    Integer FOURTEEN = new Integer(14);
    Integer TWO= new Integer(2);
    T.set(SEVEN, FIVE);
    T.unset(FOURTEEN);
    T.unset(TWO);
    assertTrue(T.size() == 6);
  }

  /*
 * Tests for a deletion that requires a roation: right-equals case
 */

@Test
 public void TestDelete3b_c() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree3();
    Integer SEVEN = new Integer(7);
    Integer FIVE = new Integer(5);
    Integer FOURTEEN = new Integer(14);
    Integer TWO= new Integer(2);
    T.set(SEVEN, FIVE);
    T.unset(TWO);
    assertTrue(utils.isAVL(T));
  }

 @Test
 public void TestDelete4b_c() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree4();
    Integer SEVEN = new Integer(7);
    Integer FIVE = new Integer(5);
    Integer FOURTEEN = new Integer(14);
    Integer TWO= new Integer(2);
    T.set(SEVEN, FIVE);
    T.unset(TWO);
    assertTrue(utils.isAVL(T));
  }

 @Test
 public void TestDelete4b_cx() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree4();
    Integer SEVEN = new Integer(7);
    Integer FIVE = new Integer(5);
    Integer FOURTEEN = new Integer(14);
    Integer TWO= new Integer(2);
    T.set(SEVEN, FIVE);
    T.unset(TWO);
    assertFalse(T.defined(TWO));
  }

 @Test
 public void TestDelete4b_cy() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree4();
    Integer SEVEN = new Integer(7);
    Integer FIVE = new Integer(5);
    Integer FOURTEEN = new Integer(14);
    Integer TWO= new Integer(2);
    T.set(SEVEN, FIVE);
    T.unset(TWO);
    assertTrue(T.size() == 7);
  }

  /*
 * Tests for deletions from larger trees
 */

  @Test
  public void TestLargeDelete1() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree5();
    int i = 0;
    while (i < 500 ) {
      Integer ii = new Integer(i);
      T.unset(ii);
      i = i + 1;
    }
    assertTrue(utils.isAVL(T));
  }

  @Test
  public void TestLargeDelete2() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree5();
    int i = 0;
    while (i < 500 ) {
      Integer ii = new Integer(i);
      T.unset(ii);
      i = i + 1;
    }
    assertTrue(T.size() == 500);
  }

  @Test
  public void TestLargeDelete3() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree5();
    int i = 0;
    while (i < 500 ) {
      Integer ii = new Integer(999-i);
      T.unset(ii);
      i = i + 1;
    }
    assertTrue(utils.isAVL(T));
  }

  @Test
  public void TestLargeDelete4() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree5();
    int i = 0;
    while (i < 500 ) {
      Integer ii = new Integer(999-i);
      T.unset(ii);
      i = i + 1;
    }
    assertTrue(T.size() == 500);
  }

  @Test
  public void TestLargeDelete5() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree5();
    int i = 0;
    while (i < 250 ) {
      Integer ii = new Integer(499-i);
      T.unset(ii);
      Integer iii = new Integer(500 + i);
      T.unset(iii);
      i = i + 1;
    }
    assertTrue(utils.isAVL(T));
  }

  @Test
  public void TestLargeDelete6() {
    AVLUtils<Integer, Integer> utils = new AVLUtils<Integer, Integer>();
    AVLSortedMap<Integer, Integer> T = utils.buildTree5();
    int i = 0;
    while (i < 250 ) {
      Integer ii = new Integer(499-i);
      T.unset(ii);
      Integer iii = new Integer(500 + i);
      T.unset(iii);
      i = i + 1;
    }
    assertTrue(T.size() == 500);
  }

}
